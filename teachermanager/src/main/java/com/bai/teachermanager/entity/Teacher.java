package com.bai.teachermanager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.bai.teachermanager.utils.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 教师信息表
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Teacher对象", description="教师信息表")
public class Teacher extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    private String name;

    @ApiModelProperty(value = "岗位等级")
    private String grade;

    @ApiModelProperty(value = "性别  （默认为男 1  女为 0)")
    private Integer sex;

    @ApiModelProperty(value = "身份证号码")
    private String idCard;

    @ApiModelProperty(value = "联系方式")
    private String telephone;

    @ApiModelProperty(value = "毕业院校")
    private String university;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "联系地址")
    private String address;

    @ApiModelProperty(value = "学历")
    private String education;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;


}
