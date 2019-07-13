package cn.hairui.blog.service.impl;

import cn.hairui.blog.model.Videos;
import cn.hairui.blog.repository.VideosRepository;
import cn.hairui.blog.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date 2019/7/12 11:36
 */
@Service
public class VideosServiceImpl implements VideosService {

    @Autowired
    private VideosRepository videosRepository;
    @Override
    public List<Videos> queryVideosList() {
        return videosRepository.queryVideosList();
    }

    @Override
    public int addVideos(Videos videos) {
        return videosRepository.addVideos(videos);
    }

    @Override
    public int queryVideosCountByFileName(String videoName) {
        return videosRepository.queryVideosCountByFileName(videoName);
    }

    @Override
    public int updateVideosStatus(Integer id, String lock) {
        return videosRepository.updateVideosStatus(id,lock);
    }

    @Override
    public Videos queryVideosById(Integer id) {
        return videosRepository.queryVideosById(id);
    }

    @Override
    public int deleteVideosById(Integer id) {
        return videosRepository.deleteVideosById(id);
    }

    @Override
    public List<Videos> queryVideosShowList() {
        return videosRepository.queryVideosShowList();
    }

    @Override
    public List<Videos> queryVideosListByOwnerAndShow(String username) {
        return videosRepository.queryVideosListByOwnerAndShow(username);
    }

    @Override
    public List<Videos> queryVideosListByOwner(String username) {
        return videosRepository.queryVideosListByOwner(username);
    }

    @Override
    public int queryVideosCount() {
        return videosRepository.queryVideosCount();
    }
}
