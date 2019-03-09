package cn.hairui.blog.mapper;

import cn.hairui.blog.model.Artical;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from artical where navId = #{navId} order by createDate desc , id desc limit #{count}")
    public List<Artical> queryArticalListByNavIdCount(Integer navId,int count);


    @Select("select * from artical where CATEGORIES = #{categories} order by createDate desc")
    public List<Artical> queryArticalListByCategories(Integer categories);

    @Select("select * from artical where CATEGORIES = #{categories} order by createDate desc limit #{count}")
    List<Artical> queryArticalListByCategoriesCount(Integer categories, int count);

    @Select("SELECT DISTINCT tags FROM artical WHERE tags IS NOT NULL AND tags != ''")
    public List<String> queryAllArticalTags();

    @Select("select * from artical where intop=#{intop} order by createDate desc limit 1")
    public Artical queryArticalFirstByIntop(String intop);

    @Select("select * from artical order by createDate desc,id desc limit 10")
    public List<Artical> queryArticalListHomePage();

    @Select("select * from artical order by createDate desc,id desc limit 6")
    public List<Artical> queryArticalListByCond(String type, String keywords);

    @Select("select * from artical where id=#{id}")
    public Artical queryArticalDetailById(Integer id);

    @Update("update artical set " +
            "author=#{author}," +
           /* "originAuthor=${originAuthor}," +
            "originUrl=#{originUrl}," +*/
            "tittle=#{tittle}," +
            "content=#{content}," +
            "tags=#{tags}," +
            "type=#{type}," +
            "summary=#{summary}," +
            "categories=#{categories}," +
            "createDate=#{createDate}" +
            " where id=#{id}")
    public Integer updateArtical(Artical artical);


    @Delete("delete from artical where id=#{id}")
    public Integer deleteArticalById(String id);

    @Insert("insert into artical(author,originAuthor,originUrl,tittle,content,imgpath,tags,navid,topicid,CATEGORIES,type,createDate,summary) values" +
            " (#{author},#{originAuthor},#{originUrl},#{tittle},#{content},#{imgpath},#{tags},#{navId},#{topicId},#{categories},#{type},#{createDate},#{summary})")
    public Integer addArtical(Artical artical);


}
