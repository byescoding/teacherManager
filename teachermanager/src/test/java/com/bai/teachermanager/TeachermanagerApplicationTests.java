package com.bai.teachermanager;

import com.bai.teachermanager.entity.Teacher;
import com.bai.teachermanager.entity.vo.CourseVo;
import com.bai.teachermanager.mapper.CourseMapper;
import com.bai.teachermanager.utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.poi.hssf.record.DVALRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootTest
class TeachermanagerApplicationTests {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    void contextLoads() {
//        Page<CourseVo> pageParm = new Page<>(0,5);
//        List<CourseVo> courseVos = courseMapper.selectPageByCourseQueryVo(pageParm, null);
//        long total = pageParm.getTotal(); //获取总数
//        pageParm.setRecords(courseVos);
//        List<CourseVo> records = pageParm.getRecords();
//        System.out.println(records);
        List<String> strings = new ArrayList<>();
        List<String> strings1 = new ArrayList<>();
        strings.add("a");
        strings.add("a");
//        Long collect = strings.stream().filter.count();
//        System.out.println(collect);
    }

}
