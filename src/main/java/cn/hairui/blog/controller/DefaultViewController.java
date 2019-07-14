package cn.hairui.blog.controller;

import cn.hairui.blog.config.WebLog;
import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.MusicList;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.service.MyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author laoganbu
 * @date: 2019/2/25 17:37
 */
@Controller
public class DefaultViewController {

    @Autowired
    private MyInfoService myInfoService;


    @RequestMapping(value = "/index")
    public String foreIndexPage(){
        return "redirect:/";
    }
    @RequestMapping(value = "/permissions")
    @WebLog(description = "该用户操作权限不足")
    public String permissions(){
        return "404";
    }

    @ResponseBody
    @RequestMapping(value = "/getMyInfo", produces = {"application/json;charset=UTF-8"})
    public MyInfo getMyInfo() {
        return myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
    }

    @RequestMapping(value = "musicplayer")
    @WebLog(description = "欢迎访问音乐馆")
    public String musicplayer(String pid ,Model model) {
        if("".equals(pid) || pid == null){
            model.addAttribute("pid","-1");
        }else{
            model.addAttribute("pid",pid);
        }

        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        MusicList musicList = myInfoService.queryMusicListById(PubConstant.MY_INFO_ID);
        model.addAttribute("music",musicList);
        return "musicplayer";
    }

    @RequestMapping(value = "videoplayer")
    public String videoplayer(Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        return "videoplayer";
    }

    @RequestMapping(value = "transfer")
    public String transfer(Model model){
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        return "transfer";
    }

    @RequestMapping(value = "test")
    public String test(Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        return "test";
    }
}