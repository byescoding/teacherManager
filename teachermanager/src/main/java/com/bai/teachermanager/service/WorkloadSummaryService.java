package com.bai.teachermanager.service;

import com.bai.teachermanager.entity.WorkloadSummary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

/**
 * <p>
 * 工作量汇总表 服务类
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
public interface WorkloadSummaryService extends IService<WorkloadSummary> {

    HashMap<String,String> workSum(String id);

}
