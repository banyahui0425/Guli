package cc.jaya.controller;

import cc.jaya.RespData;
import cc.jaya.entity.User;
import cc.jaya.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/api/edu/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public RespData login(HttpSession session) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        String uname = "zhangsan";
        String pawd = "123";
        if (uname == null || uname.equals("")) return RespData.wrong(0, "用户名不能为空！");
        if (pawd == null || pawd.equals("")) return RespData.wrong(0, "密码不能为空！");

        queryWrapper.eq("uname", uname);
        queryWrapper.eq("pawd", pawd);
        User user = userService.getOne(queryWrapper);
        if (user == null) return RespData.wrong(0, "用户名或密码不正确！");

        session.setAttribute("user", user);
        HashMap<String, String> data = new HashMap<>();
        data.put("token", "token");
        return RespData.right("用户登录成功！", data);
    }

    @GetMapping("/info")
    public RespData getInfo() {
        HashMap<String, String> data = new HashMap<>();
        data.put("roles", "shuzu");
        data.put("name", "zhansgan");
        data.put("avatar", "//www.baidu.com/img/flexible/logo/pc/result.png");
        return RespData.right("get info right", data);
    }

    @PostMapping("/logout")
    public RespData logout(HttpSession session) {
        session.removeAttribute("user");
        return RespData.right("用户登出成功！");
    }
}
