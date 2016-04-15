// Open IRCTC Site till captcha
package week1;


import org.openqa.selenium.firefox.FirefoxDriver;

public class HomeWork4 
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		// create object for firefox driver class
		FirefoxDriver webPage = new FirefoxDriver();
		
		// open IRCTC registration page using gets method 
		webPage.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		// check if requested page has been opened or not
		System.out.println(webPage.getTitle()+" Loaded");
		
		// Enter username
		webPage.findElementById("userRegistrationForm:userName").sendKeys("login987");
		
		//Enter Password
		webPage.findElementById("userRegistrationForm:password").sendKeys("Pass1234");
		
		//Re-enter Password
		webPage.findElementById("userRegistrationForm:confpasword").sendKeys("Pass1234");
		
		//Select security question
		webPage.findElementById("userRegistrationForm:securityQ").sendKeys("What is your pet name?");
		
		//Enter Security answer
		webPage.findElementById("userRegistrationForm:securityAnswer").sendKeys("Pupppy");
		
		//Enter First Name
		webPage.findElementById("userRegistrationForm:firstName").sendKeys("Arun");
		
		//Enter Last Name
		webPage.findElementById("userRegistrationForm:lastName").sendKeys("Rajamani");
		
		//Enter Gender
		webPage.findElementById("userRegistrationForm:gender:0").click();
		
		//Enter Marital Status
		webPage.findElementById("userRegistrationForm:maritalStatus:1").click();
		
		//DOB Date
		webPage.findElementById("userRegistrationForm:dobDay").sendKeys("12");
		
		//DOB Month
		webPage.findElementById("userRegistrationForm:dobMonth").sendKeys("06");
		
		//DOB Year
		webPage.findElementById("userRegistrationForm:dateOfBirth").sendKeys("1989");
		
		//Enter Occupation
		webPage.findElementById("userRegistrationForm:occupation").sendKeys("Private");
		
		//Enter email id
		webPage.findElementById("userRegistrationForm:email").sendKeys("abc@test.com");
		
		//Enter mobile num
		webPage.findElementById("userRegistrationForm:mobile").sendKeys("1234567890");
		
		//Enter Nationality
		webPage.findElementById("userRegistrationForm:nationalityId").sendKeys("India");
		
		//Enter Address
		webPage.findElementById("userRegistrationForm:address").sendKeys("123 Test Address");
		
		//Enter Country
		webPage.findElementById("userRegistrationForm:countries").sendKeys("India");
		
		//Enter pincode
		webPage.findElementById("userRegistrationForm:pincode").sendKeys("600073");
		
		//Click on page for drop down to load 
		webPage.findElementByTagName("body").click();
		Thread.sleep(10000);
		
		//Select city/town Name
		webPage.findElementById("userRegistrationForm:cityName").sendKeys("Kanchipuram");
		
		//Click on page for drop down to load
		webPage.findElementByTagName("body").click();
		
		Thread.sleep(10000);
		//Select post office name
		webPage.findElementById("userRegistrationForm:postofficeName").sendKeys("Gowriwakkam S.O");
		
		//Enter Landline phone number
		webPage.findElementById("userRegistrationForm:landline").sendKeys("1234567890");
		
		//Click Submit Link
		webPage.findElementById("userRegistrationForm:j_idt486").click();
	}

}
