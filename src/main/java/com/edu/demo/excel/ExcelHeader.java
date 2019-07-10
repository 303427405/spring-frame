package com.chemyun.mall.utils.excel;

import java.lang.reflect.Method;

public class ExcelHeader implements Comparable {
    private String headerName;
    private int columnIndex;

    /**是否必填*/
    private Integer isRequired;

    /**合并单元格的数量，默认1，不合并*/
    private int colCellNum = 1;

    /**导入属性*/
    private String importFiled;

    /**导入属性type*/
    private Class<?> importFiledType;

    /**导入属性set方法（修饰符为public）*/
    private Method writeMethod;

    public ExcelHeader() {
    }

    public ExcelHeader(String headerName, String importFiled) {
        this.headerName = headerName;
        this.importFiled = importFiled;
    }

    public ExcelHeader(String headerName, String importFiled, int columnIndex) {
        this.headerName = headerName;
        this.importFiled = importFiled;
        this.columnIndex = columnIndex;
    }

    public ExcelHeader(String headerName, String importFiled, int columnIndex, Integer isRequired) {
        this.headerName = headerName;
        this.importFiled = importFiled;
        this.columnIndex = columnIndex;
        this.isRequired = isRequired;
    }

    public ExcelHeader(String headerName, String importFiled, int columnIndex, Integer isRequired, int colCellNum) {
        this.headerName = headerName;
        this.importFiled = importFiled;
        this.columnIndex = columnIndex;
        this.isRequired = isRequired;
        this.colCellNum = colCellNum;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getImportFiled() {
        return importFiled;
    }

    public void setImportFiled(String importFiled) {
        this.importFiled = importFiled;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public int getColCellNum() {
        return colCellNum;
    }

    public void setColCellNum(int colCellNum) {
        this.colCellNum = colCellNum;
    }

    public Class<?> getImportFiledType() {
        return importFiledType;
    }

    public void setImportFiledType(Class<?> importFiledType) {
        this.importFiledType = importFiledType;
    }

    public Method getWriteMethod() {
        return writeMethod;
    }

    public void setWriteMethod(Method writeMethod) {
        this.writeMethod = writeMethod;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return 1;
        }
        if (this == o) {
            return 0;
        }
        if (o instanceof ExcelHeader) {
            ExcelHeader header = (ExcelHeader) o;
            int i = this.columnIndex - header.getColumnIndex();
            if (i == 0) {
                i = this.getHeaderName().compareTo(header.getHeaderName());
                if (i == 0) {
                    return this.getImportFiled().compareTo(header.getImportFiled());
                }
            }
            return i;
        }
        return 1;
    }
}
