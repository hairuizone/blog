package cn.hairui.blog.config;

import cn.hairui.blog.interceptor.MyInterceptor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/29 19:04
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    @Value("${blog.editmd.upload.imgages}")
    private String mImagesPath;
    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/upload/images/");
       /* if (mImagesPath.equals("") || mImagesPath.equals("${blog.editmd.upload.imgages}")) {
            String imagesPath = WebConfigurer.class.getClassLoader().getResource("").getPath();
            if (imagesPath.indexOf(".jar") > 0) {
                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            } else if (imagesPath.indexOf("classes") > 0) {
                imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
            }
            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/images/";
            mImagesPath = imagesPath;
        }
        LoggerFactory.getLogger(WebConfigurer.class).info("imagesPath=" + mImagesPath);
        registry.addResourceHandler("/images/**").addResourceLocations(mImagesPath);
        WebMvcConfigurer.super.addResourceHandlers(registry);*/
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(myInterceptor).addPathPatterns("/manage/*").excludePathPatterns("/manage/login","/manage/user-login","/manage/forgeindex");
    }

}