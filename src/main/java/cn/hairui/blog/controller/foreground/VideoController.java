package cn.hairui.blog.controller.foreground;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.service.MyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/7/11 23:48
 */
@Controller

public class VideoController {

    @Autowired
    private MyInfoService myInfoService;

    @RequestMapping(value = "/videos")
    public String videosShow(HttpServletRequest request, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        return "videos";
    }
}
