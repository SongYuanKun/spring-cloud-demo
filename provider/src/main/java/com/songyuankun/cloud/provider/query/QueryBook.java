package com.songyuankun.cloud.provider.query;

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
public class QueryBook implements Serializable {
    /**
     * 书名
     */
    @ApiModelProperty(name = "书名")
    private String name;
    /**
     * 作者
     */
    @ApiModelProperty(name = "作者")
    private String author;

}
