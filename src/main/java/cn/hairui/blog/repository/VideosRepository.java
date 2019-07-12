package cn.hairui.blog.repository;

import cn.hairui.blog.mapper.VideosMapper;
import cn.hairui.blog.model.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
 * @date 2019/7/12 11:37
 */
@Repository
public class VideosRepository {

    @Autowired
    private VideosMapper videosMapper;

    public List<Videos> queryVideosList() {
        return videosMapper.queryVideosList();
    }

    public int addVideos(Videos videos) {
        return videosMapper.addVideos(videos);
    }

    public int queryVideosCountByFileName(String videoName) {
        return videosMapper.queryVideosCountByFileName(videoName);
    }

    public int updateVideosStatus(Integer id, String lock) {
        return videosMapper.updateVideosStatus(id,lock);
    }

    public Videos queryVideosById(Integer id) {
        return videosMapper.queryVideosById(id);
    }

    public int deleteVideosById(Integer id) {
        return  videosMapper.deleteVideosById(id);
    }

    public List<Videos> queryVideosShowList() {
        return videosMapper.queryVideosShowList();
    }

    public List<Videos> queryVideosListByOwner(String username) {
        return videosMapper.queryVideosListByOwner(username);
    }
}
