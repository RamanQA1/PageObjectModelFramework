package com.ecommercePages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ContactUsPage {
	

	WebDriver driver;
	WebDriverWait wait;
	
	public ContactUsPage(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

    public void clickOnContactUsLink() {
	
	driver.findElement(By.xpath("//a[text()='Contact us']")).click();
	
}


    public void contactUsForm(String name,String email,String enquiry) {
    	
    	driver.findElement(By.id("FullName")).sendKeys(name);
    	driver.findElement(By.id("Email")).sendKeys(email);
    	driver.findElement(By.id("Enquiry")).sendKeys(enquiry);
    	driver.findElement(By.name("send-email")).click();
    }

}
