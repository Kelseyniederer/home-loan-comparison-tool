package org.launchcode.homeloancompare.controllers;

import org.launchcode.homeloancompare.data.LoanRepository;
import org.launchcode.homeloancompare.data.OccupancyCategoryRepository;
import org.launchcode.homeloancompare.data.PropertyCategoryRepository;
import org.launchcode.homeloancompare.data.TransactionCategoryRepository;
import org.launchcode.homeloancompare.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String displayAllLoanInquiries(Model model){
        model.addAttribute("loanInquiries", loanRepository.findAll());
        return "loans/index";
    }

    @GetMapping("new")
    public String renderNewLoanInquiryForm(Model model){
        model.addAttribute( new Loan());
        model.addAttribute("transactionType", transactionCategoryRepository.findAll());
        model.addAttribute("propertyType",  propertyCategoryRepository.findAll());
        model.addAttribute("occupancyCategory", occupancyCategoryRepository.findAll());
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
