package cn.hairui.blog.controller;

import cn.hairui.blog.model.ArticalCategories;
import cn.hairui.blog.service.ArticalCategoriesService;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/27 20:22
 */
@Controller
public class ArticalCategoriesController {

    @Autowired
    private ArticalCategoriesService articalCategoriesService;

    @RequestMapping(value = "/manage/categories-list")
    public String listArticalCategories(Model model){
        List<ArticalCategories> articalCategoriesList =  articalCategoriesService.qeuryArticalCategoriesList();
        model.addAttribute("articalCategoriesList",articalCategoriesList);
        return "background/categories-list";
    }

    @RequestMapping(value = "/manage/categories-add")
    public String addArticalCategories(){
        return "background/categories-add";
    }

    @RequestMapping(value = "/manage/categories-adddata",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String addArticalCategoriesData(@ModelAttribute ArticalCategories articalCategories){
        Map map = new HashMap();
        //插入之前查询分类名称是否已经存在
        int count = articalCategoriesService.qeuryArticalCategoriesByName(articalCategories.getCategoryName());
        if(count > 0){
            map.put("flag","error");
            map.put("message","分类名称重复");
        }else{

            Integer max = articalCategoriesService.queryMaxArticalCategoriesId();
            if(max == null){
                max = 0;
            }
            int nextId = max + 1;
            articalCategories.setId(nextId);
            String isShow = articalCategories.getIsShow();
            if("Y".equals(isShow)){
                //首页展示 获取当前最大展示序号
                System.out.println(articalCategories.getShowOrder());
                Integer maxSerno = articalCategoriesService.queryArticalCategoriesMaxShowOrder();
                if(maxSerno == null){
                    maxSerno = 0 ;
                }
                if(articalCategories.getShowOrder() == 1){
                    //置顶展示 需要将当前的排序编号全部后移+1
                    articalCategoriesService.moveArticalCategoriesOrderNextOne();
                    articalCategories.setShowOrder(1);//将置顶展示的顺序设置为1

                }else if(articalCategories.getShowOrder() == 0){
                    //追加展示 设置当前分类编号为maxSerno+1
                    articalCategories.setShowOrder(maxSerno+1);

                }

            }else{
                //首页不展示
                articalCategories.setShowOrder(null);
            }

            //新增分类默认文章数量为0
            articalCategories.setArticalCount(0);
            int id = articalCategoriesService.addArticalCategories(articalCategories);
            map.put("flag","success");
        }
        return JSONUtils.toJSONString(map);
    }

    @RequestMapping(value = "/manage/categories-update")
    public String updateArticalCategories(Integer id,Model model){
        ArticalCategories articalCategories = articalCategoriesService.queryArticalCategoriesDetailById(id);
        model.addAttribute("articalCategories", articalCategories);
        return "background/categories-update";
    }

    @RequestMapping(value = "/manage/categories-updatedata",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String updateArticalCategoriesData(@ModelAttribute ArticalCategories articalCategories){
        Map map = new HashMap();


        String isShow = articalCategories.getIsShow();
        if("Y".equals(isShow)){
            //首页展示 获取当前最大展示序号
            int maxSerno = articalCategoriesService.queryArticalCategoriesMaxShowOrder();

            if(articalCategories.getShowOrder() == 1){
                //置顶展示 需要将当前的排序编号全部后移+1

            }else if(articalCategories.getShowOrder() == 0){
                //追加展示 设置当前分类编号为maxSerno+1
                articalCategories.setShowOrder(maxSerno+1);
            }

        }else{
            //首页不展示
            articalCategories.setShowOrder(null);
        }

        int id = articalCategoriesService.updateArticalCategories(articalCategories);
        map.put("flag","success");
        return JSONUtils.toJSONString(map);
    }




    @RequestMapping(value = "/manage/categories-delete",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String deleteArticalCategoriesData(int id, HttpServletRequest httpServletRequest){
        Map map = new HashMap();
        Integer num = articalCategoriesService.deleteArticalCategoriesData(id);
        if(num == 1){
            map.put("flag", "success");
        }else{
            map.put("flag", "failed");
        }
        return JSONUtils.toJSONString(map);
    }


}
