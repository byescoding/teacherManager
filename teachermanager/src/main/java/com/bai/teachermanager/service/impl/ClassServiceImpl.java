package com.bai.teachermanager.service.impl;

import com.bai.teachermanager.entity.Class;
import com.bai.teachermanager.mapper.ClassMapper;
import com.bai.teachermanager.service.ClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班级表 服务实现类
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

}
