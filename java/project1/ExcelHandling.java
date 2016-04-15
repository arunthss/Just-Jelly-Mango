package project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandling {

	XSSFWorkbook wbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	FileInputStream fis;
	FileOutputStream fos;
	
	File file;
	
	public boolean openSheet(String fileName, String sheetName) throws IOException
	{
		try
		{
			file = new File(fileName);
			fis = new FileInputStream(file);
			wbook = new XSSFWorkbook(fis);
			sheet = wbook.getSheet(sheetName);
			return true;
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Requested File Unavailable");
			return false;
		}
	}
	
	public String getStringData(int rowNum, int colNum) throws NullPointerException
	{
		try {
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			return cell.getStringCellValue();
		} 
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("No Data Found at Row "+rowNum+ " Col "+colNum);
			return null;
		}
	}
	
	public double getDblData(int rowNum, int colNum) throws NullPointerException
	{
		try {
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			return cell.getNumericCellValue();
		} 
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("No Data Found at Row "+rowNum+ " Col "+colNum);
			return 0;
		}
	}
	
	public void createSheet(String fileName, String sheetName) throws IOException
	{
		file = new File(fileName);
		fos = new FileOutputStream(file);
		wbook = new XSSFWorkbook();
		sheet = wbook.createSheet(sheetName);	
	}
	
	public void putData(int rowNum, int colNum, String data)
	{
		row = sheet.createRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
	}

	public void appendSheet(String fileName, String sheetName) throws InvalidFormatException, IOException
	{
		file = new File(fileName);
		fis = new FileInputStream(file);
		
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet(sheetName);
		fos = new FileOutputStream(file);
	}
	
	public void updateData(int rowNum, int colNum, String data)
	{
		row = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
	}
	
	public void writeAndClose() throws IOException
	{
		wbook.write(fos);
		wbook.close();
		fos.close();
	}
	
	public void readClose() throws IOException
	{
		wbook.close();
		fis.close();
	}
	
	public void addRow(int rowNum)
	{
		row = sheet.createRow(rowNum);
	}
	
	public void addCellData(int rowNum, int colNum, String content)
	{
		row = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(content);
	}
}
