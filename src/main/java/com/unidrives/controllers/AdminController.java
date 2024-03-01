package com.unidrives.controllers;

import com.unidrives.entitys.University;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/admin")
@RestController
public class AdminController {
    @GetMapping("/home")
    public ModelAndView adminHome(){
        return new ModelAndView("adminHome");
    }

    @GetMapping("/universityDashboard")
    public ModelAndView universityDashboard(){
        return new ModelAndView("universityDashboard").addObject("university", new University());
    }
}
