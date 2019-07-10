package com.chemyun.mall.utils.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created By zhangyufei on 2018/5/30
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelInfo {

    /**文件导出名称*/
    String fileName() default "";

    /**sheet 名称*/
    String sheetName() default "";


}
