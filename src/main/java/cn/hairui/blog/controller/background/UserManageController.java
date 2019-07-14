package cn.hairui.blog.controller.background;

import cn.hairui.blog.config.WebLog;
import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.Books;
import cn.hairui.blog.model.MyInfo;
import cn.hairui.blog.model.User;
import cn.hairui.blog.service.MyInfoService;
import cn.hairui.blog.service.UserService;
import cn.hairui.blog.util.MD5;
import com.alibaba.druid.support.json.JSONUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/16 17:13
 */
@Controller
@RequestMapping("/manage")
public class UserManageController {

    @Autowired
    private UserService userService;
    @Autowired
    private MyInfoService myInfoService;

    private String listPage = PubConstant.BACKGROUND_DIR_NAME + "user-list";//列表页面
    private String loginPage = PubConstant.BACKGROUND_DIR_NAME + "login";

    @RequestMapping(value = "/user-list")
    public String queryUserList(HttpServletRequest request, Model model) {
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
        PageHelper.startPage(pageNum, PubConstant.TEN);

        List<User> userList = null;
        User user = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (PubConstant.YES_NO_Y.equals(user.getSuperUser())) {
            //超级用户
            userList = userService.queryUserList();
        } else if (!PubConstant.YES_NO_Y.equals(user.getSuperUser()) && PubConstant.YES_NO_Y.equals(user.getAdminflag())) {
            //不是超级用户  但是管理用户
            userList = userService.queryNormalUserList();
        }
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("users", userList);
        return listPage;
    }

    @RequestMapping(value = "/login")
    private String login(HttpServletRequest request, Model model) {
        MyInfo myInfo = myInfoService.findMyInfoById(PubConstant.MY_INFO_ID);
        model.addAttribute("myinfo", myInfo);
        return loginPage;
    }

    @RequestMapping(value = "/logout")
    public String userLogout(HttpServletRequest request) throws IOException {
        request.getSession().invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/user-login", method = RequestMethod.POST)
    @ResponseBody
    public String userLogin(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        Map map = new HashMap();
        String password = MD5.getMD5ofStr(user.getPassword());
        User domain = userService.queryUserByNameAndPwd(user.getUsername(), password);
        if (domain != null && PubConstant.YES_NO_N.equals(domain.getLockflag())) {
            session.setAttribute(PubConstant.GLOBAL_SESSION_NAME, domain);
            map.put(PubConstant.flag, PubConstant.success);
            return JSONUtils.toJSONString(map);
        } else if (domain != null && !PubConstant.YES_NO_N.equals(domain.getLockflag())) {
            map.put(PubConstant.flag, PubConstant.locked);
            return JSONUtils.toJSONString(map);
        } else {
            map.put(PubConstant.flag, PubConstant.failed);
            return JSONUtils.toJSONString(map);
        }
    }

    @RequestMapping(value = "/user-reset", method = RequestMethod.POST)
    @ResponseBody
    public Map userPwdReset(HttpServletRequest request, Integer id, Model model) {
        Map map = new HashMap();
        User user = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (PubConstant.YES_NO_Y.equals(user.getAdminflag())) {

            String originPwd = MD5.getMD5ofStr(PubConstant.ORIGIN_PWD);
            int i = userService.updateUserPwd(id, originPwd);
            map.put(PubConstant.flag, PubConstant.success);
        } else {
            map.put(PubConstant.flag, PubConstant.failed);
        }
        return map;
    }

    @RequestMapping(value = "user-lock", method = RequestMethod.POST)
    @ResponseBody
    public Map lockAndUnlockUser(HttpServletRequest request, Integer id, String lock) {
        Map map = new HashMap();
        User user = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (PubConstant.YES_NO_Y.equals(user.getAdminflag())) {
            if (!PubConstant.YES_NO_Y.equals(lock.trim().toUpperCase()) && !PubConstant.YES_NO_N.equals(lock.trim().toUpperCase())) {
                //传入锁定标志错误
                map.put(PubConstant.flag, PubConstant.failed);
                return map;
            } else {
                lock = lock.trim().toUpperCase();
            }
            int i = userService.updateUserLockSts(id, lock);
            map.put(PubConstant.flag, PubConstant.success);
        } else {
            map.put(PubConstant.flag, PubConstant.failed);
        }
        return map;
    }
}