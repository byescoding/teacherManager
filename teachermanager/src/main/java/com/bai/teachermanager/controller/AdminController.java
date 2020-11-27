package com.bai.teachermanager.controller;


import com.bai.teachermanager.entity.Admin;
import com.bai.teachermanager.mapper.AdminMapper;
import com.bai.teachermanager.service.impl.AdminServiceImpl;
import com.bai.teachermanager.utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@RestController
@RequestMapping("/teachermanager/admin")
@Api("管理员信息管理")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private AdminMapper adminMapper;


    @ApiOperation("查看管理员列表")
    @GetMapping("/getadmins")
    public R getAdminList() {
        List<Admin> list = adminService.list();
        return R.ok().data("admins", list);
    }

    /**
     * 分页
     * @param admin
     * @return
     */
    @ApiOperation("管理员列表分页")
    @GetMapping("/list/{page}/{limit}")
    public R pageList(@ApiParam( value = "页码" ,required = true) @PathVariable("page") long page,
    @ApiParam(value = "页面数据量" ,required = true) @PathVariable("limit") long limit){
        Page<Admin> pageParm = new Page<>(page,limit);
        Page<Admin> adminPage = adminMapper.selectPage(pageParm, null);
        long total = adminPage.getTotal(); //获取总数
        List<Admin> records = adminPage.getRecords();  //获取记录行数
        return R.ok().data("total",total).data("records",records);
    }

    @ApiOperation("添加管理员")
    @PostMapping("/save")
    public R saveAdmin(@ApiParam(value = "教师信息",required = true) @RequestBody Admin admin){
        boolean isSave = adminService.save(admin);
        if (isSave){
          return   R.ok().message(" 保存成功");
        }else{
          return   R.error().message("保存失败");
        }
    }


    @ApiOperation("修改管理员信息")
    @PostMapping("/update/{id}")
    public R  updateAdminById(@ApiParam(value = "教师信息",required = true) @RequestBody Admin admin){
        boolean isUpdate = adminService.updateById(admin);
        if (isUpdate){
           return    R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("删除管理员")
    @DeleteMapping("/delete/{id}")
    public R delAdminById(@ApiParam(value = "管理员id",required = true) @PathVariable String id){
        boolean isDelete = adminService.removeById(id);
        if (isDelete){
            return  R.ok().message("删除成功");
        }else{
            return  R.error().message("删除失败");
        }
    }

    @ApiOperation("根据id去获取管理员信息")
    @GetMapping("get/{id}")
    public R getAdminById(@ApiParam(value = "管理员id",required = true) @PathVariable String id){
        Admin admin = adminService.getById(id);
        if (admin == null){
           return R.error().message("不存在该管理员");
        }else{
            return  R.ok().data("admin",admin);
        }
    }
}

