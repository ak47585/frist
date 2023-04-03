package zhurui.ssm.controller;

import zhurui.ssm.pojo.User;
import zhurui.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        String code = user.getCode();
        String password = user.getPassword();
        if (code == null || code.trim().length() == 0) {
            request.setAttribute("codeError", "账号不能为空");
            return "login";
        }
        if (password == null || password.trim().length() == 0) {
            request.setAttribute("passwordError", "密码不能为空");
            request.setAttribute("user", user);
            return "login";
        }

        User u = userService.login(user);
        if (u == null) {
            request.setAttribute("codeError", "账号或密码错误");
            request.setAttribute("user", user);
            return "login";
        }
        // 登录成功
        request.getSession().setAttribute("user", u);
        return "redirect:/customer/select/1";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
