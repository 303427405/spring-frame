package com.edu.demo.core.ensure;


import com.edu.demo.core.exceptions.EnsureParamObjectExtension;

/**
 *  异常处理
 */
public class Ensure {

    /**
     * 异常捕获类型 object
     * @param tObject
     * @return
     */
    public static EnsureParamObjectExtension that(Object tObject){
        return new EnsureParamObjectExtension(tObject);
    }



}
