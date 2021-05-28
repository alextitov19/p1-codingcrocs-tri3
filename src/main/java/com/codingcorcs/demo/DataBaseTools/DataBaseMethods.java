package com.codingcorcs.demo.DataBaseTools;

import com.codingcorcs.demo.NewUser.NewUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseMethods {

    public static boolean putUser(NewUser user)  {

        try(Connection connection = DriverManager.getConnection(Config.getUrl(),Config.getUser(),Config.getPassword())){
            Statement statement = connection.createStatement();
            String sql = String.format("INSERT INTO userinfo(username,password) VALUES ('%s','%s')",user.getUsername(),user.getPassword());
            return statement.executeUpdate(sql) >0;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }
}
