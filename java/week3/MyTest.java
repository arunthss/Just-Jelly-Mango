package week3;
import org.junit.Test;
import org.openqa.selenium.By;

import week3.MyWrapper;

public class MyTest extends MyWrapper {

	@Test
	public void mymethod()
	{	
		getPage("chrome", "http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		switchToFrameByElement(driver.findElement(By.id("iframeResult")));
		clickByXpath("");
	}
}
