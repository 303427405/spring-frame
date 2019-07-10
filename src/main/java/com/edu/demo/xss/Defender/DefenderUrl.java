package com.xkeshi.market.common.handler.xss.defender;

import java.util.Map;

/**
 * Created by xukai on 2017/7/14.
 * @desc URL 保护规则
 */
public class DefenderUrl extends Defender {

    /**参数过滤规则*/
    private Map<String,Defender > params;

    public Map<String, Defender> getParams() {
        return params;
    }

    public void setParams(Map<String, Defender> params) {
        this.params = params;
    }
}
