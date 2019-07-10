package com.edu.demo.xss;

import com.edu.demo.xss.Defender.Defender;
import com.edu.demo.xss.Defender.DefenderType;
import com.edu.demo.xss.Defender.DefenderUrl;
import org.springframework.util.AntPathMatcher;

import java.util.Map;

/**
 */
public class XssDefenderFilter {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**是否启用过滤*/
    private boolean enable ;

    /**全局的过滤规则*/
    private Defender globalDefender;

    /**参数过滤规则*/
    private DefenderUrl urlDefender;

    public XssDefenderFilter(String url, XSSFilterFactoryBean  factoryBean) {

        /**获取全局过滤*/
        globalDefender = factoryBean.getGlobalDefenderRule();
        enable = globalDefender.isEnable();

        /**获取具体url过滤*/
        Map<String, DefenderUrl> urlDefenderRule = factoryBean.getUrlDefenderRule();

        for(Map.Entry<String, DefenderUrl>  entry : urlDefenderRule.entrySet()){
          if(!antPathMatcher.match( entry.getKey(), url)){
              continue;
          }
          urlDefender = entry.getValue();
          if(urlDefender != null){
             enable = urlDefender.isEnable();
          }
        }
    }

    /**处理数据*/
    public String defenderValue(String name ,String value){
        if(!enable){
            return value;
        }
        DefenderType defenderType = getDefenderType(name);
        if(defenderType.equals(DefenderType.CLEAR)){
            /**清理xss*/
            return XssDefenderUtils.sanitizerXSS(value);
        }else if(defenderType.equals(DefenderType.ESCAPE)){
            /**转义xss*/
            return XssDefenderUtils.escapeXSS(value);
        } else {
            return value;
        }
    }

    /**获保护类型*/
    public DefenderType   getDefenderType(String name ){
        if(urlDefender == null){
            return globalDefender.isEnable() ? globalDefender.getType() : null;
        }else if(!urlDefender.isEnable()){
            /**url 启用白名单*/
            return null;
        }
        Map<String, Defender> params = urlDefender.getParams();
        if(params == null){
            return globalDefender.isEnable() ? globalDefender.getType() : null;
        }
        Defender defender = params.get(name);
        if(defender == null){
            return globalDefender.isEnable() ? globalDefender.getType() : null;
        }
        return defender.isEnable() ? defender.getType() : null;
    }

    /**是否启用过滤*/
    public boolean isEnable() {
        return enable;
    }
}
