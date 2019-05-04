package com.milen.service.impl;

import com.milen.mapper.AdminLoginMapper;
import com.milen.pojo.po.Admin;
import com.milen.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("adminLoginService")
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    AdminLoginMapper adminLoginMapper;

    @Override
    public boolean getUsername(String username) {
        int row = adminLoginMapper.getUsername(username);
        return row > 0;
    }

    @Override
    public String getPasswordByUsername(String username) {
        return adminLoginMapper.getPasswordByUsername(username);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminLoginMapper.getAdminByUsername(username);
    }
}
