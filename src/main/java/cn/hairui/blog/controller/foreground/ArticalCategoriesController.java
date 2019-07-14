package cn.hairui.blog.controller.foreground;

import cn.hairui.blog.config.WebLog;
import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.Artical;
import cn.hairui.blog.model.ArticalCategories;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.service.ArticalCategoriesService;
import cn.hairui.blog.service.ArticalService;
import cn.hairui.blog.service.MyInfoService;
import com.alibaba.druid.support.json.JSONUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/27 20:22
 */
@Controller
public class ArticalCategoriesController {

    @Autowired
    private MyInfoService myInfoService;

    @Autowired
    private ArticalCategoriesService articalCategoriesService;

    @Autowired
    private ArticalService articalService;

    @RequestMapping(value = "/categories")
    @WebLog(description = "查看文章分类")
    public String showCategories(HttpServletRequest request, Model model) {

        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        Integer categoriesId = 0;
        String idStr = request.getParameter("id");
        if (idStr != null && !"null".equals(idStr)) {
            try {
                categoriesId = Integer.parseInt(idStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (categoriesId != 0) {
                ArticalCategories articalCategories = articalCategoriesService.queryArticalCategoriesDetailById(categoriesId);
                model.addAttribute("articalCategoryName", "# " + articalCategories.getCategoryName());
            } else {
                model.addAttribute("articalCategoryName", "# 全部分类");
            }
        } else {
            model.addAttribute("articalCategoryName", "# 全部分类");
        }
        //分类信息

        List<Map> categoriesList = articalCategoriesService.queryArticalCategoriesStatisticList();
        Iterator categoriesIterator = categoriesList.iterator();
        List<Map> categoryInfosList = new ArrayList<>();
        while (categoriesIterator.hasNext()) {
            Map map = new HashMap();
            Map articalCategories = (Map) categoriesIterator.next();
            map.put("categoryName", articalCategories.get("categoryName"));
            map.put("categoryNum", articalCategories.get("categoryNum"));
            map.put("categoryId", articalCategories.get("categoryId"));
            if (articalCategories.get("categoryId") == categoriesId) {
                map.put("current", "Y");
            } else {
                map.put("current", "N");
            }
            categoryInfosList.add(map);
        }
        model.addAttribute("categoryInfos", categoryInfosList);


        /*List<ArticalCategories> categoriesList = articalCategoriesService.queryArticalCategoriesList();
        Iterator categoriesIterator = categoriesList.iterator();
        List<Map> categoryInfosList = new ArrayList<>();
        while (categoriesIterator.hasNext()) {
            Map map = new HashMap();
            ArticalCategories articalCategories = (ArticalCategories) categoriesIterator.next();
            map.put("categoryName", articalCategories.getCategoryName());
            map.put("categoryNum", articalCategories.getArticalCount());
            map.put("categoryId", articalCategories.getId());
            if (articalCategories.getId() == categoriesId) {
                map.put("current", "Y");
            } else {
                map.put("current", "N");
            }
            categoryInfosList.add(map);
        }
        model.addAttribute("categoryInfos", categoryInfosList);*/


        //分页信息 文章信息
        Integer pageNum = null;
        String pageNumStr = request.getParameter("pageIndex");
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, 10);
        List<Artical> articals = new ArrayList<>();
        if (categoriesId == 0 || categoriesId == null) {
            //查詢所有
            articals = articalService.queryArticalList();
        } else {
            articals = articalService.queryArticalsByCategoriesId(categoriesId);
        }
        //List<Artical> articals=articalService.getAll();
        PageInfo<Artical> pageInfo = new PageInfo<Artical>(articals);

        List<Map> articalList = new ArrayList<Map>();
        //将对象转换为map 并在map中添加新的属性
        Iterator articalIterator = articals.iterator();
        while (articalIterator.hasNext()) {
            Map map = new HashMap();
            Artical artical = (Artical) articalIterator.next();
            map.put("id", artical.getId());
            map.put("tittle", artical.getTittle());
            map.put("categories", artical.getCategories());
            map.put("createDate", artical.getCreateDate());
            int caId = artical.getCategories();
            String categoriesName = articalCategoriesService.queryArticalCategoriesDetailById(caId).getCategoryName();
            map.put("categoriesName", categoriesName);
            articalList.add(map);
        }
        model.addAttribute("articals", articalList);
        model.addAttribute("pageInfo", pageInfo);
        return "categories";
    }
}
