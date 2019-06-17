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

    @Override
    public int qeuryOnlineToolsByName(String toolName) {
        return onlineToolsMapper.queryOnlineToolsByName(toolName);
    }

    @Override
    public int addOnlineTools(OnlineTools onlineTools) {
        return onlineToolsMapper.addOnlineTools(onlineTools);
    }

    @Override
    public OnlineTools queryOnlineToolsById(int id) {
        return onlineToolsMapper.queryOnlineToolsById(id);
    }

    @Override
    public int updateOnlineTools(OnlineTools onlineTools) {
        return onlineToolsMapper.updateOnlineTools(onlineTools);
    }

    @Override
    public int deleteOnlineToolsById(String id) {
        return onlineToolsMapper.deleteOnlineToolsById(id);
    }

    @Override
    public List<OnlineTools> queryOnlineToolsListLimited(int maxSize) {
        return onlineToolsMapper.queryOnlineToolsListLimited(maxSize);
    }
}
