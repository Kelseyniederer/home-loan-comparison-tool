package org.launchcode.homeloancompare.controllers;

import org.launchcode.homeloancompare.data.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("transaction")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;
}
