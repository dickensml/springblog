package com.example.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/firstview")
    public String returnFirstView(Model vModel ) {
        vModel.addAttribute("name", "MikeD");
        return "first-view";
    }
}
