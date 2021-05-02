package com.codingcorcs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlexMiniLabController {

    @GetMapping("/alex/FirstLab")
    public String index(Model model) {
        return "Alex/Recursion";
    }

}