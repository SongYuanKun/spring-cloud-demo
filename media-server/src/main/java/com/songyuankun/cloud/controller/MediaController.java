package com.songyuankun.cloud.controller;

import com.songyuankun.cloud.common.Response;
import com.songyuankun.cloud.common.ResponseUtils;
import com.songyuankun.cloud.common.form.MediaForm;
import com.songyuankun.cloud.common.query.QueryMedia;
import com.songyuankun.cloud.common.response.MediaVO;
import com.songyuankun.cloud.entity.Media;
import com.songyuankun.cloud.service.MediaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author songyuankun
 */

@RestController
@RequestMapping("api/media")
@Slf4j
public class MediaController {
    private final MediaServiceImpl mediaService;

    @Autowired
    public MediaController(MediaServiceImpl mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping(value = "save", produces = "application/json")
    @CacheEvict(value = "queryMediaList", allEntries = true)
    public Response<MediaVO> saveMedia(@RequestBody MediaForm mediaForm) {
        log.info("saveMedia,{}", mediaForm);
        Media media = new Media();
        BeanUtils.copyProperties(mediaForm, media);
        Media saveMedia = mediaService.saveMedia(media);
        MediaVO mediaVO = new MediaVO();
        BeanUtils.copyProperties(saveMedia, mediaVO);
        return ResponseUtils.success(mediaVO);
    }

    @PostMapping(value = "query_media", produces = "application/json")
    @Cacheable(value = "queryMediaList", key = "'author'+#queryMedia.userId+'name'+#queryMedia.name+'pageNumber_'+#pageNumber+'pageSize_'+#pageSize")
    public Page<Media> queryMediaList(@RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
                                      @RequestParam(value = "size", defaultValue = "10") Integer pageSize, @RequestBody QueryMedia queryMedia) {
        return mediaService.queryMediaList(pageNumber, pageSize, queryMedia);
    }

    @PostMapping(value = "query_media_v2", produces = "application/json")
    @Cacheable(value = "queryMediaList", key = "'author'+#queryMedia.userId+'name'+#queryMedia.name+'pageNumber_'+#pageNumber+'pageSize_'+#pageSize")
    public Page<Media> queryMediaListV2(@RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize, @RequestBody QueryMedia queryMedia) {
        return mediaService.queryMediaListV2(pageNumber, pageSize, queryMedia);
    }

    @GetMapping(value = "query_by_id")
    public MediaVO queryMediaById(@RequestParam(value = "id") Integer id) {
        Media media = mediaService.queryById(id);
        MediaVO mediaVO = new MediaVO();
        BeanUtils.copyProperties(media, mediaVO);
        return mediaVO;
    }

}
