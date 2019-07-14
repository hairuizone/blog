package cn.hairui.blog.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/7/11 21:32
 */
//将此类声明为一个切面 需要将该类放入到IOC容器中 再声明一个切面
@Aspect
@Component

public class LoggingAspectConfig {
    private final static Logger logger = LoggerFactory.getLogger(LoggingAspectConfig.class);
    /** 换行符 */
    private static final String LINE_SEPARATOR = System.lineSeparator();
    //切入点表达式可以通过声明一个方法的方式进行定义 一般情况下 该方法不需要添加任何代码 控制层添加
    @Pointcut("execution(* *cn.hairui.blog.controller.foreground.*Controller.*(..))")
    public void declareJoinPointExpression(){}

    //声明前置通知 在目标方法调用之前执行
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) throws Exception {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        /*String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("before method2 ......");
        System.out.println("the method " + methodName + " start with args " + args);*/

        String methodDescription = getAspectLogDescription(joinPoint);

        // 打印请求相关参数
        logger.info("========================================== Start ==========================================");
        // 打印请求 url
        logger.info("URL            : {}", request.getRequestURL().toString());
        // 打印描述信息
        logger.info("Description    : {}", methodDescription);
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        logger.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        logger.info("Request Args   : {}", joinPoint.getArgs());

    }
    //后置通知：在目标方法调用之后执行 无论方法是否发生异常都会被调用执行
    //后置通知中还不能访问目标方法执行的结果
    @After("declareJoinPointExpression()")
    public void afterMethod(){
        // 接口结束后换行，方便分割查看
        logger.info("=========================================== End ===========================================" + LINE_SEPARATOR);
    }

    /**
     * 环绕
     * @param
     * @return
     * @throws Throwable
     */
    /*@Around("declareJoinPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            //前置通知
            String methodName = proceedingJoinPoint.getSignature().getName();
            Object[] args = proceedingJoinPoint.getArgs();
            System.out.println("the around method begins method " + methodName + " with " + Arrays.asList(args));
            result = proceedingJoinPoint.proceed();
            //返回通知
            logger.info("Response Args  : {}", result);
            logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        }catch (Throwable throwable) {
            logger.info("Response error : {}", throwable);
        }
        //后置通知

        return result;
    }*/

    //异常通知：在方法调用发生异常时候执行
    @AfterThrowing(value = "declareJoinPointExpression()",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
        //String methodName = joinPoint.getSignature().getName();
        logger.error("Exception     : {}" ,ex);
    }
    /**
     * 获取切面注解的描述
     *
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    String desc = "";
                    try {
                        desc = method.getAnnotation(WebLog.class).description();
                    }catch (Exception ee){

                    }
                    description.append(desc);
                    break;
                }
            }
        }
        return description.toString();
    }
}
