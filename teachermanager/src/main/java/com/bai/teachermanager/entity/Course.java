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
 * 课程信息表
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Course对象", description="课程信息表")
public class Course extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "学年学期")
    private String term;

    @ApiModelProperty(value = "用于识别课程类型")
    private String courseTypeId;

    @ApiModelProperty(value = "课程名称")
    private String name;

    @ApiModelProperty(value = "总学时")
    private Integer classTime;

    @ApiModelProperty(value = "计划周数")
    private Integer weeks;

    @ApiModelProperty(value = "所教班级")
    private Integer classId;


    @ApiModelProperty(value = "教班数量")
    private Integer classNumber;

    @ApiModelProperty(value = "排课人数")
    private Integer studentNumber;

    @ApiModelProperty(value = "授课教师编号（用于获取teacher表的教师名）")
    private String teacherId;

    @ApiModelProperty(value = "指导/考察次数（用于确认课程设计、实训、实习的课程系数）")
    private  String guideInspectFrequency;

    @ApiModelProperty(value = "是否为“开新课/新开课”")
    private Integer isNew;

    @ApiModelProperty(value = "是否在西城校区教学")
    private Integer isXicheng;

    @ApiModelProperty(value = "逻辑删除，1（true）已删除，0（false）未删除")
    @TableLogic
    private Integer isDeleted;


}
