package com.bai.teachermanager.controller;


import com.bai.teachermanager.entity.CourseType;
import com.bai.teachermanager.service.impl.CourseTypeServiceImpl;
import com.bai.teachermanager.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程类型表 前端控制器
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@RestController
@RequestMapping("/teachermanager/course-type")
public class CourseTypeController {

    @Autowired
    private CourseTypeServiceImpl courseTypeService;

    @ApiOperation("获取课程类型信息")
    @GetMapping("/getcoursetypes")
    public R getAdminList(){
        List<CourseType> list = courseTypeService.list();
        return R.ok().data("coursetype",list);
    }

    @ApiOperation("添加课程类型信息")
    @PostMapping("/save")
    public R saveAdmin(@ApiParam(value = "课程类型信息",required = true) @RequestBody CourseType courseType){
        boolean isSave = courseTypeService.save(courseType);
        if (isSave){
            return   R.ok().message(" 保存成功");
        }else{
            return   R.error().message("保存失败");
        }
    }


    @ApiOperation("修改课程类型信息")
    @PostMapping("/update/{id}")
    public R  updateAdminById(@ApiParam(value = "课程信息",required = true) @RequestBody CourseType courseType){
        boolean isUpdate = courseTypeService.updateById(courseType);
        if (isUpdate){
            return    R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("删除课程信息")
    @DeleteMapping("/delete/{id}")
    public R delAdminById(@ApiParam(value = "课程id",required = true) @PathVariable String id){
        boolean isDelete = courseTypeService.removeById(id);
        if (isDelete){
            return  R.ok().message("删除成功");
        }else{
            return  R.error().message("删除失败");
        }
    }


    @ApiOperation("根据id去获取课程信息")
    @GetMapping("get/{id}")
    public R getAdminById(@ApiParam(value = "班级id",required = true) @PathVariable String id){
        CourseType courseType= courseTypeService.getById(id);
        if (courseType == null){
            return R.error().message("不存在该课程信息");
        }else{
            return  R.ok().data("coursetype",courseType);
        }
    }
}

