package cn.hairui.blog.repository;

import cn.hairui.blog.mapper.GallerysMapper;
import cn.hairui.blog.model.GalleryImg;
import cn.hairui.blog.model.Gallerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/7/5 22:08
 */
@Repository
public class GallerysRepository {

    @Autowired
    private GallerysMapper gallerysMapper;

    public List<Gallerys> queryGallerysList() {
        return gallerysMapper.queryGallerysList();
    }

    public int addGallery(Gallerys gallerys) {
        return gallerysMapper.addGallery(gallerys);
    }

    public int addGalleryImg(GalleryImg galleryImg) {
        return gallerysMapper.addGalleryImg(galleryImg);
    }

    public Integer queryGalleryImgCountByGalleryId(Integer id) {
        return gallerysMapper.queryGalleryImgCountByGalleryId(id);
    }

    public List<GalleryImg> queryGalleryImgByGalleryIdLimited(Integer id, Integer maxSize) {
        return gallerysMapper.queryGalleryImgByGalleryIdLimited(id,maxSize);
    }

    public List<GalleryImg> queryGalleryImgList(Integer gallery_id) {
        return gallerysMapper.queryGalleryImgList(gallery_id);
    }

    public Gallerys queryGallerysById(Integer id) {
        return gallerysMapper.queryGallerysById(id);
    }

    public int updateGallerys(Gallerys gallerys) {
        return gallerysMapper.updateGallerys(gallerys);
    }
}
