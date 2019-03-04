package cn.hairui.blog.mapper;

import cn.hairui.blog.model.Artical;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/4 16:47
 */
@Mapper
public interface ArticalMapper {

    @Select("select * from artical where navId = #{navId} order by createDate desc , id desc")
    public List<Artical> queryArticalListByNavId(Integer navId);

    @Select("select * from artical where CATEGORIES = #{categories} order by createDate desc")
    public List<Artical> queryArticalListByCategories(Integer categories);
}
