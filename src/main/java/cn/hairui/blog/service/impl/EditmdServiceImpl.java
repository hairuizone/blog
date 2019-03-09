package cn.hairui.blog.service.impl;

import cn.hairui.blog.model.Editmd;
import cn.hairui.blog.repository.EditmdRepository;
import cn.hairui.blog.service.EditmdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/8 20:27
 */
@Service(value = "editmdService")
public class EditmdServiceImpl implements EditmdService {

    @Autowired
    private EditmdRepository editmdRepository;

    @Override
    public Editmd queryEditmdById(int id) {
        return editmdRepository.queryEditmdById(id);
    }

    @Override
    public void updateEditmd(Editmd editmd) {
        editmdRepository.updateEditmd(editmd);
    }
}
