package com.codingcorcs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebMainMvcController {
    @GetMapping("/hello")
    public String helloMapping()
    {
        return "Hello";
    }

}
