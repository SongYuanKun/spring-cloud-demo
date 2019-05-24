package com.songyuankun.cloud.media.client.feign;


import com.songyuankun.cloud.common.Response;
import com.songyuankun.cloud.common.form.MediaForm;
import com.songyuankun.cloud.common.response.MediaVO;
import com.songyuankun.cloud.media.client.config.MultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author songyuankun
 */
@Component
@FeignClient(name = "MEDIA-SERVER", fallback = MediaRemoteFallback.class, configuration = MultipartSupportConfig.class)
public interface MediaRemoteInterface {
    /**
     * 上传文件
     *
     * @param mediaForm 媒体
     * @return key
     */
    @PostMapping(value = "api/media/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Response<MediaVO> saveMedia(@RequestBody MediaForm mediaForm);

}
