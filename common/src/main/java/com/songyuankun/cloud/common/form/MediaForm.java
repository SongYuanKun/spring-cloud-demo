package com.songyuankun.cloud.common.form;

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
public class MediaForm implements Serializable {
    /**
     * 媒体名
     */
    private String name;
    /**
     * 作者
     */
    private Integer userId;
    /**
     * 媒体地址
     */
    private String url;


}
