package cn.hairui.blog.controller.background;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.Artical;
import cn.hairui.blog.model.Books;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.service.BooksService;
import cn.hairui.blog.service.MyInfoService;
import cn.hairui.blog.util.FileUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/27 21:39
 */
@Controller
@RequestMapping("/manage")
public class BooksManageController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private MyInfoService myInfoService;
    private String listPage = PubConstant.BACKGROUND_DIR_NAME + "books-list";//列表页面
    private String addPage = PubConstant.BACKGROUND_DIR_NAME + "books-add";//新增页面

    @RequestMapping(value = "/books-list")
    public String listBooks(HttpServletRequest request,Model model) {

        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);

        Integer pageNum = null;
        String pageNumStr = request.getParameter("pageIndex");
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, 5);
        List<Books> booksList = booksService.queryBooksList();
        PageInfo<Books> pageInfo = new PageInfo<Books>(booksList);


        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("booksList", booksList);
        return listPage;
    }

    @RequestMapping(value = "/books-add")
    public String addBooks(Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        return addPage;
    }

    @RequestMapping(value = "/books-adddata")
    @ResponseBody
    public String addBooks(HttpServletRequest request, String bookName, String Author, String publishDate) throws IOException {
        Map map = new HashMap();
        String path = "";
        int num = booksService.queryBooksDetialByBookName(bookName);
        if (num >= 1) {
            map.put(PubConstant.flag, PubConstant.failed);
            map.put(PubConstant.message, "该名称对应的书籍已经存在");

        } else {
            //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //检查form中是否有enctype="multipart/form-data"
            if (multipartResolver.isMultipart(request)) {
                //将request变成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                //获取multiRequest 中所有的文件名
                Iterator iter = multiRequest.getFileNames();
                while (iter.hasNext()) {
                    //一次遍历所有文件
                    MultipartFile file = multiRequest.getFile(iter.next().toString());
                    if (file != null) {
                        path = "E:/myblog/" + file.getOriginalFilename();
                        //上传
                        file.transferTo(new File(path));
                    }
                }
            }
            Books books = new Books();
            books.setBookName(bookName);
            books.setAuthor(Author);
            books.setPublishDate(publishDate);
            books.setLocalPath(path);

            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String openday = df.format(date);
            books.setAddDate(openday);
            try {
                int n = booksService.addBooks(books);
                if (n == 1) {
                    map.put(PubConstant.flag, PubConstant.success);
                } else {
                    map.put(PubConstant.flag, PubConstant.failed);
                    map.put(PubConstant.message, "保存到数据库出现异常");
                }
            } catch (Exception e) {
                e.printStackTrace();
                map.put(PubConstant.flag, PubConstant.failed);
                map.put(PubConstant.message, e.toString());
            }
        }
        return JSONUtils.toJSONString(map);

    }

    @RequestMapping(value = "/books-delete", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String deleteBooks(int id) {
        Map map = new HashMap();
        try {
            Books books = booksService.queryBooksDetialById(id);
            if (books != null) {
                String path = books.getLocalPath();
                //删除指定路径下的文件
                if (path != null) {
                    FileUtil.deleteSingleFile(path);
                }
            }
            int num = booksService.deleteBooks(id);
            map.put(PubConstant.flag, PubConstant.success);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(PubConstant.flag, PubConstant.failed);
        }
        return JSONUtils.toJSONString(map);
    }
}
