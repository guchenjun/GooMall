package com.milen.service;

import com.milen.pojo.po.User;

public interface UserService {

    Boolean saveUser(User user);

    Boolean getUsername(String username);

    String getPasswordByUsername(String username);

    User getUserByUsername(String username);
}
