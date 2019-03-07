package cn.hairui.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/7 21:49
 */
@Controller
public class EditmdController {
    @RequestMapping(value = "/editmd", method = RequestMethod.GET)
    public String editmdPageTest() {
        return "editmd/editmd-edit";
    }

    @RequestMapping(value = "/editmd-data")
    public String editmdSubmitPageTest(HttpServletRequest httpServletRequest, Model model) {
        String text = httpServletRequest.getParameter("test-editormd-markdown-doc");
        System.out.println(text);
        String newline = System.getProperty("line.separator");
        text += newline;
        text += "# Markdown语法" + newline;
        text += "## 一、更改字体、大小、颜色" + newline;

        text = text +
                "<font face=\"黑体\">黑体</font>  <font face=\"微软雅黑\">微软雅黑</font>  <font face=\"宋体\">宋体</font>  <font face=\"STCAIYUN\">我是华文彩云</font>" + newline +
                "<font color=red>我是红色</font>  <font color=#008000>我是绿色</font>  <font color=Blue>我是蓝色</font>" +newline+
                "<font size=5>我是尺寸</font> " +newline+
                "<font face=\"黑体\" color=green size=5>我是黑体，绿色，尺寸为5</font>"+newline;

        text += "## 二、为文字添加背景色" + newline;

        text+="<table><tr><td bgcolor=green><font face=\"黑体\" size=5>背景色-green</font></td></tr>" +
                "<tr><td bgcolor=yellow>背景色-yellow</td></tr>" +
                "<tr><td bgcolor=blue>背景色-blue</td></tr></table>";





        model.addAttribute("text", text);
        return "editmd/editmd-view";
    }
}
