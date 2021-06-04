package com.codingcorcs.demo.DataBaseTools;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

@Component
public class Config {

    private static String password;
    private static String user;
    private static String url;
    private static String urlForm;


    @PostConstruct
    private void initTable()  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("DataBaseTools/info.txt"))));
        String temp;
        try {
            int counter =0;
            while ((temp= reader.readLine())!=null){
                String[] tempArray = temp.split(" ");
                StringBuilder builder = new StringBuilder();
                for (String thing:tempArray) {
                    char ch = (char) Integer.parseInt(thing);
                    builder.append(ch);
                }
                if (counter==0){
                    user=builder.toString();
                    counter++;
                    continue;
                }
                if (counter==1){
                    password=builder.toString();
                    counter++;
                    continue;
                }
                if (counter==2){
                    url = builder.toString();
                    counter++;
                    continue;
                }
                if (counter==3){
                    urlForm = builder.toString();
                    counter++;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.exit(2);
        }



    }

    public static String getPassword() {
        return password;
    }

    public static String getUser() {
        return user;
    }

    public static String getUrl() {
        return url;
    }
    public static String getUrlForm(){return urlForm;}
}
