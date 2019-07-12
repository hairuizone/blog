package cn.hairui.blog.service;

import cn.hairui.blog.model.Videos;
import org.springframework.stereotype.Service;

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
 * @date 2019/7/12 11:34
 */
public interface VideosService {
    /**
     * 获取所有视频信息
     *
     * @return
     */
    public List<Videos> queryVideosList();

    /**
     * 添加视频
     *
     * @param videos
     * @return
     */
    public int addVideos(Videos videos);

    /**
     * 通过文件名称查询是否已经上传
     *
     * @param videoName
     * @return
     */
    public int queryVideosCountByFileName(String videoName);

    /**
     * 修改视频的公开状态
     *
     * @param id
     * @param lock
     * @return
     */
    public int updateVideosStatus(Integer id, String lock);

    /**
     * 通过编号获取视频信息
     *
     * @param id
     * @return
     */
    public Videos queryVideosById(Integer id);

    /**
     * 通过编号删除视频
     *
     * @param id
     * @return
     */
    public int deleteVideosById(Integer id);

    /**
     * 查询公开展示的视频
     *
     * @return
     */
    public List<Videos> queryVideosShowList();

    /**
     * 获取当前用户名下 并且展示为是的图片
     * @param username
     * @return
     */
    public List<Videos> queryVideosListByOwner(String username);
}
