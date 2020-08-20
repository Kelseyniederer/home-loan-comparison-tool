package org.launchcode.homeloancompare.controllers;

import org.launchcode.homeloancompare.data.LoanInquiryData;
import org.launchcode.homeloancompare.models.LoanInquiry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("loans")
public class LoanController {

    @GetMapping
    public String displayAllLoanInquiries(Model model){
        model.addAttribute("loanInquiries", LoanInquiryData.getAll());
        return "loans/index";
    }

    @GetMapping("new")
    public String renderNewLoanInquiryForm(){
        return "loans/new";
    }

    @PostMapping("new")
    public String processNewLoanInquiryForm(@ModelAttribute LoanInquiry newLoanInquiry){
        LoanInquiryData.add(newLoanInquiry);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteLoanInquiryForm(Model model){
        model.addAttribute("title", "Delete Loan Inquiries");
        model.addAttribute("loanInquiries", LoanInquiryData.getAll());
        return "loans/delete";
    }

    @PostMapping("delete")
    public String processDeleteLoanInquiryForm(@RequestParam(required = false) int[] loanIds) {
        if (loanIds != null) {
            for (int id : loanIds) {
                LoanInquiryData.remove(id);
            }
        }
        return "redirect:";
    }
}
