package com.milen.service;

import com.milen.model.po.Shop;
import com.milen.model.vo.ApplyShopRecordVO;
import com.milen.model.vo.ShopVO;

import java.util.List;

public interface AdminShopService {

    List<ApplyShopRecordVO> listApplyShopRecord();

    boolean updateAgreeShopRecord(int recordId, int adminId);

    List<ShopVO> listShopInfo();

    Shop getShopById(int shopId);
}
