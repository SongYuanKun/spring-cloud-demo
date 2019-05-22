package com.songyuankun.cloud.media.client.feign;


import com.songyuankun.cloud.common.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author songyuankun
 */
@Component
@FeignClient(name = "UPLOAD", fallback = UploadRemoteFallback.class)
public interface UploadRemoteInterface {
    /**
     * 上传文件
     *
     * @param file 文件
     * @return key
     */
    @PostMapping(value = "upload/file")
    Response<String> uploadFile(@RequestParam("file") MultipartFile file);
}
