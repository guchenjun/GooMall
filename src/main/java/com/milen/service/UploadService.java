package com.milen.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    String uploadHead(MultipartFile file);
}
