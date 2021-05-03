package com.codingcorcs.demo;

import com.codingcorcs.demo.MiniLabs.Recursion.BHLinkedList;
import com.codingcorcs.demo.MiniLabs.Recursion.BHPojo;
import com.codingcorcs.demo.MiniLabs.Recursion.BHNode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


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

    @GetMapping("/LinkLists")
    public String greeting6(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("LinkLists", name);
        return "BennyLinkLists";
    }
}