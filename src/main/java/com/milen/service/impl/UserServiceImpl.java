package com.milen.service.impl;

import com.milen.entity.User;
import com.milen.mapper.UserMapper;
import com.milen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean saveUser(User user) {
        String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Password);
        Integer row = userMapper.saveUser(user);
        return row > 0;
    }

    @Override
    public User findUser(User user) {
        User loginUser = userMapper.findUser(user);
        return loginUser;
    }

    @Override
    public Boolean getUsername(String username) {
        Integer row = userMapper.getUsername(username);
        return row > 0;
    }

    @Override
    public String getPasswordByUsername(String username) {
        String md5Password = userMapper.getPasswordByUsername(username);
        return md5Password;
    }
}
