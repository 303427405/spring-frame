package com.edu.demo.core.exceptions;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 *  异常定义 错误码处理
 * Created By zhangyufei on 2017/9/18
 */
public class ExceptionDefinitions {

    private Logger logger = LoggerFactory.getLogger(ExceptionDefinitions.class);

    private Properties exceptionDefinitionProps;


    /**
     * 获取properties（缓存Properties）
     * @return properties
     * @throws IOException
     */
    private Properties getDefinitions() throws IOException {

//        if(exceptionDefinitionProps == null){
//            Resource[] resources = ApplicationContextHelper.getContext().getBean(ResourcePatternResolver.class).getResources("classpath*:/error/error.properties");
//            exceptionDefinitionProps = new Properties();
//            for(Resource resource : resources){
//                InputStream stream = resource.getInputStream();
//                try {
//                    Reader reader = new InputStreamReader(stream,  Charset.forName("UTF-8"));
//                    try {
//                        exceptionDefinitionProps.load(reader);
//                    } finally {
//                        reader.close();
//                    }
//                } finally {
//                    stream.close();
//                }
//            }
//        }
//        exceptionDefinitionProps = new Properties();
//        exceptionDefinitionProps.setProperty("DHUANGZ_VALIDATE_ERROR_00001","用户数据为空");
//        exceptionDefinitionProps.setProperty("DHUANGZ_VALIDATE_ERROR_00002","数据为false");

        if(exceptionDefinitionProps == null) {
            exceptionDefinitionProps = new Properties();
            InputStream inputStream = Object.class.getResourceAsStream("/error/error.properties");
            InputStreamReader inputStreamReader = null;
            try {
                inputStreamReader = new InputStreamReader(inputStream , "UTF-8");
                exceptionDefinitionProps.load(inputStreamReader);
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return exceptionDefinitionProps;
    }


    /**
     * 根据错误代码获取异常描述信息
     * @param errorCode 错误代码
     * @return 异常描述信息
     */
    public String getExceptionMessage(String errorCode){
        final String CANNOT_FOUND_ERROR_CODE_MESSAGE_PATTERN = "系统错误[ErrorType = ERROR_MESSAGE_DEFINITION, ErrorCode=%s]";

        String message = "";
        try {
            message =  (String) getDefinitions().get(errorCode);
        } catch (IOException e) {
            logger.error(String.format("Error message for [code=%s] is not defined", errorCode));
        }

        if(StringUtils.isEmpty(message)){
            message = String.format(CANNOT_FOUND_ERROR_CODE_MESSAGE_PATTERN, errorCode);
        }

        return message;
    }


}
