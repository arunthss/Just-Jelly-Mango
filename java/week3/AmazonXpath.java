package week3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonXpath 
{

	public static void main(String[] args) throws IOException 
	{
		String item = "";
		
		String itemno ="";
		
		FileInputStream fil = new FileInputStream(new File("./data/amazon.xlsx"));
		
		XSSFWorkbook book = new XSSFWorkbook(fil);
		
		XSSFSheet sheet = book.getSheet("data");
		
		XSSFRow rw = sheet.getRow(1);
		
		item = rw.getCell(0).getStringCellValue();
		
		itemno = rw.getCell(1).getStringCellValue();
		
		book.close();
		
		System.out.println(item+" "+itemno);
		
		String path = "//li[@id='result_"+itemno+"']/div/div/div/div[2]/div[2]/a/h2";
		
		//System.out.println(path);
		
		FirefoxDriver driver= new FirefoxDriver();
		
		driver.get("http://www.amazon.in/");
		
		driver.findElementById("twotabsearchtextbox").sendKeys(item);
		
		driver.findElementByXPath("//div[@class='nav-search-submit nav-sprite']/input").click();
		
		//driver.findElementByClassName("nav-input").click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement myItem = driver.findElementByXPath(path); 
		
		System.out.println(myItem.getText());
		
		myItem.click();
		
	}

}
