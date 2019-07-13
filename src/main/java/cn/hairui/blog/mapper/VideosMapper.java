package cn.hairui.blog.mapper;

import cn.hairui.blog.model.Videos;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
 * @date 2019/7/12 11:38
 */
@Mapper
public interface VideosMapper {

    @Select("SELECT * FROM VIDEOS ORDER BY ID DESC")
    public List<Videos> queryVideosList();

    @Insert("INSERT INTO VIDEOS(NAME,VTYPE,PUBLISH_YEAR,INTRODUCTION,COVER_PATH,FILE_PATH,SHOW_FLAG,CREATOR,CREATE_TIME)" +
            "VALUE" +
            "(#{name},#{vtype},#{publishYear},#{introduction},#{coverPath},#{filePath},#{showFlag},#{creator},#{createTime})")
    public int addVideos(Videos videos);

    @Select("SELECT COUNT(1) FROM VIDEOS WHERE FILE_PATH=#{videoName}")
    public int queryVideosCountByFileName(String videoName);

    @Update("UPDATE VIDEOS SET SHOW_FLAG=#{lock} WHERE ID=#{id}")
    public int updateVideosStatus(Integer id, String lock);

    @Select("SELECT * FROM VIDEOS WHERE ID=#{id}")
    public Videos queryVideosById(Integer id);

    @Delete("DELETE FROM VIDEOS WHERE ID=#{id}")
    public int deleteVideosById(Integer id);

    @Select("SELECT * FROM VIDEOS WHERE SHOW_FLAG='Y'")
    public List<Videos> queryVideosShowList();

    @Select("SELELECT * FROM VIDEOS WHERE SHOW_FLAG='Y' OR CREATOR=#{username}")
    public List<Videos> queryVideosListByOwnerAndShow(String username);

    @Select("SELECT * FROM VIDEOS WHERE CREATOR=#{username}")
    public List<Videos> queryVideosListByOwner(String username);

    @Select("SELECT COUNT(1) FROM VIDEOS")
    public int queryVideosCount();
}
