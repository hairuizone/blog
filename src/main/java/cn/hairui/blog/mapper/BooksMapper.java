package cn.hairui.blog.mapper;

import cn.hairui.blog.model.Books;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/5 11:13
 */
@Mapper
public interface BooksMapper {

    @Select("select * from books")
    public List<Books> queryBooksList();//查询所有书籍信息
    @Select("select * from books limit 0,#{maxSize}")
    public List<Books> queryBooksListLimited(int maxSize);
    @Select("select count(1) from books where BOOK_NAME=#{bookName}")
    public int queryBooksDetialByBookName(String bookName);


    @Insert("insert into books(BOOK_NAME,AUTHOR,PUBLISH_DATE,LOCAL_PATH,ADD_DATE) value(#{bookName},#{author},#{publishDate},#{localPath},#{addDate})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")//加入该注解可以保持对象后，查看对象插入id
    public int addBooks(Books books);

    @Delete("delete from books where id=#{id}")
    public int deleteBooks(int id);

    @Select("select * from books where id=#{id}")
    public Books queryBooksDetialById(int id);
}
