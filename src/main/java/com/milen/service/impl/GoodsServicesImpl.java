package com.milen.service.impl;

import com.milen.mapper.GoodsMapper;
import com.milen.model.po.Brand;
import com.milen.model.po.BrandCategory;
import com.milen.model.po.Category1;
import com.milen.model.po.Category2;
import com.milen.model.vo.BrandCategoryVO;
import com.milen.model.vo.GoodsCategoryVO;
import com.milen.model.vo.ReleaseGoodsVO;
import com.milen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("goodsService")
public class GoodsServicesImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;



    @Override
    public GoodsCategoryVO listCategoryAndBrand() {
        List<Category1> category1List = goodsMapper.listCategory1();
        List<Category2> category2List = goodsMapper.listCategory2();
        List<Brand> brandList = goodsMapper.listBrand();
        List<BrandCategory> brandCategoryList = goodsMapper.listBrandAndCategory2();
        GoodsCategoryVO goodsCategoryVO = new GoodsCategoryVO(category1List, category2List, brandList, brandCategoryList);
        return goodsCategoryVO;
    }

    @Override
    public boolean saveSPU(ReleaseGoodsVO releaseGoodsVO) {
        int row = goodsMapper.insertSPU(releaseGoodsVO);
        return row > 0;
    }
}
