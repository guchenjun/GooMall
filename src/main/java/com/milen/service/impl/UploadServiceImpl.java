package com.milen.service.impl;


import com.milen.constant.UploadConstant;
import com.milen.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("uploadService")
public class UploadServiceImpl implements UploadService {


    @Override
    public String uploadHead(MultipartFile file) {
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + suffix;
            String filePath = UploadConstant.HEAD_PATH + fileName;
            File saveFile = new File(filePath);
            try {
                file.transferTo(saveFile);
                return fileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
