package com.bai.teachermanager.service.impl;

import com.bai.teachermanager.entity.Course;
import com.bai.teachermanager.entity.Parameter;
import com.bai.teachermanager.entity.WorkloadSummary;
import com.bai.teachermanager.entity.vo.CourseVo;
import com.bai.teachermanager.mapper.CourseMapper;
import com.bai.teachermanager.mapper.ParameterMapper;
import com.bai.teachermanager.mapper.WorkloadSummaryMapper;
import com.bai.teachermanager.service.WorkloadSummaryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 工作量汇总表 服务实现类
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Service
public class WorkloadSummaryServiceImpl extends ServiceImpl<WorkloadSummaryMapper, WorkloadSummary> implements WorkloadSummaryService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ParameterMapper parameterMapper;

    @Override
    public HashMap<String, String> workSum(String id) {

        String theorySum = getTheorySum(id); //理论课的工作量计算

        String expSum = getExpSum(id);  //实验课的工作量的计算
        //实验课



        return null;
    }

       private String getTheorySum(String id){

        //获取计算参数
        Parameter params = getParams();

        //根据教师id去查询教师对应教的课程，以及一些工作量的计算
        QueryWrapper<CourseVo> courseVoQueryWrapper = new QueryWrapper<>();
        courseVoQueryWrapper.eq("teacher_id",id);
        List<CourseVo> courses = courseMapper.selectCourseQueryVoList(courseVoQueryWrapper);  //获取当前老师所教的课程

        //理论课
        //没有超出45人的课程
        List<CourseVo> classNoMore = courses.stream().filter(c -> c.getStudentNumber() >30 && c.getStudentNumber()<=45).collect(Collectors.toList());
        //单班的课程
        List<CourseVo> singleClassNoMore = classNoMore.stream().filter(c -> c.getClassNumber() == 1).collect(Collectors.toList());
        //双班的课程
        List<CourseVo> doubleClassNoMore = classNoMore.stream().filter(c -> c.getClassNumber() == 2).collect(Collectors.toList());
        //三班的课程
        List<CourseVo> threeClassNoMore = classNoMore.stream().filter(c -> c.getClassNumber() == 3).collect(Collectors.toList());
        //四班及四班以上
        List<CourseVo> fourClassNoMore = classNoMore.stream().filter(c -> c.getClassNumber() >=4).collect(Collectors.toList());


        //超出45人的课程
        List<CourseVo> classMore = courses.stream().filter(c -> c.getStudentNumber() > 45).collect(Collectors.toList());
        //单班的课程
        List<CourseVo> singleClassMore =  classMore.stream().filter(c -> c.getClassNumber() == 1).collect(Collectors.toList());
        //双班的课程
        List<CourseVo> doubleClassMore =  classMore.stream().filter(c -> c.getClassNumber() == 2).collect(Collectors.toList());
        //三班的课程
        List<CourseVo> threeClassMore  =  classMore.stream().filter(c -> c.getClassNumber() == 3).collect(Collectors.toList());
        //四班及四班以上
        List<CourseVo> fourClassMore   =  classMore.stream().filter(c -> c.getClassNumber() >=4).collect(Collectors.toList());

        //计算超过30但是少于45的部分
           //计算是否含有重复班级
//        singleClassNoMore.stream().filter(c-> c.get)
    return "o";
    }


    //计算实验课
    private String   getExpSum(String id){
        return "o";
    }


    //获取参数
    private Parameter getParams(){
        Parameter parameter = parameterMapper.selectOne(null);
        return  parameter;
    }
}
