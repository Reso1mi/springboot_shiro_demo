package top.imlgw.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.imlgw.demo.pojo.User;

/**
 * @author imlgw.top
 * @date 2019/11/18 19:05
 */
@Repository
public interface UserMapper {
    User findByUsername(@Param("username") String username);
}
