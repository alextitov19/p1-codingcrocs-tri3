package com.codingcorcs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/miniLab/Recursion","/minilab/Recursion"})
public class BennyMinilabController {

    @GetMapping("/Recursion")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("recursion", name);
        return "Bennyrec";
    }

}