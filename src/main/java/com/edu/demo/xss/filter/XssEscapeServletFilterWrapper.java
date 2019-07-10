
package com.edu.demo.xss;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author xukai
 * @email xk@xkeshi.com
 * @desc   防xss注入(覆盖取值)
 * @time  2017/07/13
 */
public class XssEscapeServletFilterWrapper extends HttpServletRequestWrapper {

    private XSSFilterFactoryBean xssFilterFactoryBean;

    private String path = null;

    private String method =  null;

    public XssEscapeServletFilterWrapper(ServletRequest request, XSSFilterFactoryBean xssFilterFactoryBean) {
        super((HttpServletRequest)request);
        this.path = ((HttpServletRequest)request).getRequestURI();
        this.method = getMethod(request);
        this.xssFilterFactoryBean = xssFilterFactoryBean;
    }

    @Override
    public String getParameter(String paramName) {
        String value = super.getParameter(paramName);
        return doFilter(paramName, value);
    }

    @Override
    public String[] getParameterValues(String paramName) {
        String values[] = super.getParameterValues(paramName);
        if (values == null) {
            return values;
        }
        for (int index = 0; index < values.length; index++) {
            values[index] = doFilter(paramName, values[index]);
        }
        return values;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> newFilteredParamMap = new HashMap<>();
        Map<String, String[]> paramMap = super.getParameterMap();

        Set<Map.Entry<String, String[]>> entries = paramMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            Object[] valueObj = (Object[])entry.getValue();
            String paramName = entry.getKey();
            String[] filteredValue = new String[valueObj.length];
            for (int index = 0; index < valueObj.length; index++) {
                //参数过滤
                filteredValue[index] = doFilter(paramName, String.valueOf(valueObj[index]));
            }
            newFilteredParamMap.put(entry.getKey(), filteredValue);
        }

        return newFilteredParamMap;
    }

    /** 执行过滤 */
    private String doFilter(String paramName, String value) {
        if(StringUtils.equalsIgnoreCase(method, RequestMethod.GET.toString())){
          return value;
        }
        XssDefenderFilter defenderFilter = new XssDefenderFilter(path, xssFilterFactoryBean);
        return defenderFilter.defenderValue(paramName,value);
    }

    private String getMethod(ServletRequest request){
        String method =  ((HttpServletRequest)request).getMethod();
        if(StringUtils.equalsIgnoreCase(method, RequestMethod.POST.toString())){
            String _method = request.getParameter("_method");
            method = StringUtils.isNotBlank(_method) ? _method : method;
        }
        return method;
    }
}
