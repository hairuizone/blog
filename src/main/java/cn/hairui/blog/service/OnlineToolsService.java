package cn.hairui.blog.service;

import cn.hairui.blog.model.OnlineTools;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/5 11:54
 */
public interface OnlineToolsService {

    public List<OnlineTools> queryOnlineToolsList();//查询所有工具集合

    /**
     * 通过名称查询工具数量
     *
     * @param toolName
     * @return 数量
     */
    public int qeuryOnlineToolsByName(String toolName);

    /**
     * 添加工具
     *
     * @param onlineTools
     * @return
     */
    public int addOnlineTools(OnlineTools onlineTools);

    /**
     * 通过编号查询在线工具信息
     *
     * @param id
     * @return 在线工具详细信息
     */
    public OnlineTools queryOnlineToolsById(int id);

    /**
     * 更新工具信息
     *
     * @param onlineTools
     * @return
     */
    public int updateOnlineTools(OnlineTools onlineTools);

    /**
     * 通过编号删除工具
     *
     * @param id
     * @return
     */
    public int deleteOnlineToolsById(String id);

    /**
     * 读取指定数量的工具
     *
     * @param maxShowTools
     * @return
     */
    public List<OnlineTools> queryOnlineToolsListLimited(int maxShowTools);
}
