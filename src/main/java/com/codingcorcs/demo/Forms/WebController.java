package com.codingcorcs.demo.Forms;


import com.codingcorcs.demo.Dto.Forms;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Froms is controller for all form related things like database management on top resolving templates and client connections
 */
@Controller
@RequestMapping("/Forms")
public class WebController {
    /**
     * Get all of the forms from the database
     *
     * @param model model proved by spring
     * @return html template to be resolved
     */
    @GetMapping({"/", "/titles", "/all"})
    public String getTitles(Model model) {
        return null;
    }

    /**
     * get a single form from the database use a path var
     *
     * @param post_id the id of the form, ever form has a unique id
     * @param model   model proved by spring
     * @return html template to be resolved
     */
    @GetMapping("/Forms/{id}") // path varable that gets the post_id from the database
    public String getForm(@PathVariable("id") long post_id, Model model) {

        return null;
    }

    /**
     * @param forms <font color='green'>form dto passed from front end to the back end for processing</font>
     * @return template to be resoled
     * @implNote <font color='red'>Still needs to be implemented</font>
     */
    @PreAuthorize("hasRole('ROLE_User')")
    @PostMapping("/Form/Add")
    public String AddForm(@ModelAttribute Forms forms) {
        /*
            @todo needs to be implemented
         */
        return null;
    }
}
