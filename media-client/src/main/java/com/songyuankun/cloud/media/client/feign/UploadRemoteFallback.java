package com.songyuankun.cloud.media.client.feign;

import com.songyuankun.cloud.common.Response;
import com.songyuankun.cloud.common.ResponseUtils;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author songyuankun
 */
@Component
public class UploadRemoteFallback implements UploadRemoteInterface {

    @Override
    public Response<Map<String,Object>> uploadFile(MultipartFile file) {
        return ResponseUtils.error(null);
    }
}
