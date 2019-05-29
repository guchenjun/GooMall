package com.milen.mapper;

import com.milen.model.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    Integer saveUser(User user);

    Integer getUsername(String username);

    String getPasswordByUsername(String username);

    User getUserByUsername(String username);

    int updateHeadImageById(@Param("imagePath") String imagePath, @Param("id") Long id);

    String getPasswordById(@Param("id") Long id);

    int updatePasswordById(@Param("newPwd") String newPwdMd5, @Param("id") Long id);
}
