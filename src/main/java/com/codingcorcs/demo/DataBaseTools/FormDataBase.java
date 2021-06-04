package com.codingcorcs.demo.DataBaseTools;

import com.codingcorcs.demo.Dto.Comment;
import com.codingcorcs.demo.Dto.Forms;

import java.sql.*;
import java.text.Normalizer;
import java.util.AbstractMap;
import java.util.ArrayList;

public class FormDataBase {


    /**
     * Should have learned jpa im crying
     * @return all titles from database
     */
    public Forms[] formTitles(){
        String sqlStatement = "SELECT post_id, form_title FROM forms LIMIT 90";
        try(Connection connection = DriverManager.getConnection(Config.getUrlForm(),Config.getUser(),Config.getPassword())){
            Statement statement = connection.createStatement();
           ResultSet set = statement.executeQuery(sqlStatement);
            ArrayList<Forms> forms = new ArrayList<>();
            /*
                result set should contain
                post_id

             */
           while (set.next()){
                    forms.add(new Forms(set.getLong("post_id"), set.getString("form_title")));
           }
           return forms.toArray(new Forms[0]);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AbstractMap.SimpleEntry<ArrayList<Forms>,ArrayList<Comment>> getForm(long post_id)  {
        ArrayList<Forms> form = new ArrayList<>(); // async
        ArrayList<Comment> comment = new ArrayList<>();
      Thread formThread =  new Thread(()->{
            String sql = String.format("SELECT * from forms where forms.post_id=%d",post_id);
            try(Connection connection = DriverManager.getConnection(Config.getUrlForm(),Config.getUser(),Config.getPassword())){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()){
                      form.add(new Forms(resultSet.getLong("post_id"),resultSet.getString("form_title"),resultSet.getString("poster_name"),resultSet.getString("post_content")));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        });
      Thread commentThread = new Thread(() ->{
                String sqlStatment = String.format("SELECT * from comment where comment.post_id=%d",post_id);
                try(Connection connection = DriverManager.getConnection(Config.getUrlForm(),Config.getUser(),Config.getPassword())){
                    Statement statement = connection.createStatement();
                    ResultSet set = statement.executeQuery(sqlStatment);
                    while(set.next()){
                        comment.add(new Comment(set.getLong("comment_id"),set.getLong("post_id"),set.getString("poster_name"),set.getString("content_text"),set.getBoolean("reply"),set.getString("reply_user")));
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
      });
      formThread.start();
      commentThread.start();
      try {
          formThread.join();
          commentThread.join(); // joins the threads together to wait for but result sets to be process
      }catch (InterruptedException e) {
          e.printStackTrace();
          return null;
      }
      return new AbstractMap.SimpleEntry<>(form,comment);
    }

}
