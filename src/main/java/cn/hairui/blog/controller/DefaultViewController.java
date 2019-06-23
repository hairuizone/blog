package cn.hairui.blog.controller;

import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.service.MyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author laoganbu
 * @date: 2019/2/25 17:37
 */
@Controller
public class DefaultViewController {

    @Autowired
    private MyInfoService myInfoService;

    @RequestMapping(value = "/manage/homepage", method = RequestMethod.GET)
    public String backgroundHomePage() {
        return "background/index";
    }

    @ResponseBody
    @RequestMapping(value = "/getMyInfo", produces = {"application/json;charset=UTF-8"})
    public MyInfo getMyInfo() {
        return myInfoService.findMyInfoById(1);
    }

    @RequestMapping(value = "musicplayer")
    public String musicplayer() {
        return "musicplayer";
    }

    @RequestMapping(value = "videoplayer")
    public String videoplayer() {
        return "videoplayer";
    }

    @RequestMapping(value = "test")
    public String test() {
        return "test";
    }
}