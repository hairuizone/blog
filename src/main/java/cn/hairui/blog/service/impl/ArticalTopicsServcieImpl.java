package cn.hairui.blog.service.impl;

import cn.hairui.blog.mapper.ArticalTopicsMapper;
import cn.hairui.blog.model.ArticalTopics;
import cn.hairui.blog.repository.ArticalTopicsRepository;
import cn.hairui.blog.service.ArticalTopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/4 23:42
 */
@Service
public class ArticalTopicsServcieImpl implements ArticalTopicsService {

    @Autowired
    private ArticalTopicsRepository articalTopicsRepository;

    @Override
    public List<ArticalTopics> qeuryArticalTopicsList() {

        return articalTopicsRepository.queryArticalTopicsList();
    }
}
