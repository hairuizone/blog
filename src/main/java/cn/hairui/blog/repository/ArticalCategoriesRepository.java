package cn.hairui.blog.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.hairui.blog.mapper.ArticalCategoriesMapper;
import cn.hairui.blog.model.ArticalCategories;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/9 13:14
 */
@Repository
public class ArticalCategoriesRepository {

    @Autowired
    private ArticalCategoriesMapper articalCategoriesMapper;

    public List<ArticalCategories> queryArticalCategoriesByIsShow(String isShow,int maxSize) {
        return articalCategoriesMapper.queryArticalCategoriesByIsShow(isShow,maxSize);
    }

    public List<ArticalCategories> queryArticalCategoriesList() {
        return articalCategoriesMapper.queryArticalCategoriesList();
    }

    public int addArticalCategories(ArticalCategories articalCategories) {
        int id = 0;
        try {
            id = articalCategoriesMapper.addArticalCategories(articalCategories);
            return id;
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public int qeuryArticalCategoriesByName(String categoryName) {
        return articalCategoriesMapper.qeuryArticalCategoriesByName(categoryName);
    }

    public Integer queryArticalCategoriesMaxShowOrder() {
        return articalCategoriesMapper.queryArticalCategoriesMaxShowOrder();
    }

    public ArticalCategories queryArticalCategoriesDetailById(Integer id) {
        return articalCategoriesMapper.queryArticalCategoriesDetailById(id);
    }

    public int updateArticalCategories(ArticalCategories articalCategories) {
        return articalCategoriesMapper.updateArticalCategories(articalCategories);
    }

    public int deleteArticalCategoriesData(int id) {
       return articalCategoriesMapper.deleteArticalCategoriesData(id);
    }

    public Integer queryMaxArticalCategoriesId() {
        return articalCategoriesMapper.queryMaxArticalCategoriesId();
    }

    public void moveArticalCategoriesOrderNextOne() {
        articalCategoriesMapper.moveArticalCategoriesOrderNextOne();
    }
}
