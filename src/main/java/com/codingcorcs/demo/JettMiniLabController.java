package com.codingcorcs.demo;

import com.codingcorcs.demo.MiniLabs.Jett.PalindromeCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
