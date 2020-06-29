package cc.jaya.controller;

import cc.jaya.RespData;
import cc.jaya.entity.User;
import cc.jaya.mapper.IUserMapper;
import cc.jaya.service.IUserService;
import cc.jaya.vo.UserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    private QueryWrapper<User> createWapper(UserVO userVO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (userVO == null) return null;
        String uname = userVO.getUname();
        if (uname != null && !uname.equals("")) {
            queryWrapper.like("uname", uname);
        }
        String email = userVO.getEmail();
        if (email != null && !email.equals("")) {
            queryWrapper.like("email", email);
        }
        Integer age = userVO.getAge();
        if (age != null) {
            queryWrapper.eq("age", age);
        }
        Boolean isDisabled = userVO.getIsDisabled();
        if (isDisabled != null) {
            queryWrapper.eq("is_disabled", isDisabled);
        }
        Date gmtCreateStart = userVO.getGmtCreateStart();
        if (gmtCreateStart != null) {
            queryWrapper.ge("gmt_create", gmtCreateStart);
        }
        Date gmtCreateEnd = userVO.getGmtCreateEnd();
        if (gmtCreateEnd != null) {
            queryWrapper.le("gmt_create", gmtCreateEnd);
        }
        return queryWrapper;
    }

    private User createUpdateUser(User user, UserVO userVO) {
        if (userVO == null) return user;
        String uname = userVO.getUname();
        if (uname != null && !uname.equals("")) user.setUname(uname);
        String pawd = userVO.getPawd();
        if (pawd != null && !pawd.equals("")) user.setPawd(pawd);
        Integer age = userVO.getAge();
        if (age != null) user.setAge(age);
        String email = userVO.getEmail();
        if (email != null && !email.equals("")) user.setEmail(email);
        Boolean isDisabled = userVO.getIsDisabled();
        if (isDisabled != null) user.setIsDisabled(isDisabled);
        return user;
    }


    @GetMapping("")
    public RespData getAllUser(UserVO userVO) {
        QueryWrapper<User> wapper = createWapper(userVO);
        List<User> users = userService.list(wapper);
        return RespData.right("获取用户列表成功！", users);
    }

    @GetMapping("/{pgidx}/{pgcnt}")
    public RespData getPageUser(@PathVariable("pgidx") Integer pgidx, @PathVariable("pgcnt") Integer pgcnt, UserVO userVO) {
        Page<User> page = new Page<>(pgidx, pgcnt);
        QueryWrapper<User> wapper = createWapper(userVO);
        IPage<User> result = userService.page(page, wapper);
        return RespData.right("获取用户分页列表成功！", result);
    }

    @GetMapping("/{id}")
    public RespData getUserByID(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        return RespData.right("获取用户成功!", user);
    }

    @PostMapping("")
    public RespData addUser(@RequestBody UserVO userVO) {
        User user = new User();
        user.setUname(userVO.getUname()).setPawd(userVO.getPawd());
        user.setEmail(userVO.getEmail()).setAge(userVO.getAge());
        user.setIsDisabled(userVO.getIsDisabled());
        boolean result = userService.save(user);
        if (result == true) return RespData.right("添加用户成功!");
        else return RespData.wrong(0, "添加用户失败！");
    }

    @PutMapping("/{id}")
    public RespData updateUser(@PathVariable("id") Long id, @RequestBody UserVO userVO) {
        User user = userService.getById(id);
        if (user == null) return RespData.wrong(0, "用户已不存在，更新失败！");

        user = createUpdateUser(user, userVO);
        boolean result = userService.updateById(user);
        if (result == true) return RespData.right("更新用户成功!");
        else return RespData.wrong(0, "更新用户失败！");
    }

    @DeleteMapping("/{id}")
    public RespData deleteUser(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        if (user == null) return RespData.wrong(0, "用户已不存在，删除失败！");

        boolean result = userService.removeById(id);
        if (result == true) return RespData.right("删除用户成功!");
        else return RespData.wrong(0, "删除用户失败！");
    }
}
