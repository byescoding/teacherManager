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
 * 教师岗位等级表
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="PostGrade对象", description="教师岗位等级表")
public class PostGrade extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "岗位等级")
    private String name;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;


}
