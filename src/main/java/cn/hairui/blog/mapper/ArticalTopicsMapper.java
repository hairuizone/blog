package cn.hairui.blog.mapper;

import cn.hairui.blog.model.ArticalTopics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
