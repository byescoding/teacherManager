package com.bai.teachermanager.controller;


import com.bai.teachermanager.entity.Classes;
import com.bai.teachermanager.mapper.ClassMapper;
import com.bai.teachermanager.service.impl.ClassServiceImpl;
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
 * 班级表 前端控制器
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@RestController
@RequestMapping("/teachermanager/class")
@Api("班级管理")
public class ClassController {

    @Autowired
    private ClassServiceImpl classService;
    @Autowired
    private ClassMapper classMapper;

    @ApiOperation("获取班级信息")
    @GetMapping("/getclasses")
    public R getAdminList(){
        List<Classes> list = classService.list();
        return R.ok().data("admins",list);
    }
    @ApiOperation("班级列表分页")
    @GetMapping("/list/{page}/{limit}")
    public R pageList(@ApiParam( value = "页码" ,required = true) @PathVariable("page") long page,
                      @ApiParam(value = "页面数据量" ,required = true) @PathVariable("limit") long limit){
        Page<Classes> pageParm = new Page<>(page,limit);
        Page<Classes> classPage = classMapper.selectPage(pageParm, null);
        long total = classPage.getTotal(); //获取总数
        List<Classes> records = classPage.getRecords();  //获取记录行数
        return R.ok().data("total",total).data("records",records);
    }

    @ApiOperation("添加班级信息")
    @PostMapping("/save")
    public R saveAdmin(@ApiParam(value = "班级信息",required = true) @RequestBody Classes classes){
        boolean isSave = classService.save(classes);
        if (isSave){
            return   R.ok().message(" 保存成功");
        }else{
            return   R.error().message("保存失败");
        }
    }


    @ApiOperation("修改班级信息")
    @PutMapping("/update")
    public R  updateAdminById(@ApiParam(value = "教师信息",required = true) @RequestBody Classes classes){
        boolean isUpdate = classService.updateById(classes);
        if (isUpdate){
            return    R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("删除班级信息")
    @DeleteMapping("/remove/{id}")
    public R delAdminById(@ApiParam(value = "管理员id",required = true) @PathVariable String id){
        boolean isDelete = classService.removeById(id);
        if (isDelete){
            return  R.ok().message("删除成功");
        }else{
            return  R.error().message("删除失败");
        }
    }


    @ApiOperation("根据id去获取班级信息")
    @GetMapping("get/{id}")
    public R getAdminById(@ApiParam(value = "班级id",required = true) @PathVariable String id){
        Classes classes = classService.getById(id);
        if (classes == null){
            return R.error().message("不存在该班级");
        }else{
            return  R.ok().data("item",classes);
        }
    }


    //批量删除
    @ApiOperation("批量删除班级信息")
    @PostMapping("/batch-remove")
    public R batchRemove(@ApiParam(value = "班级ID集合",required = true) @RequestBody List<String> ids){
        System.out.println(ids);
        boolean res = classService.removeByIds(ids);
        if (res){
            return R.ok().message("数据删除成功");
        }else {
            return R.error().message("数据不存在");
        }
    }

}

