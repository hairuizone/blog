package cn.hairui.blog.service.impl;

import cn.hairui.blog.mapper.BooksMapper;
import cn.hairui.blog.model.Books;
import cn.hairui.blog.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/5 11:15
 */
@Service(value = "booksService")
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksMapper booksMapper;
    @Override
    public List<Books> queryBooksList() {
        return booksMapper.queryBooksList();
    }
}
