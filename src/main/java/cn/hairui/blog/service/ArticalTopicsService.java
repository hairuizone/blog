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
     * @return
     * @Description 获取所有专题
     */
    public List<ArticalTopics> qeuryArticalTopicsList();

    /**
     * @param maxSize 数量
     * @return
     * @Description 获取指定数量的专题
     */
    public List<ArticalTopics> qeuryArticalTopicsListLimited(int maxSize);

    /**
     * 通过名称查询已经存在的专题名称数量
     *
     * @param topicName
     * @return
     */
    public int qeuryArticalTopicsByName(String topicName);

    /**
     * 新增专题
     *
     * @param articalTopics
     * @return 专题编号
     */
    public int addArticalTopics(ArticalTopics articalTopics);

    /**
     * 通过专题编号查找专题信息
     *
     * @param id
     * @return 专题信息
     */
    public ArticalTopics queryArticalTopicsDetailById(int id);

    /**
     * 修改专题名称
     *
     * @param articalTopics
     * @return
     */
    public int updateArticalTopicsData(ArticalTopics articalTopics);

    /**
     * 通过专题编号删除专题
     *
     * @param id
     * @return
     */
    public int deleteArticalTopics(int id);
}
