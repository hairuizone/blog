package cn.hairui.blog.controller;

import cn.hairui.blog.model.Artical;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.model.NavIndex;
import cn.hairui.blog.service.ArticalService;
import cn.hairui.blog.service.MyInfoService;
import cn.hairui.blog.service.NavIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/2/25 17:37
 */
@Controller
public class DefaultViewController {


    @Autowired
    private MyInfoService myInfoService;
    @Autowired
    private NavIndexService navIndexService;

    @Autowired
    private ArticalService articalService;

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String indexPage(Model model){

        MyInfo myInfo = myInfoService.findMyInfoById(1);
        model.addAttribute("myinfo",myInfo);

        List<NavIndex> navIndexList = navIndexService.queryNavIndexList();

        List<Artical> articalList1 = articalService.queryArticalListByNavId(1);
        List<Artical> articalList2 = articalService.queryArticalListByNavId(2);
        List<Artical> articalList3 = articalService.queryArticalListByNavId(3);
        List<Artical> articalList4 = articalService.queryArticalListByNavId(4);
        List<Artical> articalList5 = articalService.queryArticalListByNavId(5);



        model.addAttribute("navIndexList",navIndexList);
        model.addAttribute("articalList1",articalList1);
        model.addAttribute("articalList2",articalList2);
        model.addAttribute("articalList3",articalList3);
        model.addAttribute("articalList4",articalList4);
        model.addAttribute("articalList5",articalList5);
        return "index";
    }

    @RequestMapping(value = "/index2" ,method = RequestMethod.GET)
    public String index2Page(){
        return "index2";
    }

}
