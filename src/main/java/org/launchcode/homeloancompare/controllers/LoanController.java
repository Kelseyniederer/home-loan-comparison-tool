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


    @GetMapping
    public String displayAllLoanInquiries(Model model){
            model.addAttribute("loanInquiries", loanRepository.findAll());
        return "loans/index";
    }

    @GetMapping("new")
    public String renderNewLoanInquiryForm(Model model){
        model.addAttribute( new Loan());
        return "loans/new";
    }

    @PostMapping("new")
    public String processNewLoanInquiryForm(@ModelAttribute @Valid Loan newLoanInquiry,
                                            Errors errors, Model model){
        if(errors.hasErrors()){
            return "loans/new";
        }

        loanRepository.save(newLoanInquiry);
        return "redirect:";
    }

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

    @GetMapping("compare/{loanId}")
    public String displayViewLoan(Model model, @PathVariable int loanId) {

        Optional<Loan> optLoan = loanRepository.findById(loanId);
        if (optLoan.isPresent()) {
            Loan loan = (Loan) optLoan.get();
            model.addAttribute("loan", loan);

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
            }
            else if (closingMonth.equals(12)){
                firstPaymentMonth = 2;
                firstPaymentYear = closingYear + 1;
            }
            else {
                firstPaymentMonth = closingMonth + 2;
                firstPaymentYear = closingYear;
            }

            String customClosingDate = closingMonth.toString() + "/" + closingDay.toString() + "/" + closingYear.toString();
            String customFirstPaymentDate = firstPaymentMonth.toString() + "/" + firstPaymentDay + "/" + firstPaymentYear.toString();

            model.addAttribute("closingDate", customClosingDate);
            model.addAttribute("firstPaymentDate", customFirstPaymentDate);











            return "loans/compare";
        } else {
            return "loans/index";
        }


    }
}