package cn.hairui.blog.service;

import cn.hairui.blog.model.GalleryImg;
import cn.hairui.blog.model.Gallerys;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/7/5 22:07
 */
@Service
public interface GallerysService {

    /**
     * 获取所有相册内容
     *
     * @return
     */
    public List<Gallerys> queryGallerysList();

    /**
     * 创建相册
     * @param gallerys
     * @return
     */
    public int addGallery(Gallerys gallerys);

    /**
     * 添加相册内容图
     * @param galleryImg
     * @return
     */
    public int addGalleryImg(GalleryImg galleryImg);

    /**
     * 通过相册编号获取相册中的照片数量
     * @param id
     * @return
     */
    public Integer queryGalleryImgCountByGalleryId(Integer id);

    /**
     * 通过相册编号查询指定数量的照片信息
     * @param id
     * @param galleryPreviewNum
     * @return
     */
    public List<GalleryImg> queryGalleryImgByGalleryIdLimited(Integer id, Integer galleryPreviewNum);

    /**
     * 获取相册下所有的照片信息
     * @param gallery_id
     * @return
     */
    public List<GalleryImg> queryGalleryImgList(Integer gallery_id);

    /**
     * 通过相册编号获取相册信息
     * @param id
     * @return
     */
    public Gallerys queryGallerysById(Integer id);

    /**
     * 更新相册信息
     * @param gallerys
     * @return
     */
    public int updateGallerys(Gallerys gallerys);
}
