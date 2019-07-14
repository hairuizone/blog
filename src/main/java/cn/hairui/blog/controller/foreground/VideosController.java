package cn.hairui.blog.controller.foreground;

import cn.hairui.blog.config.WebLog;
import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.model.User;
import cn.hairui.blog.model.Videos;
import cn.hairui.blog.service.MyInfoService;
import cn.hairui.blog.service.VideosService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/7/11 23:48
 */
@Controller

public class VideosController {

    @Autowired
    private MyInfoService myInfoService;
    @Autowired
    private VideosService videosService;

    @RequestMapping(value = "/videos")
    @WebLog(description = "查看视频")
    public String videosShow(HttpServletRequest request, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        Integer pageNum = null;
        String pageNumStr = request.getParameter("pageIndex");
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, 18);

        List<Videos> videosList = null;
        User userinfo = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (userinfo == null || !PubConstant.YES_NO_Y.equals(userinfo.getAdminflag())) {
            //普通用户或者游客   只展示公开视频
            videosList = videosService.queryVideosShowList();
        } else if (PubConstant.YES_NO_Y.equals(userinfo.getAdminflag()) && !PubConstant.YES_NO_Y.equals(userinfo.getSuperUser())) {
            //管理人员 但不是超级用户
            videosList = videosService.queryVideosListByOwnerAndShow(userinfo.getUsername());
        } else if (PubConstant.YES_NO_Y.equals(userinfo.getAdminflag()) && PubConstant.YES_NO_Y.equals(userinfo.getSuperUser())) {
            //超级用户
            videosList = videosService.queryVideosList();
        }
        int vcount  = videosService.queryVideosCount();
        PageInfo<Videos> pageInfo = new PageInfo<Videos>(videosList);
        model.addAttribute("videosList", videosList);
        model.addAttribute("vcount", "共"+vcount+"个");
        model.addAttribute("pageInfo", pageInfo);
        return "videos";
    }

    @RequestMapping(value = "videoplay")
    public String videoPlay(HttpServletRequest request, Integer id, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        try {
            Videos video = videosService.queryVideosById(id);
            if(video != null){
                model.addAttribute("video",video);
            }else{
                //重新组装视频不存在错误提示
                video = new Videos();
                System.out.println("视频不存在");
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        return "videoplayer";
    }
}
