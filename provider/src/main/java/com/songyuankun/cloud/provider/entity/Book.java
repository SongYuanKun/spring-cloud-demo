package com.songyuankun.cloud.provider.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 书
 */
@Proxy(lazy = false)
@Entity
@Table(name = "book")
@Getter
@Setter
@ToString
public class Book implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 书名
     */
    private String name;
    /**
     * 作者
     */
    private String author;


}
