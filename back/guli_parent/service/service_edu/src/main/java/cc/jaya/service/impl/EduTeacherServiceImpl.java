package cc.jaya.service.impl;

import cc.jaya.entity.EduTeacher;
import cc.jaya.mapper.IEduTeacherMapper;
import cc.jaya.service.IEduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EduTeacherServiceImpl extends ServiceImpl<IEduTeacherMapper, EduTeacher> implements IEduTeacherService {
}
