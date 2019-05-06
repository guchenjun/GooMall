package com.milen.service.impl;

import com.milen.mapper.ApplyShopRecordMapper;
import com.milen.model.po.ApplyShopRecord;
import com.milen.service.ApplyShopRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("applyShopRecordService")
public class ApplyShopRecordServiceImpl implements ApplyShopRecordService {

    @Autowired
    ApplyShopRecordMapper applyShopRecordMapper;

    @Override
    public boolean saveApplyShopRecord(Long userId, Long shopId) {
        Date date = new Date();
        ApplyShopRecord applyShopRecord = new ApplyShopRecord();
        applyShopRecord.setUserId(userId);
        applyShopRecord.setShopId(shopId);
        applyShopRecord.setAdminId(null);
        applyShopRecord.setReviewStatus(false);
        applyShopRecord.setGmtCreate(date);
        applyShopRecord.setGmtModified(date);
        Long row = applyShopRecordMapper.saveApplyShopRecord(applyShopRecord);
        return row > 0;
    }
}
