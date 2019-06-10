package com.milen.service.impl;

import com.milen.mapper.AdMapper;
import com.milen.model.po.Ad;
import com.milen.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("adService")
public class AdServiceImpl implements AdService {

    @Autowired
    AdMapper adMapper;

    @Override
    public List<Ad> listAd() {
        // 2019年6月2日 00:09:14
        // 顶部1，两侧2-3
        List<Ad> adList = adMapper.listAd();
        return adList;
    }

    @Override
    public void updateAd(Ad ad) {
        adMapper.updateAd(ad, new Date());
    }

    @Override
    public void updateAdStatusById(Long id) {
        Date date = new Date();
        Boolean status = adMapper.getStatusById(id);
        if (status) {
            adMapper.updateStatusOffById(id, date);
        } else {
            adMapper.updateStatusOnById(id, date);
        }
    }
}
