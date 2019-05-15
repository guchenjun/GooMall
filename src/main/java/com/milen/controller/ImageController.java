package com.milen.controller;


import com.milen.constant.UploadConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/image")
public class ImageController {

    @RequestMapping("head/{fileName}.{suffix}")
    public void showImage(@PathVariable("fileName") String fileName, @PathVariable("suffix") String suffix,
                          HttpServletResponse response) {
        File file = new File(UploadConstant.HEAD_PATH + fileName + "." + suffix);
        try (InputStream is = new FileInputStream(file);
             OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[1024]; // 图片文件流缓存池
            while (is.read(buffer) != -1) {
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @RequestMapping("goods/{fileName}.{suffix}")
    public void showCover(@PathVariable("fileName") String fileName, @PathVariable("suffix") String suffix,
                          HttpServletResponse response) {
        File file = new File(UploadConstant.COVER_PATH + fileName + "." + suffix);
        try (InputStream is = new FileInputStream(file);
             OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[1024]; // 图片文件流缓存池
            while (is.read(buffer) != -1) {
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
