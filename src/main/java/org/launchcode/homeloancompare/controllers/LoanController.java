package org.launchcode.homeloancompare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("loan")
public class LoanController {


    @GetMapping
    public String displayAllLoanInquiries(Model model){
        List<String> loanInquiries = new ArrayList<>();
        loanInquiries.add("123 Sesame Street");
        loanInquiries.add("456 McDonald Ave");
        loanInquiries.add("789 Potomac Street");
        model.addAttribute("loanInquiries", loanInquiries);

        return "loan/index";
    }
}
