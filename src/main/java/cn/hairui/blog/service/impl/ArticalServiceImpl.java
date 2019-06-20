package cn.hairui.blog.service.impl;

import java.util.List;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hairui.blog.model.Artical;
import cn.hairui.blog.repository.ArticalRepository;
import cn.hairui.blog.service.ArticalService;

/**
 * @author laoganbu
 * @date: 2019/3/4 16:51
 */
@Service(value = "articalService")
public class ArticalServiceImpl implements ArticalService {

    @Autowired
    private ArticalRepository articalRepository;

    @Override
    public List<Artical> queryArticalListByNavId(Integer navId) {
        return articalRepository.queryArticalListByNavId(navId);
    }

    @Override
    public List<Artical> queryArticalListByNavId(Integer navId, int count) {
        return articalRepository.queryArticalListByNavId(navId,count);
    }

    @Override
    public List<Artical> queryArticalListByCategories(Integer categories) {
        return articalRepository.queryArticalListByCategories(categories);
    }

    @Override
    public List<Artical> queryArticalListByCategories(Integer categories, int count) {
        return articalRepository.queryArticalListByCategories(categories,count);
    }

    @Override
    public List<String> queryAllArticalTags() {
        return articalRepository.queryAllArticalTags();
    }

    @Override
    public Artical queryArticalFirstByIntop(String intop) {
        return articalRepository.queryArticalFirstByIntop(intop);
    }

    @Override
    public List<Artical> queryArticalListHomePage() {
        return articalRepository.queryArticalListHomePage();
    }

    @Override
    public List<Artical> queryArticalListByCond(String type, String keywords) {
        return articalRepository.queryArticalListByCond(type, keywords);
    }

    @Override
    public Artical queryArticalDetailById(Integer id) {
        return articalRepository.queryArticalDetailById(id);
    }

    @Override
    public Integer updateArtical(Artical artical) {
        return articalRepository.updateArtical(artical);
    }

    @Override
    public Integer deleteArticalById(String id) {
        return articalRepository.deleteArticalById(id);
    }

    @Override
    public Integer addArtical(Artical artical) {
        return articalRepository.addArtical(artical);
    }

    @Override
    public int queryArticalsCountByArticalCategorie(Integer id) {
        return articalRepository.queryArticalsCountByArticalCategorie(id);
    }

    @Override
    public int cleanArticalTopics(int id) {
        return articalRepository.cleanArticalTopics(id);
    }

    @Override
    public Integer updateArticalMarkdown(Artical artical) {
        return articalRepository.updateArticalMarkdown(artical);
    }

    @Override
    public Integer getMaxArticalId() {
        return articalRepository.getMaxArticalId();
    }

    @Override
    public String queryArticalCategoriesNameById(Integer categoriesId) {
        return articalRepository.queryArticalCategoriesNameById(categoriesId);
    }

    @Override
    public List<Artical> getAll() {
        return articalRepository.getAll();
    }

    @Override
	public List<String> queryAllArticalTagsLimited(int maxSize) {
		return articalRepository.queryArticalTagsLimited(maxSize);
	}
}
