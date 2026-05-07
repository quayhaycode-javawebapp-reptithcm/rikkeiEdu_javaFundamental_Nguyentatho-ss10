package org.example.project_base_spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "home", "exam"})
public class HomeController {
    @GetMapping
    public String getHome(){
        return "home";
    }
}
