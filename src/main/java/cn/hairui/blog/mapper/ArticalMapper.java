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

    @Select("SELECT * FROM ARTICAL WHERE NAVID = #{navId} ORDER BY CREATEDATE DESC , ID DESC")
    public List<Artical> queryArticalListByNavId(Integer navId);

    @Select("SELECT * FROM ARTICAL WHERE NAVID = #{navId} ORDER BY CREATEDATE DESC , ID DESC LIMIT #{count}")
    public List<Artical> queryArticalListByNavIdCount(Integer navId, int count);


    @Select("SELECT * FROM ARTICAL WHERE CATEGORIES = #{categories} ORDER BY CREATEDATE DESC")
    public List<Artical> queryArticalListByCategories(Integer categories);

    @Select("SELECT * FROM ARTICAL WHERE CATEGORIES = #{categories} ORDER BY CREATEDATE DESC LIMIT #{count}")
    List<Artical> queryArticalListByCategoriesCount(Integer categories, int count);

    @Select("SELECT DISTINCT TAGS FROM ARTICAL WHERE TAGS IS NOT NULL AND tags != ''")
    public List<String> queryAllArticalTags();

    @Select("SELECT * FROM ARTICAL WHERE INTOP=#{intop} ORDER BY CREATEDATE DESC LIMIT 1")
    public Artical queryArticalFirstByIntop(String intop);

    @Select("SELECT * FROM ARTICAL ORDER BY CREATEDATE DESC,ID DESC LIMIT 10")
    public List<Artical> queryArticalListHomePage();

    @Select("SELECT * FROM ARTICAL ORDER BY CREATEDATE DESC,ID DESC LIMIT 6")
    public List<Artical> queryArticalListByCond(String type, String keywords);

    @Select("SELECT * FROM ARTICAL WHERE ID=#{id}")
    public Artical queryArticalDetailById(Integer id);

    @Delete("DELETE FROM ARTICAL WHERE ID=#{id}")
    public Integer deleteArticalById(String id);

    @Insert("INSERT INTO ARTICAL(" +
            "ID," +
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
            "#{id}," +
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

    @Update("UPDATE ARTICAL SET " +
            "TITTLE=#{tittle}," +
            "TYPE=#{type}," +
            "ORIGINAUTHOR=#{originAuthor}," +
            "ORIGINURL=#{originUrl}," +
            "UPDATEDATE=#{updateDate}," +
            "NAVID=#{navId}," +
            "TOPICID=#{topicId}," +
            "CATEGORIES=#{categories}," +
            "CONTENT=#{content}," +
            "TAGS=#{tags}," +
            "SUMMARY=#{summary} " +
            " WHERE ID=#{id}")
    public Integer updateArtical(Artical artical);


    @Select("SELECT COUNT(1) FROM ARTICAL WHERE CATEGORIES=#{id}")
    public int queryArticalsCountByArticalCategorie(Integer id);

    @Update("UPDATE ARTICAL SET TOPICID=NULL WHERE TOPICID=#{id}")
    public int cleanArticalTopics(int id);

    @Update("UPDATE ARTICAL SET CONTENT=#{content} WHERE ID=#{id}")
    public Integer updateArticalMarkdown(Artical artical);

    @Select("SELECT MAX(ID) FROM ARTICAL")
    public Integer getMaxArticalId();

    @Select("SELECT CATEGORY_NAME FROM ARTICAL_CATEGORIES WHERE ID=#{categoriesId}")
    public String queryArticalCategoriesNameById(Integer categoriesId);

    @Select("SELECT * FROM ARTICAL ORDER BY ID DESC")
    public List<Artical> queryArticalList();

    @Select("SELECT * FROM ARTICAL WHERE CATEGORIES=#{categoriesId} ORDER BY ID DESC")
    public List<Artical> queryArticalsByCategoriesId(int categoriesId);

    @Select("SELECT date_format(CREATEDATE, '%Y-%m') AS CREATEDATE,COUNT(1) AS NUM FROM ARTICAL GROUP BY date_format(CREATEDATE, '%Y-%m') ORDER BY CREATEDATE DESC")
    public List<Map> queryArticalArchivesList();

    @Select("SELECT * FROM ARTICAL WHERE CREATEDATE LIKE CONCAT(#{dateStr},'%') ORDER BY CREATEDATE DESC")
    public List<Artical> queryArticalsByCreateDateYm(String dateStr);
}
