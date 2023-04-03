package zhurui.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:/customer/select/1";
    }
}
