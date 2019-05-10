package com.songyuankun.cloud.provider.controller;

import com.songyuankun.cloud.common.entity.Book;
import com.songyuankun.cloud.common.form.BookForm;
import com.songyuankun.cloud.common.query.QueryBook;
import com.songyuankun.cloud.provider.service.BookServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author songyuankun
 */

@RestController
@RequestMapping("api/book")
@Api
@Slf4j
public class BookController {
    private final BookServiceImpl bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @ApiOperation(value = "保存book", notes = "保存book")
    @PostMapping(value = "save", produces = "application/json")
    @CacheEvict(value = "queryBookList", allEntries = true)
    public Book saveBook(@RequestBody BookForm bookForm) {
        log.info("saveBook,{}", bookForm);
        Book book = new Book();
        BeanUtils.copyProperties(bookForm, book);
        return bookServiceImpl.saveBook(book);
    }

    @ApiOperation(value = "分页查询book", notes = "分页查询book")
    @PostMapping(value = "query_book", produces = "application/json")
    @Cacheable(value = "queryBookList", key = "'author'+#queryBook.author+'name'+#queryBook.name+'pageNumber_'+#pageNumber+'pageSize_'+#pageSize")
    public Page<Book> queryBookList(@RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
                                    @RequestParam(value = "size", defaultValue = "10") Integer pageSize, @RequestBody QueryBook queryBook) {
        return bookServiceImpl.queryBookList(pageNumber, pageSize, queryBook);
    }

    @ApiOperation(value = "分页查询book", notes = "分页查询book")
    @PostMapping(value = "query_book_v2", produces = "application/json")
    @Cacheable(value = "queryBookList", key = "'author'+#queryBook.author+'name'+#queryBook.name+'pageNumber_'+#pageNumber+'pageSize_'+#pageSize")
    public Page<Book> queryBookListV2(@RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
                                      @RequestParam(value = "size", defaultValue = "10") Integer pageSize, @RequestBody QueryBook queryBook) {
        return bookServiceImpl.queryBookListV2(pageNumber, pageSize, queryBook);
    }

}
