package cn.hairui.blog.service;

import cn.hairui.blog.model.NavIndex;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/4 14:59
 */
public interface NavIndexService {

    public NavIndex findNavIndexById(Integer id);

    public List<NavIndex> queryNavIndexList();
}
