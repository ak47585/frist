package test.service;

import zhurui.ssm.pojo.User;
import zhurui.ssm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {
    @Test
    public void testLogin() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setCode("admin");
        user.setPassword("admin");
        System.out.println(userService.login(user));
    }
}
