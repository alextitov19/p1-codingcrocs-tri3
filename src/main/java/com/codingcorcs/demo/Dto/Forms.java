package com.codingcorcs.demo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Forms {

    private Long post_id;
    @Length(min = 4,max = 50,message = "title must not be longer then 50 characters")
    private String form_title;
    private String poster_name;
    @Length(min = 0,max = 500,message = "message must not be longer than 500 characters")
    private String post_content;


    public Forms() {

    }

    public Forms(Long post_id, String form_title) {
        this.post_id = post_id;
        this.form_title = form_title;
    }

    public Forms(Long post_id, String form_title, String poster_name, String post_content) {
        this.post_id = post_id;
        this.form_title = form_title;
        this.poster_name = poster_name;
        this.post_content = post_content;
    }

    public Long getPost_id() {
        return post_id;
    }

    public String getForm_title() {
        return form_title;
    }

    public String getPoster_name() {
        return poster_name;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public void setForm_title(String form_title) {
        this.form_title = form_title;
    }

    public void setPoster_name(String poster_name) {
        this.poster_name = poster_name;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }


    @Override
    public String toString() {
        return "Forms{" +
                "post_id=" + post_id +
                ", form_title='" + form_title + '\'' +
                ", poster_name='" + poster_name + '\'' +
                ", post_content='" + post_content + '\'' +
                '}';
    }
}
