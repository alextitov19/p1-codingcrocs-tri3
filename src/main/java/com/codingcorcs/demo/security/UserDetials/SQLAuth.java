package com.codingcorcs.demo.security.UserDetials;

import com.codingcorcs.demo.DataBaseTools.Config;
import com.codingcorcs.demo.DataBaseTools.Config;
import com.codingcorcs.demo.security.Perms.Roles;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;
@Repository("SQLTable")
public class SQLAuth implements UserDao{
    @Override
    public Optional<User> selectUserByUsername(String username) {

        User thing = getUserFromDB(username);
        if (thing!=null){
        return Optional.of(thing);
        }
        return Optional.empty();

    }

    public User getUserFromDB(String username){
        User query = null;
        final String sqlRequest = "SELECT * FROM users WHERE username='"+username+"'";
        try(Connection con = DriverManager.getConnection(Config.getUrl(),Config.getUser(),Config.getPassword())) {

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlRequest);
            if (rs.next()){
                query = new User(Roles.User.getGrantedAuthority(),rs.getString("password"),rs.getString("username"),true,true,true,true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;


    }
}
