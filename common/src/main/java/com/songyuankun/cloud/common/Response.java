package com.songyuankun.cloud.common;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 响应对象
 *
 * @author songyuankun
 */
@ApiModel
@Setter
@Getter
@ToString
public class Response<T> {
    private Integer code;
    private String message;
    private T date;
}
