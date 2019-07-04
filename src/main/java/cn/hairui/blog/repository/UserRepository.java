package cn.hairui.blog.repository;

import cn.hairui.blog.mapper.UserMapper;
import cn.hairui.blog.model.MusicList;
import cn.hairui.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/29 21:19
 */
@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;
    public User queryUserByNameAndPwd(String username, String password) {
        return userMapper.queryUserByNameAndPwd(username,password);
    }
}
