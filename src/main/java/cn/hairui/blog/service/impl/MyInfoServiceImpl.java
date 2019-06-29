package cn.hairui.blog.service.impl;

import cn.hairui.blog.mapper.MyInfoMapper;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.service.MyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author laoganbu
 * @date: 2019/3/4 11:34
 */
@Service("myInfoService")
public class MyInfoServiceImpl implements MyInfoService {

    @Autowired
    private MyInfoMapper myInfoMapper;

    @Override
    public MyInfo findMyInfoById(Integer id) {
        return myInfoMapper.findMyInfoById(id);
    }

    @Override
    public int updateMyInfo(MyInfo myInfo) {
        return myInfoMapper.updateMyInfo(myInfo);
    }
}
