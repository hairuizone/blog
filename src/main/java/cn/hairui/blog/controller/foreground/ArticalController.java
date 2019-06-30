package cn.hairui.blog.controller.foreground;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import cn.hairui.blog.constant.PubConstant;
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
    @Autowired
    private ArticalCategoriesService articalCategoriesService;


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
        model.addAttribute("artical", artical);
        return "articalviewer";
    }


    @RequestMapping(value = "/archives")
    public String showArchives(HttpServletRequest request, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        List<Map> archivesList = archivesList = articalService.queryArticalArchivesList();
        String dateStr = request.getParameter("date");

        Iterator archivesIterator = archivesList.iterator();
        List<Map> archivesnfosList = new ArrayList<>();
        while (archivesIterator.hasNext()) {
            Map map = new HashMap();
            Map archives = (Map) archivesIterator.next();
            String createdate = (String) archives.get("CREATEDATE");
            Long num = (Long) archives.get("NUM");

            map.put("createdate", createdate);
            map.put("createdateCn",createdate.replaceAll("-","年")+"月");
            map.put("num", num);
            if(dateStr != null && dateStr.equals(createdate)){
                map.put("current","Y");
            }else{
                map.put("current","N");
            }
            archivesnfosList.add(map);
        }

        model.addAttribute("archivesInfos", archivesnfosList);

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
        if (dateStr == null || "null".equals(dateStr)) {
            //查詢所有
            articals = articalService.queryArticalList();
        } else {
            articals = articalService.queryArticalsByCreateDateYm(dateStr);
        }

        PageInfo<Artical> pageInfo = new PageInfo<Artical>(articals);
        List<Map> articalList = new ArrayList<Map>();
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
        if(dateStr == null || "null".equals(dateStr)){
            model.addAttribute("archivesStatistic", "您一共发布了"+pageInfo.getTotal()+"篇文章");
        }else{
            model.addAttribute("archivesStatistic", "您在"+dateStr.replaceAll("-","年")+"月，一共发布了"+pageInfo.getTotal()+"篇文章");
        }
        return "archives";
    }
}
