package com.abdul_Codefellowship.codefellowship.controller;

import com.abdul_Codefellowship.codefellowship.model.AppUser;
import com.abdul_Codefellowship.codefellowship.repositories.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AppController  {

    @Autowired
    AppRepository appRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/login")
    public String getLonginPage(){
        return "login";
    }
    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup";
    }




    @PostMapping("/signup")
    public RedirectView createUser(String username, String password, String firstName, String lastName, String dateOfBirth, String bio) {
        // hash the password!!!
        String hashedPw = passwordEncoder.encode(password);
        AppUser newUser = new AppUser(username, hashedPw,firstName,lastName,dateOfBirth,bio);
        appRepository.save(newUser);

        authWithHttpServletRequest(username, password);

        return new RedirectView("/");
    }

    public void authWithHttpServletRequest(String username, String password)
    {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            System.out.println("Error while logging in.");
            e.printStackTrace();
        }
    }
}

