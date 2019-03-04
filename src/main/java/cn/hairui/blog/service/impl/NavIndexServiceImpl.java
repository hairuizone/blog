package cn.hairui.blog.service.impl;

import cn.hairui.blog.mapper.NavIndexMapper;
import cn.hairui.blog.model.NavIndex;
import cn.hairui.blog.service.NavIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/4 15:02
 */
@Service(value = "navIndexService")
public class NavIndexServiceImpl implements NavIndexService {

    @Autowired
    private NavIndexMapper navIndexMapper;

    @Override
    public NavIndex findNavIndexById(Integer id) {
        return navIndexMapper.findNavIndexById(id);
    }

    @Override
    public List<NavIndex> queryNavIndexList() {
        return navIndexMapper.queryNavIndexList();
    }

}
