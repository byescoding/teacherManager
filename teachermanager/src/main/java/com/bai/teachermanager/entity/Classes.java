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
 * 班级表
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Class对象", description="班级表")
public class Classes extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "班级名称")
    private String name;

    @ApiModelProperty(value = "班级人数")
    private Integer number;

    @ApiModelProperty(value = "班主任名称")
    private String headmaster;

    @ApiModelProperty(value = "是否为新增专业班级，0为false，1为true")
    private Integer isNewMajor;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;


}
