package cn.hairui.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.hairui.blog.model.Artical;

/**
 * @author laoganbu
 * @date: 2019/3/4 16:47
 */
@Mapper
public interface ArticalMapper {

    @Select("select * from artical where navId = #{navId} order by createDate desc , id desc")
    public List<Artical> queryArticalListByNavId(Integer navId);

    @Select("select * from artical where navId = #{navId} order by createDate desc , id desc limit #{count}")
    public List<Artical> queryArticalListByNavIdCount(Integer navId, int count);


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

    @Delete("delete from artical where id=#{id}")
    public Integer deleteArticalById(String id);

    @Insert("INSERT INTO ARTICAL(" +
            "AUTHOR," +
            "ORIGINAUTHOR," +
            "ORIGINURL," +
            "TITTLE," +
            "IMGPATH," +
            "CONTENT," +
            "TAGS," +
            "NAVID," +
            "TOPICID," +
            "CATEGORIES," +
            "TYPE," +
            "CREATEDATE," +
            "UPDATEDATE," +
            "ARTICALURL," +
            "SUMMARY," +
            "LIKENUMS," +
            "DISSNUMS" +
            "       ) VALUES(" +
            "#{author}," +
            "#{originAuthor}," +
            "#{originUrl}," +
            "#{tittle}," +
            "#{imgpath}," +
            "#{content}," +
            "#{tags}," +
            "#{navId}," +
            "#{topicId}," +
            "#{categories}," +
            "#{type}," +
            "#{createDate}," +
            "#{updateDate}," +
            "#{articalUrl}," +
            "#{summary}," +
            "#{likeNums}," +
            "#{dissNums}" +
            ")")
    public Integer addArtical(Artical artical);

    @Update("update artical set " +
            "tittle=#{tittle}," +
            "type=#{type}," +
            "originAuthor=#{originAuthor}," +
            "originUrl=#{originUrl}," +
            "updateDate=#{updateDate}," +
            "navId=#{navId}," +
            "topicId=#{topicId}," +
            "categories=#{categories}," +
            "content=#{content}," +
            "tags=#{tags}," +
            "summary=#{summary} " +
            " where id=#{id}")
    public Integer updateArtical(Artical artical);


}
