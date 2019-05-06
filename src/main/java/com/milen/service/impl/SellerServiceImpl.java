package com.milen.service.impl;

import com.milen.mapper.SellerMapper;
import com.milen.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("sellerService")
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public String getSellerNameById(Long userId) {
        return sellerMapper.getSellerNameById(userId);
    }
}
