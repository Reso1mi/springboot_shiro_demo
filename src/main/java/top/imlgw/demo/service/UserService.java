package top.imlgw.demo.service;

import top.imlgw.demo.pojo.User;

/**
 * @author imlgw.top
 * @date 2019/11/18 19:06
 */
public interface UserService {
    User findByUsername(String username);
}
