package org.launchcode.homeloancompare.controllers;

import org.launchcode.homeloancompare.data.LoanRepository;
import org.launchcode.homeloancompare.models.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("loans")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    // Displays all loan inquiries
    @GetMapping
    public String displayAllLoanInquiries(Model model){
        model.addAttribute("loanInquiries", loanRepository.findAll());
        return "loans/index";
    }

    // Renders New Loan Form
    @GetMapping("new")
    public String renderNewLoanInquiryForm(Model model){
        model.addAttribute( new Loan());
        return "loans/new";
    }

    // Processes New Loan Form
    @PostMapping("new")
    public String processNewLoanInquiryForm(@ModelAttribute @Valid Loan newLoanInquiry,
                                            Errors errors, Model model){
        if(errors.hasErrors()){
            return "loans/new";
        }

        loanRepository.save(newLoanInquiry);
        return "redirect:";
    }

    // Delete Loan Inquiries
    @GetMapping("delete")
    public String displayDeleteLoanInquiryForm(Model model){
        model.addAttribute("title", "Delete Loan Inquiries");
        model.addAttribute("loanInquiries", loanRepository.findAll());
        return "loans/delete";
    }

    @PostMapping("delete")
    public String processDeleteLoanInquiryForm(@RequestParam(required = false) int[] loanIds) {
        if (loanIds != null) {
            for (int id : loanIds) {
                loanRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    // Loan comparison table
    @GetMapping("compare/{loanId}")
    public String displayViewLoan(Model model, @PathVariable int loanId) {

        Optional<Loan> optLoan = loanRepository.findById(loanId);
        if (optLoan.isPresent()) {
            Loan loan = (Loan) optLoan.get();
            model.addAttribute("loan", loan);

            // Finds first payment date
            String[] closingDateArr = loan.getLoanDetails().getClosingDate().split("-");
            Integer closingMonth = Integer.parseInt(closingDateArr[1]);
            Integer closingDay = Integer.parseInt(closingDateArr[2]);
            Integer closingYear = Integer.parseInt(closingDateArr[0]);
            String firstPaymentDay = "1";
            Integer firstPaymentMonth;
            Integer firstPaymentYear;

            if (closingMonth.equals(11)){
                firstPaymentMonth = 1;
                firstPaymentYear = closingYear + 1;
            } else if (closingMonth.equals(12)){
                firstPaymentMonth = 2;
                firstPaymentYear = closingYear + 1;
            } else {
                firstPaymentMonth = closingMonth + 2;
                firstPaymentYear = closingYear;
            }
            String customClosingDate = closingMonth.toString() + "/" + closingDay.toString() + "/" + closingYear.toString();
            String customFirstPaymentDate = firstPaymentMonth.toString() + "/" + firstPaymentDay + "/" + firstPaymentYear.toString();

            model.addAttribute("closingDate", customClosingDate);
            model.addAttribute("firstPaymentDate", customFirstPaymentDate);


            //Calculate Loan Amount
            long loanAmount = Math.round(loan.getLoanDetails().getDownPayment()*loan.getLoanDetails().getPurchasePrice()/100);
            model.addAttribute("loanAmount", loanAmount);

            long actualLoanAmount = Math.round(loan.getLoanDetails().getPurchasePrice() - loanAmount);
            model.addAttribute("actualLoanAmount", actualLoanAmount);

            //Calculate Principal & Interest
            long principal = loan.getLoanDetails().getPurchasePrice() - loanAmount;
            Double monthlyRate = loan.getLoanDetails().getInterestRate()/100/12;
            Double paymentAndInterest;

            //15 years
            long fifteenYrsPAndI = Math.round(principal*monthlyRate*(Math.pow(1+monthlyRate, 15*12))/((Math.pow(1+monthlyRate,15*12))-1));
            model.addAttribute("fifteenYrsPAndI", fifteenYrsPAndI);

            //20 years
            long twentyYrsPAndI = Math.round(principal*monthlyRate*(Math.pow(1+monthlyRate, 20*12))/((Math.pow(1+monthlyRate,20*12))-1));
            model.addAttribute("twentyYrsPAndI", twentyYrsPAndI);
            //30 years
            long thirtyYrsPAndI = Math.round(principal*monthlyRate*(Math.pow(1+monthlyRate, 30*12))/((Math.pow(1+monthlyRate,30*12))-1));
            model.addAttribute("thirtyYrsPAndI", thirtyYrsPAndI);

            // Calculate total monthly payment 15 Years
            long monthlyPayment15yrs = Math.round(fifteenYrsPAndI + loan.getLoanDetails().getPropertyTax()+loan.getLoanDetails().getHomeOwnersInsurance()+loan.getLoanDetails().getHoaFees());
            model.addAttribute("monthlyPayment15yrs", monthlyPayment15yrs);

            // Calculate total monthly payment 20 Years
            long monthlyPayment20yrs = Math.round(twentyYrsPAndI + loan.getLoanDetails().getPropertyTax()+loan.getLoanDetails().getHomeOwnersInsurance()+loan.getLoanDetails().getHoaFees());
            model.addAttribute("monthlyPayment20yrs", monthlyPayment20yrs);

            // Calculate total monthly payment 30 Years
            long monthlyPayment30yrs = Math.round(thirtyYrsPAndI + loan.getLoanDetails().getPropertyTax()+loan.getLoanDetails().getHomeOwnersInsurance()+loan.getLoanDetails().getHoaFees());
            model.addAttribute("monthlyPayment30yrs", monthlyPayment30yrs);

            return "loans/compare";
        } else {
            return "loans/index";
        }


    }
}