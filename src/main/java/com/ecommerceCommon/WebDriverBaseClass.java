package com.ecommerceCommon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBaseClass {
	
	 public static	WebDriver driver=null;
	   public static   WebDriverWait wait=null;
	   public static String screenshotSubFolder;
		
	@Parameters("browsersname")
		public WebDriver loadWebDriver(String browsersname) {
			

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
				 
//				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			
		
			
			
			wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			
			
			driver.get("https://demo.nopcommerce.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
			
			}
		public void captureScreenShot(String screenshotFile)  {
			
			// Formatting date and time for java from google search
			
			if(screenshotSubFolder==null) {
			
			LocalDateTime myDateObj = LocalDateTime.now();
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

		    screenshotSubFolder = myDateObj.format(myFormatObj);
			}
			
			
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/"+screenshotSubFolder+"/" +screenshotFile+".jpg");	
			
			try {
				FileUtils.copyFile(sourceFile, destFile);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			System.out.println("Screenshot saved successfully");
			
			
		}
	}


