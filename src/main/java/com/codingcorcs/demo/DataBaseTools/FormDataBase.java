package com.codingcorcs.demo.DataBaseTools;

import com.codingcorcs.demo.Dto.Comment;
import com.codingcorcs.demo.Dto.Forms;

import java.sql.*;
import java.text.Normalizer;
import java.util.AbstractMap;
import java.util.ArrayList;

import static java.lang.System.out;

public class FormDataBase {


    /**
     * Should have learned jpa im crying
     *
     * @return all titles from database
     */
    public Forms[] formTitles() {
        String sqlStatement = "SELECT post_id,form_title FROM forms LIMIT 90";
        try (Connection connection = DriverManager.getConnection(Config.getUrlForm(), Config.getUser(), Config.getPassword())) {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sqlStatement);
            ArrayList<Forms> forms = new ArrayList<>();
            /*
                result set should contain
                post_id

             */
            while (set.next()) {
                forms.add(new Forms(set.getLong("post_id"), set.getString("form_title")));
            }
            return forms.toArray(new Forms[0]);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AbstractMap.SimpleEntry<ArrayList<Forms>, ArrayList<Comment>> getForm(long post_id) {
        ArrayList<Forms> form = new ArrayList<>(); // async
        ArrayList<Comment> comment = new ArrayList<>();
        Thread formThread = new Thread(() -> {
            String sql = String.format("SELECT * from forms where forms.post_id=%d", post_id);
            try (Connection connection = DriverManager.getConnection(Config.getUrlForm(), Config.getUser(), Config.getPassword())) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    form.add(new Forms(resultSet.getLong("post_id"), resultSet.getString("form_title"), resultSet.getString("poster_name"), resultSet.getString("post_content")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        Thread commentThread = new Thread(() -> {
            String sqlStatment = String.format("SELECT * from comment where comment.post_id=%d", post_id);
            try (Connection connection = DriverManager.getConnection(Config.getUrlForm(), Config.getUser(), Config.getPassword())) {
                Statement statement = connection.createStatement();
                ResultSet set = statement.executeQuery(sqlStatment);
                while (set.next()) {
                    comment.add(new Comment(set.getLong("comment_id"), set.getLong("post_id"), set.getString("poster_name"), set.getString("content_text"), set.getBoolean("reply"), set.getString("reply_user")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        formThread.start();
        commentThread.start();
        try {
            formThread.join();
            commentThread.join(); // joins the threads together to wait for but result sets to be process
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        return new AbstractMap.SimpleEntry<>(form, comment);
    }

    public boolean putComment(Comment comment) {
        if (comment == null) {
            return false;
        }
        String sqlStatment;
        if (comment.isReply()) { // if statement if reply user is null
            sqlStatment = String.format("INSERT INTO comment (post_id,poster_name,content_text,reply,reply_user) VALUES (%d,'%s','%s',%s,'%s')", comment.getPost_id(), comment.getPoster_name(), comment.getContent_text(), comment.isReply(), comment.getReply_user());
        } else {
            sqlStatment = String.format("INSERT INTO comment (post_id,poster_name,content_text,reply) VALUES (%d,'%s','%s',%s)", comment.getPost_id(), comment.getPoster_name(), comment.getContent_text(), comment.isReply());
        }
        try (Connection connection = DriverManager.getConnection(Config.getUrlForm(), Config.getUser(), Config.getPassword())) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sqlStatment) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean putPost(Forms forms) {
        if (forms == null) {
            return false;
        }
        String sqlStatment;
        if (forms.getPost_content() == null) {
            sqlStatment = String.format("INSERT INTO forms (form_title,poster_name) VALUES ('%s','%s')", forms.getForm_title(), forms.getPoster_name());
        } else {
            sqlStatment = String.format("INSERT INTO forms (form_title,poster_name,post_content) VALUES ('%s','%s','%s')", forms.getForm_title(), forms.getPoster_name(), forms.getPost_content());
        }
        try (Connection connection = DriverManager.getConnection(Config.getUrlForm(), Config.getUser(), Config.getPassword())) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sqlStatment) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateComment(Comment comment) {
        if (comment == null) {
            return false;
        }
        String sqlStatment = String.format("UPDATE comment SET content_text='%s' WHERE comment_id=%d", comment.getContent_text(), comment.getComment_id());
        try (Connection connection = DriverManager.getConnection(Config.getUrlForm(), Config.getUser(), Config.getPassword())) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sqlStatment) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateForm(Forms forms) {
        if (forms == null) {
            return false;
        }
        String sqlStatment;
        if (forms.getPost_content() == null) {
            sqlStatment = String.format("UPDATE forms SET form_title='%s',post_content=NULL WHERE post_id=%d", forms.getForm_title(),forms.getPost_id());
        } else {
             sqlStatment = String.format("UPDATE forms SET form_title='%s',post_content='%s' WHERE post_id=%d", forms.getForm_title(), forms.getPost_content(), forms.getPost_id());
        }
        try (Connection connection = DriverManager.getConnection(Config.getUrlForm(), Config.getUser(), Config.getPassword())) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sqlStatment) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteComment(Long comment_id) {
        String sqlStatment = "DELETE FROM comment WHERE comment_id=" + comment_id;
        try (Connection connection = DriverManager.getConnection(Config.getUrlForm(), Config.getUser(), Config.getPassword())) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sqlStatment) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteForm(Long form_id) {
        String sqlStatment = "DELETE FROM forms WHERE post_id=" + form_id;
        try (Connection connection = DriverManager.getConnection(Config.getUrlForm(), Config.getUser(), Config.getPassword())) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sqlStatment) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        new Config();
        FormDataBase dataBase = new FormDataBase();
        Forms forms = new Forms();
        forms.setForm_title("this a test from java");
        forms.setPost_content("data back");
        forms.setPost_id(1L);
        out.println(dataBase.updateForm(forms));
    }

}
