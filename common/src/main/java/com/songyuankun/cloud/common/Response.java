package com.songyuankun.cloud.common;

import io.swagger.annotations.ApiModel;
import lombok.*;

/**
 * 响应对象
 *
 * @author songyuankun
 */
@ApiModel
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private Integer code;
    private String message;
    private T date;
}
