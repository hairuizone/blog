package cn.hairui.blog.service;

import cn.hairui.blog.model.ArticalTopics;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/4 23:41
 */
public interface ArticalTopicsService {

	/**
	 * 
	 * @Description 获取所有专题
	 * @return
	 */
    public List<ArticalTopics> qeuryArticalTopicsList();

    /**
     * 
     * @Description 获取指定数量的专题
     * @param maxSize 数量
     * @return
     */
	public List<ArticalTopics> qeuryArticalTopicsListLimited(int maxSize);
}
