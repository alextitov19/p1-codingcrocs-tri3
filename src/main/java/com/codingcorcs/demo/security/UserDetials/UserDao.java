package com.codingcorcs.demo.security.UserDetials;



import java.util.Optional;

public interface UserDao {
    Optional<User> selectUserByUsername(String username);
}
