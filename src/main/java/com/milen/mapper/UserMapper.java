package com.milen.mapper;

import com.milen.entity.User;

public interface UserMapper {

    Integer saveUser(User user);

    Integer getUsername(String username);

    String getPasswordByUsername(String username);

    User findUser(User user);
}
