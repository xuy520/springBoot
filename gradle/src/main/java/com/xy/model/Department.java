package com.xy.model;

import javax.persistence.*;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: Department
 * @Description:
 * @date 2019/1/15 20:23
 * Copyright (c) CSII.
 * All Rights Reserved.
 */

@Entity
@Table(name = "department")
public class Department {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
