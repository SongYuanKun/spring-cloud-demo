package com.songyuankun.cloud.provider.controller;

import com.songyuankun.cloud.provider.entity.Book;
import com.songyuankun.cloud.provider.form.BookForm;
import com.songyuankun.cloud.provider.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author songyuankun
 */

@RestController
@RequestMapping("api/book")
@Api
@Slf4j
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(value = "保存book", notes = "保存book")
    @PostMapping(value = "save", produces = "application/json")
    public Book saveBook(@RequestBody BookForm bookForm) {
        Book book = new Book();
        BeanUtils.copyProperties(bookForm, book);
        return bookService.saveBook(book);
    }


}
