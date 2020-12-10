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
 * 教书育人服务工作量表
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="TeachingEducatingWorkload对象", description="教书育人服务工作量表")
public class TeachingEducatingWorkload extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "课程类型ID")
    private String courseTypeId;


    @ApiModelProperty(value = "计算数量，次/份/套")
    private Integer quantity;

    @ApiModelProperty(value = "是否采用双语编写")
    private Integer isBilingual;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;


}
