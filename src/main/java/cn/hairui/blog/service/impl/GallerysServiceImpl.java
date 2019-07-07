package cn.hairui.blog.service.impl;

import cn.hairui.blog.model.GalleryImg;
import cn.hairui.blog.model.Gallerys;
import cn.hairui.blog.repository.GallerysRepository;
import cn.hairui.blog.service.GallerysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/7/5 22:07
 */
@Service (value = "gallerysService")
public class GallerysServiceImpl implements GallerysService {

    @Autowired
    private GallerysRepository gallerysRepository;
    @Override
    public List<Gallerys> queryGallerysList() {
        return gallerysRepository.queryGallerysList();
    }

    @Override
    public int addGallery(Gallerys gallerys) {
        return gallerysRepository.addGallery(gallerys);
    }

    @Override
    public int addGalleryImg(GalleryImg galleryImg) {
        return gallerysRepository.addGalleryImg(galleryImg);
    }

    @Override
    public Integer queryGalleryImgCountByGalleryId(Integer id) {
        return gallerysRepository.queryGalleryImgCountByGalleryId(id);
    }

    @Override
    public List<GalleryImg> queryGalleryImgByGalleryIdLimited(Integer id, Integer galleryPreviewNum) {
        return gallerysRepository.queryGalleryImgByGalleryIdLimited(id,galleryPreviewNum);
    }

    @Override
    public List<GalleryImg> queryGalleryImgList(Integer gallery_id) {
        return gallerysRepository.queryGalleryImgList(gallery_id);
    }

    @Override
    public Gallerys queryGallerysById(Integer id) {
        return gallerysRepository.queryGallerysById(id);
    }

    @Override
    public int updateGallerys(Gallerys gallerys) {
        return gallerysRepository.updateGallerys(gallerys);
    }

    @Override
    public GalleryImg queryGalleryImgById(Integer id) {
        return gallerysRepository.queryGalleryImgById(id);
    }

    @Override
    public GalleryImg queryGalleryImgByImgPathExceptId(Integer id, String imgPath) {
        return gallerysRepository.queryGalleryImgByImgPathExceptId(id,imgPath);
    }

    @Override
    public int deleteGalleryImgById(Integer id) {
        return gallerysRepository.deleteGalleryImgById(id);
    }

    @Override
    public GalleryImg queryGalleryImgByGalleryIdFirst(Integer galleryId) {
        return gallerysRepository.queryGalleryImgByGalleryIdFirst(galleryId);
    }

    @Override
    public int setShowImgByGalleryId(Integer galleryId, String newImg) {
        return gallerysRepository.setShowImgByGalleryId(galleryId,newImg);
    }

    @Override
    public int deleteGallerysById(Integer galleryId) {
        return gallerysRepository.deleteGallerysById(galleryId);
    }

}
