package com.milen.service;

import com.milen.entity.User;

public interface UserService {

    Boolean saveUser(User user);

    Boolean getUsername(String username);

    String getPasswordByUsername(String username);

    User getUserByUsername(String username);
}
