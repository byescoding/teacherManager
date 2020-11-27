package com.bai.teachermanager.controller;


import com.bai.teachermanager.entity.CourseType;
import com.bai.teachermanager.entity.Parameter;
import com.bai.teachermanager.service.impl.CourseTypeServiceImpl;
import com.bai.teachermanager.service.impl.ParameterServiceImpl;
import com.bai.teachermanager.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 计算参数表 前端控制器
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@RestController
@RequestMapping("/teachermanager/parameter")
public class ParameterController {
    @Autowired
 private ParameterServiceImpl parameterService;

    @ApiOperation("获取参数列表")
    @GetMapping("/getparams")
    public R getAdminList(){
        List<Parameter> list = parameterService.list();
        return R.ok().data("params",list);
    }

    @ApiOperation("添加参数")
    @PostMapping("/save")
    public R saveAdmin(@ApiParam(value = "参数信息",required = true) @RequestBody Parameter parameter){
        boolean isSave = parameterService.save(parameter);
        if (isSave){
            return   R.ok().message(" 保存成功");
        }else{
            return   R.error().message("保存失败");
        }
    }


    @ApiOperation("修改参数信息")
    @PostMapping("/update/{id}")
    public R  updateAdminById(@ApiParam(value = "参数信息",required = true) @RequestBody Parameter parameter){
        boolean isUpdate = parameterService.updateById(parameter);
        if (isUpdate){
            return    R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("删除课程信息")
    @DeleteMapping("/delete/{id}")
    public R delAdminById(@ApiParam(value = "课程id",required = true) @PathVariable String id){
        boolean isDelete = parameterService.removeById(id);
        if (isDelete){
            return  R.ok().message("删除成功");
        }else{
            return  R.error().message("删除失败");
        }
    }


    @ApiOperation("根据id去获取课程信息")
    @GetMapping("get/{id}")
    public R getAdminById(@ApiParam(value = "班级id",required = true) @PathVariable String id){
        Parameter parameter= parameterService.getById(id);
        if (parameter == null){
            return R.error().message("不存在该课程信息");
        }else{
            return  R.ok().data("parameter",parameter);
        }
    }
}

