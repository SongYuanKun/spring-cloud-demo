package com.songyuankun.cloud.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author songyuankun
 */
@ApiModel
@Getter
@Setter
@ToString
public class MediaVO implements Serializable {
    /**
     * 媒体名
     */
    @ApiModelProperty(name = "媒体名")
    private String name;
    /**
     * 作者
     */
    @ApiModelProperty(name = "用户id")
    private Integer userId;
    /**
     * 媒体地址
     */
    @ApiModelProperty(name = "媒体地址")
    private String url;


}
