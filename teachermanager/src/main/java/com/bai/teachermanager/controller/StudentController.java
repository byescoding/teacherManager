package com.bai.teachermanager.controller;

import com.bai.teachermanager.entity.Classes;
import com.bai.teachermanager.entity.Student;
import com.bai.teachermanager.execption.TeacherManagerException;
import com.bai.teachermanager.mapper.ClassMapper;
import com.bai.teachermanager.mapper.StudentMapper;
import com.bai.teachermanager.service.impl.ClassServiceImpl;
import com.bai.teachermanager.service.impl.StudentServiceImpl;
import com.bai.teachermanager.utils.R;
import com.bai.teachermanager.utils.ResultCode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/teachermanager/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private StudentMapper studentMapper;

    @ApiOperation("学生信息列表")
    @GetMapping("/getstudents")
    public R getAdminList(){
        List<Student> list = studentService.list();
        return R.ok().data("students",list);
    }
    @ApiOperation("学生列表分页")
    @GetMapping("/list/{page}/{limit}")
    public R pageList(@ApiParam( value = "页码" ,required = true) @PathVariable("page") long page,
                      @ApiParam(value = "页面数据量" ,required = true) @PathVariable("limit") long limit){
        Page<Student> pageParm = new Page<>(page,limit);
        Page<Student> studentPage = studentMapper.selectPage(pageParm, null);
        long total = studentPage.getTotal(); //获取总数
        List<Student> records = studentPage.getRecords();  //获取记录行数
        return R.ok().data("total",total).data("records",records);
    }

    @ApiOperation("添加班级信息")
    @PostMapping("/save")
    public R saveAdmin(@ApiParam(value = "班级信息",required = true) @RequestBody Student student){
        boolean isSave = studentService.save(student);
        if (isSave){
            return   R.ok().message(" 保存成功");
        }else{
            return   R.error().message("保存失败");
        }
    }


    @ApiOperation("修改学生信息")
    @PutMapping("/update")
    public R  updateAdminById(@ApiParam(value = "学生信息",required = true) @RequestBody Student student){
        boolean isUpdate = studentService.updateById(student);
        if (isUpdate){
            return    R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("删除学生信息")
    @DeleteMapping("/remove/{id}")
    public R delAdminById(@ApiParam(value = "管理员id",required = true) @PathVariable String id){
        boolean isDelete = studentService.removeById(id);
        if (isDelete){
            return  R.ok().message("删除成功");
        }else{
            return  R.error().message("删除失败");
        }
    }


    @ApiOperation("根据id去获取班级信息")
    @GetMapping("get/{id}")
    public R getAdminById(@ApiParam(value = "学生id",required = true) @PathVariable String id){
        Student student = studentService.getById(id);
        if (student == null){
            return R.error().message("不存在该班级");
        }else{
            return  R.ok().data("item",student);
        }
    }


    //批量删除
    @ApiOperation("批量删除学生信息")
    @PostMapping("/batch-remove")
    public R batchRemove(@ApiParam(value = "学生ID集合",required = true) @RequestBody List<String> ids){
        System.out.println(ids);
        boolean res = studentService.removeByIds(ids);
        if (res){
            return R.ok().message("数据删除成功");
        }else {
            return R.error().message("数据不存在");
        }
    }

//    //批量导入数据
//    @ApiOperation("批量导入数据")
//    @PostMapping("import")
//    public R batchExcel(@ApiParam(value = "文件",required = true) @RequestParam("file") MultipartFile file) {
//        try {
//            InputStream inputStream = file.getInputStream();
//            classService.batchImport(inputStream);
//            return R.ok().message("导入成功");
//        } catch (Exception e) {
////            log.error(ExceptionUtils.getMessage(e));
//            throw  new TeacherManagerException(ResultCode.EXCEL_DATA_IMPORT_ERROR);
//
//        }

//    }



}
