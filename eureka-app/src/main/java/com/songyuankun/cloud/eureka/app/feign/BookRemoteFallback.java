package com.songyuankun.cloud.eureka.app.feign;

import com.songyuankun.cloud.common.form.BookForm;
import org.springframework.stereotype.Component;

/**
 * 熔断后方法
 *
 * @author songyuankun
 */
@Component
public class BookRemoteFallback implements BookRemoteInterface {
    @Override
    public String saveBook(BookForm bookForm) {
        return "save error";
    }

    @Override
    public String queryById(int id) {
        return "query error";
    }
}
