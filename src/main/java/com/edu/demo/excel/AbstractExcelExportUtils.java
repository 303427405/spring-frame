package com.chemyun.mall.utils.excel;

import com.chemyun.mall.utils.excel.annotation.ExcelColumn;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created By zhangyufei on 2018/5/30
 */
public abstract class AbstractExcelExportUtils implements ExcelExport {
    private static Logger logger = LoggerFactory.getLogger(AbstractExcelExportUtils.class);

    protected String filename;

    protected HSSFWorkbook wb;

    protected List<ExcelSheet> excelSheets = new ArrayList<>();

    protected AbstractExcelExportUtils(List<ExcelBaseAttribute> excelBaseAttrs){
        for (ExcelBaseAttribute excelBaseAttr : excelBaseAttrs ) {
            ExcelSheet excelSheet = new ExcelSheet(excelBaseAttr.getSheetName(), excelBaseAttr.getHeaders(), excelBaseAttr.getDataList());
            init(excelSheet);
            excelSheets.add(excelSheet);
        }
    }

    protected AbstractExcelExportUtils(String sheetname, List<ExcelHeader> headers, List dataList) {
        ExcelSheet excelSheet = new ExcelSheet(sheetname,headers,dataList);
        init(excelSheet);
        excelSheets.add(excelSheet);
    }

    private void init(ExcelSheet excelSheet) {
        if(wb==null) {
            wb = new HSSFWorkbook();
        }
        excelSheet.setSheet(wb.createSheet(excelSheet.getSheetname()));

        HSSFCellStyle titleStyle = wb.createCellStyle();
        HSSFCellStyle dataStyle = wb.createCellStyle();
        initTitleStyle(wb, titleStyle);
        initDataStyle(wb, dataStyle);
        excelSheet.setTitleStyle(titleStyle);
        excelSheet.setDataStyle(dataStyle);
        excelSheet.setHeightInPoints(initHeightInPoints());
    }

    /**
     * 初始化TitleStyle。
     */
    protected abstract void initTitleStyle(HSSFWorkbook wb, HSSFCellStyle titleStyle);

    /**
     * 初始化DataStyle。
     */
    protected abstract void initDataStyle(HSSFWorkbook wb, HSSFCellStyle dataStyle);

    /**
     * 初始化HeightInPoints。
     */
    protected abstract float initHeightInPoints();

    /**
     * 导入Excel
     *
     * @throws Exception
     */
    @Override
    public Workbook exportWorkbook() throws Exception {
        createExcelTitle();
        createData();
        return wb;
    }

    /**
     * 得到Excel表头
     */
    protected static List<ExcelHeader> getExcelHeader(Class<?> clazz) throws Exception {
        clazz = Objects.requireNonNull(clazz);
        List<ExcelHeader> headers = new ArrayList<>();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(ExcelColumn.class)) {
                ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
                int columnIndex = excelColumn.sort();
                String headerName = excelColumn.value();
                boolean required = excelColumn.required();
                int colCellNum =  excelColumn.colCellNum();
                ExcelHeader header = new ExcelHeader(headerName, field.getName(), columnIndex, required ? 1 : 0, colCellNum);
                header.setImportFiledType(field.getType());
                header.setWriteMethod(getWriteMethod(clazz, field));
                headers.add(header);
            }
        }
        Collections.sort(headers);
        return headers;
    }

    /**获取属性的set方法*/
    private static Method getWriteMethod(Class<?> clazz, Field field) throws Exception {
        Method method = null;
        StringBuffer sb = new StringBuffer();
        sb.append("set").append(field.getName().substring(0, 1).toUpperCase()).append(field.getName().substring(1));
        try {
            method = clazz.getMethod(sb.toString(), field.getType());
        } catch (Exception e) {
            logger.error("{}没有找到{}的set方法",clazz.getName(),field.getName());
        }
        return method;
    }

    protected abstract void createExcelTitle();

    protected abstract void createData() throws Exception;

    protected Object getValueFromObject(Object o, String fieldName) throws Exception {
        String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Method method = o.getClass().getMethod(methodName);

        return method.invoke(o);
    }

    /**
     * 转换为字符串
     */
    protected String convertDataValueToString(Object value) {
        if (value instanceof Date) {
            Format format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return format.format(value);
        }

        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).setScale(2).toString();
        }

        return value.toString();
    }

    protected void calcColumWidth(Sheet sheet, List<ExcelHeader> headers,final int[] columnWidths) {
        for (int i = 0; i < headers.size(); i++) {
            sheet.setColumnWidth(i, columnWidths[i]);
        }
    }

    /**
     * double 宽度 = (字符个数 * (字符宽度 - 1) + 5) / (字符宽度 - 1) * 256;
     */
    protected static int calcCellWidth(String text, int fontSize) {
        if (text != null && text.trim().length() > 0) {
            int length = 0;
            try {
                length = text.getBytes("gbk").length;
            } catch (UnsupportedEncodingException e) {
                logger.error("编码格式错误,method:calcCellWidth,message:{}",e.getMessage());
            }
            double result = (length + 5.0) * fontSize / 8 * 256;
            int i = new Long(Math.round(result)).intValue();
            return i > 20000 ? 20000 : i;
        }
        return 0;
    }
}
