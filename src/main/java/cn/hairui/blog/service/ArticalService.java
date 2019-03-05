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

    public List<Artical> queryArticalListByCategories(Integer categories);//通过分类号查询文章

    public List<String> queryAllArticalTags();//查询标签集合

    public Artical queryArticalFirstByIntop(String intop);//查询置顶第一篇文章
}
