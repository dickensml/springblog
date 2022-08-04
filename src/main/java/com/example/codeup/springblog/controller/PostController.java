package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.repositories.PostRepository;
import com.example.codeup.springblog.repositories.UserRepository;
import com.example.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Controller
public class PostController {
    private PostRepository postDao;
    private UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String allPosts(Model vModel) {
        List<Post> posts = new ArrayList<>(Arrays.asList(
            new Post("Entry Two"),
            new Post("Entry Three")
        ));
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model vModel) {
        Post post = new Post(
        1,
            "Post number " + id,
            "Things about the post..."
        );
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    // Model is the data model we want to pass to the html page.
    public String createPost(Model model) {
        model.addAttribute("newPost", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@ModelAttribute Post newPost) {
        User user = userDao.findById(1L).get();
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newPost.setUser(principal);
        postDao.save(newPost);
        emailService.prepareAndSend(newPost, "You created a new post!");
        return "redirect:/posts";
    }

}




