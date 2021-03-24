package com.codingcorcs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

}
