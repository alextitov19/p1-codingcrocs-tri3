package com.codingcorcs.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping({"/miniLab/Benny","/minilab/Benny"})
public class BennyMinilabController {

    @GetMapping("/Recursion")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("recursion", name);
        return "Bennyrec";
    }

    @GetMapping("/Inheritance")
    public String greeting2(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("Inheritance", name);
        return "Bennyint";
    }

    @GetMapping("/Sorts")
    public String greeting3(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("Sorts", name);
        return "Bennybbsort";
    }

    @GetMapping("/InsertionSorts")
    public String greeting4(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("InsertionSorts", name);
        return "Bennysorts";

    }

    @GetMapping("/SecSorts")
    public String greeting5(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("SecSorts", name);
        return "Bennyselsorts";
    }

    @GetMapping("/LinkList")
    public String greeting6(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("LinkList", name);
        return "LinkList";
    }
}