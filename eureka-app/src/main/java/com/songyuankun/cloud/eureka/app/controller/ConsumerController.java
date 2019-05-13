package com.songyuankun.cloud.eureka.app.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.songyuankun.cloud.common.form.BookForm;
import com.songyuankun.cloud.eureka.app.feign.BookRemoteInterface;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author songyuankun
 */
@RestController
public class ConsumerController {
    private final RestTemplate restTemplate;
    private final BookRemoteInterface bookRemoteInterface;

    public ConsumerController(RestTemplate restTemplate, BookRemoteInterface bookRemoteInterface) {
        this.restTemplate = restTemplate;
        this.bookRemoteInterface = bookRemoteInterface;
    }

    @GetMapping(value = "/ribbon-consumer")
    public String ribbonConsumer() {
        return restTemplate.getForEntity("http://EUREKA-PROVIDER/", String.class).getBody();
    }

    @PostMapping(value = "/saveBook")
    public String saveBook(@RequestBody BookForm bookForm) {
        return bookRemoteInterface.saveBook(bookForm);
    }

    @GetMapping(value = "/queryBookById")
    public String queryBookById(@RequestParam Integer id) {
        return bookRemoteInterface.queryById(id);
    }

}