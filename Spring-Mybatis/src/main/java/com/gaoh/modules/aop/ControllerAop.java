package com.gaoh.modules.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/19 15:35
 * @Version: 1.0
 */
@Component
@Aspect
@Slf4j
public class ControllerAop {
    @Pointcut("execution(* com.gaoh.modules.controller.*.*(..)))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        MethodSignature methodSignature = ((MethodSignature) point.getSignature());

        long timeMillis = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = point.proceed();
            log.debug("执行时间：{}", System.currentTimeMillis() - timeMillis);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

}
