package cn.hairui.blog.controller.background;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.GalleryImg;
import cn.hairui.blog.model.Gallerys;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.service.GallerysService;
import cn.hairui.blog.service.MyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/7/5 22:40
 */
@Controller
@RequestMapping("/manage")
public class GallerysManageController {
    @Autowired
    private MyInfoService myInfoService;

    @Autowired
    private GallerysService gallerysService;
    private String listPage = PubConstant.BACKGROUND_DIR_NAME + "gallerys-list";//列表页面
    private String addPage = PubConstant.BACKGROUND_DIR_NAME + "gallerys-add";//新增相册页面
    private String updatePage = PubConstant.BACKGROUND_DIR_NAME + "gallerys-update";//新增相册页面

    @RequestMapping(value = "/gallerys-list")
    public String queryGallserysList(Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        List<Gallerys> gallerysList = gallerysService.queryGallerysList();
        System.out.println(gallerysList.toString());
        model.addAttribute("gallerysList", gallerysList);

        return listPage;
    }


    @RequestMapping(value = "/gallerys-add")
    public String addGallerys(Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        return addPage;
    }

    @Value("${upload_path}")
    private String uploadPath;

    @Value("${virtual_upload_path}")
    private String virtualUploadPath;

    @RequestMapping(value = "/gallerys-adddata")
    @ResponseBody
    @Transactional
    public Map addGalleryData(HttpServletRequest request, String name, String creator, String showFlag, String introduction, Model model) {
        Map map = new HashMap();
        Gallerys gallerys = new Gallerys();
        gallerys.setName(name);
        gallerys.setCreator(creator);
        gallerys.setShowFlag(showFlag);
        gallerys.setIntroduction(introduction);
        gallerys.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> filelist = multipartRequest.getFiles("showImgFile");
        String fileName = "";
        MultipartFile file = null;
        if (filelist.size() > 0 && !filelist.get(0).isEmpty()) {
            file = (MultipartFile) filelist.get(0);
            fileName = filelist.get(0).getOriginalFilename();
            gallerys.setShowImg(fileName);

        }
        ////文件上传 对象提交插入数据库
        File targetPath = new File(uploadPath);
        if (!targetPath.exists()) {
            targetPath.mkdirs();
        }
        //保存
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadPath + PubConstant.GALLERS_DIR + fileName);
            Files.write(path, bytes);
            gallerysService.addGallery(gallerys);//创建相册
            //构造相册内容中添加一张默认照片
            Integer galleryId = gallerys.getId();
            GalleryImg galleryImg = new GalleryImg();
            galleryImg.setImgPath(fileName);
            galleryImg.setGalleryId(galleryId);

            int i = gallerysService.addGalleryImg(galleryImg);

            System.out.println("zhujian " + gallerys.getId());
            System.out.println("success");
            map.put(PubConstant.flag, PubConstant.success);
        } catch (Exception e) {
            map.put(PubConstant.flag, PubConstant.failed);
            System.out.println("error");
            e.printStackTrace();
        }


        System.out.println(gallerys.toString());
        return map;
    }

    @RequestMapping(value = "gallerys-update")
    public String updateGallerys(HttpServletRequest request, Integer id, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        Gallerys gallerys = gallerysService.queryGallerysById(id);
        model.addAttribute("gallerys", gallerys);
        return updatePage;
    }

    @RequestMapping(value = "gallerys-updatedata")
    @ResponseBody
    public Map updateGallerysData(HttpServletRequest request, Integer id, String name, String showFlag, String introduction, Model model) {
        Map map = new HashMap();
        Gallerys gallerys = new Gallerys();
        gallerys.setId(id);
        gallerys.setName(name);
        gallerys.setShowFlag(showFlag);
        gallerys.setIntroduction(introduction);

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> filelist = multipartRequest.getFiles("showImgFile");
        String fileName = "";
        MultipartFile file = null;
        if (filelist.size() > 0 && !filelist.get(0).isEmpty()) {
            System.out.println("封面图发生了变化");
            file = (MultipartFile) filelist.get(0);
            fileName = filelist.get(0).getOriginalFilename();
            File targetPath = new File(uploadPath);
            if (!targetPath.exists()) {
                targetPath.mkdirs();
            }
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(uploadPath + PubConstant.GALLERS_DIR + fileName);
                Files.write(path, bytes);

                //构造相册内容中添加一张默认照片
                Integer galleryId = gallerys.getId();
                GalleryImg galleryImg = new GalleryImg();
                galleryImg.setImgPath(fileName);
                galleryImg.setGalleryId(galleryId);

                int i = gallerysService.addGalleryImg(galleryImg);

            }catch (IOException e){
                e.printStackTrace();
            }
            gallerys.setShowImg(fileName);

        }else{
            System.out.println("封面图未发生变化");
            gallerys.setShowImg(gallerysService.queryGallerysById(id).getShowImg());
        }

        //保存
        try {

            gallerysService.updateGallerys(gallerys);//创建相册
            System.out.println("zhujian " + gallerys.getId());
            System.out.println("success");
            map.put(PubConstant.flag, PubConstant.success);
        } catch (Exception e) {
            map.put(PubConstant.flag, PubConstant.failed);
            System.out.println("error");
            e.printStackTrace();
        }
        System.out.println(gallerys.toString());
        //gallerysService.updateGallerys(gallerys);

        map.put(PubConstant.flag, PubConstant.success);
        return map;
    }

    @RequestMapping(value = "upload_galleryimg")
    public String uploadGalleryImg(Model model){
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        return "gallerys-upload";
    }
}
