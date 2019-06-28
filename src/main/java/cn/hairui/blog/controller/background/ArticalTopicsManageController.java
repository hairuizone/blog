package cn.hairui.blog.controller.background;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.Artical;
import cn.hairui.blog.model.ArticalTopics;
import cn.hairui.blog.model.MyInfo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/27 21:23
 */
@Controller
@RequestMapping("/manage")
public class ArticalTopicsManageController {

    @Autowired
    private ArticalTopicsService articalTopicsService;
    @Autowired
    private ArticalService articalService;
    @Autowired
    private MyInfoService myInfoService;

    private String listPage = PubConstant.BACKGROUND_DIR_NAME + "topic-list";//列表页面
    private String addPage = PubConstant.BACKGROUND_DIR_NAME + "topic-add";//新增页面
    private String updatePage = PubConstant.BACKGROUND_DIR_NAME + "topic-update";//修改页面


    @RequestMapping(value = "/topic-list")
    public String listArticalTopics(HttpServletRequest request,Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(1);
        model.addAttribute("myinfo", myInfo);

        Integer pageNum = null;
        String pageNumStr = request.getParameter("pageIndex");
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, 5);
        List<ArticalTopics> articalTopicsList = articalTopicsService.qeuryArticalTopicsList();
        PageInfo<ArticalTopics> pageInfo = new PageInfo<ArticalTopics>(articalTopicsList);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("topicList", articalTopicsList);
        return listPage;
    }

    @RequestMapping(value = "/topic-add")
    public String addArticalTopics(Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(1);
        model.addAttribute("myinfo", myInfo);
        return addPage;
    }

    @RequestMapping(value = "/topic-adddata", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String addArticalTopics(@ModelAttribute ArticalTopics articalTopics) {
        Map map = new HashMap();
        //插入之前查询分类名称是否已经存在
        int count = articalTopicsService.qeuryArticalTopicsByName(articalTopics.getTopicName());
        if (count > 0) {
            map.put(PubConstant.flag, PubConstant.failed);
            map.put(PubConstant.message, "专题名称重复");
        } else {

            //新增专题默认文章数量为0
            articalTopics.setArticalCount(0);
            int id = articalTopicsService.addArticalTopics(articalTopics);
            map.put(PubConstant.flag, PubConstant.success);
        }
        return JSONUtils.toJSONString(map);
    }

    @RequestMapping(value = "/topic-update")
    public String updateArticalTopics(int id, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(1);
        model.addAttribute("myinfo", myInfo);
        ArticalTopics articalTopics = articalTopicsService.queryArticalTopicsDetailById(id);
        model.addAttribute("articalTopics", articalTopics);
        return updatePage;
    }

    @RequestMapping(value = "/topic-updatedata", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String updateArticalTopicsData(@ModelAttribute ArticalTopics articalTopics) {
        Map map = new HashMap();
        try {
            int id = articalTopicsService.updateArticalTopicsData(articalTopics);
            map.put(PubConstant.flag, PubConstant.success);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(PubConstant.flag, PubConstant.failed);
        }
        return JSONUtils.toJSONString(map);
    }

    @RequestMapping(value = "/topic-delete", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String deleteArticalTopics(int id) {
        Map map = new HashMap();
        try {
            int num = articalTopicsService.deleteArticalTopics(id);
            if (num == 1) {
                //级联清空文章对应的专题编号
                int articalNum = articalService.cleanArticalTopics(id);
            }
            map.put(PubConstant.flag, PubConstant.success);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(PubConstant.flag, PubConstant.failed);
        }
        return JSONUtils.toJSONString(map);
    }
}
