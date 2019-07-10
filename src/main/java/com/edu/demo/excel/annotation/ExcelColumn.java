package com.chemyun.mall.utils.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumn {

    String value() default "";

    boolean required() default false;/**Excel导入时，表头是否必填参数*/

    int sort() default 0;/**表头顺序*/

    /** 列单元格数量，合并单元格时的合并数量 */
    int colCellNum() default 1;
}
