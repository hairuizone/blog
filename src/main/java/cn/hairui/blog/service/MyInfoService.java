package cn.hairui.blog.service;

import cn.hairui.blog.model.MyInfo;

/**
 * 
 *<p>
 *<h2>我的信息</h2>
 *<ol>请添加详细描述
 *</ol>
 *</p>
 *@author lihairui     
 *@Date 2019年6月7日 下午12:46:28   
 *@version 1.0 
 *@since jdk 1.8
 */
public interface MyInfoService {

	/**
	 * 
	 * @Description 查询指定编号的信息
	 * @param id
	 * @return
	 */
    public MyInfo findMyInfoById(Integer id);
}
