package com.glp.utils;

import com.glp.anotation.NoRepeatSubmit;
import com.google.common.cache.Cache;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;

/**
 * @author zmm
 * @date 2019/12/12
 */
@Aspect
@Component
public class NotRepeatAopUtils {

    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private Cache<String, Integer> cache;

    @Around("execution(* com.glp..*Controller.*(..)) && @annotation(nrs)")
    public Object arround(ProceedingJoinPoint pjp, NoRepeatSubmit nrs) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
            HttpServletRequest request = attributes.getRequest();
            String key = sessionId + "-" + request.getServletPath();
            if (cache.getIfPresent(key) == null) {// 如果缓存中有这个url视为重复提交
                Object o = pjp.proceed();
                cache.put(key, 0);
                return o;
            } else {
                logger.error("重复提交");
                return new String("重复提交");
            }
        } catch (Throwable e) {
            e.printStackTrace();
            logger.error("验证重复提交时出现未知异常!");
            return "{\"code\":-889,\"message\":\"验证重复提交时出现未知异常!\"}";
        }

    }

}
