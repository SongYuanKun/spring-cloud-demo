package com.songyuankun.cloud.media.client.feign;


import com.songyuankun.cloud.common.Response;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author songyuankun
 */
@Component
@FeignClient(name = "UPLOAD", fallback = UploadRemoteFallback.class, configuration = UploadRemoteInterface.MultipartSupportConfig.class)
public interface UploadRemoteInterface {
    /**
     * 上传文件
     *
     * @param file 文件
     * @return key
     */
    @RequestMapping(method = RequestMethod.POST, value = "upload/file", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Response<Map<String,Object>> uploadFile(@RequestPart("file") MultipartFile file);

    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
