package com.milen.service;

import com.milen.model.po.Ad;

import java.util.List;

public interface AdService {


    List<Ad> listAd();

    void updateAd(Ad ad);

    void updateAdStatusById(Long id);
}
