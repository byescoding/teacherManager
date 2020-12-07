package com.bai.teachermanager.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CourseVo implements Serializable {

    private static final long serialVersionUID=1L;
     private String id;
    @ApiModelProperty(value = "学年学期")
    private String term;

    @ApiModelProperty(value = "用于识别课程类型")
    private String courseType;

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

    @ApiModelProperty(value = "授课老师的姓名（用于获取teacher表的教师名）")
    private String teacherName;

    @ApiModelProperty(value = "指导/考察次数（用于确认课程设计、实训、实习的课程系数）")
    private  String guideInspectFrequency;

    @ApiModelProperty(value = "是否为“开新课/新开课”")
    private Integer isNew;

    @ApiModelProperty(value = "是否在西城校区教学")
    private Integer isXicheng;
}
