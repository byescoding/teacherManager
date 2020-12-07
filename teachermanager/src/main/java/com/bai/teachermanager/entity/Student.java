package com.bai.teachermanager.entity;

import com.bai.teachermanager.utils.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Student对象", description="学生表")
public class Student extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "职称")
    private String title;

    @ApiModelProperty(value = "联系方式")
    private String telephone;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;


}
