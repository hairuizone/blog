package cn.hairui.blog.repository;

import cn.hairui.blog.mapper.ArticalCategoriesMapper;
import cn.hairui.blog.model.Artical;
import cn.hairui.blog.model.ArticalCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/9 13:14
 */
@Repository
public class ArticalCategoriesRepository {

    @Autowired
    private ArticalCategoriesMapper articalCategoriesMapper;

    public List<ArticalCategories> queryArticalCategoriesByIsShow(String isShow) {
        return articalCategoriesMapper.queryArticalCategoriesByIsShow(isShow);
    }

    public List<ArticalCategories> queryArticalCategoriesList() {
        return articalCategoriesMapper.queryArticalCategoriesList();
    }
}
