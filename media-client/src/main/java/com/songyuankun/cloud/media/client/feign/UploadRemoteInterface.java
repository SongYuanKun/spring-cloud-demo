package com.songyuankun.cloud.media.client.feign;


import com.alibaba.fastjson.JSONObject;
import com.songyuankun.cloud.common.Response;
import com.songyuankun.cloud.media.client.config.MultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author songyuankun
 */
@Component
@FeignClient(name = "UPLOAD", fallback = UploadRemoteFallback.class, configuration = MultipartSupportConfig.class)
public interface UploadRemoteInterface {
    /**
     * 上传文件
     *
     * @param file 文件
     * @return key
     */
    @PostMapping( value = "upload/file", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Response<JSONObject> uploadFile(@RequestPart("file") MultipartFile file);
}
