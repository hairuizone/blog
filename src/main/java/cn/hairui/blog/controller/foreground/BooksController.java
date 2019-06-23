package cn.hairui.blog.controller.foreground;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.Artical;
import cn.hairui.blog.model.Books;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.service.BooksService;
import cn.hairui.blog.service.MyInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/27 21:39
 */
@Controller

public class BooksController {
    @Autowired
    private MyInfoService myInfoService;

    @Autowired
    private BooksService booksService;

    @RequestMapping(value = "/books")
    public String showBooks(HttpServletRequest request, Model model){
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        //分页信息 文章信息
        Integer pageNum = null;
        String pageNumStr = request.getParameter("pageIndex");
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        System.out.println(pageNum);
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, 10);
        List<Books> books = booksService.queryBooksList();
        PageInfo<Books> pageInfo = new PageInfo<Books>(books);
        model.addAttribute("books", books);
        model.addAttribute("pageInfo", pageInfo);
        return "books";
    }
    @RequestMapping(value = "/books-view")
    public String bookDetails(String id) {
        if (id != null && !"null".equals(id)) {
            try {
                int idNo = Integer.parseInt(id);
                Books book = booksService.queryBooksDetialById(idNo);
                System.out.println(book.getLocalPath());
                String bookType = "pdf";
                if ("pdf".equals(bookType)) {
                    return "pdfviewer";
                } else {
                    return "chmviewer";
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "404";
            }

        } else {
            return "404";
        }
    }
}
