package cn.hairui.blog.service.impl;

import cn.hairui.blog.mapper.ArticalMapper;
import cn.hairui.blog.model.Artical;
import cn.hairui.blog.service.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/4 16:51
 */
@Service(value = "articalService")
public class ArticalServiceImpl implements ArticalService {

    @Autowired
    private ArticalMapper articalMapper;

    @Override
    public List<Artical> queryArticalListByNavId(Integer navId) {
        return articalMapper.queryArticalListByNavId(navId);
    }

    @Override
    public List<Artical> queryArticalListByCategories(Integer categories) {
        return articalMapper.queryArticalListByCategories(categories);
    }
}
