package cn.hairui.blog.service;

import cn.hairui.blog.model.Artical;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/4 16:50
 */
public interface ArticalService {

    public List<Artical> queryArticalListByNavId(Integer navId);//通过tab标签索引查找文章

    public List<Artical> queryArticalListByCategories(Integer categories);//通过分类号查询文章
}
