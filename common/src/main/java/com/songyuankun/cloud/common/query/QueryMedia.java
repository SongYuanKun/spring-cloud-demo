package com.songyuankun.cloud.common.query;

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
public class QueryMedia implements Serializable {
    /**
     * 媒体名
     */
    @ApiModelProperty(name = "媒体名")
    private String name;
    /**
     * 用户id
     */
    @ApiModelProperty(name = "用户id")
    private Integer userId;

}
