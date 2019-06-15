package cn.hairui.blog.mapper;

import cn.hairui.blog.model.ArticalTopics;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/4 23:40
 */
@Mapper
public interface ArticalTopicsMapper {

    @Select("select * from Artical_Topics")
    public List<ArticalTopics> queryArticalTopicsList();
    @Select("select * from Artical_Topics limit 0,#{maxSize}")
    public List<ArticalTopics> queryArticalTopicsListLimited(int maxSize);

    @Select("select count(1) from Artical_Topics where TOPIC_NAME=#{topicName}")
    public int qeuryArticalTopicsByName(String topicName);

    @Insert("insert into Artical_Topics(TOPIC_NAME,ARTICAL_COUNT,introduction) value(#{topicName},#{articalCount},#{introduction})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")//加入该注解可以保持对象后，查看对象插入id
    public int addArticalTopics(ArticalTopics articalTopics);

    @Select("select * from artical_topics where id=#{id}")
    public ArticalTopics queryArticalTopicsDetailById(int id);

    @Update("update artical_topics set TOPIC_NAME=#{topicName},introduction=#{introduction} where id=#{id}")
    public int updateArticalTopicsData(ArticalTopics articalTopics);


    @Delete("delete from artical_topics where id=#{id}")
    public int deleteArticalTopics(int id);
}
