package com.songyuankun.cloud.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 书
 */
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
