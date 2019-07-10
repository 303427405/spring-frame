package com.xkeshi.market.common.handler.xss.defender;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created by xukai on 2017/7/14.
 */
public class Defender {

    /**保护类型(转义和清理)*/
    private DefenderType type = DefenderType.CLEAR;

    /**是否开启校验*/
    private boolean enable = true ;

    public DefenderType getType() {
        return type;
    }

    public void setType(DefenderType type) {
        this.type = type;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.PrettyFormat);
    }
}
