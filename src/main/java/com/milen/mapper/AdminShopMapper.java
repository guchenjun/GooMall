package com.milen.mapper;

import com.milen.pojo.dto.ApplyShopRecordDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AdminShopMapper {

    List<ApplyShopRecordDTO> listApplyShopRecord();

    int updateAgreeShopRecord(@Param("recordId") int recordId, @Param("adminId") int adminId, @Param("gmtModified") Date gmtModified);
}
