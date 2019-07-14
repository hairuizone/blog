package cn.hairui.blog.controller.foreground;

import cn.hairui.blog.config.WebLog;
import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.Artical;
import cn.hairui.blog.model.ArticalTopics;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.service.ArticalCategoriesService;
import cn.hairui.blog.service.ArticalService;
import cn.hairui.blog.service.ArticalTopicsService;
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
 * @date: 2019/3/27 21:23
 */
@Controller
public class ArticalTopicsController {

    @Autowired
    private MyInfoService myInfoService;

    @Autowired
    private ArticalService articalService;
    @Autowired
    private ArticalCategoriesService articalCategoriesService;
    @Autowired
    private ArticalTopicsService articalTopicsService;

    @RequestMapping(value = "/topics")
    @WebLog(description = "查看专题文章")
    public String showTopics(HttpServletRequest request, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        List<Map> topicsList = articalService.queryArticalTopicsList();
        String idStr = request.getParameter("id");
        Integer id = 0;
        if (idStr != null && !"null".equals(idStr)) {
            try {
                id = Integer.parseInt(idStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Iterator topicsIterator = topicsList.iterator();
        List<Map> topicInfosList = new ArrayList<>();
        while (topicsIterator.hasNext()) {
            Map map = new HashMap();
            Map topics = (Map) topicsIterator.next();
            map.put("topicName", topics.get("topicName"));
            map.put("topicNum", topics.get("topicNum"));
            map.put("topicId", topics.get("topicId"));
            if (topics.get("topicId") == id) {
                map.put("current", "Y");
            } else {
                map.put("current", "N");
            }
            topicInfosList.add(map);
        }
        model.addAttribute("topicInfos", topicInfosList);



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
        if (idStr == null || "null".equals(idStr)) {
            //查詢所有
            articals = articalService.queryArticalInTopicList();
        } else {
            articals = articalService.queryArticalsByTopicId(id);
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
        if(idStr == null || "null".equals(idStr)){
            model.addAttribute("archivesStatistic", "所有专题下一共发布了"+pageInfo.getTotal()+"篇文章");
        }else{
            String topicName = articalTopicsService.queryArticalTopicsDetailById(id).getTopicName();
            model.addAttribute("archivesStatistic", "“"+topicName+"”专题下，一共发布了"+pageInfo.getTotal()+"篇文章");
        }




        return "topics";
    }
}
