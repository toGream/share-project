package org.share.topic.impl.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static void main(String[] args) {
		String[] A = {"a1", "a2", "a3", "a4", "a5", "a6"};
		String[] B = {"a1", "a2", "a3", "a4", "a5"};
		String[] C = {"a1", "a2"};
		String[] D = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9"};
		String[] E = {"a1", "a2", "a3", "a4", "a5"};
		//1.从数据库中获取模板，查询所有的columns
		List<String> titles = Arrays.asList(A);
		//2.查询所有的数据
		List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
		for(int i=0; i<10000; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			for(int j=0; j<100; j++) {
				map.put("a"+j, i+"-"+j);
			}
			datas.add(map);
		}
		
		//3.导出
		ExcelExportBean excelExportBean = new ExcelExportBean("TEST", "TEST1", titles, datas);
		try {
			long startTime = System.currentTimeMillis();
//			Excel2007AboveOperateOldLarge("test");
			ExcelUtils.exportToExcel(excelExportBean);
			long endTime = System.currentTimeMillis();
			System.err.println(endTime - startTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 不支持2007版本HSSF
	 * @param filePath
	 * @throws Exception
	 */
	public static void Excel2003perate(String filePath) throws Exception{
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
		HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
		for(int i=0; i<10000; i++) {
			HSSFRow hssfRow = sheet.createRow(i);
			for(int j=0; j<10; j++) {
				HSSFCellUtil.createCell(hssfRow, j, String.valueOf(Math.random()));
			}
		}
		FileOutputStream out = new FileOutputStream("workbook.xlsx");
		hssfWorkbook.write(out);
		out.close();
	}
	
	/**
	 * 2007及以上版本 XSSF
	 * @param filePath
	 * @throws Exception
	 */
	public static void Excel2007AboveOperateOld(String filePath) throws Exception{
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(new File(filePath)));
		XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
		for(int i=0; i<100000; i++) {
			XSSFRow xssfRow = sheet.createRow(i);
			for(int j=0; j<10; j++) {
				if(i == 0) {
					xssfRow.createCell(j).setCellValue("column"+j);
				}else {
					if(j == 0) {
						CellUtil.createCell(xssfRow, j, String.valueOf(i));
					}else {
						CellUtil.createCell(xssfRow, j, String.valueOf(Math.random()));
					}
				}
			}
		}
		FileOutputStream out = new FileOutputStream("H:\\workbook.xlsx");
		xssfWorkbook.write(out);
		out.close();
	}
	
	/**
	 * 超大数据量处理SXSSF
	 * @param filePath
	 * @throws Exception
	 */
	public static void Excel2007AboveOperateOldLarge(String sheetName) throws Exception{
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(xssfWorkbook, 100);		
		Sheet sheet = sxssfWorkbook.createSheet(sheetName);
		for(int i=0; i<1000000; i++) {
			Row row = sheet.createRow(i);
			for(int j=0; j<10; j++) {
				if(i == 0) {
					row.createCell(j).setCellValue("column"+j);
				}else {
					if(j == 0) {
						CellUtil.createCell(row, j, String.valueOf(i));
					}else {
						CellUtil.createCell(row, j, String.valueOf(Math.random()));
					}
				}
			}
		}
		FileOutputStream out = new FileOutputStream("H:\\workbook.xlsx");
		sxssfWorkbook.write(out);
		out.close();
	}
	
	public static void exportToExcel(ExcelExportBean excelExportBean) throws Exception {
		String sheetName = excelExportBean.getSheetName();
		List<String> titles = excelExportBean.getTitles();
		List<Map<String,Object>> datas = excelExportBean.getDatas();
		SXSSFWorkbook book = new SXSSFWorkbook();
		Sheet sheet = book.createSheet(sheetName);
		Row row = sheet.createRow(0);
		CellStyle cellStyle = book.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		
		//1.设置列名
		Cell cell = null;
		for(int i=0; i<titles.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(titles.get(i));
			cell.setCellStyle(cellStyle);
		}
		//2.设置列值
		int rows = 1;
		int titleSize = titles.size();
		for(Map<String, Object> data : datas) {
			Row row1 = sheet.createRow(rows++);
			
			int cells = 0;
			for(int i=0; i<titleSize; i++) {
				String key = titles.get(i);
				Object obj = data.get(key);
				if(null == obj) {
					row1.createCell(cells).setCellValue("");
				}else {
					row1.createCell(cells).setCellValue(String.valueOf(obj));
				}
				cells++;
			}
		}
		FileOutputStream out = new FileOutputStream("H:\\workbook.xlsx");
		book.write(out);
		out.close();
	}
	

	private static String matchTitle(String column) {
        if ("字段1".equalsIgnoreCase(column)) return "标题1";
        if ("字段2".equalsIgnoreCase(column)) return "标题2";
        if ("字段3".equalsIgnoreCase(column)) return "标题3";
        if ("字段4".equalsIgnoreCase(column)) return "标题4";
        return column;
    }
}

class ExcelExportBean {
	private String sheetName;
	private String fileName;
	private List<String> titles;
	private List<Map<String, Object>> datas;
	
	public ExcelExportBean(String sheetName, String fileName, 
			List<String> titles, List<Map<String, Object>> datas){
		this.sheetName = sheetName;
		this.fileName = fileName;
		this.titles = titles;
		this.datas = datas;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	public List<Map<String, Object>> getDatas() {
		return datas;
	}

	public void setDatas(List<Map<String, Object>> datas) {
		this.datas = datas;
	}
}
