package cn.hairui.blog.mapper;

import cn.hairui.blog.model.ArticalCategories;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/4 21:06
 */
@Mapper
public interface ArticalCategoriesMapper {

    @Select("select * from artical_categories where is_show=#{isShow} order by show_order asc  limit 0,#{maxSize}")
    public List<ArticalCategories> queryArticalCategoriesByIsShow(String isShow,int maxSize);

    @Select("select * from artical_categories order by id asc")
    public List<ArticalCategories> queryArticalCategoriesList();
}
