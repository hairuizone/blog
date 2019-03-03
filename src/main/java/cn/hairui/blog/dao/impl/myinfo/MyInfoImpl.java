package cn.hairui.blog.dao.impl.myinfo;

import cn.hairui.blog.dao.myinfo.MyInfoDao;
import cn.hairui.blog.model.myinfo.MyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/3 21:46
 */
@Repository(value = "myInfoDao")
public class MyInfoImpl implements MyInfoDao {

    @Override
    public MyInfo find(int pk) {
        return null;
    }
}
