package cn.hairui.blog.service;

import cn.hairui.blog.model.User;
import org.springframework.stereotype.Service;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/29 21:16
 */
public interface UserService {

    /**
     * 查询用户信息
     * @param username 用户名
     * @param password 密码密文
     * @return
     */
    public User queryUserByNameAndPwd(String username,String password);
}
