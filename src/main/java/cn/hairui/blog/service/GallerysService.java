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
     *
     * @param gallerys
     * @return
     */
    public int addGallery(Gallerys gallerys);

    /**
     * 添加相册内容图
     *
     * @param galleryImg
     * @return
     */
    public int addGalleryImg(GalleryImg galleryImg);

    /**
     * 通过相册编号获取相册中的照片数量
     *
     * @param id
     * @return
     */
    public Integer queryGalleryImgCountByGalleryId(Integer id);

    /**
     * 通过相册编号查询指定数量的照片信息
     *
     * @param id
     * @param galleryPreviewNum
     * @return
     */
    public List<GalleryImg> queryGalleryImgByGalleryIdLimited(Integer id, Integer galleryPreviewNum);

    /**
     * 获取相册下所有的照片信息
     *
     * @param gallery_id
     * @return
     */
    public List<GalleryImg> queryGalleryImgList(Integer gallery_id);

    /**
     * 通过相册编号获取相册信息
     *
     * @param id
     * @return
     */
    public Gallerys queryGallerysById(Integer id);

    /**
     * 更新相册信息
     *
     * @param gallerys
     * @return
     */
    public int updateGallerys(Gallerys gallerys);

    /**
     * 通过照片编号查询照片信息
     *
     * @param id
     * @return
     */
    public GalleryImg queryGalleryImgById(Integer id);

    /**
     * 查询编号不是id 名称是imgName的照片
     *
     * @param id
     * @param imgPath
     * @return
     */
    public GalleryImg queryGalleryImgByImgPathExceptId(Integer id, String imgPath);

    /**
     * 通过照片编号删除照片信息
     *
     * @param id
     * @return
     */
    public int deleteGalleryImgById(Integer id);

    /**
     * 获取相册中下一张照片的信息
     *
     * @param galleryId
     * @return
     */
    public GalleryImg queryGalleryImgByGalleryIdFirst(Integer galleryId);

    /**
     * 修改封面图信息
     *
     * @param galleryId
     * @param newImg
     * @return
     */
    public int setShowImgByGalleryId(Integer galleryId, String newImg);

    /**
     * 通过编号删除相册
     *
     * @param galleryId
     * @return
     */
    public int deleteGallerysById(Integer galleryId);

    /**
     * 通过图片名称查询是否已经存在了
     *
     * @param imgName
     * @return
     */
    public int queryGalleryImgByImgPath(String imgName);

    /**
     * 获取展示的相册信息
     *
     * @return
     */
    public List<Gallerys> queryGallerysShowList();

    /**
     * 查询所有者的相册信息
     *
     * @return
     */
    public List<Gallerys> queryGallerysListByOwner(String username);

    /**
     * 查询所有者以及展示状态为公开的相册
     *
     * @param username
     * @return
     */
    public List<Gallerys> queryGallerysListByOwnerAndShow(String username);
}
