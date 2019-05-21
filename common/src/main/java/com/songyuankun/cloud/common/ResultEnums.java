package com.songyuankun.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author songyuankun
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public enum ResultEnums {

    /**
     *
     */
    SUCCESS(0, "请求成功"),
    ERROR(1, "请求失败"),
    SYSTEM_ERROR(1000, "系统异常");

    private Integer code;
    private String message;


}