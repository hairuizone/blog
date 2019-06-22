package cn.hairui.blog.controller.foreground;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.*;
import cn.hairui.blog.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 * <h2>主页控制器</h2>
 * <ol>请添加详细描述
 * </ol>
 * </p>
 *
 * @author lihairui
 * @version 1.0
 * @Date 2019年6月7日 下午12:41:01
 * @since jdk 1.8
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
            List<Artical> listArt = articalService.queryArticalListByNavId(nav.getId(), PubConstant.TAB_CONTENT_SHOW_MAX);
            articalList.add(listArt);
        }
        model.addAttribute("articalList", articalList);


        //查询展示的分类，只展示指定数量的内容，分开展示两栏
        List<ArticalCategories> articalCategoriesList = articalCategoriesService.qeuryArticalCategoriesByIsShow(PubConstant.YES_NO_Y, 0, PubConstant.MAX_SHOW_ARTICALCATEGORIES);
        model.addAttribute("articalCategoriesList", articalCategoriesList);

        List<ArticalCategories> articalCategoriesList2 = articalCategoriesService.qeuryArticalCategoriesByIsShow(PubConstant.YES_NO_Y, PubConstant.MAX_SHOW_ARTICALCATEGORIES, PubConstant.MAX_SHOW_ARTICALCATEGORIES_2);
        model.addAttribute("articalCategoriesList2", articalCategoriesList2);


        //分类中的内容
        List<List<Artical>> articals = new ArrayList<List<Artical>>();

        for (ArticalCategories art : articalCategoriesList) {
            //指定首页分类块中每块显示指定条记录
            List<Artical> listArt = articalService.queryArticalListByCategories(art.getId(), PubConstant.MAX_SHOW_ARTICAL_IN_CATEGORIES);
            articals.add(listArt);
        }
        for (ArticalCategories art : articalCategoriesList2) {
            //指定首页分类块中每块显示指定条记录
            List<Artical> listArt = articalService.queryArticalListByCategories(art.getId(), PubConstant.MAX_SHOW_ARTICAL_IN_CATEGORIES);
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
        List<OnlineTools> onlineToolsList = onlineToolsService.queryOnlineToolsListLimited(PubConstant.MAX_SHOW_TOOLS);
        model.addAttribute("onlineToolsList", onlineToolsList);

        //查询统计标签 最多显示指定条数
        List<String> tagsList = articalService.queryAllArticalTagsLimited(PubConstant.MAX_SHOW_ARTICALTAGS);
        model.addAttribute("tagsList", tagsList);

        //获取置顶文章
        Artical articalTop = new Artical();
        articalTop = articalService.queryArticalFirstByIntop(PubConstant.YES_NO_Y);
        model.addAttribute("articalTop", articalTop);






        PageHelper.startPage(1, 10);
        List<Artical> articalListHomePage = articalService.getAll();
        PageInfo<Artical> pageInfo = new PageInfo<Artical>(articalListHomePage);






        /*List<Artical> articalListHomePage = articalService.queryArticalListHomePage();*/
        model.addAttribute("articalListHomePage", articalListHomePage);
        model.addAttribute("pageInfo",pageInfo);
        return "index";

    }

    @RequestMapping(value = "categories")
    public String showCategories(HttpServletRequest request, Model model) {

        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        int categoriesId=0;
        String idStr = request.getParameter("id");
        if(idStr != null && !"null".equals(idStr)){
            try {
                categoriesId = Integer.parseInt(idStr);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(categoriesId != 0){
                ArticalCategories articalCategories = articalCategoriesService.queryArticalCategoriesDetailById(categoriesId);
                model.addAttribute("articalCategoryName","# "+articalCategories.getCategoryName());
            }else{
                model.addAttribute("articalCategoryName","# 全部分类");
            }
        }else{
            model.addAttribute("articalCategoryName","# 全部分类");
        }
        //分类信息
        List<ArticalCategories> categoriesList = articalCategoriesService.queryAllArticalCategories();
        Iterator categoriesIterator = categoriesList.iterator();
        List<Map> categoryInfosList = new ArrayList<>();
        while(categoriesIterator.hasNext()){
            Map map = new HashMap();
            ArticalCategories articalCategories = (ArticalCategories) categoriesIterator.next();
            map.put("categoryName",articalCategories.getCategoryName());
            map.put("categoryNum",articalCategories.getArticalCount());
            map.put("categoryId",articalCategories.getId());
            if(articalCategories.getId() == categoriesId){
                map.put("current","Y");
            }else{
                map.put("current","N");
            }
            categoryInfosList.add(map);
        }
        model.addAttribute("categoryInfos",categoryInfosList);


        //分页信息 文章信息
        Integer pageNum = null;
        String pageNumStr = request.getParameter("pageIndex");
        if(pageNumStr != null){
            pageNum = Integer.parseInt(pageNumStr);
        }
         
        System.out.println(pageNum);
        if(pageNum == null){
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, 10);
        List<Artical> articals = new ArrayList<>();
        if(categoriesId == 0){
            //查詢所有
            articals=articalService.getAll();
        }else{
            articals=articalService.getAllByCategoriesId(categoriesId);
        }
        //List<Artical> articals=articalService.getAll();
        PageInfo<Artical> pageInfo = new PageInfo<Artical>(articals);

        List<Map> articalList = new ArrayList<Map>();
        //将对象转换为map 并在map中添加新的属性
        Iterator articalIterator = articals.iterator();
        while(articalIterator.hasNext()){
            Map map = new HashMap();
            Artical artical = (Artical) articalIterator.next();
            map.put("id",artical.getId());
            map.put("tittle",artical.getTittle());
            map.put("categories",artical.getCategories());
            map.put("createDate",artical.getCreateDate());
            int caId = artical.getCategories();
            String categoriesName = articalCategoriesService.queryArticalCategoriesDetailById(caId).getCategoryName();
            map.put("categoriesName",categoriesName);
            articalList.add(map);
        }
        model.addAttribute("articals",articalList);
        model.addAttribute("pageInfo",pageInfo);

        return "categories";
    }
}
