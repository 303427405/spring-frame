package com.edu.demo.core.exceptions;

/**
 * 东皇钟异常处理
 * Created By zhangyufei on 2017/9/19
 */
public class DHuangZException extends RuntimeException{

    public static final String DEFAULT_FAULT_CODE = "X0001";

    private String xCode;
    private String message;

    public DHuangZException(String message){
        this(DEFAULT_FAULT_CODE, message);
    }

    public DHuangZException(String xCode, String message) {
        this(xCode, message, new Throwable());
    }

    public DHuangZException(String xCode, String message, String internalMessage) {
        this(xCode, message, internalMessage, null);
    }

    public DHuangZException(String code, String message, Throwable throwable) {
        this(code, message, throwable.getMessage(), throwable);
    }

    public DHuangZException(String xCode, String message, String internalMessage, Throwable throwable) {
        /**xcode 扩展 可判断异常类型*/
        super(message, throwable);
        this.message = message;
        this.xCode = xCode;
    }

    public String getXCode() {
        return xCode;
    }

    public void setXCode(String xCode) {
        this.xCode = xCode;
    }

    public String getMessageWithoutCode(){
        return message;
    }

    @Override
    public String getMessage() {
//        return "[" + xCode + "]" + " - " + message;
        return  message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
