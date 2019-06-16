package cn.hairui.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hairui.blog.model.ArticalCategories;
import cn.hairui.blog.repository.ArticalCategoriesRepository;
import cn.hairui.blog.service.ArticalCategoriesService;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/4 21:09
 */
@Service(value = "articalCategoriesService")
public class ArticalCategoriesServiceImpl implements ArticalCategoriesService {

    @Autowired
    private ArticalCategoriesRepository articalCategoriesRepository;

    @Override
    public List<ArticalCategories> qeuryArticalCategoriesByIsShow(String isShow,int maxSize) {
        return articalCategoriesRepository.queryArticalCategoriesByIsShow(isShow,maxSize);
    }

    @Override
    public List<ArticalCategories> qeuryArticalCategoriesList() {
        return articalCategoriesRepository.queryArticalCategoriesList();
    }

    @Override
    public int addArticalCategories(ArticalCategories articalCategories) {
        return articalCategoriesRepository.addArticalCategories(articalCategories);
    }

    @Override
    public int qeuryArticalCategoriesByName(String categoryName) {
        return articalCategoriesRepository.qeuryArticalCategoriesByName(categoryName);
    }

    @Override
    public Integer queryArticalCategoriesMaxShowOrder() {
        return articalCategoriesRepository.queryArticalCategoriesMaxShowOrder();
    }

    @Override
    public ArticalCategories queryArticalCategoriesDetailById(Integer id) {
        return articalCategoriesRepository.queryArticalCategoriesDetailById(id);
    }

    @Override
    public int updateArticalCategories(ArticalCategories articalCategories) {
        return articalCategoriesRepository.updateArticalCategories(articalCategories);
    }

    @Override
    public int deleteArticalCategoriesData(int id) {
        return articalCategoriesRepository.deleteArticalCategoriesData(id);
    }
}
