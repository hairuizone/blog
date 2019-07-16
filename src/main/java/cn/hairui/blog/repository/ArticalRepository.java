package cn.hairui.blog.repository;

import cn.hairui.blog.mapper.ArticalMapper;
import cn.hairui.blog.model.Artical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    public List<Artical> queryArticalListByNavId(Integer navId, int count) {
        return articalMapper.queryArticalListByNavIdCount(navId, count);
    }


    public List<Artical> queryArticalListByCategories(Integer categories) {
        return articalMapper.queryArticalListByCategories(categories);
    }

    public List<Artical> queryArticalListByCategories(Integer categories, int count) {
        return articalMapper.queryArticalListByCategoriesCount(categories, count);
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

    public List<String> queryArticalTagsLimited(int maxSize) {
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
        if (result.size() > maxSize) {
            result = result.subList(0, maxSize);
        }
        return result;
    }

    public int queryArticalsCountByArticalCategorie(Integer id) {
        return articalMapper.queryArticalsCountByArticalCategorie(id);
    }

    public int cleanArticalTopics(int id) {
        return articalMapper.cleanArticalTopics(id);
    }

    public Integer updateArticalMarkdown(Artical artical) {
        return articalMapper.updateArticalMarkdown(artical);
    }

    public Integer getMaxArticalId() {
        return articalMapper.getMaxArticalId();
    }

    public String queryArticalCategoriesNameById(Integer categoriesId) {
        return articalMapper.queryArticalCategoriesNameById(categoriesId);
    }

    public List<Artical> queryArticalList() {
        return articalMapper.queryArticalList();
    }

    public List<Artical> queryArticalsByCategoriesId(int categoriesId) {
        return articalMapper.queryArticalsByCategoriesId(categoriesId);
    }

    public List<Map> queryArticalArchivesList() {
        return articalMapper.queryArticalArchivesList();
    }

    public List<Artical> queryArticalsByCreateDateYm(String dateStr) {
        return articalMapper.queryArticalsByCreateDateYm(dateStr);
    }

    public List<Map> queryArticalTopicsList() {
        return articalMapper.queryArticalTopicsList();
    }

    public List<Artical> queryArticalsByTopicId(Integer id) {
        return articalMapper.queryArticalsByTopicId(id);
    }

    public List<Artical> queryArticalInTopicList() {
        return articalMapper.queryArticalInTopicList();
    }

    public int queryArticalsCountByTagName(String tagName) {
        return articalMapper.queryArticalsCountByTagName(tagName);
    }

    public List<Artical> queryArticalsByTagName(String tag) {
        return articalMapper.queryArticalsByTagName(tag);
    }
}
