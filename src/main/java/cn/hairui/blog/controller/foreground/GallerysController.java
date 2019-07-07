package cn.hairui.blog.controller.foreground;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.GalleryImg;
import cn.hairui.blog.model.Gallerys;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.service.GallerysService;
import cn.hairui.blog.service.MyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
 * @date 2019/7/5 17:31
 */
@Controller
public class GallerysController {

    @Autowired
    private MyInfoService myInfoService;

    @Autowired
    private GallerysService gallerysService;

    @RequestMapping(value = "gallerys")
    public String gallerysShow(HttpServletRequest request, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        List<Gallerys> gallerysList = gallerysService.queryGallerysList();
        Iterator gallerysIterator = gallerysList.iterator();
        List<Map> gallerysInfo = new ArrayList<>();
        while (gallerysIterator.hasNext()) {
            Map map = new HashMap();
            Gallerys gallery = (Gallerys) gallerysIterator.next();

            Integer id = gallery.getId();
            String name = gallery.getName();
            Integer num = gallerysService.queryGalleryImgCountByGalleryId(id);

            map.put("id", id);
            map.put("name",name);
            map.put("num", num);

            //最大展示预览图设置 太大会造成内存不足
            List<GalleryImg> galleryImgList = gallerysService.queryGalleryImgByGalleryIdLimited(id,PubConstant.GALLERY_PREVIEW_NUM);
            map.put("gallery",galleryImgList);
            gallerysInfo.add(map);
        }
        model.addAttribute("gallerysInfo", gallerysInfo);
        System.out.println(gallerysList.toString());
        return "gallerys";

    }

    @RequestMapping(value = "gallery")
    public String galleryShow(Integer gallery_id, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        System.out.println("gallery_id = " + gallery_id);
        List<GalleryImg> galleryImgList = gallerysService.queryGalleryImgList(gallery_id);
        model.addAttribute("galleryImgList",galleryImgList);
        System.out.println(galleryImgList.toString());
        return "gallery";
    }
}
