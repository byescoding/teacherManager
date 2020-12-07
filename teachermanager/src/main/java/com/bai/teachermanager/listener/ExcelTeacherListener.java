package com.bai.teachermanager.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bai.teachermanager.entity.Teacher;
import com.bai.teachermanager.entity.excel.ExcelTeacherData;
import com.bai.teachermanager.mapper.TeacherMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class ExcelTeacherListener extends AnalysisEventListener<ExcelTeacherData> {

    @Autowired
    private TeacherMapper  teacherMapper;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void invoke(ExcelTeacherData data, AnalysisContext analysisContext) {
        log.info("解析到一条记录：{}", data);
        //解析获取教师数据
        String name = data.getName();
        String password = data.getPassword();
        String grade = data.getGrade();
        Integer sex = data.getSex();
        String university = data.getUniversity();
        String telephone = data.getTelephone();
        String email = data.getEmail();
        String idCard = data.getIdCard();
        String education = data.getEducation();
        String address = data.getAddress();

        Teacher teacher = new Teacher();

            teacher.setPassword(password);
            teacher.setName(name);
            teacher.setGrade(grade);
            teacher.setSex(sex);
            teacher.setUniversity(university);
            teacher.setTelephone(telephone);
            teacher.setEmail(email);
            teacher.setIdCard(idCard);
            teacher.setEducation(education);
            teacher.setAddress(address);

        //插入信息
        teacherMapper.insert(teacher);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("数据解析完成 ");
    }
}
