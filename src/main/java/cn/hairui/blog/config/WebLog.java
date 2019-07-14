package cn.hairui.blog.config;

import java.lang.annotation.*;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/7/13 20:54
 */
@Retention(RetentionPolicy.RUNTIME)//什么时候使用该注解，我们定义为运行时
@Target({ElementType.METHOD})//注解用于什么地方，我们定义为作用于方法上
@Documented//注解是否将包含在 JavaDoc 中
public @interface WebLog {
    /**
     * 日志描述
     * @return
     */
    String description() default "";
}
