package cn.hairui.blog.service;

import cn.hairui.blog.model.Artical;

import java.util.List;
import java.util.Map;

/**
 * @author laoganbu
 * @date: 2019/3/4 16:50
 */
public interface ArticalService {

    public List<Artical> queryArticalListByNavId(Integer navId);//通过tab标签索引查找文章
    public List<Artical> queryArticalListByNavId(Integer navId,int count);//通过tab标签索引查找文章 指定条数

    public List<Artical> queryArticalListByCategories(Integer categories);//通过分类号查询文章
    public List<Artical> queryArticalListByCategories(Integer categories,int count);//通过分类号查询文章 指定条数

    public List<String> queryAllArticalTags();//查询标签集合

    public Artical queryArticalFirstByIntop(String intop);//查询置顶第一篇文章

    public List<Artical> queryArticalListHomePage();//查询首页显示的前10篇文章

    public List<Artical> queryArticalListByCond(String type,String keywords);//通过类型和搜索关键字查询文章集合

    public Artical queryArticalDetailById(Integer id);//根据编号查询文章详细信息

    public Integer updateArtical(Artical artical);//更新文章

    public Integer deleteArticalById(String id);//根据编号删除文章

    public Integer addArtical(Artical artical);//新增文章
}
