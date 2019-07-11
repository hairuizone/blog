package cn.hairui.blog.repository;

import cn.hairui.blog.mapper.UserMapper;
import cn.hairui.blog.model.MusicList;
import cn.hairui.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return userMapper.queryUserByNameAndPwd(username, password);
    }

    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    public List<User> queryNormalUserList() {
        return userMapper.queryNormalUserList();
    }

    public int updateUserPwd(Integer id, String newPwd) {
        return userMapper.updateUserPwd(id, newPwd);
    }

    public int updateUserLockSts(Integer id, String lock) {
        return userMapper.updateUserLockSts(id, lock);
    }
}
