package com.ecommerceTest;


import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerceCommon.WebDriverBaseClass;
import com.ecommercePages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestHomePage extends WebDriverBaseClass{
	

	WebDriver driver=null;
	WebDriverWait wait=null;
	HomePage homepage=null;
	
	@Parameters("browsersname")
	@BeforeClass
	public void beforeClass(@Optional("chrome")String browsersname) {
		

	driver=loadWebDriver(browsersname);
	
	homepage=new HomePage(driver);
		}
	
	@AfterClass
	public void afterClass() {
		
		driver.close();
	}




        @Test
        public void fillRegistrationForm() {
        	
        homepage.RegistrationForm("Akash","Thakur","21","3","1993","akash123","ibm","akash123","akasgdhdbh");	
	 
		homepage.successfullySubmitted();
	}

}
