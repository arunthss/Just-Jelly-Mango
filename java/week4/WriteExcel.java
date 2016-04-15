package week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException 
	{
		String tcase[] = {"Create Lead",
						"Edit Lead",
						"Delete Lead",
						"Merge Lead"};
		
		int i;
		
		XSSFWorkbook wbook = new XSSFWorkbook();
		XSSFSheet sheet = wbook.createSheet("Output1");
		XSSFRow row = sheet.createRow(0);
		
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("Serial No");
		
		cell = row.createCell(1);
		cell.setCellValue("Test Case");
		
		cell = row.createCell(2);
		cell.setCellValue("Status");
		
		for(i=1;i<=4;i++)
			{
				//System.out.println(i);
				
				row = sheet.createRow(i);
				row.createCell(0).setCellValue(i);
				row.createCell(1).setCellValue(tcase[i-1]);

				if(i%2==0)
				{
					row.createCell(2).setCellValue("Fail");				
				}
				else
				{
					row.createCell(2).setCellValue("Pass");				
				}
			}
		System.out.println("Out of loop");	
		FileOutputStream fos = new FileOutputStream(new File("D:\\Programs\\Java\\Output.xlsx"));
		wbook.write(fos);
		
		wbook.close();
		fos.close();
	}

}
