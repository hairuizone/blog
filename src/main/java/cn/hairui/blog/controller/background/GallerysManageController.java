package cn.hairui.blog.controller.background;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.GalleryImg;
import cn.hairui.blog.model.Gallerys;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.model.User;
import cn.hairui.blog.service.GallerysService;
import cn.hairui.blog.service.MyInfoService;
import cn.hairui.blog.util.FileUtil;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private String uploadPage = PubConstant.BACKGROUND_DIR_NAME + "gallerys-upload";//上传图片页面

    @RequestMapping(value = "/gallerys-list")
    public String queryGallserysList(HttpServletRequest request, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        List<Gallerys> gallerysList = null;
        //获取登录用户信息
        User user = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (PubConstant.YES_NO_Y.equals(user.getSuperUser())) {
            //超级权限可以访问所有
            gallerysList = gallerysService.queryGallerysList();
        } else if (PubConstant.YES_NO_Y.equals(user.getAdminflag())) {
            //后台管理用户
            gallerysList = gallerysService.queryGallerysListByOwner(user.getUsername());
        } else {
            //非法用户 你想干什么
        }

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
        //废弃前台获取creator 从登录信息中获取
        User user = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        gallerys.setCreator(user.getUsername());
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

            System.out.println("success");
            map.put(PubConstant.flag, PubConstant.success);
        } catch (Exception e) {
            map.put(PubConstant.flag, PubConstant.failed);
            System.out.println("error");
            e.printStackTrace();
        }

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

            } catch (IOException e) {
                e.printStackTrace();
            }
            gallerys.setShowImg(fileName);

        } else {
            System.out.println("封面图未发生变化");
            gallerys.setShowImg(gallerysService.queryGallerysById(id).getShowImg());
        }

        //保存
        try {
            gallerysService.updateGallerys(gallerys);//创建相册
            map.put(PubConstant.flag, PubConstant.success);
        } catch (Exception e) {
            map.put(PubConstant.flag, PubConstant.failed);
            e.printStackTrace();
        }
        map.put(PubConstant.flag, PubConstant.success);
        return map;
    }

    @RequestMapping(value = "gallerys-delete")
    @ResponseBody
    public Map deleteGallerys(Integer id, Model model) {
        Map map = new HashMap();
        int count = gallerysService.queryGalleryImgCountByGalleryId(id);
        if (count <= 1) {
            //没有照片或者只有一张封面图
            gallerysService.deleteGallerysById(id);
            map.put(PubConstant.flag, PubConstant.success);
        } else {
            map.put(PubConstant.flag, PubConstant.failed);
            map.put(PubConstant.message, "该相册下面存在未被删除的图片，无法删除");
        }
        return map;
    }

    @RequestMapping(value = "upload_gallerys")
    public String uploadGalleryImg(HttpServletRequest request, Integer id, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        //获取相册信息
        Gallerys gallerys = gallerysService.queryGallerysById(id);
        User user = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (PubConstant.YES_NO_Y.equals(user.getSuperUser())) {

        } else if (PubConstant.YES_NO_Y.equals(user.getAdminflag())) {
            //管理用户 确认该相册是否归属其管理
            if (!user.getUsername().equals(gallerys.getCreator().trim())) {
                gallerys = null;
            }
        } else {
            //盗链用户 胆子肥的很
            gallerys = null;
        }
        model.addAttribute("gallerys", gallerys);
        if (gallerys != null) {
            Integer imgcount = gallerysService.queryGalleryImgCountByGalleryId(gallerys.getId());
            model.addAttribute("imgcount", imgcount);
            //通过id获取相册信息
            List<GalleryImg> galleryImgList = gallerysService.queryGalleryImgList(id);
            model.addAttribute("galleryImgs", galleryImgList);
        } else {
            model.addAttribute("galleryImgs", null);
        }
        return uploadPage;
    }

    @RequestMapping(value = "galleryimg-delete")
    @ResponseBody
    @Transactional
    public Map deleteGalleryImg(Integer id, Model model) {
        Map map = new HashMap();
        try {
            //防止图片上传多次，查询数据库中存在其他相册下有该照片信息
            GalleryImg galleryImg = gallerysService.queryGalleryImgById(id);
            String imgPath = galleryImg.getImgPath();

            GalleryImg galleryImg1 = gallerysService.queryGalleryImgByImgPathExceptId(id, imgPath);

            if (galleryImg1 == null) {
                //不存在重名的 可以删除文件
                String path = uploadPath + PubConstant.GALLERS_DIR + imgPath;
                System.out.println(path);
                FileUtil.deleteSingleFile(path);
            }

            //删除数据库记录
            int i = gallerysService.deleteGalleryImgById(id);

            Integer galleryId = galleryImg.getGalleryId();
            int galleryImgCount = gallerysService.queryGalleryImgCountByGalleryId(galleryId);
            if (galleryImgCount == 0) {
                int m = gallerysService.deleteGallerysById(galleryId);
                map.put("clear", "Y");//设置情况标识
            } else {
                Gallerys gallerys = gallerysService.queryGallerysById(galleryId);

                //判断删除的是否为封面图
                if (gallerys != null && galleryImg1 == null && gallerys.getShowImg().equals(imgPath)) {
                    //将 galleryId 对应的相册的封面图设置为下一站图片
                    GalleryImg galleryImg2 = gallerysService.queryGalleryImgByGalleryIdFirst(galleryId);
                    if (galleryImg2 != null) {
                        String newImg = galleryImg2.getImgPath();
                        int x = gallerysService.setShowImgByGalleryId(galleryId, newImg);
                    }
                }
                map.put("clear", "N");
            }
            map.put(PubConstant.flag, PubConstant.success);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(PubConstant.flag, PubConstant.failed);
        }
        return map;
    }


    @RequestMapping(value = "gallery-upload")
    public String addGalleryImg(HttpServletRequest request, Integer gallery_id, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        Gallerys gallerys = gallerysService.queryGallerysById(gallery_id);

        User user = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (PubConstant.YES_NO_Y.equals(user.getSuperUser())) {

        } else if (PubConstant.YES_NO_Y.equals(user.getAdminflag())) {
            if (!user.getUsername().equals(gallerys.getCreator().trim())) {
                gallerys = null;
            }
        } else {
            gallerys = null;
        }

        model.addAttribute("gallerys", gallerys);
        return "background/gallery-upload";
    }

    public static void main(String[] args) {
        String a = "{}";

        String[] aa = a.split("\\,\\{");
        System.out.println(aa.length);
        for (String i : aa) {
            if (!i.startsWith("{")) {
                i = "{" + i;
            }
            System.out.println(i);
        }
    }

    @RequestMapping(value = "galleryimg-upload")
    @ResponseBody
    public Map uploadGalleryImg(HttpServletRequest request, @RequestParam(value = "file", required = true) List<MultipartFile> files, Model model) {
        Map map = new HashMap();
        Integer gallery_id = Integer.parseInt(request.getParameter("gallery_id"));
        String descStr = request.getParameter("desc");
        descStr = descStr.substring(1, descStr.length() - 1);
        String[] tempStr = descStr.split("\\,\\{");
        Map descMap = new HashMap();
        //将temStr重组为map
        for (String str : tempStr) {
            if (!str.startsWith("{")) {
                str = "{" + str;
            }
            JSONObject descJson = JSONObject.fromObject(str);
            descMap.put(descJson.get("name"), descJson.get("value"));
        }

        for (MultipartFile file : files) {
            System.out.println("文件名：" + file.getOriginalFilename() + "---contentType：" + file.getContentType());
            try {
                int x = gallerysService.queryGalleryImgByImgPath(file.getOriginalFilename());
                if (x == 0) {
                    String imgFilePath = uploadPath + PubConstant.GALLERS_DIR + file.getOriginalFilename();//新生成的图片
                    System.out.println(imgFilePath);
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(imgFilePath);
                    Files.write(path, bytes);
                    GalleryImg galleryImg = new GalleryImg();
                    galleryImg.setGalleryId(gallery_id);
                    galleryImg.setImgPath(file.getOriginalFilename());
                    galleryImg.setIntroduction((String) descMap.get(file.getOriginalFilename()));
                    gallerysService.addGalleryImg(galleryImg);
                } else {
                    System.out.println("图片" + file.getOriginalFilename() + "已经存在 不上传  不保存");
                }
            } catch (Exception e) {
                e.printStackTrace();
                map.put(PubConstant.flag, PubConstant.failed);
                return map;
            }
        }
        map.put(PubConstant.flag, PubConstant.success);
        System.out.println(request.getParameter("gallery_id"));
        return map;
    }

    @RequestMapping(value = "galleryimg-send")
    @ResponseBody
    public Map sendGalleryImgs(@RequestParam("base64Str") String base64Str, Integer gallery_id, Model model) {
        Map map = new HashMap();
        base64Str = base64Str.substring(1, base64Str.length() - 1);
        String[] tempStr = base64Str.split("\\,\\{");
        for (String imgData : tempStr) {
            if (!imgData.startsWith("{")) {
                imgData = "{" + imgData;
            }

            JSONObject imgJson = JSONObject.fromObject(imgData);
            String imgName = (String) imgJson.get("name");
            String source = (String) imgJson.get("base64");
            String desc = (String) imgJson.get("desc");
            System.out.println(desc);
            String dataPrix = ""; //base64格式前头
            String data = "";//实体部分数据

            String[] d = source.split("base64,");//将字符串分成数组
            if (d != null && d.length == 2) {
                dataPrix = d[0];
                data = d[1];
            } else {
                return null;
            }
            /*
            //这里直接拿前台传入的图片名称 不进行判断了
            String suffix = "";//图片后缀，用以识别哪种格式数据
            //data:image/jpeg;base64,base64编码的jpeg图片数据
            if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){
                suffix = ".jpg";
            }else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){
                //data:image/x-icon;base64,base64编码的icon图片数据
                suffix = ".ico";
            }else if("data:image/gif;".equalsIgnoreCase(dataPrix)){
                //data:image/gif;base64,base64编码的gif图片数据
                suffix = ".gif";
            }else if("data:image/png;".equalsIgnoreCase(dataPrix)){
                //data:image/png;base64,base64编码的png图片数据
                suffix = ".png";
            }else if("data:image/bmp;".equalsIgnoreCase(dataPrix)){
                //data:image/png;base64,base64编码的png图片数据
                suffix = ".bmp";
            }
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String tempFileName=uuid+suffix;
            String imgFilePath = "D:\\upload\\Images\\"+tempFileName;//新生成的图片
            */
            //根据imgName名称判断是否已经存在  存在则绕过上传和保存
            int x = gallerysService.queryGalleryImgByImgPath(imgName);
            if (x == 0) {
                String imgFilePath = uploadPath + PubConstant.GALLERS_DIR + imgName;//新生成的图片
                BASE64Decoder decoder = new BASE64Decoder();
                try {
                    //Base64解码
                    byte[] b = decoder.decodeBuffer(data);
                    for (int i = 0; i < b.length; ++i) {
                        if (b[i] < 0) {
                            //调整异常数据
                            b[i] += 256;
                        }
                    }
                    OutputStream out = new FileOutputStream(imgFilePath);
                    out.write(b);
                    out.flush();
                    out.close();

                    //创建GalleryImg对新
                    GalleryImg galleryImg = new GalleryImg();
                    galleryImg.setGalleryId(gallery_id);
                    galleryImg.setImgPath(imgName);
                    galleryImg.setIntroduction(desc);
                    gallerysService.addGalleryImg(galleryImg);
                } catch (IOException e) {
                    e.printStackTrace();
                    map.put(PubConstant.flag, PubConstant.failed);
                    return map;
                }
            } else {
                System.out.println("图片" + imgName + "已经存在 不上传  不保存");
            }

            map.put(PubConstant.flag, PubConstant.success);
        }
        return map;
    }
}
