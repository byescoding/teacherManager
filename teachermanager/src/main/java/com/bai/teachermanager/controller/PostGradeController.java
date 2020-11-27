package com.bai.teachermanager.controller;


import com.bai.teachermanager.entity.Parameter;
import com.bai.teachermanager.entity.PostGrade;
import com.bai.teachermanager.service.impl.PostGradeServiceImpl;
import com.bai.teachermanager.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 教师岗位等级表 前端控制器
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@RestController
@RequestMapping("/teachermanager/post-grade")
public class PostGradeController {
 @Autowired
    private PostGradeServiceImpl postGradeService;

 @ApiOperation("获取等级列表")
 @GetMapping("/getgrades")
  public R  getGrades(){
     List<PostGrade> grades = postGradeService.list();
     return R.ok().data("grades",grades);
 }

 @PostMapping("/save")
 @ApiOperation("添加等级信息")
 public R  addGrade(@ApiParam(value = "参数信息",required = true) @RequestBody PostGrade postGrade){
     boolean isSave = postGradeService.save(postGrade);
     if (isSave){
         return R.ok().message("保存成功");
     }else{
         return R.error().message("保存失败");
     }
 }
}

