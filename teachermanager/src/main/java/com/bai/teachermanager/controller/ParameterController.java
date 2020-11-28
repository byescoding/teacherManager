package com.bai.teachermanager.controller;


import com.bai.teachermanager.entity.Classes;
import com.bai.teachermanager.entity.CourseType;
import com.bai.teachermanager.entity.Parameter;
import com.bai.teachermanager.mapper.ParameterMapper;
import com.bai.teachermanager.service.impl.CourseTypeServiceImpl;
import com.bai.teachermanager.service.impl.ParameterServiceImpl;
import com.bai.teachermanager.utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
@Autowired
private ParameterMapper parameterMapper;
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
    @PostMapping("/update")
    public R  updateAdminById(@ApiParam(value = "参数信息",required = true) @RequestBody Parameter parameter){
        boolean isUpdate = parameterService.updateById(parameter);
        if (isUpdate){
            return    R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("删除课程信息")
    @DeleteMapping("/remove/{id}")
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
            return  R.ok().data("item",parameter);
        }
    }

    @ApiOperation("参数列表分页")
    @GetMapping("/list/{page}/{limit}")
    public R pageList(@ApiParam( value = "页码" ,required = true) @PathVariable("page") long page,
                      @ApiParam(value = "页面数据量" ,required = true) @PathVariable("limit") long limit){
        Page<Parameter> pageParm = new Page<>(page,limit);
        Page<Parameter> classPage = parameterMapper.selectPage(pageParm, null);
        long total = classPage.getTotal(); //获取总数
        List<Parameter> records = classPage.getRecords();  //获取记录行数
        return R.ok().data("total",total).data("records",records);
    }

}

