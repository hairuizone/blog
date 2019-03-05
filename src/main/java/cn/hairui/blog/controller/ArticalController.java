package cn.hairui.blog.controller;

import cn.hairui.blog.model.Artical;
import cn.hairui.blog.service.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/5 22:42
 */
@Controller
public class ArticalController {

    @Autowired
    private ArticalService articalService;

    @RequestMapping(value = "/artical-list", method = RequestMethod.GET)
    public String indexPage(Model model) {

        List<Artical> articalList = articalService.queryArticalListByCond("1",null);
        model.addAttribute("articalList",articalList);
        return "background/artical-list";
    }
}
