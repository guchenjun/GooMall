package com.milen.mapper;

import com.milen.model.po.Brand;
import com.milen.model.po.BrandCategory;
import com.milen.model.po.Category1;
import com.milen.model.po.Category2;
import com.milen.model.vo.ReleaseGoodsVO;

import java.util.List;

public interface GoodsMapper {
    List<Category1> listCategory1();

    List<Category2> listCategory2();

    List<BrandCategory> listBrandAndCategory2();

    List<Brand> listBrand();

    int insertSPU(ReleaseGoodsVO releaseGoodsVO);
}
