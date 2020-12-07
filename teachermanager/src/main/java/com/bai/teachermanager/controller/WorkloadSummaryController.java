package com.bai.teachermanager.controller;


import com.bai.teachermanager.entity.Course;
import com.bai.teachermanager.service.WorkloadSummaryService;
import com.bai.teachermanager.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 * 工作量汇总表 前端控制器
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@RestController
@RequestMapping("/teachermanager/workload-summary")
public class WorkloadSummaryController {
  @Autowired
    private WorkloadSummaryService workloadSummaryService;

    @ApiOperation("计算教师工作量")
    @GetMapping("get/{id}")
    public R getAdminById(@ApiParam(value = "教师id",required = true) @PathVariable String id){
      HashMap<String, String> map = workloadSummaryService.workSum(id);
      if (map == null){
            return R.error().message("不存在该教师工作量信息");
        }else{
            return  R.ok().data("item",map);
        }
    }

}

