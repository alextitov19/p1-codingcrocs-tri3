package com.codingcorcs.demo.Dto;

public class Comment {
    private Long comment_id;
    private Long post_id;
    private String poster_name;
    private String content_text;
    private boolean reply;
    private String reply_user;

    public Comment(Long comment_id, Long post_id, String poster_name, String content_text, boolean reply, String reply_user) {
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.poster_name = poster_name;
        this.content_text = content_text;
        this.reply = reply;
        this.reply_user = reply_user;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getPoster_name() {
        return poster_name;
    }

    public void setPoster_name(String poster_name) {
        this.poster_name = poster_name;
    }

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public boolean isReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }

    public String getReply_user() {
        return reply_user;
    }

    public void setReply_user(String reply_user) {
        this.reply_user = reply_user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", post_id=" + post_id +
                ", poster_name='" + poster_name + '\'' +
                ", content_text='" + content_text + '\'' +
                ", reply=" + reply +
                ", reply_user='" + reply_user + '\'' +
                '}';
    }
}

