package cn.hairui.blog.AmazeUI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/2/24 21:45
 */
@Controller
public class AmazeUITemplatesController {

    @RequestMapping("/admin-404")
    public String admin404(){
        return "admin-404";
    }

    @RequestMapping("/landing")
    public String landing(){
        return "landing";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "blog";
    }
    @RequestMapping("/sidebar")
    public String sidebar(){
        return "sidebar";
    }
    @RequestMapping("/widget")
    public String widget(){
        return "widget";
    }
    @RequestMapping("widget.basic")
    public String widgetBasic(){
        return "widget.basic";
    }
}
