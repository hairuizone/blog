package cn.hairui.blog.controller;

import cn.hairui.blog.model.Books;
import cn.hairui.blog.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/27 21:39
 */
@Controller

public class BooksController {

    @Autowired
    private BooksService booksService;

    @RequestMapping(value = "/manage/books-list")
    public String listBooks(Model model){
        List<Books> booksList = booksService.queryBooksList();
        model.addAttribute("booksList",booksList);
        return "background/books-list";

    }
}
