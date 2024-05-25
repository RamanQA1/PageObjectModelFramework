package com.ecommercePages;


import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ecommerceCommon.ObjectLocatorRepository;


public class HomePage implements ObjectLocatorRepository{
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	
	public void RegistrationForm(String Firstname,String Lastname,String day,String month,String year,String email,
			String companyname,String password, String confirmPassword) {
		
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		boolean display1=driver.findElement(By.xpath("//h1[text()='Register']")).isDisplayed();
		assertEquals(display1, true);
		String pageurl= driver.getCurrentUrl();
		assertEquals(pageurl, "https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.findElement(By.id("gender-male")).click();
		
		driver.findElement(By.id(homepage_firstname)).sendKeys(Firstname);
		driver.findElement(By.id(homepage_lastname)).sendKeys(Lastname);
		
		Select sel= new Select(driver.findElement(By.name(homepage_dateofbirthday)));
		sel.selectByValue(day);
		 sel= new Select(driver.findElement(By.name( homepage_dateofbirthmonth)));
		sel.selectByValue(month);
		 sel= new Select(driver.findElement(By.name(homepage_dateofbirthyear)));
		sel.selectByValue(year);
		
		driver.findElement(By.id( homepage_email)).sendKeys( email);
		driver.findElement(By.id(homepage_company)).sendKeys(companyname);
		driver.findElement(By.id(homepage_password)).sendKeys(password);
		driver.findElement(By.id(homepage_confirnpassword)).sendKeys(confirmPassword);
		driver.findElement(By.id(homepage_registrationbutton)).click();
		
		}
	
	public void successfullySubmitted() {
		boolean display2=driver.findElement(By.xpath("//div[text()='Your registration completed']")).isDisplayed();
		assertEquals(display2,true);
	}

}
