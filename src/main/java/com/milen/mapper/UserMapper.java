package com.milen.mapper;

import com.milen.model.po.User;

public interface UserMapper {

    Integer saveUser(User user);

    Integer getUsername(String username);

    String getPasswordByUsername(String username);

    User getUserByUsername(String username);
}
