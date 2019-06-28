package cn.hairui.blog.controller.background;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.Artical;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.model.OnlineTools;
import cn.hairui.blog.service.MyInfoService;
import cn.hairui.blog.service.OnlineToolsService;
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
@RequestMapping("/manage")
public class OnlineToolsManageController {

    @Autowired
    private OnlineToolsService onlineToolsService;
    @Autowired
    private MyInfoService myInfoService;
    private String listPage = PubConstant.BACKGROUND_DIR_NAME + "tools-list";//列表页面
    private String addPage = PubConstant.BACKGROUND_DIR_NAME + "tools-add";//新增页面
    private String updatePage = PubConstant.BACKGROUND_DIR_NAME + "tools-update";//修改页面

    @RequestMapping(value = "/tools-list")
    public String listOnlineTools(HttpServletRequest request,Model model) {
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
        List<OnlineTools> onlineToolsList = onlineToolsService.queryOnlineToolsList();
        PageInfo<OnlineTools> pageInfo = new PageInfo<OnlineTools>(onlineToolsList);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("toolsList", onlineToolsList);
        return listPage;
    }

    @RequestMapping(value = "/tools-add")
    public String addOnlineTools(Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(1);
        model.addAttribute("myinfo", myInfo);
        return addPage;
    }

    @RequestMapping(value = "/tools-adddata", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String addArticalCategoriesData(@ModelAttribute OnlineTools onlineTools) {
        Map map = new HashMap();
        //插入之前查询是否已经存在
        int count = onlineToolsService.qeuryOnlineToolsByName(onlineTools.getToolName());
        if (count > 0) {
            map.put(PubConstant.flag, "error");
            map.put(PubConstant.message, "该名称的在线工具已经存在");
        } else {

            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String openday = df.format(date);

            onlineTools.setAddDate(openday);
            int id = onlineToolsService.addOnlineTools(onlineTools);
            map.put(PubConstant.flag, PubConstant.success);
        }
        return JSONUtils.toJSONString(map);
    }

    @RequestMapping(value = "/tools-update")
    public String updateOnlineTools(int id, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(1);
        model.addAttribute("myinfo", myInfo);

        OnlineTools onlineTools = onlineToolsService.queryOnlineToolsById(id);
        model.addAttribute("onlineTools", onlineTools);
        return updatePage;
    }

    @RequestMapping(value = "/tools-updatedata", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String updateOnlineToolsData(@ModelAttribute OnlineTools onlineTools) {
        Map map = new HashMap();
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String openday = df.format(date);
        onlineTools.setAddDate(openday);
        int id = onlineToolsService.updateOnlineTools(onlineTools);
        map.put(PubConstant.flag, PubConstant.success);
        return JSONUtils.toJSONString(map);
    }

    @RequestMapping(value = "/tools-delete", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String deleteOnlineToolsData(String id) {
        Map map = new HashMap();
        try {
            int num = onlineToolsService.deleteOnlineToolsById(id);
            map.put(PubConstant.flag, PubConstant.success);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(PubConstant.flag, PubConstant.failed);
        }
        return JSONUtils.toJSONString(map);
    }

}
