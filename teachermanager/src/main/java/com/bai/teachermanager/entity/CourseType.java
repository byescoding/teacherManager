package com.bai.teachermanager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * 课程类型表
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="CourseType对象", description="课程类型表")
public class CourseType extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "课程名称")
    private String name;

    @ApiModelProperty(value = "父级id")
    private String parentId;

    @ApiModelProperty(value = "父级课程名")
    private String parentName;



    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;



}
