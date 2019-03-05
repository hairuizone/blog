package cn.hairui.blog.mapper;

import cn.hairui.blog.model.Artical;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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

    @Select("SELECT DISTINCT tags FROM artical WHERE tags IS NOT NULL AND tags != ''")
    public List<String> queryAllArticalTags();

    @Select("select * from artical where intop=#{intop} order by createDate desc limit 1")
    public Artical queryArticalFirstByIntop(String intop);
}
