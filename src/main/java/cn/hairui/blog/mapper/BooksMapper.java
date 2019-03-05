package cn.hairui.blog.mapper;

import cn.hairui.blog.model.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/5 11:13
 */
@Mapper
public interface BooksMapper {

    @Select("select * from books")
    public List<Books> queryBooksList();//查询所有书籍信息
}
