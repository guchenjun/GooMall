package com.milen.service;

import com.milen.model.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    Boolean saveUser(User user);

    Boolean getUsername(String username);

    String getPasswordByUsername(String username);

    User getUserByUsername(String username);

    boolean updateHeadImageById(String imagePath, Long id);

    String getPasswordById(Long id);

    boolean updatePasswordById(String newPwd, Long id);

}
