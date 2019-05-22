package com.songyuankun.cloud.repository;

import com.songyuankun.cloud.entity.Media;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author songyuankun
 */
public interface MediaRepository extends JpaRepository<Media, Integer>, JpaSpecificationExecutor<Media> {

    /**
     * 模糊查询
     *
     * @param userId   作者
     * @param name     姓名
     * @param pageable 分页参数
     * @return 分页结果
     */
    Page<Media> findAllByUserIdContainingAndNameContaining(Integer userId, String name, Pageable pageable);
}
