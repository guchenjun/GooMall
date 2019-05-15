package com.milen.service;

import com.milen.model.vo.GoodsCategoryVO;
import com.milen.model.vo.ReleaseGoodsVO;

public interface GoodsService {

    GoodsCategoryVO listCategoryAndBrand();

    boolean saveSPU(ReleaseGoodsVO releaseGoodsVO);
}
