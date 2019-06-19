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

    @Select("select * from artical_categories where is_show=#{isShow} order by show_order asc  limit #{beginIdx},#{endIdx}")
    public List<ArticalCategories> queryArticalCategoriesByIsShow(String isShow,int beginIdx,int endIdx);

    @Select("select * from artical_categories order by id asc")
    public List<ArticalCategories> queryArticalCategoriesList();

    @Insert("insert into artical_categories(id,CATEGORY_NAME,IS_SHOW,SHOW_ORDER,ARTICAL_COUNT,INTRODUCTION) value(#{id},#{categoryName},#{isShow},#{showOrder},#{articalCount},#{introduction})")
    //@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")//加入该注解可以保持对象后，查看对象插入id
    public int addArticalCategories(ArticalCategories articalCategories);

    @Select("select count(*) from artical_categories where CATEGORY_NAME=#{categoryName}")
    public int qeuryArticalCategoriesByName(String categoryName);

    @Select("select max(SHOW_ORDER) from artical_categories")
    public Integer queryArticalCategoriesMaxShowOrder();

    @Select("select * from artical_categories where id=#{id}")
    public ArticalCategories queryArticalCategoriesDetailById(Integer id);

    @Update("update artical_categories set CATEGORY_NAME=#{categoryName},IS_SHOW=#{isShow},SHOW_ORDER=#{showOrder},INTRODUCTION=#{introduction} where id=#{id}")
    public int updateArticalCategories(ArticalCategories articalCategories);

    @Delete("delete from artical_categories where id=#{id}")
    public int deleteArticalCategoriesData(int id);

    @Select("select max(id) from artical_categories")
    public Integer queryMaxArticalCategoriesId();

    @Update("update artical_categories set SHOW_ORDER = SHOW_ORDER+1 where SHOW_ORDER is not null and SHOW_ORDER!=''")
    public void moveArticalCategoriesOrderNextOne();

    @Select("select * from artical_categories")
    public List<ArticalCategories> queryAllArticalCategories();
}
