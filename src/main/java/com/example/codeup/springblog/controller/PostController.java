package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Controller
public class PostController {
    @Autowired
    private PostRepository postDao;

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

    public String getCreatePostForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")

    public String savePost() {
        return "create a new post";
    }


}




