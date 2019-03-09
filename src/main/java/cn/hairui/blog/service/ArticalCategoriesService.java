package cn.hairui.blog.service;

import cn.hairui.blog.model.ArticalCategories;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/4 21:09
 */
public interface ArticalCategoriesService {

    public List<ArticalCategories> qeuryArticalCategoriesByIsShow(String isShow);

    public List<ArticalCategories> qeuryArticalCategoriesList();//查询所有分类
}
