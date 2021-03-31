package com.codingcorcs.demo;

import com.codingcorcs.demo.MiniLabs.Andrew.Recursion.Fibo;
import com.codingcorcs.demo.MiniLabs.Andrew.Recursion.Recursion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/miniLab/Andrew","/minilab/Andrew"})
public class AndrewMiniLabController {
    @GetMapping("/Fib/{nth}")
    @ResponseBody
    public String Tester(@PathVariable int nth)
    {
        return new Recursion().getFib(nth).toString();
    }


}
