package cn.hairui.blog.interceptor;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/29 18:45
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        System.out.println("在控制器执行前调用 ");
        User userinfo = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (userinfo == null) {
            System.out.println("当前用户未登录!");
            /*request.getSession().setAttribute("name","lihairui");
            admin = request.getSession().getAttribute("name");*/
            response.sendRedirect( "login");
            return false;
        }else if (userinfo != null && !PubConstant.YES_NO_Y.equals(userinfo.getAdminflag())) {
            System.out.println("当前用户已经登录但是管理权限不足!登录用户名："+userinfo.getUsername());
            /*request.getSession().setAttribute("name","lihairui");
            admin = request.getSession().getAttribute("name");*/
            response.sendRedirect( "forgeindex");
            return false;
        }
        System.out.println("当前用户已登录，登录的用户名为： " + userinfo.getUsername());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //controller方法处理完毕后，调用此方法
        System.out.println("在后端控制器执行后调用 ");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //页面渲染完毕后调用此方法
        System.out.println("整个请求执行完成后调用 ");
    }
}
