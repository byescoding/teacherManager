package com.bai.teachermanager.service;

import com.bai.teachermanager.entity.Course;
import com.bai.teachermanager.entity.Teacher;
import com.bai.teachermanager.entity.vo.CourseQueryVo;
import com.bai.teachermanager.entity.vo.CourseVo;
import com.bai.teachermanager.entity.vo.TeacherQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;

/**
 * <p>
 * 课程信息表 服务类
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
public interface CourseService extends IService<Course> {

    void batchImport(InputStream inputStream);


    IPage<CourseVo> selectPage(long page, long limit, CourseQueryVo courseQueryVo);

}

