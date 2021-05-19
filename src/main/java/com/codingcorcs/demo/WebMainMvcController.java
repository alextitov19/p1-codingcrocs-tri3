package com.codingcorcs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Main controller of the project will handle the landing page and things related to it
 * @see SocialApplication
 */
@Controller
public class WebMainMvcController {
    @GetMapping("/hello")
    public String helloMapping()
    {
        return "Hello";
    }
    @GetMapping("/Home")
    public String HomePage()
    {
        return "Hello"; // place holder for now
    }

    @GetMapping("/SignUp")
    public String SignUpPage(){
        return null; // place holder
    }
    @PostMapping("/SignUp")
    public String SignUpPage(Object obj){
        return null; //place holder
    }


}
