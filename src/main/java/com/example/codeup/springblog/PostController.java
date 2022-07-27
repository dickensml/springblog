package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


//        method	url	        description
//        GET	/posts	        posts index page
//        GET	/posts/{id}	    view an individual post
//        GET	/posts/create	view the form for creating a post
//        POST	/posts/create	create a new post
@Controller
public class PostController {

    @GetMapping("/index")
    @ResponseBody
    public String posts(Model vModel) {
        List<posts> postList
        return "index";
    }

    @GetMapping("/show")
    @ResponseBody
    public String getPosts(@PathVariable Model vModel) {
        vModel.addAttribute("posts", "First entry");
        return "show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreatePostForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String savePost() {
        return "create a new post";
    }


}




