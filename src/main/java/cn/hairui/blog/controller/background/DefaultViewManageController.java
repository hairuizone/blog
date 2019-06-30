package cn.hairui.blog.controller.background;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.model.OnlineTools;
import cn.hairui.blog.service.MyInfoService;
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
import java.util.Map;

/**
 * <p>
 * <h2>请添加说明
 * </h2>
 * <ol>请添加详细说明
 * </ol>
 *
 * <h2>修改历史
 * </h2>
 * <ol>如有修改，请添加修改历史
 * </ol>
 *
 * </p>
 *
 * @author laoganbu
 * @version V1.0
 * @date 2019/6/27 13:50
 */
@Controller
@RequestMapping(value = "/manage")
public class DefaultViewManageController {

    @Autowired
    private MyInfoService myInfoService;
    @RequestMapping(value = "/index")
    public String backgroundHomePage(Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        return "background/index";
    }

    @RequestMapping(value = "/calendar", method = RequestMethod.GET)
    public String calendar() {
        return "background/calendar";
    }



    @RequestMapping(value = "/setting")
    public String setting(Model model){
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        return "background/setting";
    }


    @RequestMapping(value = "/myinfo-updatedata", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String updateOnlineToolsData(@ModelAttribute MyInfo myInfo) {
        System.out.println(myInfo.toString());
        Map map = new HashMap();
        int id = myInfoService.updateMyInfo(myInfo);
        map.put(PubConstant.flag, PubConstant.success);
        return JSONUtils.toJSONString(map);
    }

}
