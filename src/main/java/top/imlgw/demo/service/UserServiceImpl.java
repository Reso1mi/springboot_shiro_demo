package top.imlgw.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.imlgw.demo.mapper.UserMapper;
import top.imlgw.demo.pojo.User;

/**
 * @author imlgw.top
 * @date 2019/11/18 19:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
