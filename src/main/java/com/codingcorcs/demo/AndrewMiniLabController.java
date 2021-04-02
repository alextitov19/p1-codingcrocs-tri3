package com.codingcorcs.demo;

import com.codingcorcs.demo.MiniLabs.Andrew.Recursion.Fibo;
import com.codingcorcs.demo.MiniLabs.Andrew.Recursion.Recursion;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping({"/miniLab/Andrew","/minilab/Andrew"})
public class AndrewMiniLabController {
    @GetMapping({"/Fib/{nth}","/Fib/"})
    @ResponseBody // restfull return
    public String Tester(@PathVariable Optional<Integer> nth)
    {
        return new Recursion().getFib(nth.orElse(0)).toString();
    } //returns json list


}
