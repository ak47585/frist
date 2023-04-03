package zhurui.ssm.dao;

import zhurui.ssm.pojo.User;

import java.util.List;

public interface UserDao {
    User findByUserCode(String code);
    List<User> findAll();
}
