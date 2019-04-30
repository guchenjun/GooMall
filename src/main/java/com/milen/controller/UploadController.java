package com.milen.controller;


import com.milen.constant.ResultConstant;
import com.milen.constant.UploadConstant;
import com.milen.pojo.vo.ResultVO;
import com.milen.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/head", method = RequestMethod.POST)
    public ResultVO uploadHead(MultipartFile file) {
        String imagePath = uploadService.uploadHead(file);
        if (imagePath != null && !"".equals(imagePath)) {
            return ResultVO.ok(ResultConstant.UPLOAD_SUCCESS, ResultConstant.UPLOAD_SUCCESS_MSG, imagePath);
        }
        return ResultVO.error(ResultConstant.UPLOAD_ERROR, ResultConstant.UPLOAD_ERROR_MSG, "");
    }
}
