package com.edu.demo.core.exceptions;


/**
 * 东皇钟异常工厂类
 * Created By zhangyufei on 2017/9/18
 */
public class DHZExceptionFactory{


    private static ExceptionDefinitions exceptionDefinitions;


    public static DHuangZException create(String errorCode, String...args){
        String exceptionPattern = getExceptionDefinitions().getExceptionMessage(errorCode);

        if(args.length > 0){
            String errorMsg = String.format(exceptionPattern, args);
            return new DHuangZException(errorCode,errorMsg);
        }
        return new DHuangZException(errorCode,exceptionPattern);
    }

    /**整合spring 可放入bean中*/
    private static ExceptionDefinitions getExceptionDefinitions(){
        if(exceptionDefinitions == null){
            exceptionDefinitions = new ExceptionDefinitions();
        }
        return exceptionDefinitions;
    }
}
