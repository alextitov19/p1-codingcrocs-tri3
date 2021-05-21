package com.codingcorcs.demo.security.UserDetials;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserDao userDaoService;

    public UserService(@Qualifier("SQLTable")UserDao userDaoService) {
        this.userDaoService = userDaoService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDaoService.selectUserByUsername(s).orElseThrow(()->new UsernameNotFoundException("username of "+s+" not found in database"));
    }
}
