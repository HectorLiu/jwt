package com.hector.jwt.service;


import com.hector.jwt.model.User;
import com.hector.jwt.shiro.core.Authenticatable;
import com.hector.jwt.shiro.core.UserProvider;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserProvider {


    @Override
    public Authenticatable retrieveById(Object identifier) {
        User user = new User();
        user.setId((Long) identifier);
        user.setName("hector");
        user.setAge(30);
        return user;
    }
}
