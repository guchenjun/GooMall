package com.milen.service.impl;

import com.milen.model.po.Feedback;
import com.milen.model.po.User;
import com.milen.mapper.UserMapper;
import com.milen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

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
    public Boolean getUsername(String username) {
        Integer row = userMapper.getUsername(username);
        return row > 0;
    }

    @Override
    public String getPasswordByUsername(String username) {
        String md5Password = userMapper.getPasswordByUsername(username);
        return md5Password;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userMapper.getUserByUsername(username);
        return user;
    }

    @Override
    public boolean updateHeadImageById(String imagePath, Long id) {
        int row = userMapper.updateHeadImageById(imagePath, id);
        return row > 0;
    }

    @Override
    public String getPasswordById(Long id) {
        return userMapper.getPasswordById(id);
    }

    @Override
    public boolean updatePasswordById(String newPwd, Long id) {
        String newPwdMd5 = DigestUtils.md5DigestAsHex(newPwd.getBytes());
        int row = userMapper.updatePasswordById(newPwdMd5, id);
        return row > 0;
    }

    @Override
    public void saveFeedback(String content, String username) {
        userMapper.insertFeedback(content, username, new Date());
    }

    @Override
    public List<Feedback> listFeedback() {
        List<Feedback> feedbackList = userMapper.listFeedback();
        return feedbackList;
    }
}
