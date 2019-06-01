package com.milen.mapper;

import com.milen.model.po.Feedback;
import com.milen.model.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserMapper {

    Integer saveUser(User user);

    Integer getUsername(String username);

    String getPasswordByUsername(String username);

    User getUserByUsername(String username);

    int updateHeadImageById(@Param("imagePath") String imagePath, @Param("id") Long id);

    String getPasswordById(@Param("id") Long id);

    int updatePasswordById(@Param("newPwd") String newPwdMd5, @Param("id") Long id);

    String getUsernameById(@Param("userId") Long userId);

    void insertFeedback(@Param("content") String content, @Param("username") String username, @Param("date") Date date);

    List<Feedback> listFeedback();
}
