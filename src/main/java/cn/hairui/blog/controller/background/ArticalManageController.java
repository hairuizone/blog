package cn.hairui.blog.controller.background;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import cn.hairui.blog.constant.PubConstant;
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
@RequestMapping("/manage")
public class ArticalManageController {

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

    private String listPage = PubConstant.BACKGROUND_DIR_NAME + "artical-list";//列表页面
    private String addPage = PubConstant.BACKGROUND_DIR_NAME + "artical-add";//新增页面
    private String updatePage = PubConstant.BACKGROUND_DIR_NAME + "artical-update";//修改页面

    private String markdownPage = PubConstant.BACKGROUND_DIR_NAME + "artical-markdown";

    @RequestMapping(value = "/artical-list", method = RequestMethod.GET)
    public String listArtical(Model model) {
        List<Artical> articalList = articalService.queryArticalListByCond("1", null);
        model.addAttribute("articalList", articalList);

        List<ArticalCategories> categoriesList = articalCategoriesService.queryArticalCategoriesList();
        model.addAttribute("categoriesList", categoriesList);
        return listPage;
    }

    @RequestMapping(value = "/artical-add", method = RequestMethod.GET)
    public String addArtical(Model model) {
        List<ArticalCategories> acList = articalCategoriesService.queryArticalCategoriesList();
        model.addAttribute("acList", acList);

        List<NavIndex> navList = navIndexService.queryNavIndexList();
        model.addAttribute("navList", navList);

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String openday = df.format(date);
        model.addAttribute("OPENDAY", openday);

        List<ArticalTopics> topicList = articalTopicsService.qeuryArticalTopicsList();
        model.addAttribute("topicList", topicList);
        return addPage;
    }

    @RequestMapping(value = "/artical-adddata", method = RequestMethod.POST)
    public String addArticalDAta(@ModelAttribute Artical artical, Model model) {
        //随机设置封面图
        int i = new Random().nextInt(8) + 1;//1-9随机图片
        String imgPath = "images/" + i + ".jpg";
        System.out.println(imgPath);
        artical.setImgpath(imgPath);
        //初始化新增设置
        artical.setLikeNums(0);
        artical.setDissNums(0);
        artical.setUpdateDate(artical.getCreateDate());

        //获取最大值
        Integer max = articalService.getMaxArticalId();
        if (max == null) {
            max = 0;
        }
        int nextId = max + 1;
        artical.setId(nextId);

        Integer num = articalService.addArtical(artical);
        System.out.println(nextId);
        model.addAttribute("artical", artical);
        return markdownPage;
    }

    @RequestMapping(value = "/artical-update", method = RequestMethod.GET)
    public String updateArtical(Integer id, Model model) {

        if (id == null) {
            return "404";
        }
        List<ArticalCategories> acList = articalCategoriesService.queryArticalCategoriesList();
        model.addAttribute("acList", acList);

        List<NavIndex> navList = navIndexService.queryNavIndexList();
        model.addAttribute("navList", navList);

        List<ArticalTopics> topicList = articalTopicsService.qeuryArticalTopicsList();
        model.addAttribute("topicList", topicList);

        Artical artical = articalService.queryArticalDetailById(id);
        model.addAttribute("artical", artical);
        System.out.println("update" + artical.getContent());
        return updatePage;
    }

    @RequestMapping(value = "/artical-updatedata", method = RequestMethod.POST)
    public String updateArticalData(@ModelAttribute Artical artical, Model model) {

        System.out.println("updatedata" + artical.getContent());
        articalService.updateArtical(artical);
        model.addAttribute("artical", artical);
        return markdownPage;
    }

    @RequestMapping(value = "/artical-updatemarkdowndata", method = RequestMethod.POST)
    @ResponseBody
    public String updateArticalMarkDownData(@ModelAttribute Artical artical, Model model) {
        Map map = new HashMap();
        articalService.updateArticalMarkdown(artical);
        map.put(PubConstant.flag, PubConstant.success);
        return JSONUtils.toJSONString(map);
    }

    @RequestMapping(value = "/artical-delete", method = RequestMethod.POST)
    @ResponseBody
    public Map deleteArtical(String id, HttpServletRequest httpServletRequest) {
        Map map = new HashMap();
        try {
            int num = articalService.deleteArticalById(id);
            if (num == 1) {
                map.put(PubConstant.flag, PubConstant.success);
            } else {
                map.put(PubConstant.flag, PubConstant.failed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/articals_query_categorie", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String queryArticalsCountByArticalCategorie(int id, HttpServletRequest httpServletRequest) {
        Map map = new HashMap();
        int count = articalService.queryArticalsCountByArticalCategorie(id);

        if (count == 0) {
            map.put(PubConstant.flag, PubConstant.success);
        } else {
            map.put(PubConstant.flag, PubConstant.failed);
            map.put(PubConstant.message, "该分类下存在文章，不允许删除");
        }
        return JSONUtils.toJSONString(map);
    }

}
