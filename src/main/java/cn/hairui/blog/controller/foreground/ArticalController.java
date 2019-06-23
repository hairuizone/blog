package cn.hairui.blog.controller.foreground;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hairui.blog.model.Artical;
import cn.hairui.blog.model.ArticalCategories;
import cn.hairui.blog.model.ArticalTopics;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.model.NavIndex;
import cn.hairui.blog.service.ArticalCategoriesService;
import cn.hairui.blog.service.ArticalService;
import cn.hairui.blog.service.ArticalTopicsService;
import cn.hairui.blog.service.MyInfoService;
import cn.hairui.blog.service.NavIndexService;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/5 22:42
 */
@Controller

public class ArticalController {

    @Autowired
    private ArticalService articalService;
    @Autowired
    private MyInfoService myInfoService;


    @RequestMapping(value = "artical-view")
    public String articalView(String type, int id, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(1);
        model.addAttribute("myinfo", myInfo);

        Artical artical = articalService.queryArticalDetailById(id);
        String articalType = artical.getType();
        if ("YC".equals(articalType)) {
            model.addAttribute("articalTypeCn", "原创");
        } else {
            model.addAttribute("articalTypeCn", "转载");
        }
        int categoriesId = artical.getCategories();
        String categoriesCn = articalService.queryArticalCategoriesNameById(categoriesId);
        if (categoriesCn == null || "".equals(categoriesCn)) {
            model.addAttribute("categoriesCn", "其他");
        } else {
            model.addAttribute("categoriesCn", categoriesCn);
        }
        //名言
        String solidot = "我一直在坚定不移的在做我认为正确的事情，走我认为正确的道路，并且我还会继续！";
        String solidotor = "老干部";
        model.addAttribute("solidot", solidot);
        model.addAttribute("solidotor", solidotor);
        model.addAttribute("endmeeting", "欢迎关注我的微信公众号:老干部的咖啡屋");
        model.addAttribute("artical", artical);
        return "articalviewer";
    }


}
