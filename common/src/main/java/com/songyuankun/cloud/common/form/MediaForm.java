package com.songyuankun.cloud.common.form;

import com.sun.istack.internal.NotNull;
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
    @NotNull
    private String name;
    /**
     * 作者
     */
    @NotNull
    private Integer userId;
    /**
     * 媒体地址
     */
    private String url;


}
