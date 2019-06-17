package cn.hairui.blog.controller;

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
    private ArticalCategoriesService articalCategoriesService;
    @Autowired
    private NavIndexService navIndexService;
    @Autowired
    private ArticalTopicsService articalTopicsService;
    @Autowired
    private MyInfoService myInfoService;

    /*********后台控制********/

    @RequestMapping(value = "/manage/artical-list", method = RequestMethod.GET)
    public String listArtical(Model model) {

        List<Artical> articalList = articalService.queryArticalListByCond("1", null);
        model.addAttribute("articalList", articalList);

        List<ArticalCategories> categoriesList = articalCategoriesService.qeuryArticalCategoriesList();
        model.addAttribute("categoriesList", categoriesList);

        return "background/artical-list";
    }

    @RequestMapping(value = "/manage/artical-add",method = RequestMethod.GET)
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

    @RequestMapping(value = "/manage/artical-adddata" ,method = RequestMethod.POST)
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
    @RequestMapping(value = "/manage/artical-update", method = RequestMethod.GET)
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
        System.out.println("update"+artical.getContent());

        return "background/artical-update";
    }

    @RequestMapping(value = "/manage/artical-updatedata", method = RequestMethod.POST)
    public String updateArticalData(@ModelAttribute Artical artical, Model model) {

        System.out.println("updatedata"+artical.getContent());
        articalService.updateArtical(artical);
        model.addAttribute("artical",artical);
        return "background/artical-markdown";
    }
    @RequestMapping(value = "/manage/artical-updatemarkdowndata", method = RequestMethod.POST)
    @ResponseBody
    public String updateArticalMarkDownData(@ModelAttribute Artical artical, Model model) {
        Map map = new HashMap();
        articalService.updateArticalMarkdown(artical);
        map.put("flag","success");
        return JSONUtils.toJSONString(map);
    }

    @RequestMapping(value = "/manage/artical-delete", method = RequestMethod.POST)
    @ResponseBody
    public Map deleteArtical(String id, HttpServletRequest httpServletRequest) {
        Map map = new HashMap();
        try {
            int num = articalService.deleteArticalById(id);
            if(num == 1){
                map.put("flag", "success");
            }else{
                map.put("flag", "failed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return map;
    }








    @RequestMapping(value = "/manage/articals_query_categorie",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String queryArticalsCountByArticalCategorie(int id, HttpServletRequest httpServletRequest){
        Map map = new HashMap();
        int count = articalService.queryArticalsCountByArticalCategorie(id);

        if(count == 0){
            map.put("flag","success");
        }else{
            map.put("flag","failed");
            map.put("message","该分类下存在文章，不允许删除");
        }

        return JSONUtils.toJSONString(map);
    }





    /**************前台控制**************/
    @RequestMapping(value = "artical-view")
    public String viewArtical(String type,int id,Model model){
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
