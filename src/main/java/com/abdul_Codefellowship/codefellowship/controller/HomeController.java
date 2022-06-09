package com.abdul_Codefellowship.codefellowship.controller;

import com.abdul_Codefellowship.codefellowship.model.AppUser;
import com.abdul_Codefellowship.codefellowship.model.Post;
import com.abdul_Codefellowship.codefellowship.repositories.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AppRepository appRepository;

    // CUSTOM 404 exception!!
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        ResourceNotFoundException(String message) {
            super(message);
        }
    }

    @GetMapping("/")
    public String getHomePage(Principal p, Model m) {

        if (p != null) {
            String username = p.getName();
            AppUser appUser = appRepository.findByUsername(username);

            m.addAttribute("username", username);
        }

//        throw a 404 error,
        throw new ResourceNotFoundException("This is a 404");

    }

    @GetMapping("/myProfile")
    public String userProfile(Principal p, Model m) {

        if (p != null) {
            String username = p.getName();
            AppUser appUser = appRepository.findByUsername(username);



           List<Post> postList = appUser.getPostList();
            m.addAttribute("username", username);
            m.addAttribute("user", appUser);
            m.addAttribute("posts",postList);



        }
        return "profile";
    }


    @GetMapping("/user/{id}")
    public String userInfo(Principal p, Model m, @PathVariable Long id) {

        if (p != null) { // not strictly required if your WebSecuityConfig is correct
            String username = p.getName();
            AppUser appUser = appRepository.findByUsername(username);

            m.addAttribute("username", username);
        }

        AppUser appUser = appRepository.findById(id).orElseThrow(IllegalAccessError::new);
        m.addAttribute("appUsername",appUser.getUsername());
        m.addAttribute("appUserId",appUser.getId());
        m.addAttribute("user",appUser.getFirstName() + ' '+ appUser.getLastName()+ ' '+appUser.getBio());

        List<Post> postList = appUser.getPostList();

        m.addAttribute("post", postList);


        return "user-info";
    }





}

