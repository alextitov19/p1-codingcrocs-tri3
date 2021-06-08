package com.codingcorcs.demo;

import com.codingcorcs.demo.Alex.SuperLinkedList;
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
        SuperLinkedList sll = new SuperLinkedList();
        sll = sll.insert(sll, 1);
        sll = sll.insert(sll, 2);
        sll = sll.insert(sll, 3);
        sll = sll.insert(sll, 4);
        sll = sll.insert(sll, 5);
        sll = sll.insert(sll, 6);
        sll = sll.insert(sll, 7);
        sll = sll.insert(sll, 8);
        model.addAttribute("sll", sll);
        return "Alex/LinkedList";
    }

    @GetMapping("/alex/binarytree")
    public String binaryTreeIndex(Model model) {
        return "Alex/BinaryTree";
    }

    @GetMapping("/blog")
    public String blogIndex(Model model) {
        return "Blog/Blog";
    }

    @GetMapping("/store")
    public String storeIndex(Model model) {
        return "Store/Store";
    }

    @GetMapping("/newItem")
    public String storeNewItemIndex(Model model) {
        return "Store/Store_NewItem";
    }

    @GetMapping("/chat")
    public String storeChatIndex(Model model) {
        return "Store/Store_Chat";
    }
    @GetMapping("/checkout")
    public String storeCheckoutIndex(Model model) {
        return "Store/Checkout";
    }

}