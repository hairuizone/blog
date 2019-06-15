package cn.hairui.blog.controller;

import cn.hairui.blog.model.ArticalTopics;
import cn.hairui.blog.model.Books;
import cn.hairui.blog.service.BooksService;
import cn.hairui.blog.util.FileUtil;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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

public class BooksController {

    @Autowired
    private BooksService booksService;

    @RequestMapping(value = "/manage/books-list")
    public String listBooks(Model model){
        List<Books> booksList = booksService.queryBooksList();
        model.addAttribute("booksList",booksList);
        return "background/books-list";

    }

    @RequestMapping(value = "/manage/books-add")
    public String addBooks(){
        return "background/books-add";

    }

    @RequestMapping(value = "/manage/books-adddata")
    @ResponseBody
    public String addBooks(HttpServletRequest request,String bookName,String Author,String publishDate) throws IOException {
        Map map = new HashMap();
        String path = "";
        int num = booksService.queryBooksDetialByBookName(bookName);
        if(num >= 1){
            map.put("flag","failed");
            map.put("message","该名称对应的书籍已经存在");

        }else{
            //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
            CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
            //检查form中是否有enctype="multipart/form-data"
            if(multipartResolver.isMultipart(request)){
                //将request变成多部分request
                MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
                //获取multiRequest 中所有的文件名
                Iterator iter=multiRequest.getFileNames();
                while(iter.hasNext()){
                    //一次遍历所有文件
                    MultipartFile file=multiRequest.getFile(iter.next().toString());
                    if(file!=null){
                        path="E:/myblog/"+file.getOriginalFilename();
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
                if(n == 1){
                    map.put("flag","success");
                }else{
                    map.put("flag","failed");
                    map.put("message","保存到数据库出现异常");
                }
            }catch (Exception e){
                e.printStackTrace();
                map.put("flag","failed");
                map.put("message",e.toString());
            }
        }
        return JSONUtils.toJSONString(map);

    }


    @RequestMapping(value = "/manage/books-delete",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String deleteBooks(int id){
        Map map = new HashMap();
        try {
            Books books = booksService.queryBooksDetialById(id);
            if(books !=null){
                String path = books.getLocalPath();
                //删除指定路径下的文件
                if(path != null){
                    FileUtil.deleteSingleFile(path);
                }
            }
            int num = booksService.deleteBooks(id);
            map.put("flag","success");
        }catch (Exception e){
            e.printStackTrace();
            map.put("flag","failed");
        }

        return JSONUtils.toJSONString(map);
    }
}
