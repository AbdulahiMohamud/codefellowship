package com.abdul_Codefellowship.codefellowship.controller;

import com.abdul_Codefellowship.codefellowship.model.AppUser;
import com.abdul_Codefellowship.codefellowship.repositories.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    AppRepository appRepository;

    @GetMapping("/")
    public String getHomePage(Principal p, Model m) {

        if(p != null){
            String username = p.getName();
            String firstName = p.getName();
            AppUser appUser = appRepository.findByUsername(username);

            m.addAttribute("username",username);
            m.addAttribute("user",appUser);
        }
        return "index";
    }
}
