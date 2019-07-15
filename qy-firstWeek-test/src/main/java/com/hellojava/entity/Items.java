package com.hellojava.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Items implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String detail;
    private String pic;
    @Column(name="createtime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
