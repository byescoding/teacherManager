package com.bai.teachermanager.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 教师信息录入
 */
@Data
public class ExcelTeacherData {

    @ExcelProperty(value = "登录密码")
    private String password;

    @ExcelProperty(value = "教师姓名")
    private String name;

    @ExcelProperty(value = "教师等级")
    private String grade;

    @ExcelProperty(value = "性别")
    private Integer sex;

    @ExcelProperty(value = "身份证")
    private String idCard;

    @ExcelProperty(value = "联系方式")
    private String telephone;

    @ExcelProperty(value = "毕业院校")
    private String university;

    @ExcelProperty(value = "邮箱")
    private String email;

    @ExcelProperty(value = "联系地址")
    private String address;

    @ExcelProperty(value = "学历")
    private String education;


}
