package cn.hairui.blog.controller;

import cn.hairui.blog.model.ArticalTopics;
import cn.hairui.blog.service.ArticalService;
import cn.hairui.blog.service.ArticalTopicsService;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/27 21:23
 */
@Controller
public class ArticalTopicsController {

    @Autowired
    private ArticalTopicsService articalTopicsService;
    @Autowired
    private ArticalService articalService;

    @RequestMapping(value = "/manage/topic-list")
    public String listArticalTopics(Model model) {
        List<ArticalTopics> articalTopicsList = articalTopicsService.qeuryArticalTopicsList();
        model.addAttribute("topicList", articalTopicsList);
        return "background/topic-list";
    }
    @RequestMapping(value = "/manage/topic-add")
    public String addArticalTopics(Model model) {

        return "background/topic-add";
    }


    @RequestMapping(value = "/manage/topic-adddata",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String addArticalTopics(@ModelAttribute ArticalTopics articalTopics){
        Map map = new HashMap();
        //插入之前查询分类名称是否已经存在
        int count = articalTopicsService.qeuryArticalTopicsByName(articalTopics.getTopicName());
        if(count > 0){
            map.put("flag","error");
            map.put("message","专题名称重复");
        }else{

            //新增专题默认文章数量为0
            articalTopics.setArticalCount(0);
            int id = articalTopicsService.addArticalTopics(articalTopics);
            map.put("flag","success");
        }
        return JSONUtils.toJSONString(map);
    }

    @RequestMapping(value = "/manage/topic-update")
    public String updateArticalTopics(int id,Model model){
        ArticalTopics articalTopics = articalTopicsService.queryArticalTopicsDetailById(id);
        model.addAttribute("articalTopics", articalTopics);
        return "background/topic-update";
    }

    @RequestMapping(value = "/manage/topic-updatedata",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String updateArticalTopicsData(@ModelAttribute ArticalTopics articalTopics){
        Map map = new HashMap();
        try {
            int id = articalTopicsService.updateArticalTopicsData(articalTopics);
            map.put("flag","success");
        }catch (Exception e){
            e.printStackTrace();
            map.put("flag","failed");
        }

        return JSONUtils.toJSONString(map);
    }

    @RequestMapping(value = "/manage/topic-delete",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String deleteArticalTopics(int id){
        Map map = new HashMap();
        try {
            int num = articalTopicsService.deleteArticalTopics(id);
            if(num == 1){
                //级联清空文章对应的专题编号
                int articalNum = articalService.cleanArticalTopics(id);
            }
            map.put("flag","success");
        }catch (Exception e){
            e.printStackTrace();
            map.put("flag","failed");
        }

        return JSONUtils.toJSONString(map);
    }


}
