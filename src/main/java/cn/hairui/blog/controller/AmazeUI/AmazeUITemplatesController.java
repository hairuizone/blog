package cn.hairui.blog.controller.AmazeUI;

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
        return "AmazeUI/admin-404";
    }

    @RequestMapping("/admin-form")
    public String adminForm() {
        return "AmazeUI/admin-form";
    }

    @RequestMapping("/admin-gallery")
    public String adminGallery() {
        return "AmazeUI/admin-gallery";
    }

    @RequestMapping("/admin-help")
    public String adminHelp() {
        return "AmazeUI/admin-help";
    }

    @RequestMapping("/admin-index")
    public String adminIndex() {
        return "AmazeUI/admin-index";
    }

    @RequestMapping("/admin-log")
    public String adminLog() {
        return "AmazeUI/admin-log";
    }

    @RequestMapping("/admin-table")
    public String adminTable() {
        return "AmazeUI/admin-table";
    }

    @RequestMapping("/admin-user")
    public String adminUser() {
        return "AmazeUI/admin-user";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "AmazeUI/blog";
    }

    @RequestMapping("/index")
    public String index() {
        return "AmazeUI/index";
    }

    @RequestMapping("/iscroll")
    public String iscroll() {
        return "AmazeUI/iscroll";
    }

    @RequestMapping("/landing")
    public String landing() {
        return "AmazeUI/landing";
    }

    @RequestMapping("/login")
    public String login() {
        return "AmazeUI/login";
    }

    @RequestMapping("/non-responsive")
    public String nonResponsive() {
        return "AmazeUI/non-responsive";
    }

    @RequestMapping("/sidebar")
    public String sidebar() {
        return "AmazeUI/sidebar";
    }

    @RequestMapping("widget.basic")
    public String widgetBasic() {
        return "AmazeUI/widget.basic";
    }

    @RequestMapping("/widget")
    public String widget() {
        return "AmazeUI/widget";
    }


}
