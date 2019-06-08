package cn.hairui.blog.service;

import cn.hairui.blog.model.Books;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/5 11:15
 */
public interface BooksService {

	/**
	 * 
	 * @Description 获取所有书籍
	 * @return
	 */
    public List<Books> queryBooksList();

    /**
     * 
     * @Description 获取指定数量书籍
     * @param maxSize 数量
     * @return
     */
	public List<Books> queryBooksListLimited(int maxSize);
}
