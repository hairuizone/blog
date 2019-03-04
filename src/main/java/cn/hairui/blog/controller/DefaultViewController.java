package cn.hairui.blog.controller;

import cn.hairui.blog.model.*;
import cn.hairui.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * @author laoganbu
 * @date: 2019/2/25 17:37
 */
@Controller
public class DefaultViewController {


    @Autowired
    private MyInfoService myInfoService;
    @Autowired
    private NavIndexService navIndexService;
    @Autowired
    private ArticalService articalService;
    @Autowired
    private ArticalCategoriesService articalCategoriesService;
    @Autowired
    private ArticalTopicsService articalTopicsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Model model) {

        //查询个人名片信息
        MyInfo myInfo = myInfoService.findMyInfoById(1);
        model.addAttribute("myinfo", myInfo);

        //查询首页tab中的tab页签信息
        List<NavIndex> navIndexList = navIndexService.queryNavIndexList();
        model.addAttribute("navIndexList", navIndexList);

        //查询tab中的详细信息

        List<List<Artical>> articalList = new ArrayList<List<Artical>>();
        for (NavIndex nav : navIndexList) {
            List<Artical> listArt = articalService.queryArticalListByNavId(nav.getId());

            articalList.add(listArt);
        }
        model.addAttribute("articalList", articalList);

       /*
        List<Artical> articalList1 = articalService.queryArticalListByNavId(1);
        List<Artical> articalList2 = articalService.queryArticalListByNavId(2);
        List<Artical> articalList3 = articalService.queryArticalListByNavId(3);
        List<Artical> articalList4 = articalService.queryArticalListByNavId(4);
        List<Artical> articalList5 = articalService.queryArticalListByNavId(5);
        model.addAttribute("articalList1", articalList1);
        model.addAttribute("articalList2", articalList2);
        model.addAttribute("articalList3", articalList3);
        model.addAttribute("articalList4", articalList4);
        model.addAttribute("articalList5", articalList5);*/

        //查询展示的分类
        List<ArticalCategories> articalCategoriesList = articalCategoriesService.qeuryArticalCategoriesByIsShow("Y");//Y-展示 N-不展示
        model.addAttribute("articalCategoriesList", articalCategoriesList);

        //分类中的内容 - 4块
        List<List<Artical>> articals = new ArrayList<List<Artical>>();
        for (ArticalCategories art : articalCategoriesList) {
            List<Artical> listArt = articalService.queryArticalListByCategories(art.getId());
            articals.add(listArt);
        }
        model.addAttribute("articals", articals);

        //专题
        List<ArticalTopics> articalTopicsList = articalTopicsService.qeuryArticalTopicsList();

        model.addAttribute("articalTopicsList", articalTopicsList);

        return "index";
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public String index2Page() {
        return "index2";
    }

}
