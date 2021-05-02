package com.codingcorcs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlexMiniLabController {

    @GetMapping("/alex")
    public String index(Model model) {
        return "Alex";
    }

}