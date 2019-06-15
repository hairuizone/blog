package cn.hairui.blog.mapper;

import cn.hairui.blog.model.ArticalCategories;
import org.apache.ibatis.annotations.*;

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

    @Insert("insert into artical_categories(CATEGORY_NAME,IS_SHOW,SHOW_ORDER,ARTICAL_COUNT,INTRODUCTION) value(#{categoryName},#{isShow},#{showOrder},#{articalCount},#{introduction})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")//加入该注解可以保持对象后，查看对象插入id
    public int addArticalCategories(ArticalCategories articalCategories);

    @Select("select count(*) from artical_categories where CATEGORY_NAME=#{categoryName}")
    public int qeuryArticalCategoriesByName(String categoryName);

    @Select("select max(SHOW_ORDER) from artical_categories")
    public int queryArticalCategoriesMaxShowOrder();

    @Select("select * from artical_categories where id=#{id}")
    public ArticalCategories queryArticalCategoriesDetailById(Integer id);

    @Update("update artical_categories set CATEGORY_NAME=#{categoryName},IS_SHOW=#{isShow},SHOW_ORDER=#{showOrder},INTRODUCTION=#{introduction} where id=#{id}")
    public int updateArticalCategories(ArticalCategories articalCategories);

    @Delete("delete from artical_categories where id=#{id}")
    public int deleteArticalCategoriesData(int id);
}
