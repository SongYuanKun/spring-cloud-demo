package com.songyuankun.cloud.media.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.songyuankun.cloud.common.Response;
import com.songyuankun.cloud.common.form.MediaForm;
import com.songyuankun.cloud.common.response.MediaVO;
import com.songyuankun.cloud.media.client.feign.MediaRemoteInterface;
import com.songyuankun.cloud.media.client.feign.UploadRemoteInterface;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * @author songyuankun
 */
@RestController
@RequestMapping("media/upload")
@Log
public class MediaUploadController {
    private final UploadRemoteInterface uploadRemoteInterface;
    private final MediaRemoteInterface mediaRemoteInterface;

    @Autowired
    public MediaUploadController(UploadRemoteInterface uploadRemoteInterface, MediaRemoteInterface mediaRemoteInterface) {
        this.uploadRemoteInterface = uploadRemoteInterface;
        this.mediaRemoteInterface = mediaRemoteInterface;
    }

    @PostMapping("file")
    public Response<MediaVO> uploadFile(@RequestParam("file") MultipartFile file, @ModelAttribute @Valid MediaForm mediaForm) {
        Response<JSONObject> jsonObjectResponse = uploadRemoteInterface.uploadFile(file);
        JSONObject date = jsonObjectResponse.getDate();
        String url = date.getString("url");
        mediaForm.setUrl(url);
        return mediaRemoteInterface.saveMedia(mediaForm);
    }
}
