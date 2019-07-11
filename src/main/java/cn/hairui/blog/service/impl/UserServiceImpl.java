package cn.hairui.blog.service.impl;

import cn.hairui.blog.model.MusicList;
import cn.hairui.blog.model.User;
import cn.hairui.blog.repository.UserRepository;
import cn.hairui.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/29 21:18
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User queryUserByNameAndPwd(String username, String password) {
        return userRepository.queryUserByNameAndPwd(username, password);
    }

    @Override
    public List<User> queryUserList() {
        return userRepository.queryUserList();
    }

    @Override
    public List<User> queryNormalUserList() {
        return userRepository.queryNormalUserList();
    }

    @Override
    public int updateUserPwd(Integer id, String newPwd) {
        return userRepository.updateUserPwd(id, newPwd);
    }

    @Override
    public int updateUserLockSts(Integer id, String lock) {
        return userRepository.updateUserLockSts(id, lock);
    }

}
