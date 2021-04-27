package com.codingcorcs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BrendanMiniLabController {

    @GetMapping("/Brendan")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "Image";

        
@Controller
@RequestMapping({"/miniLab/Brendan","/minilab/Brendan"})
public class BrendanMinilabController {

    @GetMapping("/Recursion")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("recursion", name);
        return "Brendanrec";
    }

    @GetMapping("/Inheritance")
    public String greeting2(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("Inheritance", name);
        return "Brendanint";
    }

    @GetMapping("/Sorts")
    public String greeting3(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("Sorts", name);
        return "Brendansorts";
    }
} 
   


