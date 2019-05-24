package com.songyuankun.cloud.media.client.feign;

import com.songyuankun.cloud.common.Response;
import com.songyuankun.cloud.common.ResponseUtils;
import com.songyuankun.cloud.common.form.MediaForm;
import com.songyuankun.cloud.common.response.MediaVO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.util.Map;

/**
 * @author songyuankun
 */
@Component
public class MediaRemoteFallback implements MediaRemoteInterface {

    @Override
    public Response<MediaVO> saveMedia(MediaForm mediaForm) {
        return ResponseUtils.error(null);
    }
}
