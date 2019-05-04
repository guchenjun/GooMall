package com.milen.service.impl;

import com.milen.mapper.AdminMapper;
import com.milen.mapper.AdminShopMapper;
import com.milen.pojo.dto.ApplyShopRecordDTO;
import com.milen.pojo.vo.ApplyShopRecordVO;
import com.milen.service.AdminShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("adminShopService")
public class AdminShopServiceImpl implements AdminShopService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminShopMapper adminShopMapper;

    @Override
    public List<ApplyShopRecordVO> listApplyShopRecord() {
        List<ApplyShopRecordDTO> recordListDTO = adminShopMapper.listApplyShopRecord();
        List<ApplyShopRecordVO> recordListVO = new ArrayList<>();
        for (ApplyShopRecordDTO recordDTO : recordListDTO) {
            String admin = "无", status = "未审核";
            Integer adminId = recordDTO.getAdminId();
            Boolean reviewStatus = recordDTO.getReviewStatus();
            if (adminId != null) {
                admin = adminMapper.findRealNameById(adminId);
            }
            if (reviewStatus) {
                status = "已通过";
            }
            recordListVO.add(new ApplyShopRecordVO(recordDTO, admin, status));
        }
        return recordListVO;
    }

    @Override
    public boolean updateAgreeShopRecord(int recordId, int adminId) {
        Date gmtModified = new Date();
        int row = adminShopMapper.updateAgreeShopRecord(recordId, adminId, gmtModified);
        return row > 0;
    }
}
