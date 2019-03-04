package cn.hairui.blog.controller;

import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.service.MyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author laoganbu
 * @date: 2019/3/4 14:38
 */
@Controller
public class MyInfoController {

    @Autowired
    private MyInfoService myInfoService;

    @ResponseBody
    @RequestMapping(value = "/getMyInfo", produces = {"application/json;charset=UTF-8"})
    public MyInfo getMyInfo() {
        return myInfoService.findMyInfoById(1);
    }
}
