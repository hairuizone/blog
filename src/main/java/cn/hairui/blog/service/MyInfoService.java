package cn.hairui.blog.service;

import cn.hairui.blog.model.MyInfo;

/**
 * <p>
 * <h2>我的信息</h2>
 * <ol>请添加详细描述
 * </ol>
 * </p>
 *
 * @author lihairui
 * @version 1.0
 * @Date 2019年6月7日 下午12:46:28
 * @since jdk 1.8
 */
public interface MyInfoService {

    /**
     * @param id
     * @return
     * @Description 查询指定编号的信息
     */
    public MyInfo findMyInfoById(Integer id);

    /**
     * 更新我的信息
     * @param myInfo
     * @return
     */
    public int updateMyInfo(MyInfo myInfo);
}
