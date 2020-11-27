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
 * 计算参数表
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Parameter对象", description="计算参数表")
public class Parameter extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "单班课合班系数")
    private Float singleClass;

    @ApiModelProperty(value = "双班课合班系数")
    private Float doubleClass;

    @ApiModelProperty(value = "三班课合班系数")
    private Float threeClass;

    @ApiModelProperty(value = "四班课及以上合班系数")
    private Float fourClass;

    @ApiModelProperty(value = "重复班课合班系数（用于第二个教学大班的计算）")
    private Float repeatCourse;

    @ApiModelProperty(value = "理论课单班标准人数")
    private Integer theoryStandardNumber;

    @ApiModelProperty(value = "理论课超额学生合班累加系数")
    private Float theoryExcessStudent;

    @ApiModelProperty(value = "实验课重复班课合班系数")
    private Float experimentRepeatCourse;

    @ApiModelProperty(value = "实验课单班分批进行的合班系数")
    private Float experimentClassBatch;

    @ApiModelProperty(value = "实验课多班分批进行的合班系数")
    private Float experimentClassesBatch;

    @ApiModelProperty(value = "上机课重复课双班合班系数（每次上机两个班）")
    private Float operationRepeatDoubleClass;

    @ApiModelProperty(value = "开新课/新开课")
    private Float newCourse;

    @ApiModelProperty(value = "在西城校区开设的课程")
    private Float xichengCourse;

    @ApiModelProperty(value = "13级教师岗位系数")
    private Float grade13;

    @ApiModelProperty(value = "12级教师岗位系数")
    private Float grade12;

    @ApiModelProperty(value = "11级教师岗位系数")
    private Float grade11;

    @ApiModelProperty(value = "10级教师岗位系数")
    private Float grade10;

    @ApiModelProperty(value = "9级教师岗位系数")
    private Float grade9;

    @ApiModelProperty(value = "8级教师岗位系数")
    private Float grade8;

    @ApiModelProperty(value = "7级教师岗位系数")
    private Float grade7;

    @ApiModelProperty(value = "6级教师岗位系数")
    private Float grade6;

    @ApiModelProperty(value = "5级教师岗位系数")
    private Float grade5;

    @ApiModelProperty(value = "4级教师岗位系数")
    private Float grade4;

    @ApiModelProperty(value = "3级教师岗位系数")
    private Float grade3;

    @ApiModelProperty(value = "2级教师岗位系数")
    private Float grade2;

    @ApiModelProperty(value = "校内指导学时（课程设计、实训、认识/毕业/专业实习）")
    private Integer practiceGuidance1Time;

    @ApiModelProperty(value = "校内指导课程系数1（每周集体指导至少5次）")
    private Float practiceGuidance1Course1;

    @ApiModelProperty(value = "校内指导课程系数2【每周2次（含2次）以下理论指导或集体指导】")
    private Float practiceGuidance1Course2;

    @ApiModelProperty(value = "校外指导实习学时")
    private Integer practiceGuidance2Time;

    @ApiModelProperty(value = "校外指导实习课程系数")
    private Float practiceGuidance2Course;

    @ApiModelProperty(value = "校外实习联系学时")
    private Integer externalPracticeContactTime;

    @ApiModelProperty(value = "校外实习联系课程系数1（参观考察2次/个以上周边企业单位）")
    private Float externalPracticeContactCourse1;

    @ApiModelProperty(value = "校外实习联系课程系数2（参观考察少于2次/个周边企业单位）")
    private Float externalPracticeContactCourse2;

    @ApiModelProperty(value = "学生毕业论文（设计）学时/学生")
    private Integer dissertationTime;

    @ApiModelProperty(value = "评阅论文学时/学生")
    private Float reviewTime;

    @ApiModelProperty(value = "开题答辩学时/学生")
    private Float capstonePresentationTime;

    @ApiModelProperty(value = "中期答辩学时/学生")
    private Float interimDefenseTime;

    @ApiModelProperty(value = "小组答辩学时/学生")
    private Float groupDenfenseTime;

    @ApiModelProperty(value = "公开答辩学时/学生")
    private Float publicDenfenseTime;

    @ApiModelProperty(value = "答辩秘书学时/学生")
    private Float denfenseSecretaryTime;

    @ApiModelProperty(value = "Capstone课程学时/学生")
    private Float capstoneCourseTime;

    @ApiModelProperty(value = "首次建立试题库")
    private Float establishTestBanks;

    @ApiModelProperty(value = "补充完善试题库")
    private Float perfectTestBanks;

    @ApiModelProperty(value = "笔试命题")
    private Float writtenTestProposition;

    @ApiModelProperty(value = "机考命题")
    private Float computerTestProposition;

    @ApiModelProperty(value = "期末考试、各种补考阅卷")
    private Float readingVolumes;

    @ApiModelProperty(value = "监考1（正常上班期间）")
    private Float invigilator1;

    @ApiModelProperty(value = "监考2（下午4：20～6：20）")
    private Float invigilator2;

    @ApiModelProperty(value = "监考3（晚上、双休日、寒暑假）")
    private Float invigilator3;

    @ApiModelProperty(value = "考试值班1（下午4：20～6：20）")
    private Float examination1;

    @ApiModelProperty(value = "考试值班2（晚上、双休日、寒暑假）")
    private Float examination2;

    @ApiModelProperty(value = "制订新专业人才培养方案")
    private Float writingTeachingDocuments1;

    @ApiModelProperty(value = "修订专业人才培养方案")
    private Float writingTeachingDocuments2;

    @ApiModelProperty(value = "按照专业认证标准要求编写课程教学大纲、考试大纲")
    private Float writingTeachingDocuments3;

    @ApiModelProperty(value = "按照专业认证标准要求修订课程教学大纲、考试大纲")
    private Float writingTeachingDocuments4;

    @ApiModelProperty(value = "按常规编写课程教学大纲、考试大纲")
    private Float writingTeachingDocuments5;

    @ApiModelProperty(value = "按常规修订课程教学大纲、考试大纲")
    private Float writingTeachingDocuments6;

    @ApiModelProperty(value = "采用双语编写教学文件")
    private Float compilingBilingualTeachingDocuments;

    @ApiModelProperty(value = "新增专业工作量（当年）")
    private Integer newProfessionalWorkload1;

    @ApiModelProperty(value = "新增专业工作量【第四年（获得学士学位授予资格）】")
    private Integer newProfessionalWorkload2;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;


}
