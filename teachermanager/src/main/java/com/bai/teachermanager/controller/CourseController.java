package com.bai.teachermanager.controller;


import com.bai.teachermanager.entity.Class;
import com.bai.teachermanager.entity.Course;
import com.bai.teachermanager.entity.CourseType;
import com.bai.teachermanager.mapper.CourseMapper;
import com.bai.teachermanager.service.impl.CourseServiceImpl;
import com.bai.teachermanager.service.impl.CourseTypeServiceImpl;
import com.bai.teachermanager.utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程信息表 前端控制器
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@RestController
@RequestMapping("/teachermanager/course")
public class CourseController {

    @Autowired
   private CourseServiceImpl courseService;
    @Autowired
    private CourseMapper courseMapper;

    @ApiOperation("获取课程信息")
    @GetMapping("/getcourses")
    public R getAdminList(){
        List<Course> list = courseService.list();
        return R.ok().data("courses",list);
    }

    @ApiOperation("课程列表分页")
    @GetMapping("/list/{page}/{limit}")
    public R pageList(@ApiParam( value = "页码" ,required = true) @PathVariable("page") long page,
                      @ApiParam(value = "页面数据量" ,required = true) @PathVariable("limit") long limit){
        Page<Course> pageParm = new Page<>(page,limit);
        Page<Course> coursePage = courseMapper.selectPage(pageParm, null);
        long total = coursePage.getTotal(); //获取总数
        List<Course> records = coursePage.getRecords();  //获取记录行数
        return R.ok().data("total",total).data("records",records);
    }

    @ApiOperation("添加课程信息")
    @PostMapping("/save")
    public R saveAdmin(@ApiParam(value = "课程信息",required = true) @RequestBody Course course){
        boolean isSave = courseService.save(course);
        if (isSave){
            return   R.ok().message(" 保存成功");
        }else{
            return   R.error().message("保存失败");
        }
    }


    @ApiOperation("修改课程类型信息")
    @PostMapping("/update/{id}")
    public R  updateAdminById(@ApiParam(value = "课程信息",required = true) @RequestBody Course course){
        boolean isUpdate = courseService.updateById(course);
        if (isUpdate){
            return    R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("删除课程信息")
    @DeleteMapping("/delete/{id}")
    public R delAdminById(@ApiParam(value = "课程id",required = true) @PathVariable String id){
        boolean isDelete = courseService.removeById(id);
        if (isDelete){
            return  R.ok().message("删除成功");
        }else{
            return  R.error().message("删除失败");
        }
    }


    @ApiOperation("根据id去获取课程信息")
    @GetMapping("get/{id}")
    public R getAdminById(@ApiParam(value = "班级id",required = true) @PathVariable String id){
        Course course= courseService.getById(id);
        if (course == null){
            return R.error().message("不存在该课程信息");
        }else{
            return  R.ok().data("course",course);
        }
    }
}

