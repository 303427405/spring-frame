package com.edu.demo.core.exceptions;

import com.edu.demo.core.ensure.EnsureParam;

/**
 * Created By zhangyufei on 2017/9/20
 */
public class EnsureParamObjectExtension extends EnsureParam<Object> {

    private boolean isSatisfied;

    /**
     *  构造方法传参
     * @param o
     */
    public EnsureParamObjectExtension(Object o) {
        super(o);
    }

    public EnsureParamObjectExtension isNotNull(String errorCode){
        if(tObjct == null){
            throw DHZExceptionFactory.create(errorCode);
        }
        return this;
    }

    public EnsureParamObjectExtension isTrue(String errorCode){
        if(!Boolean.parseBoolean(tObjct.toString())){
            throw DHZExceptionFactory.create(errorCode);
        }
        return this;
    }

    public <TObject extends Object> EnsureParamObjectExtension isEqualTo(TObject obj, String errorCode){
        isSatisfied = (obj == tObjct) || (obj != null && tObjct != null && tObjct.equals(obj));

        if(!isSatisfied){
            throw DHZExceptionFactory.create(errorCode);
        }
        return this;
    }

    public <TObject extends Object> EnsureParamObjectExtension isNotEqualTo(TObject obj, String errorCode){
        if(obj != tObjct){
            if(obj != null){
                isSatisfied = !obj.equals(tObjct);
            }else if(tObjct != null){
                isSatisfied = !tObjct.equals(obj);
            } else {
                isSatisfied = false;
            }
        }else {
            isSatisfied = false;
        }

        if(!isSatisfied){
            throw DHZExceptionFactory.create(errorCode);
        }
        return this;
    }

}
