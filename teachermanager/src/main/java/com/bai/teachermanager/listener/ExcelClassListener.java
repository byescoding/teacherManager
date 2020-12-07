package com.bai.teachermanager.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bai.teachermanager.entity.Classes;
import com.bai.teachermanager.entity.excel.ExcelClassData;
import com.bai.teachermanager.entity.excel.ExcelCourseData;
import com.bai.teachermanager.entity.excel.ExcelTeacherData;
import com.bai.teachermanager.mapper.ClassMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class ExcelClassListener extends AnalysisEventListener<ExcelClassData> {

    @Autowired
    private ClassMapper classMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void invoke(ExcelClassData data, AnalysisContext analysisContext) {
        log.info("解析到一条数据"+data);
        String name = data.getName();
        Integer number = data.getNumber();
        String headmaster = data.getHeadmaster();
        Integer isNewMajor = data.getIsNewMajor();

        Classes classes = new Classes();
        classes.setName(name);
        classes.setNumber(number);
        classes.setHeadmaster(headmaster);
        classes.setIsNewMajor(isNewMajor);

        classMapper.insert(classes);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("数据解析完成 ");
    }
}
