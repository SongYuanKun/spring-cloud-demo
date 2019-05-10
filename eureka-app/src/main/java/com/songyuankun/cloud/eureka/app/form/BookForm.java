package com.songyuankun.cloud.eureka.app.form;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author songyuankun
 */
@Getter
@Setter
@ToString
public class BookForm implements Serializable {

    /**
     * 书名
     */
    private String name;
    /**
     * 作者
     */
    private String author;

}
