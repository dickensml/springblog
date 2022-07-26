package com.example.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

        @GetMapping("/home")
        @ResponseBody
        public String landing() {
            return "This is the landing page!";
        }


        @Controller
        public class MathController {


            @GetMapping("/add/{number1}/and/{number2}")
            @ResponseBody
            public String addNum(@PathVariable int number1, @PathVariable int number2){
                return (number1 + number2)  + " is the sum!";
            }
            @GetMapping("/subtract/{number1}/and/{number2}")
            @ResponseBody
            public String subNum(@PathVariable int number1, @PathVariable int number2){
                return (number1 - number2)  + " is the difference!";
            }

            @GetMapping("/multiply/{number1}/and/{number2}")
            @ResponseBody
            public String multNum(@PathVariable int number1, @PathVariable int number2){
                return (number1 * number2)  + " is the product!";
            }

            @GetMapping("/divide/{number1}/and/{number2}")
            @ResponseBody
            public String divNum(@PathVariable int number1, @PathVariable int number2){
                return (number1 / number2)  + " is the quotient!";
            }
        }

    }


