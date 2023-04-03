package zhurui.ssm.service;

import zhurui.ssm.dao.UserDao;
import zhurui.ssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User login(User user) {
        User u = userDao.findByUserCode(user.getCode());
        // 账号错误
        if (u == null) {
            return null;
        }
        // 密码错误
        if (!u.getPassword().equals(user.getPassword())) {
            return null;
        }
        // 如果账户暂停，登录失败
        if (u.getState() == 0) {
            return null;
        }
        // 登录成功
        u.setPassword(null);
        return u;
    }

    public List<User> userList() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            user.setPassword(null);
        }
        return userList;
    }
}
