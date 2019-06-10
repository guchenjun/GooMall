package com.milen.mapper;

import com.milen.model.po.Ad;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AdMapper {

    List<Ad> listAd();

    void updateAd(@Param("ad") Ad ad, @Param("date") Date date);

    Boolean getStatusById(@Param("id") Long id);

    void updateStatusOnById(@Param("id") Long id, @Param("date") Date date);

    void updateStatusOffById(@Param("id") Long id, @Param("date") Date date);
}
