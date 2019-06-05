package cn.hairui.blog.controller;

import cn.hairui.blog.model.*;
import cn.hairui.blog.service.*;
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
    @Autowired
    private MyInfoService myInfoService;

    @RequestMapping(value = "/bg/artical-list", method = RequestMethod.GET)
    public String listArtical(Model model) {

        List<Artical> articalList = articalService.queryArticalListByCond("1", null);
        model.addAttribute("articalList", articalList);

        List<ArticalCategories> categoriesList = articalCategoriesService.qeuryArticalCategoriesList();
        model.addAttribute("categoriesList", categoriesList);

        return "background/artical-list";
    }

    @RequestMapping(value = "/bg/artical-add",method = RequestMethod.GET)
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
        model.addAttribute("topicList", topicList);
        return "background/artical-add";
    }

    @RequestMapping(value = "/bg/artical-adddata" ,method = RequestMethod.POST)
    public String addArticalDAta(@ModelAttribute Artical artical){

        //随机设置封面图


        int i = new Random().nextInt(8)+1;//1-9随机图片
        String imgPath = "images/"+i+".jpg";
        System.out.println(imgPath);
        artical.setImgpath(imgPath);
        //初始化新增设置
        artical.setLikeNums(0);
        artical.setDissNums(0);
        artical.setUpdateDate(artical.getCreateDate());

        Integer num = articalService.addArtical(artical);

        return "redirect:artical-list";
    }
    @RequestMapping(value = "/bg/artical-update", method = RequestMethod.GET)
    public String updateArtical(Integer id, Model model) {

        if (id == null) {
            return "404";
        }
        List<ArticalCategories> acList = articalCategoriesService.qeuryArticalCategoriesList();
        model.addAttribute("acList", acList);

        List<NavIndex> navList = navIndexService.queryNavIndexList();
        model.addAttribute("navList", navList);

        List<ArticalTopics> topicList = articalTopicsService.qeuryArticalTopicsList();
        model.addAttribute("topicList", topicList);

        Artical artical = articalService.queryArticalDetailById(id);
        model.addAttribute("artical", artical);

        return "background/artical-update";
    }

    @RequestMapping(value = "/bg/artical-updatedata", method = RequestMethod.POST)
    public String updateArticalData(@ModelAttribute Artical artical, Model model) {
        /*

        "tittle=#{tittle}," +
            "type=#{type}," +
            "originAuthor=${originAuthor}," +
            "originUrl=#{originUrl}," +
            "updateDate=#{updateDate}" +
            "navId=#{navId}," +
            "topicId=#{topicId}," +
            "categories=#{categories}," +
            "content=#{content}," +
            "tags=#{tags}," +
            "summary=#{summary} " +

        */
        Integer num = articalService.updateArtical(artical);
        return "redirect:artical-list";
    }

    @RequestMapping(value = "/bg/artical-delete", method = RequestMethod.POST)
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

    @RequestMapping(value = "artical-view")
    public String viewArtical(String type,int id,Model model){
        System.out.println(type);
        System.out.println(id);
        MyInfo myInfo = myInfoService.findMyInfoById(1);
        model.addAttribute("myinfo", myInfo);

        Artical artical = articalService.queryArticalDetailById(id);
        String articalType = artical.getType();
        if("YC".equals(articalType)){
            model.addAttribute("articalTypeCn","原创");
        }else {
            model.addAttribute("articalTypeCn","转载");
        }
        int categories = artical.getCategories();
        if(categories == 6){
            model.addAttribute("categoriesCn","博文欣赏");
        }
        //名言
        String solidot = "我一直在坚定不移的在做我认为正确的事情，走我认为正确的道路，并且我还会继续！";
        String solidotor = "老干部";
        model.addAttribute("solidot",solidot);
        model.addAttribute("solidotor",solidotor);


        model.addAttribute("artical",artical);
        return "viewartical";
    }
}