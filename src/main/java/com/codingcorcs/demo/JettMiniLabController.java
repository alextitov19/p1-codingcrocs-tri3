package com.codingcorcs.demo;

import com.codingcorcs.demo.MiniLabs.Jett.InsertionRecursion;
import com.codingcorcs.demo.MiniLabs.Jett.PalindromeCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Random;

@Controller
@RequestMapping({"/miniLab/Jett","/minilab/Jett"})
public class JettMiniLabController {
    @GetMapping("")
    public String HtmlTemplate(@RequestParam(value = "word", required = false) String word, Model model)
    {
        if(word != null){
            boolean isPal = PalindromeCheck.isPal(word);

            model.addAttribute("isPal",  isPal);
        }
        return "Jett/JettPalindrome";
    }

    @GetMapping("/insertion")
    public String InsertionTemplate(Model model)
    {
        Random rand = new Random();
        int[] arr = new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i] = rand.nextInt(100)+1;
        }
        InsertionRecursion ir = new InsertionRecursion();
        int[] sr = ir.insertionSort(arr);
        model.addAttribute("sorted", Arrays.toString(sr));
        model.addAttribute("unsorted", Arrays.toString(arr));
        return "Jett/JettInsertion";
    }

}
