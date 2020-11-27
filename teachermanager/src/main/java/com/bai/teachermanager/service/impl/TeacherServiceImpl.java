package com.bai.teachermanager.service.impl;

import com.bai.teachermanager.entity.Teacher;
import com.bai.teachermanager.mapper.TeacherMapper;
import com.bai.teachermanager.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
}
