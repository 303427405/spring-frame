package com.chemyun.mall.utils.excel;

import java.util.List;

/**
 * excel导出基本属性
 */
public class ExcelBaseAttribute {
    /**工作簿名称*/
    private String sheetName;

    private Class<?> clazz;

    /**数据列表*/
    private List dataList;

    private List<ExcelHeader> headers;

    public ExcelBaseAttribute(){}

    public ExcelBaseAttribute(Class<?> clazz, List dataList){
        this.clazz = clazz;
        this.dataList = dataList;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public List<ExcelHeader> getHeaders() {
        return headers;
    }

    public void setHeaders(List<ExcelHeader> headers) {
        this.headers = headers;
    }
}
