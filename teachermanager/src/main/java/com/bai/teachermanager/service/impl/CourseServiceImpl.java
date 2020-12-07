package com.bai.teachermanager.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.bai.teachermanager.entity.Course;
import com.bai.teachermanager.entity.excel.ExcelTeacherData;
import com.bai.teachermanager.entity.vo.CourseQueryVo;
import com.bai.teachermanager.entity.vo.CourseVo;
import com.bai.teachermanager.listener.ExcelCourseListener;
import com.bai.teachermanager.listener.ExcelTeacherListener;
import com.bai.teachermanager.mapper.CourseMapper;
import com.bai.teachermanager.service.CourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程信息表 服务实现类
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void batchImport(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelTeacherData.class,new ExcelCourseListener(baseMapper)
        ).excelType(ExcelTypeEnum.XLSX).doReadAll();
    }

    @Override
    public IPage<CourseVo> selectPage(long page, long limit, CourseQueryVo courseQueryVo) {
        String name = courseQueryVo.getName();
        Integer isNew = courseQueryVo.getIsNew();
        Integer isXicheng = courseQueryVo.getIsXicheng();

        QueryWrapper<CourseVo> courseVoQueryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)){
            courseVoQueryWrapper.eq("name",name);
        }else if (isNew != null){
            courseVoQueryWrapper.eq("is_new",isNew);
        }else if (isXicheng != null){
            courseVoQueryWrapper.eq("is_xicheng",isXicheng);
        }
        Page<CourseVo> courseVoPage = new Page<>(page, limit);
        List<CourseVo> courseVos = baseMapper.selectPageByCourseQueryVo(courseVoPage, courseVoQueryWrapper);
        courseVoPage.setRecords(courseVos);
        return courseVoPage;
    }


}
