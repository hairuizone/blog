package cn.hairui.blog.controller.background;

import cn.hairui.blog.constant.PubConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/16 17:13
 */
@Controller
@RequestMapping("manage")
public class UserManageController {

    private String listPage = PubConstant.BACKGROUND_DIR_NAME + "user-list";//列表页面

    @RequestMapping(value = "/user-list")
    public String queryUserList() {
        return listPage;
    }
}
