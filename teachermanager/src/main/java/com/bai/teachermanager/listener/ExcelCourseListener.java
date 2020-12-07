package com.bai.teachermanager.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bai.teachermanager.entity.Course;
import com.bai.teachermanager.entity.Teacher;
import com.bai.teachermanager.entity.excel.ExcelCourseData;
import com.bai.teachermanager.entity.excel.ExcelTeacherData;
import com.bai.teachermanager.mapper.CourseMapper;
import com.bai.teachermanager.mapper.TeacherMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class ExcelCourseListener extends AnalysisEventListener<ExcelCourseData> {

    @Autowired
    private CourseMapper courseMapper;
   @Transactional(rollbackFor = Exception.class)
    @Override
    public void invoke(ExcelCourseData data, AnalysisContext analysisContext) {
     log.info("解析到一条数据"+data);
     //获取数据
        String term = data.getTerm();
        String courseTypeId = data.getCourseTypeId();
        String name = data.getName();
        Integer classTime = data.getClassTime();
        Integer theoryClassTime = data.getTheoryClassTime();
        Integer experimentalClassTime = data.getExperimentalClassTime();
        Integer weeks = data.getWeeks();
        Integer classNumber = data.getClassNumber();
        Integer studentNumber = data.getStudentNumber();
        String teacherId = data.getTeacherId();
        Integer isNew = data.getIsNew();
        Integer isXicheng = data.getIsXicheng();

        Course course = new Course();
        course.setTerm(term);
        course.setCourseTypeId(courseTypeId);
        course.setName(name);
        course.setClassTime(classTime);
        course.setTheoryClassTime(theoryClassTime);
        course.setExperimentalClassTime(experimentalClassTime);
        course.setWeeks(weeks);
        course.setClassNumber(classNumber);
        course.setStudentNumber(studentNumber);
        course.setTeacherId(teacherId);
        course.setIsNew(isNew);
        course.setIsXicheng(isXicheng);

        courseMapper.insert(course);



    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("数据解析完成 ");
    }
}
