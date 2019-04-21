package com.milen.service.impl;

import com.milen.entity.User;
import com.milen.mapper.UserMapper;
import com.milen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(User user) {
        User loginUser = userMapper.findUser(user);
        return loginUser;
    }
}
