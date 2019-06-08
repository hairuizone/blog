package cn.hairui.blog.controller.foreground;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.Artical;
import cn.hairui.blog.model.ArticalCategories;
import cn.hairui.blog.model.ArticalTopics;
import cn.hairui.blog.model.Books;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.model.NavIndex;
import cn.hairui.blog.model.OnlineTools;
import cn.hairui.blog.service.ArticalCategoriesService;
import cn.hairui.blog.service.ArticalService;
import cn.hairui.blog.service.ArticalTopicsService;
import cn.hairui.blog.service.BooksService;
import cn.hairui.blog.service.MyInfoService;
import cn.hairui.blog.service.NavIndexService;
import cn.hairui.blog.service.OnlineToolsService;

/**
 *
 *<p>
 *<h2>主页控制器</h2>
 *<ol>请添加详细描述
 *</ol>
 *</p>
 *@author lihairui
 *@Date 2019年6月7日 下午12:41:01
 *@version 1.0
 *@since jdk 1.8
 */
@Controller
public class HomePageController {

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
    @Autowired
    private BooksService booksService;
    @Autowired
    private OnlineToolsService onlineToolsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Model model) {

        //查询个人名片信息
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        //查询首页tab中的指定条数tab页签
        List<NavIndex> navIndexList = navIndexService.queryNavIndexListLimited(PubConstant.TAB_INDEX_SHOW_MAX);
        model.addAttribute("navIndexList", navIndexList);

        //查询tab中的详细信息

        //这里首页tab页签中只显示指定条数内容
        List<List<Artical>> articalList = new ArrayList<List<Artical>>();
        for (NavIndex nav : navIndexList) {
            List<Artical> listArt = articalService.queryArticalListByNavId(nav.getId(),PubConstant.TAB_CONTENT_SHOW_MAX);
            articalList.add(listArt);
        }
        model.addAttribute("articalList", articalList);


        //查询展示的分类，只展示指定数量的内容
        List<ArticalCategories> articalCategoriesList = articalCategoriesService.qeuryArticalCategoriesByIsShow(PubConstant.YES_NO_Y,PubConstant.MAX_SHOW_ARTICALCATEGORIES);
        model.addAttribute("articalCategoriesList", articalCategoriesList);

        //分类中的内容
        List<List<Artical>> articals = new ArrayList<List<Artical>>();
        for (ArticalCategories art : articalCategoriesList) {
            //指定首页分类块中每块显示指定条记录
            List<Artical> listArt = articalService.queryArticalListByCategories(art.getId(),PubConstant.MAX_SHOW_ARTICAL_IN_CATEGORIES);
            articals.add(listArt);
        }
        model.addAttribute("articals", articals);

        //读取指定数量专题
        List<ArticalTopics> articalTopicsList = articalTopicsService.qeuryArticalTopicsListLimited(PubConstant.MAX_SHOW_ARTICAL_TOPICS);
        model.addAttribute("articalTopicsList", articalTopicsList);

        //读取指定数量开源书籍
        List<Books> booksList = booksService.queryBooksListLimited(PubConstant.MAX_SHOW_BOOK);
        model.addAttribute("booksList", booksList);

        //在线工具
        List<OnlineTools> onlineToolsList = onlineToolsService.queryOnlineToolsList();
        model.addAttribute("onlineToolsList", onlineToolsList);

        //查询统计标签 最多显示指定条数
        List<String> tagsList = articalService.queryAllArticalTagsLimited(PubConstant.MAX_SHOW_ARTICALTAGS);
        model.addAttribute("tagsList", tagsList);

        //获取置顶文章
        Artical articalTop = new Artical();
        articalTop = articalService.queryArticalFirstByIntop(PubConstant.YES_NO_Y);
        model.addAttribute("articalTop", articalTop);

        List<Artical> articalListHomePage = articalService.queryArticalListHomePage();
        model.addAttribute("articalListHomePage", articalListHomePage);
        return "index";

    }
}