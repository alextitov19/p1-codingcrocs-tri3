package com.codingcorcs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/miniLab","/minilab"})
public class MiniLabController {

    @GetMapping("")
    public String showMainPage()
    {
        return "MiniLabMainPage";
    }
}

