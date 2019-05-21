package com.songyuankun.cloud.common;

/**
 * @author songyuankun
 */
public class ResponseUtils {

    public static <T> Response success(T object) {
        return new Response<>(0, "", object);
    }

}
