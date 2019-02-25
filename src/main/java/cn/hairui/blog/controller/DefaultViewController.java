package cn.hairui.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author laoganbu
 * @date: 2019/2/25 17:37
 */
@Controller
public class DefaultViewController {

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String indexPage(Model model){
        model.addAttribute("greetings","你的努力就是对自己最好的回报");
        model.addAttribute("bg_path","http://localhost:8848/myblog/img/index_bg.jpg");
        model.addAttribute("name","LaoGanbu");
        return "index";


    }
}
