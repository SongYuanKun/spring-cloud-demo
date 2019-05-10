package com.songyuankun.cloud.provider.repository;

import com.songyuankun.cloud.provider.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author songyuankun
 */
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    /**
     * 模糊查询
     *
     * @param author   作者
     * @param name     姓名
     * @param pageable 分页参数
     * @return 分页结果
     */
    Page<Book> findAllByAuthorContainingAndNameContaining(String author, String name, Pageable pageable);
}
