package com.brightpaths.datadrivenmarketing.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.brightpaths.datadrivenmarketing.controllers..*)"
            + "|| within(com.brightpaths.datadrivenmarketing.dao..*)")
    public void definePackagePointcuts() {
        // empty method just to name the location specified in the Pointcut
    }

    @Around("definePackagePointcuts()")
    public Object logAround(ProceedingJoinPoint jp) {
        log.debug("\n \n \n");
        log.debug("********** BEFORE METHOD EXECUTION ********** \n {}.{} () with arguments[s] = {}", jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("________________________________________________ \n \n \n");

        Object o = null;

        try {
            o = jp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        log.debug("********** AFTER METHOD EXECUTION ********** \n {}.{} () with arguments[s] = {}", jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("________________________________________________ \n \n \n");
        return o;
    }

}
