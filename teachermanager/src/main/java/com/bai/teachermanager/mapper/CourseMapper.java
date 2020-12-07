package com.bai.teachermanager.mapper;

import com.bai.teachermanager.entity.Course;
import com.bai.teachermanager.entity.vo.CourseVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xpath.internal.objects.XNull;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程信息表 Mapper 接口
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {

    //分页查询
    List<CourseVo> selectPageByCourseQueryVo(Page<CourseVo> pageParam,   @Param(Constants.WRAPPER) QueryWrapper<CourseVo> queryWrapper);

    //查询课程讯息
    List<CourseVo> selectCourseQueryVoList(QueryWrapper<CourseVo> queryWrapper);
}
