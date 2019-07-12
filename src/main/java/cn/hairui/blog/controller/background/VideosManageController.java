package cn.hairui.blog.controller.background;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.GalleryImg;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.model.User;
import cn.hairui.blog.model.Videos;
import cn.hairui.blog.service.MyInfoService;
import cn.hairui.blog.service.VideosService;
import cn.hairui.blog.util.FileUtil;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
 * @date 2019/7/12 11:12
 */
@Controller
@RequestMapping("/manage")
public class VideosManageController {
    @Autowired
    private MyInfoService myInfoService;
    @Autowired
    private VideosService videosService;
    private String listPage = PubConstant.BACKGROUND_DIR_NAME + "videos-list";//列表页面
    private String addPage = PubConstant.BACKGROUND_DIR_NAME + "videos-add";//列表页面

    @Value("${upload_path}")
    private String uploadPath;

    @Value("${virtual_upload_path}")
    private String virtualUploadPath;


    @RequestMapping(value = "/videos-list")
    public String videosList(HttpServletRequest request, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        List<Videos> videosList = videosService.queryVideosList();
        model.addAttribute("videos", videosList);
        return listPage;
    }

    @RequestMapping(value = "/videos-add")
    public String addVideos(Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        return addPage;
    }

    @RequestMapping(value = "/videos-adddata")
    @ResponseBody
    @Transactional
    public Map addGalleryData(HttpServletRequest request, String name, String vtype, Integer publishYear, String creator, String showFlag, String introduction, Model model) {
        Map map = new HashMap();
        int count = 0;
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> coverfile = multipartRequest.getFiles("coverfile");
        String coverName = "";
        MultipartFile file = null;
        if (coverfile.size() > 0 && !coverfile.get(0).isEmpty()) {
            file = (MultipartFile) coverfile.get(0);
            coverName = coverfile.get(0).getOriginalFilename();
            System.out.println("封面图名称：" + coverName);
        }

        List<MultipartFile> videofile = multipartRequest.getFiles("videofile");
        String videoName = "";
        MultipartFile file1 = null;
        if (coverfile.size() > 0 && !videofile.get(0).isEmpty()) {
            file1 = (MultipartFile) videofile.get(0);
            videoName = videofile.get(0).getOriginalFilename();
            //通过文件名查询是否已经上传过  如果上传过了 则跳过
            count = videosService.queryVideosCountByFileName(videoName);
            System.out.println("文件名称：" + videoName);
        }

        ////文件上传 对象提交插入数据库
        File targetPath = new File(uploadPath + PubConstant.VIDEOS_DIR + PubConstant.COVERS_DIR);
        if (!targetPath.exists()) {
            targetPath.mkdirs();
        }
        //保存
        try {
            if (count == 0) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(uploadPath + PubConstant.VIDEOS_DIR + PubConstant.COVERS_DIR + coverName);
                Files.write(path, bytes);

                byte[] bytes1 = file1.getBytes();
                Path path1 = Paths.get(uploadPath + PubConstant.VIDEOS_DIR + videoName);
                Files.write(path1, bytes1);

                Videos videos = new Videos();
                videos.setName(name);
                videos.setVtype(vtype);
                videos.setPublishYear(publishYear);
                videos.setIntroduction(introduction);
                videos.setCoverPath(coverName);
                videos.setFilePath(videoName);
                videos.setShowFlag(showFlag);
                videos.setCreator(creator);
                videos.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

                int i = videosService.addVideos(videos);
                map.put(PubConstant.flag, PubConstant.success);
            } else {
                map.put(PubConstant.flag, PubConstant.failed);
                map.put(PubConstant.message,"上传文件名已经存在");

            }
        } catch (Exception e) {
            map.put(PubConstant.flag, PubConstant.failed);
            map.put(PubConstant.message,"系统异常");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/videos-lock")
    @ResponseBody
    public Map updateVideosStatus(HttpServletRequest request, Integer id, String lock, Model model) {
        Map map = new HashMap();
        User user = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (PubConstant.YES_NO_Y.equals(user.getAdminflag())) {
            if (!PubConstant.YES_NO_Y.equals(lock.trim().toUpperCase()) && !PubConstant.YES_NO_N.equals(lock.trim().toUpperCase())) {
                //传入锁定标志错误
                map.put(PubConstant.flag, PubConstant.failed);
                return map;
            } else {
                lock = lock.trim().toUpperCase();
            }
            int i = videosService.updateVideosStatus(id, lock);
            map.put(PubConstant.flag, PubConstant.success);
        } else {
            map.put(PubConstant.flag, PubConstant.failed);
            map.put(PubConstant.message, "权限不足");
        }
        return map;
    }

    @RequestMapping(value = "/videos-delete")
    @ResponseBody
    public Map deleteVideos(HttpServletRequest request, Integer id, Model model) {
        Map map = new HashMap();
        User user = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (PubConstant.YES_NO_Y.equals(user.getAdminflag())) {
            Videos videos = videosService.queryVideosById(id);
            if (videos != null && user.getUsername().equals(videos.getCreator())) {
                //删除文件
                try {
                    String path = uploadPath + PubConstant.VIDEOS_DIR + videos.getFilePath();
                    FileUtil.deleteSingleFile(path);
                }catch (Exception e){
                    e.printStackTrace();
                }
                //删除数据
                int i = videosService.deleteVideosById(id);
                map.put(PubConstant.flag, PubConstant.success);
            } else {
                map.put(PubConstant.flag, PubConstant.failed);
                map.put(PubConstant.message, "权限不足");
            }
        } else {
            map.put(PubConstant.flag, PubConstant.failed);
            map.put(PubConstant.message, "权限不足");
        }
        return map;
    }
}
