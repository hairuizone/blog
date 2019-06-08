package cn.hairui.blog.service;

import cn.hairui.blog.model.ArticalCategories;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/4 21:09
 */
public interface ArticalCategoriesService {

	/**
	 * 
	 * @Description 获取指定条数的是否要展示的信息
	 * @param isShow 是否展示
	 * @param maxSize 数量
	 * @return
	 */
    public List<ArticalCategories> qeuryArticalCategoriesByIsShow(String isShow, int maxSize);

    /**
     * 
     * @Description 查询所有分类
     * @return
     */
    public List<ArticalCategories> qeuryArticalCategoriesList();
}
