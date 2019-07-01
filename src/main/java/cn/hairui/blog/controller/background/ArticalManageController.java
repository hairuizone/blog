package cn.hairui.blog.controller.background;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.*;
import com.alibaba.druid.support.json.JSONUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cn.hairui.blog.service.ArticalCategoriesService;
import cn.hairui.blog.service.ArticalService;
import cn.hairui.blog.service.ArticalTopicsService;
import cn.hairui.blog.service.MyInfoService;
import cn.hairui.blog.service.NavIndexService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/5 22:42
 */
@Controller
@RequestMapping("/manage")
public class ArticalManageController {

    @Autowired
    private ArticalService articalService;
    @Autowired
    private ArticalCategoriesService articalCategoriesService;
    @Autowired
    private NavIndexService navIndexService;
    @Autowired
    private ArticalTopicsService articalTopicsService;
    @Autowired
    private MyInfoService myInfoService;

    private String listPage = PubConstant.BACKGROUND_DIR_NAME + "artical-list";//列表页面
    private String addPage = PubConstant.BACKGROUND_DIR_NAME + "artical-add";//新增页面
    private String updatePage = PubConstant.BACKGROUND_DIR_NAME + "artical-update";//修改页面
    private String loginPage = PubConstant.BACKGROUND_DIR_NAME + "login";//修改页面

    private String markdownPage = PubConstant.BACKGROUND_DIR_NAME + "artical-markdown";

    @RequestMapping(value = "/artical-list", method = RequestMethod.GET)
    public String listArtical(HttpServletRequest request, Model model) {

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
        PageHelper.startPage(pageNum, 5);
        List<Artical> articals = articalService.queryArticalList();
        PageInfo<Artical> pageInfo = new PageInfo<Artical>(articals);


        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("articalList", articals);
        List<ArticalCategories> categoriesList = articalCategoriesService.queryArticalCategoriesList();
        model.addAttribute("categoriesList", categoriesList);
        return listPage;
    }

    @RequestMapping(value = "/artical-add", method = RequestMethod.GET)
    public String addArtical(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User domain = (User) session.getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (!PubConstant.YES_NO_Y.equals(domain.getAdminflag())) {
            System.out.println("权限不足 后期使用切面处理");
        }
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        List<ArticalCategories> acList = articalCategoriesService.queryArticalCategoriesList();
        model.addAttribute("acList", acList);

        List<NavIndex> navList = navIndexService.queryNavIndexList();
        model.addAttribute("navList", navList);

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String openday = df.format(date);
        model.addAttribute("OPENDAY", openday);

        List<ArticalTopics> topicList = articalTopicsService.qeuryArticalTopicsList();
        model.addAttribute("topicList", topicList);
        return addPage;
    }

    @RequestMapping(value = "/artical-adddata", method = RequestMethod.POST)
    public String addArticalDAta(@ModelAttribute Artical artical, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        //随机设置封面图
        int i = new Random().nextInt(19) + 1;//1-20随机图片
        String imgPath = i + ".jpg";
        System.out.println(imgPath);
        artical.setImgpath(imgPath);
        //初始化新增设置
        artical.setLikeNums(0);
        artical.setDissNums(0);
        artical.setUpdateDate(artical.getCreateDate());

        //获取最大值
        Integer max = articalService.getMaxArticalId();
        if (max == null) {
            max = 0;
        }
        int nextId = max + 1;
        artical.setId(nextId);

        Integer num = articalService.addArtical(artical);
        System.out.println(nextId);
        model.addAttribute("artical", artical);
        return markdownPage;
    }

    @RequestMapping(value = "/artical-update", method = RequestMethod.GET)
    public String updateArtical(Integer id, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        if (id == null) {
            return "404";
        }
        List<ArticalCategories> acList = articalCategoriesService.queryArticalCategoriesList();
        model.addAttribute("acList", acList);

        List<NavIndex> navList = navIndexService.queryNavIndexList();
        model.addAttribute("navList", navList);

        List<ArticalTopics> topicList = articalTopicsService.qeuryArticalTopicsList();
        model.addAttribute("topicList", topicList);

        Artical artical = articalService.queryArticalDetailById(id);
        model.addAttribute("artical", artical);
        System.out.println("update" + artical.getContent());
        return updatePage;
    }

    @RequestMapping(value = "/artical-updatedata", method = RequestMethod.POST)
    public String updateArticalData(@ModelAttribute Artical artical, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        System.out.println("updatedata" + artical.getContent());
        articalService.updateArtical(artical);
        model.addAttribute("artical", artical);
        return markdownPage;
    }

    @RequestMapping(value = "/artical-updatemarkdowndata", method = RequestMethod.POST)
    @ResponseBody
    public String updateArticalMarkDownData(@ModelAttribute Artical artical, Model model) {
        Map map = new HashMap();
        articalService.updateArticalMarkdown(artical);
        map.put(PubConstant.flag, PubConstant.success);
        return JSONUtils.toJSONString(map);
    }

    @RequestMapping(value = "/artical-delete", method = RequestMethod.POST)
    @ResponseBody
    public Map deleteArtical(String id, HttpServletRequest httpServletRequest) {
        Map map = new HashMap();
        try {
            int num = articalService.deleteArticalById(id);
            if (num == 1) {
                map.put(PubConstant.flag, PubConstant.success);
            } else {
                map.put(PubConstant.flag, PubConstant.failed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/articals_query_categorie", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String queryArticalsCountByArticalCategorie(int id, HttpServletRequest httpServletRequest) {
        Map map = new HashMap();
        int count = articalService.queryArticalsCountByArticalCategorie(id);

        if (count == 0) {
            map.put(PubConstant.flag, PubConstant.success);
        } else {
            map.put(PubConstant.flag, PubConstant.failed);
            map.put(PubConstant.message, "该分类下存在文章，不允许删除");
        }
        return JSONUtils.toJSONString(map);
    }



    private String editmdImgPath = "D:/upload/images/";

    @RequestMapping("/uploadimg")
       public @ResponseBody Map<String,Object> demo(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        System.out.println(request.getContextPath());
        String UPLOADED_FOLDER = editmdImgPath;
        String realPath = UPLOADED_FOLDER ;
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
/*        File targetFile = new File(realPath, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }*/
        //保存
        try {
            /*            file.transferTo(targetFile);*/
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            resultMap.put("url",UPLOADED_FOLDER+fileName);
        } catch (Exception e) {
            resultMap.put("success", 0);
            resultMap.put("message", "上传失败！");
            e.printStackTrace();
        }
        System.out.println(resultMap.get("success"));
        return resultMap;


    }
}
