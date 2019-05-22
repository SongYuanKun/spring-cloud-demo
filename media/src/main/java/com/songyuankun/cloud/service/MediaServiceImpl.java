package com.songyuankun.cloud.service;

import com.songyuankun.cloud.common.query.QueryMedia;
import com.songyuankun.cloud.entity.Media;
import com.songyuankun.cloud.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * @author songyuankun
 */
@Service
public class MediaServiceImpl {

    private final MediaRepository mediaRepository;

    @Autowired
    public MediaServiceImpl(MediaRepository mediaRepository) {

        this.mediaRepository = mediaRepository;
    }


    public Media saveMedia(Media media) {
        return mediaRepository.save(media);
    }

    /**
     * 查询条件不能为null
     *
     * @param pageNumber 页数
     * @param pageSize   条数
     * @param queryMedia 请求参数
     * @return 分页media
     */

    public Page<Media> queryMediaListV2(int pageNumber, int pageSize, QueryMedia queryMedia) {
        Sort sort = new Sort(Sort.Direction.DESC, "name");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return mediaRepository.findAllByUserIdContainingAndNameContaining(queryMedia.getUserId(), queryMedia.getName(), pageable);
    }


    public Page<Media> queryMediaList(int pageNumber, int pageSize, QueryMedia queryMedia) {
        Sort sort = new Sort(Sort.Direction.DESC, "name");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return mediaRepository.findAll((Specification<Media>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.and(
                        criteriaBuilder.like(root.get("author"), "%" + queryMedia.getUserId() + "%"),
                        criteriaBuilder.like(root.get("name"), "%" + queryMedia.getName() + "%")
                ), pageable);
    }

    public Media queryById(int id) {
        return mediaRepository.getOne(id);
    }
}
