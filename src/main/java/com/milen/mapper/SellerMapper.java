package com.milen.mapper;

import org.apache.ibatis.annotations.Param;

public interface SellerMapper {

    String getSellerNameById(@Param("userId") Long userId);
}
