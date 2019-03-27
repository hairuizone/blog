package cn.hairui.blog.controller;

import cn.hairui.blog.model.ArticalTopics;
import cn.hairui.blog.service.ArticalTopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/27 21:23
 */
@Controller
@RequestMapping(value = "/bg")
public class ArticalTopicsController {

    @Autowired
    private ArticalTopicsService articalTopicsService;

    @RequestMapping(value = "topic-list")
    public String listArticalTopics(Model model) {
        List<ArticalTopics> articalTopicsList = articalTopicsService.qeuryArticalTopicsList();
        model.addAttribute("topicList", articalTopicsList);
        return "background/topic-list";
    }
}
