package com.bai.teachermanager.service.impl;

import com.bai.teachermanager.entity.PostGrade;
import com.bai.teachermanager.entity.Student;
import com.bai.teachermanager.mapper.PostGradeMapper;
import com.bai.teachermanager.mapper.StudentMapper;
import com.bai.teachermanager.service.PostGradeService;
import com.bai.teachermanager.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
