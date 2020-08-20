package org.launchcode.homeloancompare.controllers;

import org.launchcode.homeloancompare.data.LoanInquiryData;
import org.launchcode.homeloancompare.models.LoanInquiry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String processNewLoanInquiryForm(@RequestParam String propertyAddress,
    @RequestParam String borrowersName){
        LoanInquiryData.add(new LoanInquiry(propertyAddress, borrowersName));
        return "redirect:";
    }
}
