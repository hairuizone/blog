package cn.hairui.blog.controller;

import cn.hairui.blog.model.ArticalCategories;
import cn.hairui.blog.service.ArticalCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/27 20:22
 */
@Controller
@RequestMapping(value = "/bg")
public class ArticalCategoriesController {

    @Autowired
    private ArticalCategoriesService articalCategoriesService;

    @RequestMapping(value = "categories-list")
    public String listArticalCategories(Model model){
        List<ArticalCategories> articalCategoriesList =  articalCategoriesService.qeuryArticalCategoriesList();
        model.addAttribute("articalCategoriesList",articalCategoriesList);
        return "background/categories-list";
    }
}
