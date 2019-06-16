package cn.hairui.blog.controller;

import cn.hairui.blog.model.OnlineTools;
import cn.hairui.blog.service.OnlineToolsService;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/27 21:48
 */
@Controller
public class OnlineToolsController {

    @Autowired
    private OnlineToolsService onlineToolsService;

    @RequestMapping(value = "/manage/tools-list")
    public String listOnlineTools(Model model){
        List<OnlineTools> onlineToolsList = onlineToolsService.queryOnlineToolsList();
        model.addAttribute("toolsList",onlineToolsList);
        return "background/tools-list";
    }
    @RequestMapping(value = "/manage/tools-add")
    public String addOnlineTools(){
        return "background/tools-add";
    }

    @RequestMapping(value = "/manage/tools-adddata",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String addArticalCategoriesData(@ModelAttribute OnlineTools onlineTools){
        Map map = new HashMap();
        //插入之前查询是否已经存在
        int count = onlineToolsService.qeuryOnlineToolsByName(onlineTools.getToolName());
        if(count > 0){
            map.put("flag","error");
            map.put("message","该名称的在线工具已经存在");
        }else{

            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String openday = df.format(date);

            onlineTools.setAddDate(openday);
            int id = onlineToolsService.addOnlineTools(onlineTools);
            map.put("flag","success");
        }
        return JSONUtils.toJSONString(map);
    }
    @RequestMapping(value = "/manage/tools-update")
    public String updateOnlineTools(int id,Model model){

        OnlineTools onlineTools = onlineToolsService.queryOnlineToolsById(id);
        model.addAttribute("onlineTools",onlineTools);
        return "background/tools-update";
    }

    @RequestMapping(value = "/manage/tools-updatedata",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String updateOnlineToolsData(@ModelAttribute OnlineTools onlineTools){
        Map map = new HashMap();
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String openday = df.format(date);
        onlineTools.setAddDate(openday);
        int id = onlineToolsService.updateOnlineTools(onlineTools);
        map.put("flag","success");
        return JSONUtils.toJSONString(map);
    }

    @RequestMapping(value = "/manage/tools-delete",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String deleteOnlineToolsData(String id){
        Map map = new HashMap();
        try {
            int num = onlineToolsService.deleteOnlineToolsById(id);
            map.put("flag","success");
        }catch (Exception e){
            e.printStackTrace();
            map.put("flag","failed");
        }

        return JSONUtils.toJSONString(map);
    }


}
