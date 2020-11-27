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

    @ApiModelProperty(value = "教书育人工作名称")
    private String name;

    @ApiModelProperty(value = "监考时间1（正常上班时间）")
    private String time1;

    @ApiModelProperty(value = "监考/值班时间2（下午4：20~6：20）")
    private String time2;

    @ApiModelProperty(value = "监考/值班时间3（晚上、双休日、寒暑假）")
    private String time3;

    @ApiModelProperty(value = "计算数量，次/份/套")
    private Integer quantity;

    @ApiModelProperty(value = "是否是监考，0为考试值班，1为监考工作")
    private Integer isInvigilation;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;


}
