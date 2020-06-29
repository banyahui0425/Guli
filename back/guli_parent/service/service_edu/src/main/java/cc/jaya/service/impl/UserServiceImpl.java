package cc.jaya.service.impl;

import cc.jaya.entity.User;
import cc.jaya.mapper.IUserMapper;
import cc.jaya.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {
}
