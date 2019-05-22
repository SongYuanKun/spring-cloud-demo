package com.songyuankun.cloud.common.response;

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
public class BookVO implements Serializable {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 书名
     */
    private String name;
    /**
     * 作者
     */
    private String author;
}
