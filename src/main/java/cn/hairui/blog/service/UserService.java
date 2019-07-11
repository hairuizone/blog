package cn.hairui.blog.service;

import cn.hairui.blog.model.MusicList;
import cn.hairui.blog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/29 21:16
 */
public interface UserService {

    /**
     * 查询用户信息
     *
     * @param username 用户名
     * @param password 密码密文
     * @return
     */
    public User queryUserByNameAndPwd(String username, String password);

    /**
     * 获取所有用户
     *
     * @return
     */
    public List<User> queryUserList();

    /**
     * 查询非管理用户
     *
     * @return
     */
    public List<User> queryNormalUserList();

    /**
     * 设置用户密码
     *
     * @param id
     * @param newPwd
     * @return
     */
    public int updateUserPwd(Integer id, String newPwd);

    /**
     * 更新用户锁定状态
     *
     * @param id
     * @param lock
     * @return
     */
    public int updateUserLockSts(Integer id, String lock);
}
