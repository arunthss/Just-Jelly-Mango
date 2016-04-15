package week1;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstProject {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.calculator.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCalc() throws Exception {
    driver.findElement(By.linkText("Loan")).click();
    driver.findElement(By.id("cloanamount")).clear();
    driver.findElement(By.id("cloanamount")).sendKeys("500000");
    driver.findElement(By.id("cloanterm")).clear();
    driver.findElement(By.id("cloanterm")).sendKeys("15");
    driver.findElement(By.id("cloantermmonth")).clear();
    driver.findElement(By.id("cloantermmonth")).sendKeys("8");
    driver.findElement(By.id("cinterestrate")).clear();
    driver.findElement(By.id("cinterestrate")).sendKeys("8");
    new Select(driver.findElement(By.id("ccompound"))).selectByVisibleText("Semi-monthly");
    new Select(driver.findElement(By.id("cpayback"))).selectByVisibleText("Every Quarter");
    driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
    driver.findElement(By.cssSelector("h2.h2result")).click();
    driver.findElement(By.cssSelector("h1")).click();
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
