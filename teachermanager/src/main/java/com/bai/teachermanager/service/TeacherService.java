package com.bai.teachermanager.service;

import com.bai.teachermanager.entity.Teacher;
import com.bai.teachermanager.entity.vo.TeacherQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 教师信息表 服务类
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
public interface TeacherService extends IService<Teacher> {

    List<Map<String, Object>> selectNameListByKey(String key);

    void batchImport(InputStream inputStream);

    Page<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo);

}
