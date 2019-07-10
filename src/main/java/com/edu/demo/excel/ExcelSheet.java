package com.chemyun.mall.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By zhangyufei on 2018/5/30
 * 工作簿
 */
public class ExcelSheet {

    protected String sheetname;

    protected List<ExcelHeader> headers = new ArrayList<>();

    protected List<?> dataList = new ArrayList<>();

    HSSFCellStyle titleStyle;

    protected HSSFCellStyle dataStyle;

    protected Sheet sheet;

    protected float heightInPoints;

    protected int rowIndex; /** 行号*/

    protected final int[] columnWidths;

    public ExcelSheet(String sheetname, List<ExcelHeader> headers, List dataList) {
        this.headers = headers;
        this.sheetname = sheetname;
        this.dataList = dataList;
        /**设置列宽*/
        this.columnWidths = new int[headers.size()];
    }

    public String getSheetname() {
        return sheetname;
    }

    public void setSheetname(String sheetname) {
        this.sheetname = sheetname;
    }

    public List<ExcelHeader> getHeaders() {
        return headers;
    }

    public void setHeaders(List<ExcelHeader> headers) {
        this.headers = headers;
    }

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }

    public HSSFCellStyle getTitleStyle() {
        return titleStyle;
    }

    public void setTitleStyle(HSSFCellStyle titleStyle) {
        this.titleStyle = titleStyle;
    }

    public HSSFCellStyle getDataStyle() {
        return dataStyle;
    }

    public void setDataStyle(HSSFCellStyle dataStyle) {
        this.dataStyle = dataStyle;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public float getHeightInPoints() {
        return heightInPoints;
    }

    public void setHeightInPoints(float heightInPoints) {
        this.heightInPoints = heightInPoints;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int[] getColumnWidths() {
        return columnWidths;
    }
}
