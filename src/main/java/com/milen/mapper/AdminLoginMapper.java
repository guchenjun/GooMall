package com.milen.mapper;

import com.milen.model.po.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminLoginMapper {
    int getUsername(@Param("username") String username);

    String getPasswordByUsername(@Param("username") String username);

    Admin getAdminByUsername(@Param("username") String username);
}
