package com.songyuankun.cloud.provider.repository;

import com.songyuankun.cloud.provider.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author songyuankun
 */
public interface BookRepository extends JpaRepository<Book, Integer> {


}
