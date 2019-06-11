package cn.hairui.blog.controller;

import cn.hairui.blog.model.OnlineTools;
import cn.hairui.blog.service.OnlineToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/27 21:48
 */
@Controller
public class OnlineToolsController {

    @Autowired
    private OnlineToolsService onlineToolsService;

    @RequestMapping(value = "/manage/tools-list")
    public String listOnlineTools(Model model){
        List<OnlineTools> onlineToolsList = onlineToolsService.queryOnlineToolsList();
        model.addAttribute("toolsList",onlineToolsList);
        return "background/tools-list";
    }
}
