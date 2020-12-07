package com.bai.teachermanager.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExcelClassData {
    @ExcelProperty(value = "班级名称")
    private String name;

    @ExcelProperty(value = "班级人数")
    private Integer number;

    @ExcelProperty(value = "班主任")
    private String headmaster;

    @ExcelProperty(value = "是否为新专业")
    private Integer isNewMajor;
}
