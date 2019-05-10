package com.songyuankun.cloud.eureka.app.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.songyuankun.cloud.common.form.BookForm;
import com.songyuankun.cloud.eureka.app.feign.BookRemoteInterface;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String ribbonConsumer() {
        return restTemplate.getForEntity("http://EUREKA-PROVIDER/", String.class).getBody();
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "error")
    public String helloController(@RequestBody BookForm bookForm) {
        return bookRemoteInterface.saveBook(bookForm);
    }

}