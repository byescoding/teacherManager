package com.bai.teachermanager.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseQueryVo implements Serializable {
    private static final long serialVersionUID=1L;
    private String name;
    private Integer isNew;
    private Integer isXicheng;
}
