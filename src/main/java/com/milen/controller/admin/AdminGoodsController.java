package com.milen.controller.admin;

import com.milen.model.dto.CategoryBrandDTO;
import com.milen.model.vo.GoodsCategoryVO;
import com.milen.model.vo.R;
import com.milen.service.AttributeService;
import com.milen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private AttributeService attributeService;

    @RequestMapping("/category")
    public String category(Model model) {
        GoodsCategoryVO goodsCategoryVO = goodsService.listCategoryAndBrand();
        model.addAttribute("goodsCategory", goodsCategoryVO);
        return "admin";
    }

    @RequestMapping("/attribute/{id}")
    @ResponseBody
    public List<Map<String, Object>> attribute(@PathVariable("id") Long id) {
        List<Map<String, Object>> mapList = attributeService.getAttributesListByCategory2(id);
        System.out.println(mapList);
        return mapList;
    }

    @RequestMapping(value = "/attribute/name/add", method = RequestMethod.POST)
    @ResponseBody
    public R addAttributeName(@RequestParam("attrName")String attrName,
                              @RequestParam("category2Id") Long category2Id) {
        boolean isSaved = attributeService.saveAttrName(attrName, category2Id);
        if (isSaved) {
            return R.ok(200, "添加属性名称成功!");
        }
        return R.error(400, "添加属性名称失败!");
    }

    @RequestMapping(value = "/attribute/value/add", method = RequestMethod.POST)
    @ResponseBody
    public R addAttributeValue(@RequestParam("attrId") Long attrId, @RequestParam("attrValue") String attrValue) {
        String attrName = attributeService.getAttrNameByAttrId(attrId);
        boolean isSaved = attributeService.saveAttrValueAndAttrNameByAttrId(attrName, attrValue, attrId);
        if (isSaved) {
            return R.ok(200, "添加属性成功!");
        } else {
            return R.error(400, "添加属性失败!");
        }
    }

    @RequestMapping(value = "/brand/add", method = RequestMethod.POST)
    @ResponseBody
    public R addBrand(@RequestBody CategoryBrandDTO categoryBrandDTO) {
        boolean isSaved = attributeService.saveBrandByCategoryDTO(categoryBrandDTO);
        if (isSaved) {
            return R.ok(200, "品牌添加成功!");
        }
        return R.error(400, "品牌添加失败!");
    }

    @RequestMapping("/spu")
    public String spu() {
        return "admin";
    }

    @RequestMapping("/sku")
    public String sku() {
        return "admin";
    }
}
