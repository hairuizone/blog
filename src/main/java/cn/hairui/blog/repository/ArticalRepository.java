package cn.hairui.blog.repository;

import cn.hairui.blog.mapper.ArticalMapper;
import cn.hairui.blog.model.Artical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/9 2:54
 */
@Repository
public class ArticalRepository {

    @Autowired
    private ArticalMapper articalMapper;


    public List<Artical> queryArticalListByNavId(Integer navId) {
        return articalMapper.queryArticalListByNavId(navId);
    }

    public List<Artical> queryArticalListByNavId(Integer navId,int count) {
        return articalMapper.queryArticalListByNavIdCount(navId,count);
    }


    public List<Artical> queryArticalListByCategories(Integer categories) {
        return articalMapper.queryArticalListByCategories(categories);
    }
    public List<Artical> queryArticalListByCategories(Integer categories,int count) {
        return articalMapper.queryArticalListByCategoriesCount(categories,count);
    }


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


    public Artical queryArticalFirstByIntop(String intop) {
        return articalMapper.queryArticalFirstByIntop(intop);
    }


    public List<Artical> queryArticalListHomePage() {
        return articalMapper.queryArticalListHomePage();
    }


    public List<Artical> queryArticalListByCond(String type, String keywords) {
        return articalMapper.queryArticalListByCond(type, keywords);
    }

    public Artical queryArticalDetailById(Integer id) {
        return articalMapper.queryArticalDetailById(id);
    }

    public Integer updateArtical(Artical artical) {
        return articalMapper.updateArtical(artical);
    }

    public Integer deleteArticalById(String id) {
        return articalMapper.deleteArticalById(id);
    }

    public Integer addArtical(Artical artical) {
        return articalMapper.addArtical(artical);
    }
}
