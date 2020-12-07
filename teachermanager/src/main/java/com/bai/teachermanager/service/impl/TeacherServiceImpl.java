package com.bai.teachermanager.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.bai.teachermanager.entity.Teacher;
import com.bai.teachermanager.entity.excel.ExcelTeacherData;
import com.bai.teachermanager.entity.vo.TeacherQueryVo;
import com.bai.teachermanager.listener.ExcelTeacherListener;
import com.bai.teachermanager.mapper.TeacherMapper;
import com.bai.teachermanager.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 教师信息表 服务实现类
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {


    @Override
    public List<Map<String, Object>> selectNameListByKey(String key) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper.select("name");
        teacherQueryWrapper.likeRight("name",key);

        return baseMapper.selectMaps(teacherQueryWrapper);
    }

    /**
     * 使用excel  进行批量导入
     * @param inputStream
     */
    @Override
    public void batchImport(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelTeacherData.class,new ExcelTeacherListener(baseMapper)
        ).excelType(ExcelTypeEnum.XLSX).doReadAll();
    }

    @Override
    public Page<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo) {
        //先将查询条件取出来
        String name = teacherQueryVo.getName();
        String grade = teacherQueryVo.getGrade();
        String idCard = teacherQueryVo.getIdCard();

        //构造查询条件
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(name)){
            teacherQueryWrapper.eq("name",name);
        }else if(!StringUtils.isEmpty(grade)){
            teacherQueryWrapper.eq("grade",grade);
        }else if(!StringUtils.isEmpty(idCard)){
            teacherQueryWrapper.eq("id_card",idCard);
        }


        return baseMapper.selectPage(pageParam,teacherQueryWrapper);
    }
}
