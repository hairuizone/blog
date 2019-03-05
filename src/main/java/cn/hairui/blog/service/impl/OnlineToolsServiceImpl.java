package cn.hairui.blog.service.impl;

import cn.hairui.blog.mapper.OnlineToolsMapper;
import cn.hairui.blog.model.OnlineTools;
import cn.hairui.blog.service.OnlineToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/5 11:54
 */
@Service(value = "onlineToolsService")
public class OnlineToolsServiceImpl implements OnlineToolsService {

    @Autowired
    private OnlineToolsMapper onlineToolsMapper;

    @Override
    public List<OnlineTools> queryOnlineToolsList() {
        return onlineToolsMapper.queryOnlineToolsList();
    }
}
