package com.chemyun.mall.utils.excel;

import com.chemyun.framework.utils.ResultCode;
import com.chemyun.mall.utils.error.BizException;
import com.chemyun.mall.utils.excel.annotation.ExcelInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created By zhangyufei on 2018/5/30
 * 导入默认工具实现
 */
public final class DefaultExcelExportUtils extends SimpleExcelExportUtils {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultExcelExportUtils.class);

    private DefaultExcelExportUtils(String sheetname, List<ExcelHeader> headers, List dataList) {
        super(sheetname, headers, dataList);
    }

    private DefaultExcelExportUtils(List<ExcelBaseAttribute> excelBaseAttrs) {
        super(excelBaseAttrs);
    }

    public static DefaultExcelExportUtils getInstance(String sheetname, List<ExcelHeader> headers, List dataList) {
        return new DefaultExcelExportUtils(sheetname, headers, dataList);
    }

    public static DefaultExcelExportUtils getInstance(List<ExcelBaseAttribute> excelBaseAttrs) {
        return new DefaultExcelExportUtils(excelBaseAttrs);
    }

    @Override
    protected void createExcelTitle(Sheet sheet, HSSFCellStyle titleStyle, List<ExcelHeader> headers, int[] columnWidths, float heightInPoints) {
        Row row = sheet.createRow(sheet.getLastRowNum());
        row.setHeightInPoints(heightInPoints);
        for (int i = 0; i < headers.size(); i++) {
            ExcelHeader header = headers.get(i);
            if (header.getColCellNum() <= 0) {
                header.setColCellNum(1);
            }
            if (header.getColCellNum() > 1) {
                CellRangeAddress cra = new CellRangeAddress(row.getRowNum(), row.getRowNum(), i, i + header.getColCellNum() - 1);
                /**在sheet里增加合并单元格 */
                sheet.addMergedRegion(cra);
            }
            Cell cell = row.createCell(i);

            /**数据*/
            StringBuffer value = new StringBuffer();
            /**是否必填*/
            /*if (null != header.getIsRequired() && header.getIsRequired() == 1) {
                value.append("*");
            }*/
            value.append(header.getHeaderName());
            cell.setCellValue(value.toString());
            int width = calcCellWidth(header.getHeaderName(), 12);
            if (width > columnWidths[i]) {
                columnWidths[i] = width;
            }
            cell.setCellStyle(titleStyle);
            /** 跳到合并的最后一个单元格 */
            i = i + header.getColCellNum() - 1;
        }
        for (int i = 0; i < headers.size(); i++) {
            sheet.setColumnWidth(i, columnWidths[i]);
        }
        calcColumWidth(sheet, headers, columnWidths);
    }

    @Override
    protected void createData(Sheet sheet, HSSFCellStyle dataStyle, List<?> dataList, List<ExcelHeader> headers, int[] columnWidths, float heightInPoints) throws Exception {
        createData(sheet, dataStyle, dataList, headers, columnWidths, heightInPoints, false);
    }


    /**
     * 下载行业应用
     */
    public static void exportExcel(Class<?> clazz, HttpServletResponse response) throws Exception {
        exportExcel(clazz, null, null, response);
    }

    /**
     * 导出多工作簿Excel
     *
     * @param excelBaseAttrs
     * @param response
     * @throws Exception
     */
    public static void exportExcel(List<ExcelBaseAttribute> excelBaseAttrs, String filename, HttpServletResponse response) throws Exception {
        if (CollectionUtils.isEmpty(excelBaseAttrs)) {
            throw new BizException(ResultCode.INVALID_ARGUMENT, "Excel属性列表不能为空");
        }
        Set<String> sheetNameSet = new HashSet<>();
        for (int i = 0; i < excelBaseAttrs.size(); i++) {
            ExcelBaseAttribute excelBaseAttr = excelBaseAttrs.get(i);
            String sheetName = getSheetName(excelBaseAttr.getClazz());
            sheetName = sheetNameSet.contains(sheetName) ? sheetName + i : sheetName;
            excelBaseAttr.setSheetName(sheetName);
            sheetNameSet.add(sheetName);
            excelBaseAttr.setHeaders(getExcelHeader(excelBaseAttr.getClazz()));
        }
        /**取第一个*/
        filename = StringUtils.isNotBlank(filename) ? filename : getFilename(excelBaseAttrs.get(0).getClazz());
        filename = StringUtils.isNotBlank(filename) ? filename : DEFAULT_FILENAME;
        /**得到Excel导出实例*/
        DefaultExcelExportUtils export = DefaultExcelExportUtils.getInstance(excelBaseAttrs);
        Workbook wb = export.exportWorkbook();
        /**设置导出文件名,开始进行导出*/
        DefaultExcelExportUtils.writer(filename, wb, response);
    }

    /***
     * 导出Excel
     *
     * @param clazz
     * @param dataList
     * @param response
     */
    public static void exportExcel(Class<?> clazz, List dataList, String filename, HttpServletResponse response) throws Exception {
        clazz = Objects.requireNonNull(clazz);
        String sheetName = "";
        if (clazz.isAnnotationPresent(ExcelInfo.class)) {
            ExcelInfo annotation = clazz.getAnnotation(ExcelInfo.class);
            filename = StringUtils.isNotBlank(filename) ? filename : annotation.fileName();
            sheetName = annotation.sheetName();
        }
        filename = StringUtils.isNotBlank(filename) ? filename : DEFAULT_FILENAME;
        sheetName = StringUtils.isNotBlank(sheetName) ? sheetName : DEFAULT_SHEETNAME;

        List<ExcelHeader> headers = getExcelHeader(clazz);

        /**得到Excel导出实例*/
        DefaultExcelExportUtils export = DefaultExcelExportUtils.getInstance(sheetName, headers, dataList);
        Workbook wb = export.exportWorkbook();
        /**设置导出文件名,开始进行导出*/
        DefaultExcelExportUtils.writer(filename, wb, response);
    }

    /**
     * @param headers
     * @param dataList
     * @param sheetName
     * @param filename
     * @param response
     * @throws Exception
     */
    public static void exportExcelByMap(List<ExcelHeader> headers, List dataList, String sheetName,
                                        String filename, HttpServletResponse response) throws Exception {
        /**得到Excel导出实例*/
        DefaultExcelExportUtils export = DefaultExcelExportUtils.getInstance(sheetName, headers, dataList);
        Workbook wb = export.exportWorkbookByMap();
        /**设置导出文件名,开始进行导出*/
        DefaultExcelExportUtils.writer(filename, wb, response);
    }

    /**
     * @return
     * @throws Exception
     */
    protected Workbook exportWorkbookByMap() throws Exception {
        createExcelTitle();
        createDataByMap();
        return wb;
    }

    /**
     * 通过map方式创建
     *
     * @throws Exception
     */
    protected void createDataByMap() throws Exception {
        for (ExcelSheet excelSheet : excelSheets) {
            createData(excelSheet.getSheet(), excelSheet.getDataStyle(), excelSheet.getDataList(),
                    excelSheet.getHeaders(), excelSheet.getColumnWidths(), excelSheet.getHeightInPoints(),
                    true);
        }
    }

    /**
     * 填充数据，支持map
     *
     * @param sheet
     * @param dataStyle
     * @param dataList
     * @param headers
     * @param columnWidths
     * @param heightInPointsm
     * @param isMap
     * @throws Exception
     */
    protected void createData(Sheet sheet, HSSFCellStyle dataStyle, List<?> dataList, List<ExcelHeader> headers, int[] columnWidths, float heightInPointsm, boolean isMap) throws Exception {
        if (dataList == null || dataList.isEmpty()) return;
        int rowIndex = sheet.getLastRowNum() + 1;
        for (int i = 0; i < dataList.size(); i++) {
            Row row = sheet.createRow(rowIndex);
            row.setHeightInPoints(heightInPointsm);
            Object o = dataList.get(i);
            for (int j = 0; j < headers.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellStyle(dataStyle);
                Object value = null;
                try {
                    if (isMap) {
                        value = ((Map) o).get(headers.get(j).getImportFiled());
                    } else {
                        value = getValueFromObject(o, headers.get(j).getImportFiled());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new BizException(ResultCode.INVALID_ARGUMENT, "获取对象属性值出错");
                }
                if (value != null) {
                    String valueString = convertDataValueToString(value);
                    cell.setCellValue(valueString);
                    int width = calcCellWidth(valueString, 8);
                    if (width > columnWidths[j]) {
                        columnWidths[j] = width;
                    }
                }
            }
            rowIndex++;
        }
        /** 设置 Column Width*/
        calcColumWidth(sheet, headers, columnWidths);
    }
}
