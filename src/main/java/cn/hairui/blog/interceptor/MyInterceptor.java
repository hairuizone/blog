package cn.hairui.blog.interceptor;

import cn.hairui.blog.constant.PubConstant;
import cn.hairui.blog.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        User userinfo = (User) request.getSession().getAttribute(PubConstant.GLOBAL_SESSION_NAME);
        if (userinfo == null) {
            logger.info("USER           : {}", "");
            /*request.getSession().setAttribute("name","lihairui");
            admin = request.getSession().getAttribute("name");*/
            response.sendRedirect( "login");
            return false;
        }else if (userinfo != null && !PubConstant.YES_NO_Y.equals(userinfo.getAdminflag())) {
            logger.info("Permission Delined: {}", userinfo.getUsername());
            /*request.getSession().setAttribute("name","lihairui");
            admin = request.getSession().getAttribute("name");*/
            response.sendRedirect( "forgeindex");
            return false;
        }
        logger.info("USER           : {}", userinfo.getUsername());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //controller方法处理完毕后，调用此方法
        //logger.info("在后端控制器执行后调用 ");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //页面渲染完毕后调用此方法
        //logger.info("整个请求执行完成后调用 ");
    }
}
