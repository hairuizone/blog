package cn.hairui.blog.service.impl;

import cn.hairui.blog.mapper.ArticalCategoriesMapper;
import cn.hairui.blog.model.ArticalCategories;
import cn.hairui.blog.repository.ArticalCategoriesRepository;
import cn.hairui.blog.service.ArticalCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<ArticalCategories> qeuryArticalCategoriesByIsShow(String isShow) {
        return articalCategoriesRepository.queryArticalCategoriesByIsShow(isShow);
    }

    @Override
    public List<ArticalCategories> qeuryArticalCategoriesList() {
        return articalCategoriesRepository.queryArticalCategoriesList();
    }
}
