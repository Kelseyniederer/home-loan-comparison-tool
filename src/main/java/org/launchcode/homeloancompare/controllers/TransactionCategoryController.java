package org.launchcode.homeloancompare.controllers;

import org.launchcode.homeloancompare.data.TransactionCategoryRepository;
import org.launchcode.homeloancompare.models.TransactionCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("transactionCategories")
public class TransactionCategoryController {

    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Transaction Types");
        model.addAttribute("transactionCategories", transactionCategoryRepository.findAll());
        return "transactionCategories/index";
    }

    @GetMapping("create")
    public String renderCreateTransactionCategoryForm(Model model) {
        model.addAttribute("title", "Create Transaction Type");
        model.addAttribute(new TransactionCategory());
        return "transactionCategories/create";
    }

    @PostMapping("create")
    public String processCreateOccupancyCategoryForm(@Valid @ModelAttribute TransactionCategory transactionCategory,
                                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Transaction Type");
            model.addAttribute(new TransactionCategory());
            return "transactionCategories/create";
        }

        transactionCategoryRepository.save(transactionCategory);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteTransactionCategoryForm(Model model){
        model.addAttribute("title", "Delete Transaction Categories");
        model.addAttribute("transactionCategories", transactionCategoryRepository.findAll());
        return "transactionCategories/delete";
    }

    @PostMapping("delete")
    public String processDeleteTransactionCategoriesForm(@RequestParam(required = false) int[] transactionCategoryIds) {
        if (transactionCategoryIds != null) {
            for (int id : transactionCategoryIds) {
                transactionCategoryRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

}
