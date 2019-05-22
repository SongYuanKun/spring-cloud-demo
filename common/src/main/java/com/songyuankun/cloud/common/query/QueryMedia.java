package com.songyuankun.cloud.common.query;

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
public class QueryMedia implements Serializable {
    /**
     * 媒体名
     */
    private String name;
    /**
     * 用户id
     */
    private Integer userId;

}
