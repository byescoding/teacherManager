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
 * 工作量汇总表
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="WorkloadSummary对象", description="工作量汇总表")
public class WorkloadSummary extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "学年学期")
    private String term;

    @ApiModelProperty(value = "教师编号")
    private String teacherId;

    @ApiModelProperty(value = "理论课工作量")
    private Float theory;

    @ApiModelProperty(value = "实验课工作量")
    private Float experiment;

    @ApiModelProperty(value = "课程设计工作量")
    private Float curriculumDesign;

    @ApiModelProperty(value = "实习工作量")
    private Float practice;

    @ApiModelProperty(value = "毕业设计工作量")
    private Float graduationProject;

    @ApiModelProperty(value = "教书育人服务工作量")
    private Float teachingEducatingService;

    @ApiModelProperty(value = "合计工作量")
    private Float total;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;


}
