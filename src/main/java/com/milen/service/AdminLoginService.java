package com.milen.service;

import com.milen.model.po.Admin;

public interface AdminLoginService {

    boolean getUsername(String username);

    String getPasswordByUsername(String username);

    Admin getAdminByUsername(String username);
}
