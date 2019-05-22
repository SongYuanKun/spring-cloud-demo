package com.songyuankun.cloud.media.client.feign;

import com.songyuankun.cloud.common.Response;
import com.songyuankun.cloud.common.ResponseUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author songyuankun
 */
@Component
public class UploadRemoteFallback implements UploadRemoteInterface {

    @Override
    public Response<String> uploadFile(MultipartFile file) {
        return ResponseUtils.error("upload error");
    }
}
