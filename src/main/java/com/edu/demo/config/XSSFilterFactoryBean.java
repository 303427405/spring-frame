package com.edu.demo.xss;

import com.alibaba.fastjson.JSON;
import com.edu.demo.xss.Defender.Defender;
import com.edu.demo.xss.Defender.DefenderUrl;
import com.edu.demo.xss.filter.XssEscapeServletFilter;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * xss过滤
 * Created By zhangyufei on 2019/7/4
 */
@Configuration
public class XSSFilterFactoryBean {

    /**全局的过滤规则*/
    private Defender globalDefenderRule =  new Defender();

    /**具体url过滤规则 */
    private Map<String,DefenderUrl> urlDefenderRule =  new HashMap<>();

    /**xss规则文件地址*/
    private final static String XSS_DEFENDER_PATH = "props/xss_defender.json";

    /**
     * xss过滤拦截器
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new XssEscapeServletFilter());
        return filterRegistrationBean;
    }


    /**
     * xss过滤拦截器
     */
    @Bean
    public XSSFilterFactoryBean xssFilterFactoryBean() {
        XSSFilterFactoryBean xssFilterFactoryBean = new XSSFilterFactoryBean();
        try{
            /**获取当前文件的绝对路径*/
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(XSS_DEFENDER_PATH);
            String toString = IOUtils.toString(inputStream);
            xssFilterFactoryBean = JSON.parseObject(toString, XSSFilterFactoryBean.class);

        }catch (Exception e){
            System.out.println("加载xss规则出错:"+e);
        }
        return xssFilterFactoryBean;
    }

    public Defender getGlobalDefenderRule() {
        return globalDefenderRule;
    }

    public void setGlobalDefenderRule(Defender globalDefenderRule) {
        this.globalDefenderRule = globalDefenderRule;
    }

    public Map<String, DefenderUrl> getUrlDefenderRule() {
        return urlDefenderRule;
    }

    public void setUrlDefenderRule(Map<String, DefenderUrl> urlDefenderRule) {
        this.urlDefenderRule = urlDefenderRule;
    }
}
