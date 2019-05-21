package com.songyuankun.cloud.common;

/**
 * @author songyuankun
 */
public class ResponseUtils {

    public static <T> Response<T> success(T object) {
        return new Response<T>(ResultEnums.SUCCESS.getCode(), ResultEnums.SUCCESS.getMessage(), object);
    }

}
