package com.codingcorcs.demo;

import com.codingcorcs.demo.MiniLabs.Jett.Inheritance;
import com.codingcorcs.demo.MiniLabs.Jett.InsertionRecursion;
import com.codingcorcs.demo.MiniLabs.Jett.PalindromeCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Controller
@RequestMapping({"/miniLab/Jett"})
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

    @GetMapping("/inheritance")
    public String inheritance(@RequestParam(value = "catSpots", required = false) Integer catSpots,
                              @RequestParam(value = "catStripes", required = false) Integer catStripes,
                              @RequestParam(value = "dogBrown", required = false) Integer dogBrown,
                              @RequestParam(value = "dogWhite", required = false) Integer dogWhite,
                              Model model){



        int catSpotsNum = (catSpots == null || catSpots<0 || catSpots>10)?0:catSpots.intValue();
        int catStripesNum = (catStripes == null || catStripes<0 || catStripes>10)?0:catStripes.intValue();
        int dogBrownNum = (dogBrown == null || dogBrown<0 || dogBrown>10)?0:dogBrown.intValue();
        int dogWhiteNum = (dogWhite == null || dogWhite<0 || dogWhite>10)?0:dogWhite.intValue();

        ArrayList<Inheritance.Animal> animalList = new ArrayList<>();
        for(int i=0;i<catSpotsNum;i++){ animalList.add(new Inheritance.Cat("Spots")); }
        for(int i=0;i<catStripesNum;i++){ animalList.add(new Inheritance.Cat("Stripes")); }
        for(int i=0;i<dogBrownNum;i++){ animalList.add(new Inheritance.Terrier("Brown")); }
        for(int i=0;i<dogWhiteNum;i++){ animalList.add(new Inheritance.Terrier("White")); }


        String[] strings = new String[animalList.size()];
        Integer[]pnds = new Integer[animalList.size()];
        int totalPnds = 0;

        for(int i=0;i<strings.length;i++){
            strings[i] = animalList.get(i).toString();
           pnds[i] = animalList.get(i).getLbs();
            totalPnds +=pnds[i];
        }

        model.addAttribute("strings", strings);
        model.addAttribute("cals",pnds);
        model.addAttribute("totalPnds", totalPnds);

        model.addAttribute("catSpots", catSpotsNum);
        model.addAttribute("catStripes", catStripesNum);
        model.addAttribute("dogBrown", dogBrownNum);
        model.addAttribute("dogWhite", dogWhiteNum);


        return "Jett/JettInheritance.html";
    }

}
