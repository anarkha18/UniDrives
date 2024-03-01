package com.unidrives.controllers;

import com.unidrives.entitys.University;
import com.unidrives.services.UniversityService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/university")
public class UniversityController {

    private static final Logger logger = LoggerFactory.getLogger(UniversityController.class);

    @Autowired
    private UniversityService universityService;

    @PostMapping("/add")
    public String addUniversity(@Valid @ModelAttribute("university") University university, RedirectAttributes redirectAttributes) throws Exception {
        if (universityService.alreadyExists(university.getUniversityId())) {
            redirectAttributes.addFlashAttribute("errorMessage", "University already exists");
            return "redirect:/admin/universityDashboard";
        }
        universityService.addOrUpdateUniversity(university);
        return "redirect:/admin/universityDashboard";
    }

}
