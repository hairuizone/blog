package cn.hairui.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/16 17:13
 */
@Controller
public class UserController {

    @RequestMapping(value = "/manage/user-list")
    public String queryUserList(){
        return "background/user-list";
    }
}
