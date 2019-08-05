package com.course.advice;

import org.aspectj.lang.JoinPoint;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;

public class LogAdvice{
    private static Logger logger = Logger.getLogger(LogAdvice.class);
    public void afterRerurningMethod(JoinPoint joinpoint){

        String method = joinpoint.getSignature().getName();
        Object[] args = joinpoint.getArgs();
        logger.info("[log4j-INFO] method:" + method + " args:" + Arrays.toString(args));

    }

}
