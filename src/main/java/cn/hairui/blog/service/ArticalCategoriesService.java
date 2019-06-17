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

	/**
	 *
	 * @param articalCategories
	 * @return 插入分类编号
	 */
	public int addArticalCategories(ArticalCategories articalCategories);

	/**
	 * 通过分类名称查询该分类是否已经存在
	 * @param categoryName
	 * @return 返回分类名称对应的分类数量
	 */
	public int qeuryArticalCategoriesByName(String categoryName);

	/**
	 * 获取当前最大排序编号
	 * @return
	 */
	public Integer queryArticalCategoriesMaxShowOrder();

	/**
	 * 根据编号查询分类信息
	 * @param id
	 * @return
	 */
    public ArticalCategories queryArticalCategoriesDetailById(Integer id);

	public int updateArticalCategories(ArticalCategories articalCategories);

	/**
	 * 根据分类编号删除分类信息
	 * @param id
	 * @return
	 */
    public int deleteArticalCategoriesData(int id);

	/**
	 * 获取当前数据库中最大编号文章
	 * @return
	 */
	public Integer queryMaxArticalCategoriesId();

	/**
	 * 将所有的分类的展示顺序向后挪动一位
	 */
	public void moveArticalCategoriesOrderNextOne();
}
