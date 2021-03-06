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
public class MediaVO implements Serializable {
    /**
     * 主键
     */
    private Integer id;

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
