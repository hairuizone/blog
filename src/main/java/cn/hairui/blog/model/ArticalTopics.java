package cn.hairui.blog.model;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/4 23:36
 */
public class ArticalTopics {
    private Integer id;//专题编号
    private String topicName;//专题名称
    private Integer articalCount;//文章数量
    private String introduction;//专题介绍

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getArticalCount() {
        return articalCount;
    }

    public void setArticalCount(Integer articalCount) {
        this.articalCount = articalCount;
    }
}
