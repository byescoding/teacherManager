package com.bai.teachermanager.entity.sum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


import java.awt.*;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CourseSum implements Serializable {
    @ApiModelProperty(value = "学年学期")
    private String term;

    @ApiModelProperty(value = "课程类型集合")
    private List courseTypes;

    @ApiModelProperty(value = "课程名称")
    private String name;

    @ApiModelProperty(value = "总学时")
    private Integer classTime;

    @ApiModelProperty(value = "理论课学时")
    private Integer theoryClassTime;

    @ApiModelProperty(value = "实验课学时")
    private Integer experimentalClassTime;

    @ApiModelProperty(value = "计划周数")
    private Integer weeks;

    @ApiModelProperty(value = "教班数量")
    private Integer classNumber;

    @ApiModelProperty(value = "排课人数")
    private Integer studentNumber;

    @ApiModelProperty(value = "是否为“开新课/新开课”")
    private Integer isNew;

    @ApiModelProperty(value = "是否在西城校区教学")
    private Integer isXicheng;
}
