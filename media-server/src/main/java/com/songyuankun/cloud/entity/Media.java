package com.songyuankun.cloud.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 书
 */
@Proxy(lazy = false)
@Entity
@Table(name = "book")
@Getter
@Setter
@ToString
public class Media implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 媒体名称
     */
    private String name;
    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 访问地址
     */
    private String url;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
