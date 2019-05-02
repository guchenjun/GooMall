package com.milen.controller;


import com.milen.constant.ResultConstant;
import com.milen.pojo.vo.ResultVO;
import com.milen.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value = "/head", method = RequestMethod.POST)
    public ResultVO uploadHead(MultipartFile file) {
        String imagePath = UploadUtil.uploadHead(file);
        if (imagePath != null && !"".equals(imagePath)) {
            return ResultVO.ok(ResultConstant.UPLOAD_SUCCESS, ResultConstant.UPLOAD_SUCCESS_MSG, imagePath);
        }
        return ResultVO.error(ResultConstant.UPLOAD_ERROR, ResultConstant.UPLOAD_ERROR_MSG, "");
    }
}
