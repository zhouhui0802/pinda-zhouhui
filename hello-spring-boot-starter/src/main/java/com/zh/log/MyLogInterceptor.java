package com.zh.log;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class MyLogInterceptor extends HandlerInterceptorAdapter {

    private static final ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();//获得被拦截的方法对象
        MyLog myLog = method.getAnnotation(MyLog.class);//获得方法上的注解
        if(myLog != null){
            //方法上加了MyLog注解，需要进行日志记录
            long startTime = System.currentTimeMillis();
            startTimeThreadLocal.set(startTime);
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();//获得被拦截的方法对象
        MyLog myLog = method.getAnnotation(MyLog.class);//获得方法上的注解
        if(myLog != null){
            //方法上加了MyLog注解，需要进行日志记录
            long endTime = System.currentTimeMillis();
            Long startTime = startTimeThreadLocal.get();
            long optTime = endTime - startTime;

            String requestUri = request.getRequestURI();
            String methodName = method.getDeclaringClass().getName() + "." +
                    method.getName();
            String methodDesc = myLog.desc();

            System.out.println("request uri：" + requestUri);
            System.out.println("request methodName ：" + methodName);
            System.out.println("the description of the method ：" + methodDesc);
            System.out.println("the time of the method " + optTime + "ms");
        }
    }
}
