package org.launchcode.homeloancompare.controllers;

import org.launchcode.homeloancompare.data.PropertyCategoryRepository;
import org.launchcode.homeloancompare.models.PropertyCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("propertyCategories")
public class PropertyCategoryController {

    @Autowired
    private PropertyCategoryRepository propertyCategoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Property Types");
        model.addAttribute("propertyCategories", propertyCategoryRepository.findAll());
        return "propertyCategories/index";
    }

    @GetMapping("create")
    public String renderCreatePropertyCategoryForm(Model model) {
        model.addAttribute("title", "Create Property Type");
        model.addAttribute(new PropertyCategory());
        return "propertyCategories/create";
    }

    @PostMapping("create")
    public String processCreatePropertyCategoryForm(@Valid @ModelAttribute PropertyCategory propertyCategory,
                                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Property Type");
            model.addAttribute(new PropertyCategory());
            return "propertyCategories/create";
        }

        propertyCategoryRepository.save(propertyCategory);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeletePropertyCategoryForm(Model model){
        model.addAttribute("title", "Delete Property Categories");
        model.addAttribute("propertyCategories", propertyCategoryRepository.findAll());
        return "propertyCategories/delete";
    }

    @PostMapping("delete")
    public String processDeletePropertyCategoriesForm(@RequestParam(required = false) int[] propertyCategoryIds) {
        if (propertyCategoryIds != null) {
            for (int id : propertyCategoryIds) {
                propertyCategoryRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

}