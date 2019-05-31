package com.milen.mapper;

import com.milen.model.dto.ApplyShopRecordDTO;
import com.milen.model.po.Shop;
import com.milen.model.vo.ShopVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AdminShopMapper {

    List<ApplyShopRecordDTO> listApplyShopRecord();

    int updateAgreeShopRecord(@Param("recordId") int recordId, @Param("adminId") int adminId, @Param("gmtModified") Date gmtModified);

    List<Shop> listShopInfo();

    Shop getShopById(@Param("shopId") int shopId);

    Long getShopIdByRecordId(@Param("recordId") int recordId);

    int updateShopStatusByShopId(@Param("shopId") Long shopId);
}
