package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ExampleNewController {

 @GetMapping("/helloworld")
 public String returnHelloWorld(Model vModel) {
   vModel.addAttribute("name", "MikeD");
  return "hello-world";
 }

@GetMapping("/search")
    public String returnSearchForm() {
     return "search";
}

    @PostMapping("/search")
    public String returnSearchResults(@RequestParam String query, Model vModel) {
     vModel.addAttribute("search", query);
        return "search-results";
    }


}


