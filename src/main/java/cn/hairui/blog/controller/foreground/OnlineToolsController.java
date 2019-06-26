package cn.hairui.blog.controller.foreground;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.model.OnlineTools;
import cn.hairui.blog.service.MyInfoService;
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
    private MyInfoService myInfoService;
    @Autowired
    private  OnlineToolsService onlineToolsService;
    @RequestMapping(value = "/tools")
    public String tools(Model model){
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        List<OnlineTools> toolsList = onlineToolsService.queryOnlineToolsList();
        model.addAttribute("tools",toolsList);
        return "tools";
    }

}
