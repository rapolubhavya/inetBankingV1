package com.inetbanking.testCases;

import org.testng.annotations.Test;

import java.io.IOException;



import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

@Test
public class TC_AddCustomerTest_003 extends BaseClass{
	
	
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust= new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("Providing customer details.....");
		
		addcust.custName("bhavya");
		addcust.custgender("female");
		addcust.custdob("01", "05", "2002");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("TELANGANA");
		addcust.custpinno("500008");
		addcust.custtelephoneno("9390297681");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started...");
		
		boolean res= driver.getPageSource().contains("Customer Registered Successfully");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			logger.info("test case failed...");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}

	
	
	

}
