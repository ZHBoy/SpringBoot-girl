package com.hao.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 记录http请求
 */
@Aspect
@Component
public class HttpAspect {

    public final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.hao.girl.controller.GirlController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){


        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();

        //url
        logger.info("url={}", httpServletRequest.getRequestURL());

        //method
        logger.info("method={}", httpServletRequest.getMethod());

        //ip
        logger.info("ip={}", httpServletRequest.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "."+joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());

    }

    @After("log()")
    public void doAfter(){
        logger.info("222222222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterRetruning(Object object){

        logger.info("response={}",object.toString());
    }

}
