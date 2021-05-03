package com.codingcorcs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlexMiniLabController {

    @GetMapping("/alex/recursion")
    public String recursionIndex(Model model) {
        return "Alex/Recursion";
    }

    @GetMapping("/alex/inheritance")
    public String inheritanceIndex(Model model) {
        return "Alex/Inheritance";
    }

    @GetMapping("/alex/sorting")
    public String sortingIndex(Model model) {
        return "Alex/Sorting";
    }

    @GetMapping("/alex/linkedlist")
    public String linkedListIndex(Model model) {
        return "Alex/LinkedList";
    }

}