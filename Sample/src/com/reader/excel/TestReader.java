package com.reader.excel;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class TestReader
{
	
	
	public static void main(String[] args) throws Exception
	{
		String fileName = "C:\\redknee\\selenium-2.25.0\\etc\\Config-New.xls";
		
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileName));
		HSSFSheet sheet = workbook.getSheet("Execution_Step");
		
		/*int lastRowNum = sheet.getPhysicalNumberOfRows();
		HSSFRow row = sheet.getRow(1);
		Iterator<Row> i = sheet.rowIterator();
		i.next();
		while(i.hasNext())
		{
			Row r = i.next();
			System.out.println(r.getCell(0).getStringCellValue());
			if(Integer.parseInt(r.getCell(0).getStringCellValue()) == 3)
			{
				System.out.println("Value 3 found at row: " +r.getRowNum());
			}
		}
		HSSFCell cell = row.getCell(2);*/
		
		//System.out.println(row.toString());
		/*System.out.println(cell.getRichStringCellValue());
		System.out.println(cell.getStringCellValue());*/
		//workbook.createSheet("Report");
		
		/*-------------------------------------------------------------*/
		String[] list = getRow(sheet, 3, 0, 10);
		String values = getCommaSeparatedValues(list);
		System.out.println(values);
		
	}
	
	public static String readByRowNameColumnId(String columnName, int rowId)
	{
		String data = "";
		
		
		
		return data;
	}
	
	public static String[] getRow(HSSFSheet sheet, int rowNum, int leftBoundary, int rightBoundary)
	{
		String[] rowValues = new String[rightBoundary - leftBoundary + 1];
		
		/*
		 * i is the pointer to array index.
		 * left boundary is dynamic and increases. It's the pointer to cell in the row.
		 * Proceed until leftBoundary meets rightBoundary.
		 */
		for(int i = 0; leftBoundary <= rightBoundary; i++, leftBoundary++)
		{
			HSSFCell cell = sheet.getRow(rowNum).getCell(leftBoundary);
			try
			{
				rowValues[i] = cell.getStringCellValue();
			}
			catch(IllegalStateException ise)
			{
				rowValues[i] = String.valueOf((long)cell.getNumericCellValue());
			}
		}
		
		return rowValues;
	}
	
	private static String getCommaSeparatedValues(String[] argList)
	{
		if(argList.length == 0)
			return "";
		
		StringBuffer sb = new StringBuffer();
		for(String s : argList)
		{
			sb.append(s+ ",");
		}
		int length = sb.toString().length();
		return sb.toString().substring(0, length - 1);
	}
}
