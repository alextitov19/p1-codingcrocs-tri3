package com.codingcorcs.demo.security.Vaildator;

import com.codingcorcs.demo.DataBaseTools.Config;
import com.codingcorcs.demo.NewUser.NewUser;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.*;


@Service
@Repository("UserValidator")
public class Vaildator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return NewUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
            NewUser user = (NewUser) o;
            if (!isUnique(user.getUsername())){
                errors.rejectValue("username","USER.USERNAME.UNIQUE.username","username is not unique");
            }

    }


    private boolean isUnique(String username){
        try(Connection connection = DriverManager.getConnection(Config.getUrl(),Config.getUser(),Config.getPassword())) {
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT COUNT(username) AS total FROM userinfo WHERE username='"+username+"'";
            ResultSet set = statement.executeQuery(sqlQuery);
            if (set.next()){
                return set.getInt("total")<=0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
