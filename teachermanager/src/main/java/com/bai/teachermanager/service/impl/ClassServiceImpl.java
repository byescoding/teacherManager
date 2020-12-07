package com.bai.teachermanager.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.bai.teachermanager.entity.Classes;
import com.bai.teachermanager.entity.excel.ExcelTeacherData;
import com.bai.teachermanager.listener.ExcelClassListener;
import com.bai.teachermanager.listener.ExcelCourseListener;
import com.bai.teachermanager.listener.ExcelTeacherListener;
import com.bai.teachermanager.mapper.ClassMapper;
import com.bai.teachermanager.service.ClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * <p>
 * 班级表 服务实现类
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Classes> implements ClassService {

    @Override
    public void batchImport(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelTeacherData.class,new ExcelClassListener(baseMapper)
        ).excelType(ExcelTypeEnum.XLSX).doReadAll();
    }
}
