package com.songyuankun.cloud.eureka.app.feign;

import com.songyuankun.cloud.eureka.app.form.BookForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author songyuankun
 */
@Component
@FeignClient(name = "EUREKA-PROVIDER")

public interface BookRemoteInterface {

    /**
     * 保存book
     *
     * @param bookForm bookForm
     * @return book
     */
    @PostMapping(value = "api/book/save")
    String saveBook(@RequestBody BookForm bookForm);
}