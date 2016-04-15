package project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import project1.ExcelHandling;

public class AppendExcel extends MyWrapper 
{	
	@Test
	public void maina() throws InvalidFormatException, IOException 
	{
		String a = "No records to display";
		System.out.println(a.trim().equalsIgnoreCase("No records to display"));
	}
}
