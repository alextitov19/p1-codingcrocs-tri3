package com.codingcorcs.demo;

import com.codingcorcs.demo.DataBaseTools.DataBaseMethods;
import com.codingcorcs.demo.NewUser.NewUser;
import com.codingcorcs.demo.security.Vaildator.Vaildator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    private final PasswordEncoder encoder;
    private final Vaildator vaildator;
    @Autowired
    public WebMainMvcController(PasswordEncoder encoder,@Qualifier("UserValidator") Vaildator vaildator){
        this.encoder=encoder;
        this.vaildator=vaildator;
    }

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
        model.addAttribute("newUser",new NewUser());
        System.out.println("Made it here to sign up");
        return "SignUpPage"; // place holder

    }

    @PostMapping("/SignUp")
    public String SignUpPage(@Valid NewUser user, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "SignUpPage";
        }
        vaildator.validate(user,bindingResult);
        if (bindingResult.hasErrors()){
            return "SignUpPage";
        }
        user.setPassword(encoder.encode(user.getPassword()));
        if (DataBaseMethods.putUser(user)){
            return "redirect:/login"; //  page
        }else {

            return "SignUpERROR"; //error page
        }
        //place holder
    }



}
