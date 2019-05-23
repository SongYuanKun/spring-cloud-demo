package com.songyuankun.cloud.media.client.feign;


import com.songyuankun.cloud.common.Response;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    @RequestMapping(method = RequestMethod.POST, value = "upload/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Response<String> uploadFile(@RequestParam("file") MultipartFile file);

    @Configuration
    class MultipartSupportConfig {
        @Bean
        public SpringFormEncoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
