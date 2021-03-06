package cn.hairui.blog.service;

import cn.hairui.blog.model.Artical;

import java.util.List;
import java.util.Map;

/**
 * @author laoganbu
 * @date: 2019/3/4 16:50
 */
public interface ArticalService {

    /**
     * 通过tab标签索引查找文章
     *
     * @param navId
     * @return
     */
    public List<Artical> queryArticalListByNavId(Integer navId);

    /**
     * 通过tab标签索引查找文章 指定条数
     *
     * @param navId
     * @param count
     * @return
     */
    public List<Artical> queryArticalListByNavId(Integer navId, int count);

    /**
     * 通过分类号查询文章
     *
     * @param categories
     * @return
     */
    public List<Artical> queryArticalListByCategories(Integer categories);

    /**
     * 通过分类号查询文章 指定条数
     *
     * @param categories
     * @param count
     * @return
     */
    public List<Artical> queryArticalListByCategories(Integer categories, int count);

    /**
     * @return
     * @Description 查询所有标签集合
     */
    public List<String> queryAllArticalTags();

    /**
     * @param maxSize 数量
     * @return
     * @Description 查询标签集合并展示指定数量
     */
    public List<String> queryAllArticalTagsLimited(int maxSize);

    /**
     * 查询置顶第一篇文章
     *
     * @param intop
     * @return
     */
    public Artical queryArticalFirstByIntop(String intop);

    public List<Artical> queryArticalListHomePage();//查询首页显示的前10篇文章

    /**
     * 通过类型和搜索关键字查询文章集合
     *
     * @param type
     * @param keywords
     * @return
     */
    public List<Artical> queryArticalListByCond(String type, String keywords);

    /**
     * 根据编号查询文章详细信息
     *
     * @param id
     * @return
     */
    public Artical queryArticalDetailById(Integer id);

    /**
     * 更新文章
     *
     * @param artical
     * @return
     */
    public Integer updateArtical(Artical artical);

    /**
     * 根据编号删除文章
     *
     * @param id
     * @return
     */
    public Integer deleteArticalById(String id);

    /**
     * 新增文章
     *
     * @param artical
     * @return
     */
    public Integer addArtical(Artical artical);

    /**
     * 通过分类编号查询文章数量
     *
     * @param id
     * @return
     */
    public int queryArticalsCountByArticalCategorie(Integer id);

    /**
     * 将传递的专题编号清空
     *
     * @param id
     * @return
     */
    public int cleanArticalTopics(int id);

    public Integer updateArticalMarkdown(Artical artical);

    /**
     * 获取当前数据库中最大编号文章
     *
     * @return
     */
    public Integer getMaxArticalId();

    /**
     * 通过分类编号查询分类名称
     *
     * @param categoriesId
     * @return
     */
    public String queryArticalCategoriesNameById(Integer categoriesId);

    /**
     * 查询所有文章
     *
     * @return
     */
    public List<Artical> queryArticalList();

    /**
     * 查詢分类编号下面的所有的文章
     *
     * @param categoriesId
     * @return
     */
    public List<Artical> queryArticalsByCategoriesId(int categoriesId);

    /**
     * 归档形式统计所有文章
     *
     * @return
     */
    public List<Map> queryArticalArchivesList();

    /**
     * 通过年月查询文章信息
     *
     * @param dateStr
     * @return
     */
    public List<Artical> queryArticalsByCreateDateYm(String dateStr);

    /**
     * 专题形式统计所有文章
     *
     * @return
     */
    public List<Map> queryArticalTopicsList();

    /**
     * 获取专题下所有文章
     *
     * @param id
     * @return
     */
    public List<Artical> queryArticalsByTopicId(Integer id);


    /**
     * 获取专题下的所有文章
     *
     * @return
     */
    public List<Artical> queryArticalInTopicList();

    /**
     * 查询标签对应的文章数量
     *
     * @param tagName
     * @return
     */
    public int queryArticalsCountByTagName(String tagName);

    /**
     * 查询标签下的文章
     *
     * @param tag
     * @return
     */
    public List<Artical> queryArticalsByTagName(String tag);
}
