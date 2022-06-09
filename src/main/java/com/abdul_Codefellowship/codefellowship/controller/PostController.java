package com.abdul_Codefellowship.codefellowship.controller;

import com.abdul_Codefellowship.codefellowship.model.AppUser;
import com.abdul_Codefellowship.codefellowship.model.Post;
import com.abdul_Codefellowship.codefellowship.repositories.AppRepository;
import com.abdul_Codefellowship.codefellowship.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    AppRepository appRepository;


    @PostMapping("/add-post")
    public RedirectView addPost (Principal p, Model m, String text) {
        if(p != null){
            String username = p.getName();
            AppUser appUser = appRepository.findByUsername(username);
            m.addAttribute("Appuser",appUser);

            Post post = new Post(text);
            post.setCreatedAt(new Date());
            post.setUserPosts(appUser);
            postRepository.save(post);

//            List<Post> postList = appUser.getPostList();


//            m.addAttribute("posts",postList);


        }
        return new RedirectView("/myProfile");
    }
}
