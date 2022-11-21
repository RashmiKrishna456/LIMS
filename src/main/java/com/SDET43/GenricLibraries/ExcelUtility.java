package com.SDET43.GenricLibraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility extends JavaUtility{
	/**
	 * This method is used to read the data from Excel
	 * @author Admin
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 */

	public String readDataFromExcel(String SheetName, int RowNo, int ColumnNo) throws Throwable
	{
		FileInputStream fi = new FileInputStream(iPathConstant.ExcelPath);	
		Workbook wb = WorkbookFactory.create(fi);	
		Sheet sh = wb.getSheet(SheetName);			
		Row ro = sh.getRow(RowNo);						
		Cell cel = ro.getCell(ColumnNo);					
		String value = cel.getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to write the data into Excel
	 * @author Admin
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	
	public String WriteDataIntoExcel(String SheetName, int RowNo, int ColumnNo, String data) throws Throwable 
	{	
		FileInputStream fi = new FileInputStream(iPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);	
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.createRow(RowNo);
		Cell cel = ro.createCell(ColumnNo);
			cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(iPathConstant.ExcelPath);
		wb.write(fos);
		return data;	
	}
	
	/**
	 * This method is used to get Last Row Count
	 * @author Admin
	 * @param SheetName
	 * @return 
	 * @throws Throwable
	 */
	public int GetLastRowNo(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(iPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);	
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	
	public Map<String, String> getList(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(iPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getRow(1).getLastCellNum();
		Map<String, String> map = new HashMap<String, String>();
		for(int i = 0; i<count; i++)
		{
			String key = sh.getRow(0).getCell(i).getStringCellValue();
			String value = sh.getRow(1).getCell(i).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	/**
	 * This method is used to get
	 * @param SheetName
	 * @param driver
	 * @throws Throwable
	 */
	public void getList(String SheetName,WebDriver driver) throws Throwable 
	{
		FileInputStream fi = new FileInputStream(iPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		for (int i = 0; i <=count; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			if(key.equals("columnName")) {
				value = value+"_"+getRandomNumber();
			}
			driver.findElement(By.name(key)).sendKeys(value);
		}
		}
	public void getListForUpdate(int count,Sheet sh,WebDriver driver,int random)
	{
	for(int i=0;i<=count;i++)
	{
		String key=sh.getRow(i).getCell(0).getStringCellValue();
		String Value=sh.getRow(i).getCell(1).getStringCellValue();
		if(key.equals("client_password"))
		{
			Value=Value+"_"+random;
		}
		driver.findElement(By.name(key)).sendKeys(Value);
	}
	}
	public Object[][] readMulitipleData(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(iPathConstant.ExcelDataProvider);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i = 0; i<lastRow; i++)
		{
			for(int j = 0; j < lastCell; j++)
				{
					obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				}
		}
		return obj;
	}
}
