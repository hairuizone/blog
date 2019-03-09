package cn.hairui.blog.service;

import cn.hairui.blog.model.Editmd;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/8 20:26
 */
public interface EditmdService {

    public Editmd queryEditmdById(int id);

    public void updateEditmd(Editmd editmd);
}
