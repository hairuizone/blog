package cn.hairui.blog.repository;

import cn.hairui.blog.mapper.EditmdMapper;
import cn.hairui.blog.model.Editmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/8 20:54
 */
@Repository
public class EditmdRepository {

    @Autowired
    private EditmdMapper editmdMapper;

    public Editmd queryEditmdById(int id){
        return editmdMapper.queryEditmdById(id);
    }

    public void updateEditmd(Editmd editmd) {
        editmdMapper.updateEditmd(editmd);
    }
}
