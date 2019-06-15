package cn.hairui.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hairui.blog.model.ArticalTopics;
import cn.hairui.blog.repository.ArticalTopicsRepository;
import cn.hairui.blog.service.ArticalTopicsService;

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

	@Override
	public List<ArticalTopics> qeuryArticalTopicsListLimited(int maxSize) {
		return articalTopicsRepository.queryArticalTopicsListLimited(maxSize);
	}

	@Override
	public int qeuryArticalTopicsByName(String topicName) {
		return articalTopicsRepository.qeuryArticalTopicsByName(topicName);
	}

	@Override
	public int addArticalTopics(ArticalTopics articalTopics) {
		return articalTopicsRepository.addArticalTopics(articalTopics);
	}

	@Override
	public ArticalTopics queryArticalTopicsDetailById(int id) {
		return articalTopicsRepository.queryArticalTopicsDetailById(id);
	}

	@Override
	public int updateArticalTopicsData(ArticalTopics articalTopics) {
		return articalTopicsRepository.updateArticalTopicsData(articalTopics);
	}

	@Override
	public int deleteArticalTopics(int id) {
		return articalTopicsRepository.deleteArticalTopics(id);
	}
}
