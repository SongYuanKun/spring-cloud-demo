package com.songyuankun.cloud.media.client.controller;

import com.songyuankun.cloud.common.Response;
import com.songyuankun.cloud.media.client.feign.UploadRemoteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author songyuankun
 */
@RestController
@RequestMapping("media/upload")
public class MediaUploadController {
    private final UploadRemoteInterface uploadRemoteInterface;

    @Autowired
    public MediaUploadController(UploadRemoteInterface uploadRemoteInterface) {
        this.uploadRemoteInterface = uploadRemoteInterface;
    }

    @PostMapping("file")
    public Response<String> uploadFile(@RequestParam("file") MultipartFile file) {
        return uploadRemoteInterface.uploadFile(file);
    }
}
