package cn.hairui.blog.service.impl;

import cn.hairui.blog.mapper.ArticalMapper;
import cn.hairui.blog.model.Artical;
import cn.hairui.blog.service.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<String> queryAllArticalTags() {

        List<String> result = new LinkedList<>();
        List<String> tags = articalMapper.queryAllArticalTags();
        for (String tag : tags
        ) {
            String[] args = tag.split("/");
            for (String arg : args
            ) {

                if (!result.contains(arg.replaceAll("#", ""))) {
                    result.add(arg.replaceAll("#", ""));
                }
            }
        }
        return result;
    }

    @Override
    public Artical queryArticalFirstByIntop(String intop) {
        return articalMapper.queryArticalFirstByIntop(intop);
    }

    @Override
    public List<Artical> queryArticalListHomePage() {
        return articalMapper.queryArticalListHomePage();
    }

    @Override
    public List<Artical> queryArticalListByCond(String type, String keywords) {
        return articalMapper.queryArticalListByCond(type,keywords);
    }
}
