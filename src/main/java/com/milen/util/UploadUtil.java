package com.milen.util;

import com.milen.constant.UploadConstant;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtil {

    public static String uploadHead(MultipartFile file) {
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

    public static String uploadCover(MultipartFile file) {
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + suffix;
            String filePath = UploadConstant.COVER_PATH + fileName;
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
