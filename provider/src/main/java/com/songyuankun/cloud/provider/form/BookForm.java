package com.songyuankun.cloud.provider.form;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author songyuankun
 */
@ApiModel
@Getter
@Setter
@ToString
public class BookForm {

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
