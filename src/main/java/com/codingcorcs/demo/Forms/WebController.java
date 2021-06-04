package com.codingcorcs.demo.Forms;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Forms")
public class WebController {
    @GetMapping({"/","/titles","/all"})
    public String getTitles(Model model){
        return null;
    }

    @GetMapping("/Forms/{id}") // path varable that gets the post_id from the database
    public String getForm(@PathVariable("id") long post_id,Model model){

        return null;
    }

    @PreAuthorize("hasRole('ROLE_User')")
    @PostMapping("/Form/Add")
    public String AddForm(){
            return null;
    }
}
