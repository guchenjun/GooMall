package com.milen.controller;


import com.milen.constant.ResultConstant;
import com.milen.model.vo.R;
import com.milen.util.UploadUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value = "/head", method = RequestMethod.POST)
    public R uploadHead(MultipartFile file) {
        String imagePath = UploadUtil.uploadHead(file);
        if (imagePath != null && !"".equals(imagePath)) {
            return R.ok(ResultConstant.UPLOAD_SUCCESS, ResultConstant.UPLOAD_SUCCESS_MSG, imagePath);
        }
        return R.error(ResultConstant.UPLOAD_ERROR, ResultConstant.UPLOAD_ERROR_MSG, "");
    }
    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    public R uploadCover(MultipartFile file) {
        String imagePath = UploadUtil.uploadCover(file);
        if (imagePath != null && !"".equals(imagePath)) {
            return R.ok(ResultConstant.UPLOAD_SUCCESS, ResultConstant.UPLOAD_SUCCESS_MSG, imagePath);
        }
        return R.error(ResultConstant.UPLOAD_ERROR, ResultConstant.UPLOAD_ERROR_MSG, "");
    }
}
