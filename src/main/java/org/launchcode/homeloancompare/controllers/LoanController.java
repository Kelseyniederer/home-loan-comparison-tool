package org.launchcode.homeloancompare.controllers;

import org.launchcode.homeloancompare.data.LoanRepository;
import org.launchcode.homeloancompare.data.OccupancyCategoryRepository;
import org.launchcode.homeloancompare.data.PropertyCategoryRepository;
import org.launchcode.homeloancompare.data.TransactionCategoryRepository;
import org.launchcode.homeloancompare.models.Loan;
import org.launchcode.homeloancompare.models.OccupancyCategory;
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

    @Autowired
    private OccupancyCategoryRepository occupancyCategoryRepository;

    @Autowired
    private PropertyCategoryRepository propertyCategoryRepository;

    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    @GetMapping
    public String displayAllLoanInquiries(@RequestParam(required = false) Integer occupancyCategoryId, Model model){
        if (occupancyCategoryId == null){
        model.addAttribute("loanInquiries", loanRepository.findAll());
        }else {
           Optional<OccupancyCategory> result = occupancyCategoryRepository.findById(occupancyCategoryId);
           if(result.isEmpty()){
               model.addAttribute("title", "Invalid Occupancy Type: " + occupancyCategoryId);
           } else {
               OccupancyCategory occupancyCategory = result.get();
               model.addAttribute("title", "Loan Inquiries with Occupancy Type " + occupancyCategory.getName());
               model.addAttribute("loans", occupancyCategory.getLoans());
           }
        }

        return "loans/index";
    }

    @GetMapping("new")
    public String renderNewLoanInquiryForm(Model model){
        model.addAttribute( new Loan());
        model.addAttribute("transactionCategories", transactionCategoryRepository.findAll());
        model.addAttribute("propertyCategories",  propertyCategoryRepository.findAll());
        model.addAttribute("occupancyCategories", occupancyCategoryRepository.findAll());
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
}
