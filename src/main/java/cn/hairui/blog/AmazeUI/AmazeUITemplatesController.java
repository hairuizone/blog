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
    public String admin404() {
        return "admin-404";
    }

    @RequestMapping("/admin-form")
    public String adminForm() {
        return "admin-form";
    }

    @RequestMapping("/admin-gallery")
    public String adminGallery() {
        return "admin-gallery";
    }

    @RequestMapping("/admin-help")
    public String adminHelp() {
        return "admin-help";
    }

    @RequestMapping("/admin-index")
    public String adminIndex() {
        return "admin-index";
    }

    @RequestMapping("/admin-log")
    public String adminLog() {
        return "admin-log";
    }

    @RequestMapping("/admin-table")
    public String adminTable() {
        return "admin-table";
    }

    @RequestMapping("/admin-user")
    public String adminUser() {
        return "admin-user";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "blog";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/iscroll")
    public String iscroll() {
        return "iscroll";
    }

    @RequestMapping("/landing")
    public String landing() {
        return "landing";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/non-responsive")
    public String nonResponsive() {
        return "non-responsive";
    }

    @RequestMapping("/sidebar")
    public String sidebar() {
        return "sidebar";
    }

    @RequestMapping("widget.basic")
    public String widgetBasic() {
        return "widget.basic";
    }

    @RequestMapping("/widget")
    public String widget() {
        return "widget";
    }


}
