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

    @Select("SELECT * FROM BOOKS ORDER BY ID DESC")
    public List<Books> queryBooksList();

    @Select("SELECT * FROM BOOKS LIMIT 0,#{maxSize}")
    public List<Books> queryBooksListLimited(int maxSize);

    @Select("SELECT COUNT(1) FROM BOOKS WHERE BOOK_NAME=#{bookName}")
    public int queryBooksDetialByBookName(String bookName);

    @Insert("INSERT INTO BOOKS(BOOK_NAME,AUTHOR,PUBLISH_DATE,LOCAL_PATH,ADD_DATE) value(#{bookName},#{author},#{publishDate},#{localPath},#{addDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")//加入该注解可以保持对象后，查看对象插入id
    public int addBooks(Books books);

    @Delete("DELETE FROM BOOKS WHERE ID=#{id}")
    public int deleteBooks(int id);

    @Select("SELECT * FROM BOOKS WHERE ID=#{id}")
    public Books queryBooksDetialById(int id);

}
