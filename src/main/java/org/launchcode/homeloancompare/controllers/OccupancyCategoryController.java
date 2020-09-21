package org.launchcode.homeloancompare.controllers;

import org.launchcode.homeloancompare.data.OccupancyCategoryRepository;
import org.launchcode.homeloancompare.models.OccupancyCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("occupancyCategories")
public class OccupancyCategoryController {

    @Autowired
    private OccupancyCategoryRepository occupancyCategoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Occupancy Types");
        model.addAttribute("occupancyCategories", occupancyCategoryRepository.findAll());
        return "occupancyCategories/index";
    }

    @GetMapping("create")
    public String renderCreateOccupancyCategoryForm(Model model) {
        model.addAttribute("title", "Create Occupancy Type");
        model.addAttribute(new OccupancyCategory());
        return "occupancyCategories/create";
    }

    @PostMapping("create")
    public String processCreateOccupancyCategoryForm(@Valid @ModelAttribute OccupancyCategory occupancyCategory,
                                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Occupancy Type");
            model.addAttribute(new OccupancyCategory());
            return "occupancyCategories/create";
        }

        occupancyCategoryRepository.save(occupancyCategory);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteOccupancyCategoryForm(Model model){
        model.addAttribute("title", "Delete Occupancy Categories");
        model.addAttribute("occupancyCategories", occupancyCategoryRepository.findAll());
        return "occupancyCategories/delete";
    }

    @PostMapping("delete")
    public String processDeleteOccupancyCategoriesForm(@RequestParam(required = false) int[] occupancyCategoryIds) {
        if (occupancyCategoryIds != null) {
            for (int id : occupancyCategoryIds) {
                occupancyCategoryRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

}