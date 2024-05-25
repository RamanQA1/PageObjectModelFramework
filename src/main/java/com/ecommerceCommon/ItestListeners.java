package com.ecommerceCommon;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListeners extends WebDriverBaseClass implements ITestListener {
	
	
	
	public void onTestFailure(ITestResult result) {
		
		System.out.println(result.getName());
		
		captureScreenShot(result.getName()+"jpg");
	}


}
