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
        model.addAttribute("Recursion", name);
        return "BrendanRecursion";
    }

    @GetMapping("/Inheritance")
    public String greeting2(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("Inheritance", name);
        return "BrendanInheritance";
    }

    @GetMapping("/BubbleSorts")
    public String greeting3(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("BubbleSorts", name);
        return "BrendanBubbleSorts";
    }

    @GetMapping("/InsertionSorts")
    public String greeting4(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("InsertionSorts", name);
        return "BrendanInsertionSorts";

    }

    @GetMapping("/SelectionSorts")
    public String greeting5(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("SelectionSorts", name);
        return "BrendanSelectionSorts";
    }

    @GetMapping("/LinkList")
    public String greeting6(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("LinkList", name);
        return "BrendanLinkList";
    }
}
   


