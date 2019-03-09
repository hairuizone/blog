package cn.hairui.blog.controller;

import cn.hairui.blog.model.Artical;
import cn.hairui.blog.model.ArticalCategories;
import cn.hairui.blog.model.ArticalTopics;
import cn.hairui.blog.model.NavIndex;
import cn.hairui.blog.service.ArticalCategoriesService;
import cn.hairui.blog.service.ArticalService;
import cn.hairui.blog.service.ArticalTopicsService;
import cn.hairui.blog.service.NavIndexService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private ArticalCategoriesService articalCategoriesService;
    @Autowired
    private NavIndexService navIndexService;
    @Autowired
    private ArticalTopicsService articalTopicsService;

    @RequestMapping(value = "/artical-list", method = RequestMethod.GET)
    public String listArtical(Model model) {

        List<Artical> articalList = articalService.queryArticalListByCond("1", null);
        model.addAttribute("articalList", articalList);
        return "background/artical-list";
    }

    @RequestMapping(value = "/artical-add",method = RequestMethod.GET)
    public  String addArtical(Model model){
        List<ArticalCategories> acList = articalCategoriesService.qeuryArticalCategoriesList();
        model.addAttribute("acList", acList);

        List<NavIndex> navList = navIndexService.queryNavIndexList();
        model.addAttribute("navList", navList);

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String openday = df.format(date);
        model.addAttribute("OPENDAY",openday);

        List<ArticalTopics> topicList = articalTopicsService.qeuryArticalTopicsList();
        return "background/artical-add";
    }

    @RequestMapping(value = "/artical-adddata" ,method = RequestMethod.POST)
    public String addArticalDAta(@ModelAttribute Artical artical){

        //随机设置封面图


        int i = new Random().nextInt(8)+1;//1-9随机图片
        String imgPath = "images/"+i+".jpg";
        System.out.println(imgPath);
        artical.setImgpath(imgPath);

        Integer num = articalService.addArtical(artical);
        System.out.println(num);
        return "redirect:/artical-list";
    }
    @RequestMapping(value = "/artical-update", method = RequestMethod.GET)
    public String updateArtical(Integer id, Model model) {

        if (id == null) {
            return "404";
        }
        List<ArticalCategories> acList = articalCategoriesService.qeuryArticalCategoriesList();
        model.addAttribute("acList", acList);

        Artical artical = articalService.queryArticalDetailById(id);
        model.addAttribute("artical", artical);

        return "background/artical-update";
    }

    @RequestMapping(value = "/artical-updatedata", method = RequestMethod.POST)
    public String updateArticalData(@ModelAttribute Artical artical, Model model) {
        Integer num = articalService.updateArtical(artical);
        return "redirect:/artical-list";
    }

    @RequestMapping(value = "/artical-delete", method = RequestMethod.POST)
    @ResponseBody
    public Map deleteArtical(String id, HttpServletRequest httpServletRequest) {
        Map map = new HashMap();
        Integer num = articalService.deleteArticalById(id);
        if(num == 1){
            map.put("flag", "success");
        }else{
            map.put("flag", "failed");
        }
        return map;
    }
}
