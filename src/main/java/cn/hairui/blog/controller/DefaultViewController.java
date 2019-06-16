package cn.hairui.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author laoganbu
 * @date: 2019/2/25 17:37
 */
@Controller
public class DefaultViewController {


    @RequestMapping(value = "/background", method = RequestMethod.GET)
    public String backgroundPage() {
        return "background/index";
    }

    @RequestMapping(value = "/manage/homepage", method = RequestMethod.GET)
    public String backgroundHomePage() {
        return "background/index";

    }
}