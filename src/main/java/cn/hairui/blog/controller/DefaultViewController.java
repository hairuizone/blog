package cn.hairui.blog.controller;

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

    @ResponseBody
    @RequestMapping(value = "/getMyInfo", produces = {"application/json;charset=UTF-8"})
    public MyInfo getMyInfo() {
        return myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
    }

    @RequestMapping(value = "musicplayer")
    public String musicplayer(Model model) {
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
    public String test() {
        return "test";
    }
}