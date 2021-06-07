package com.codingcorcs.demo.Forms;


import com.codingcorcs.demo.DataBaseTools.FormDataBase;
import com.codingcorcs.demo.Dto.Forms;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.AbstractMap;

/**
 * Froms is controller for all form related things like database management on top resolving templates and client connections
 */
@Controller
@RequestMapping("/Forms")
public class WebController {

    private final FormDataBase formDataBase;

    /**
     * Constructor of form web controller
     * @param formDataBase Autowired service for the form data bases methods
     */
    @Autowired
    public WebController(FormDataBase formDataBase) {

        this.formDataBase = formDataBase;
    }

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

        if (formDataBase.putPost(forms)) {
            return null; // could be template or json stuff
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request was not prefilled");
        }

    }

    /**
     * This should be called async as this method will take a longer time to process
     * @param id the id of the form to be deleted
     * @param authentication user account to make sure a non owner can not delete the form with out permission
     * @return json output of what was deleted
     */
    @PreAuthorize("hasAuthority('ROLE_User')")
    @DeleteMapping(value = "/Form/Delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteForm(@PathVariable long id, Authentication authentication) {
        String username = authentication.getName();
        AbstractMap.SimpleEntry<Boolean, Boolean> simpleEntry = formDataBase.deleteForm(id, username);
        if (simpleEntry.getValue() == null && simpleEntry.getKey() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There was an error processing your request with our database verify that you are the owner of the form");
        }
        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        objectNode.put("Form Deleted", simpleEntry.getKey());
        objectNode.put("Comments Deleted", simpleEntry.getValue());
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);
        } catch (JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something went processing your request we apologies for the inconvenience");
        }

    }
}
