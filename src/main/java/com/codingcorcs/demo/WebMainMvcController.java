package com.codingcorcs.demo;

import com.codingcorcs.demo.DataBaseTools.DataBaseMethods;
import com.codingcorcs.demo.NewUser.NewUser;
import com.codingcorcs.demo.security.Vaildator.Vaildator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Main controller of the project will handle the landing page and things related to it
 * @see SocialApplication
 */
@Controller
public class WebMainMvcController {
    @GetMapping("/hello")
    public String helloMapping()
    {
        return "Hello";
    }
    @GetMapping("/Home")
    public String HomePage()
    {
        return "Hello"; // place holder for now
    }





    @GetMapping("/SignUp")
    public String SignUpPage(Model model){
        model.addAttribute("user",new NewUser());
        return null; // place holder

    }
    @PostMapping("/SignUp")
    public String SignUpPage(@Valid NewUser user, BindingResult bindingResult, PasswordEncoder encoder, @Qualifier("UserValidator") Vaildator vaildator){

        if (bindingResult.hasErrors()){
            return null; //placeHolder;
        }
        vaildator.validate(user,bindingResult);
        if (bindingResult.hasErrors()){
            return null;
        }
        user.setPassword(encoder.encode(user.getPassword()));
        if (DataBaseMethods.putUser(user)){
            return null; //  page
        }else {

            return null; //error page
        }
        //place holder
    }



}
