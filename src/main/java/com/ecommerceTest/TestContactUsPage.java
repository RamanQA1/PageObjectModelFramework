package com.ecommerceTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommercePages.ContactUsPage;
import com.ecommercePages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestContactUsPage {
	

	WebDriver driver=null;
	WebDriverWait wait=null;
	ContactUsPage contactpage=null;
	
	@Parameters("browsersname")
	@BeforeClass
	public void beforeClass(@Optional("chrome")String browsersname) {
		

		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		
		if(browsersname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browsersname.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver ();
		}
		else if(browsersname.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			 
//			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	
		 contactpage= new ContactUsPage(driver);
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		}
	
@Test
    public void fillContactUsForm() {
	
	contactpage.clickOnContactUsLink();
	contactpage.contactUsForm("Raman Thakur","Raman12@gmail.com","Automation testing is good");
}

}
