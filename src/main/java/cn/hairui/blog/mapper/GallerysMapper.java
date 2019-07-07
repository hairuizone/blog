package cn.hairui.blog.mapper;

import cn.hairui.blog.model.GalleryImg;
import cn.hairui.blog.model.Gallerys;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/7/5 22:09
 */
@Mapper
public interface GallerysMapper {

    @Select("SELECT * FROM GALLERYS ORDER BY ID DESC")
    public List<Gallerys> queryGallerysList();

    @Insert("INSERT INTO GALLERYS " +
            "(NAME,SHOW_IMG,SHOW_FLAG,INTRODUCTION,CREATE_TIME,CREATOR) " +
            "VALUES" +
            "(#{name},#{showImg},#{showFlag},#{introduction},#{createTime},#{creator})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int addGallery(Gallerys gallerys);

    @Insert("INSERT INTO GALLERY_IMG " +
            "(GALLERY_ID,IMG_NAME,IMG_PATH,INTRODUCTION)" +
            "VALUES" +
            "(#{galleryId},#{imgName},#{imgPath},#{introduction})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int addGalleryImg(GalleryImg galleryImg);

    @Select("SELECT COUNT(1) FROM GALLERY_IMG WHERE GALLERY_ID=#{gallery_id}")
    public Integer queryGalleryImgCountByGalleryId(Integer gallery_id);

    //list出入顺序  asc保证展示最新在最前面
    @Select("SELECT * FROM GALLERY_IMG WHERE GALLERY_ID=#{gallery_id} ORDER BY ID ASC LIMIT #{maxSize}")
    public List<GalleryImg> queryGalleryImgByGalleryIdLimited(Integer gallery_id, Integer maxSize);

    @Select("SELECT * FROM GALLERY_IMG WHERE GALLERY_ID=#{gallery_id} ORDER BY ID DESC")
    public List<GalleryImg> queryGalleryImgList(Integer gallery_id);

    @Select("SELECT * FROM GALLERYS WHERE ID=#{id}")
    public Gallerys queryGallerysById(Integer id);

    @Update("UPDATE GALLERYS SET NAME=#{name},SHOW_IMG=#{showImg},SHOW_FLAG=#{showFlag},INTRODUCTION=#{introduction} WHERE ID=#{id}")
    public int updateGallerys(Gallerys gallerys);

    @Select("SELECT * FROM GALLERY_IMG WHERE ID=#{id}")
    public GalleryImg queryGalleryImgById(Integer id);

    @Select("SELECT * FROM GALLERY_IMG WHERE ID!=#{id} AND IMG_PATH=#{imgPath}")
    public GalleryImg queryGalleryImgByImgPathExceptId(Integer id, String imgPath);

    @Delete("DELETE FROM GALLERY_IMG WHERE ID=#{id}")
    public int deleteGalleryImgById(Integer id);

    @Select("SELECT * FROM GALLERY_IMG WHERE GALLERY_ID=#{galleryId} oRDER BY ID DESC LIMIT 1")
    public GalleryImg queryGalleryImgByGalleryIdFirst(Integer galleryId);

    @Update("UPDATE GALLERYS SET SHOW_IMG=#{newImg} WHERE ID=#{galleryId}")
    public int setShowImgByGalleryId(Integer galleryId, String newImg);

    @Delete("DELETE FROM GALLERYS WHERE ID=#{id}")
    public int deleteGallerysById(Integer galleryId);
}
