package com.bai.teachermanager.controller;


import com.bai.teachermanager.entity.Teacher;
import com.bai.teachermanager.mapper.TeacherMapper;
import com.bai.teachermanager.service.impl.TeacherServiceImpl;
import com.bai.teachermanager.utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 教师信息表 前端控制器
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@RestController
@RequestMapping("/teachermanager/teacher")
public class TeacherController {
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private TeacherMapper  teacherMapper;

    @ApiOperation("获取老师信息")
    @GetMapping("/getteachers")
    public R getAdminList(){
        List<Teacher> list = teacherService.list();
        return R.ok().data("teachers",list);
    }
    @ApiOperation("教师列表分页")
    @GetMapping("/list/{page}/{limit}")
    public R pageList(@ApiParam( value = "页码" ,required = true) @PathVariable("page") long page,
                      @ApiParam(value = "页面数据量" ,required = true) @PathVariable("limit") long limit){
        Page<Teacher> pageParm = new Page<>(page,limit);
        Page<Teacher> teacherPage = teacherMapper.selectPage(pageParm, null);
        long total = teacherPage.getTotal(); //获取总数
        List<Teacher> records = teacherPage.getRecords();  //获取记录行数
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation("添加教师信息")
    @PostMapping("/save")
    public R saveAdmin(@ApiParam(value = "教师信息",required = true) @RequestBody Teacher teacher){
        boolean isSave = teacherService.save(teacher);
        if (isSave){
            return   R.ok().message(" 保存成功");
        }else{
            return   R.error().message("保存失败");
        }
    }


    @ApiOperation("修改教师信息")
    @PostMapping("/update/{id}")
    public R  updateAdminById(@ApiParam(value = "教师信息",required = true) @RequestBody Teacher teacher){
        boolean isUpdate = teacherService.updateById(teacher);
        if (isUpdate){
            return    R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("删除教师信息")
    @DeleteMapping("/remove/{id}")
    public R delAdminById(@ApiParam(value = "教师id",required = true) @PathVariable String id){
        boolean isDelete = teacherService.removeById(id);
        if (isDelete){
            return  R.ok().message("删除成功");
        }else{
            return  R.error().message("删除失败");
        }
    }


    @ApiOperation("根据id去获取教师信息信息")
    @GetMapping("get/{id}")
    public R getAdminById(@ApiParam(value = "班级id",required = true) @PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        if (teacher == null){
            return R.error().message("不存在该班级");
        }else {
            return  R.ok().data("item",teacher);
        }
    }


    //数据回显
    @ApiOperation("查询数据匹配")
    @GetMapping("list/name/{key}")
    public R likeName(@ApiParam(value = "模糊查询的关键字" ,required = true) @PathVariable("key") String key){

        List<Map<String, Object>> maps = teacherService.selectNameListByKey(key);
        if (maps !=null){
            return R.ok().data("nameList",maps);
        }else {
            return R.error().message("数据不存在");
        }
    }

    //批量删除教师信息
    @ApiOperation("批量删除教师信息")
    @PostMapping("/batch-remove")
    public R batchRemove(@ApiParam(value = "教师ID集合",required = true) @RequestBody List<String> ids){
        System.out.println(ids);
        boolean res = teacherService.removeByIds(ids);
        if (res){
            return R.ok().message("数据删除成功");
        }else {
            return R.error().message("数据不存在");
        }
    }




}

