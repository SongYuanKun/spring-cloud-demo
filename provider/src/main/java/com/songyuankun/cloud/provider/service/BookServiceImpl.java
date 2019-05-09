package com.songyuankun.cloud.provider.service;

import com.songyuankun.cloud.provider.entity.Book;
import com.songyuankun.cloud.provider.query.QueryBook;
import com.songyuankun.cloud.provider.repository.BookRepository;
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
public class BookServiceImpl {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * 查询条件不能为null
     *
     * @param pageNumber 页数
     * @param pageSize   条数
     * @param queryBook  请求参数
     * @return 分页book
     */
    
    public Page<Book> queryBookListV2(int pageNumber, int pageSize, QueryBook queryBook) {
        Sort sort = new Sort(Sort.Direction.DESC, "name");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return bookRepository.findAllByAuthorContainingAndNameContaining(queryBook.getAuthor(), queryBook.getName(), pageable);
    }

    
    public Page<Book> queryBookList(int pageNumber, int pageSize, QueryBook queryBook) {
        Sort sort = new Sort(Sort.Direction.DESC, "name");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return bookRepository.findAll((Specification<Book>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.and(
                        criteriaBuilder.like(root.get("author"), "%" + queryBook.getAuthor() + "%"),
                        criteriaBuilder.like(root.get("name"), "%" + queryBook.getName() + "%")
                ), pageable);
    }
}
