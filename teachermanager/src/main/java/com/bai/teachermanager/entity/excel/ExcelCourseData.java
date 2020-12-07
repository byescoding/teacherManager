package com.bai.teachermanager.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExcelCourseData {
    @ExcelProperty(value = "学年学期")
    private String term;

    @ExcelProperty(value = "课程类型")
    private String courseTypeId;

    @ExcelProperty(value = "课程名称")
    private String name;

    @ExcelProperty(value = "总学时")
    private Integer classTime;

    @ExcelProperty(value = "理论课学时")
    private Integer theoryClassTime;

    @ExcelProperty(value = "实验课学时")
    private Integer experimentalClassTime;

    @ExcelProperty(value = "计划周数")
    private Integer weeks;

    @ExcelProperty(value = "教班数量")
    private Integer classNumber;

    @ExcelProperty(value = "排课人数")
    private Integer studentNumber;

    @ExcelProperty(value = "授课老师编号")
    private String teacherId;

    @ExcelProperty(value = "是否新开课")
    private Integer isNew;

    @ExcelProperty(value = "是否在西城校区")
    private Integer isXicheng;
}
