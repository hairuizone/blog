package cn.hairui.blog.repository;

import cn.hairui.blog.mapper.ArticalTopicsMapper;
import cn.hairui.blog.model.ArticalTopics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/9 23:13
 */
@Repository
public class ArticalTopicsRepository {

    @Autowired
    private ArticalTopicsMapper articalTopicsMapper;

    public List<ArticalTopics> queryArticalTopicsList() {
        return articalTopicsMapper.queryArticalTopicsList();
    }

    public List<ArticalTopics> queryArticalTopicsListLimited(int maxSize) {
        return articalTopicsMapper.queryArticalTopicsListLimited(maxSize);
    }
}
