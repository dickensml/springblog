package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "This is a different mapping!";
    }

//    @GetMapping("/increment/{number}")
//    @ResponseBody
//    public String increment(@PathVariable int number) {
//        return number + " plus 1 = " + (number + 1) + "!";
//    }


    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

}
