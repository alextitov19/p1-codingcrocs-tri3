package com.codingcorcs.demo.Forms;


import com.codingcorcs.demo.DataBaseTools.FormDataBase;
import com.codingcorcs.demo.Dto.Comment;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        ArrayList<Forms> forms = new ArrayList<>();
        Collections.addAll(forms,formDataBase.formTitles());
        model.addAttribute("Forms",forms);
        return "forms_templates/Forms";
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
        AbstractMap.SimpleEntry<ArrayList<Forms>,ArrayList<Comment>> map = formDataBase.getForm(post_id);
        model.addAttribute("Form",map.getKey().get(0));
        model.addAttribute("Comments",map.getValue());
        return "forms_templates/Form";
    }

    @GetMapping(value = "/Forms/Add")
    public String AddForm(){

        return null;
    }

    /**
     * @param forms <font color='green'>form dto passed from front end to the back end for processing</font>
     * @return template to be resoled
     * @implNote <font color='red'>Still needs to be implemented</font>
     */
    @PreAuthorize("hasRole('ROLE_User')")
    @PostMapping(value = "/Form/Add")
    public String AddForm(@Valid Forms forms, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Form has errors: " + bindingResult.getFieldErrors());
        }

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
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something went wrong processing your request, we apologies for the inconvenience");
        }

    }

    @PreAuthorize("hasAuthority('ROLE_User')")
    @PostMapping(value = "/Form/Comment/Add",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addComment(@RequestBody Comment comment,Authentication authentication)  {
        System.out.println(comment.toString());
        System.out.println("Entered");
       comment.setPoster_name(authentication.getName());
       if(formDataBase.putComment(comment)){
           ObjectMapper objectMapper = new ObjectMapper();
           ObjectNode objectNode = objectMapper.createObjectNode();
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
           objectNode.put("Time-Created", dtf.format(LocalDateTime.now()));
           objectNode.put("Poster-Name",authentication.getName());
           try {
               return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);
           }catch (JsonProcessingException e){
               e.printStackTrace();
               throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error processing json value but request prefilled");
           }
       }else{
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User request Failed");
       }
    }
    @PreAuthorize("hasAuthority('ROLE_User')")
    @DeleteMapping(value = "/Form/Comment/Delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteComment(@PathVariable long id,Authentication authentication){
        String username = authentication.getName();
        if(formDataBase.deleteComment(id,username)){
                ObjectMapper objectMapper = new ObjectMapper();
                ObjectNode objectNode = objectMapper.createObjectNode();
                objectNode.put("Comment_ID",id);
                objectNode.put("Time_Deleted",DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
                try {
                    return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);
                }catch (JsonProcessingException e){
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Comment of Id "+id+" has been deleted but json string failed to be created");
                }
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"There was an error processing your request");
        }
    }

}
