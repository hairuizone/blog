package cn.hairui.blog.service;

import cn.hairui.blog.model.Books;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/5 11:15
 */
public interface BooksService {

    /**
     * @return
     * @Description 获取所有书籍
     */
    public List<Books> queryBooksList();

    /**
     * @param maxSize 数量
     * @return
     * @Description 获取指定数量书籍
     */
    public List<Books> queryBooksListLimited(int maxSize);

    /**
     * 通过书籍名称查询书籍是否已经存在
     *
     * @param bookName
     * @return 查询结果数量
     */
    public int queryBooksDetialByBookName(String bookName);

    /**
     * 添加书籍
     *
     * @param books
     * @return
     */
    public int addBooks(Books books);

    /**
     * 删除指定书籍
     *
     * @param id
     * @return
     */
    public int deleteBooks(int id);

    /**
     * 通过书籍编号获取书籍信息
     *
     * @param id
     * @return
     */
    public Books queryBooksDetialById(int id);

}
