package tests;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;


public class JQCAdminStoreSetup extends QCStore
{

	public static void storeSetup(String SSN,String AppURL)
	{
		
	try{
			int lastrow=TestData.getLastRow("Store_Setup");
			String sheetName="Store_Setup";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
					String Password = TestData.getCellData(sheetName,"AdminPassword",row);
					String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);

					String StoreID = TestData.getCellData(sheetName,"StoreID",row);

					if(prop.getProperty("login_method").equalsIgnoreCase("local"))
					{
						driver = new InternetExplorerDriver();
					}
					else
					{
						String Node = "http://192.168.1.182:5555/wd/hub";
						 //String Node2 = "http://192.168.0.238:5566/wd/hub";
						 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
						 driver = new RemoteWebDriver(new URL(Node), cap);	
					}
					wait = new WebDriverWait(driver, 40000);

					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
				
					driver.get(AdminURL);
					test.log(LogStatus.INFO, "Opened the Admin URL" + AdminURL);

		driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

		test.log(LogStatus.PASS, "Username is entered: "+UserName); 

		driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

		test.log(LogStatus.PASS, "Password is entered: "+Password); 

		//Click Login Button

		driver.findElement(By.name("login")).click();

		test.log(LogStatus.PASS, "Clicked on Submit button");
		
		driver.switchTo().defaultContent();

		driver.switchTo().frame("topFrame");

		driver.findElement(locator(Jprop.getProperty("admin_store_setup_tab"))).click(); 

		test.log(LogStatus.PASS, "Clicked on Store tab");
	
	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	
	driver.findElement(locator(Jprop.getProperty("admin_store_config"))).click();

	test.log(LogStatus.PASS, "Clicked on Store Config link");

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");
Thread.sleep(2000);
	driver.findElement(locator(Jprop.getProperty("admin_store_edit"))).click();

	test.log(LogStatus.PASS, "Clicked on Store Edit");
	
	Thread.sleep(2000);
	
	driver.switchTo().frame("main");
	
	driver.findElement(locator(Jprop.getProperty("admin_store_nbr"))).sendKeys(StoreID);

	test.log(LogStatus.PASS, "Entered Store number "+StoreID);

	driver.findElement(locator(Jprop.getProperty("admin_store_submit_btn"))).click();

	test.log(LogStatus.PASS, "Clicked on Submit button");


	Thread.sleep(5000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");

	driver.findElement(locator(Jprop.getProperty("admin_store_status"))).sendKeys("Open");

	test.log(LogStatus.PASS, "Store status set as Open"); 

	driver.findElement(locator(Jprop.getProperty("admin_store_edit_submit"))).click();

	test.log(LogStatus.PASS, "Clicked on Submit"); 
	Thread.sleep(2000);
	driver.findElement(locator(Jprop.getProperty("admin_store_ok_btn"))).click();

	test.log(LogStatus.PASS, "Clicked on OK button"); 


	test.log(LogStatus.PASS, "Store Setup is successful:");
	test.log(LogStatus.PASS, "***********************************************");
	

break;
}
			}	
	
	
}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					test.log(LogStatus.INFO,""+e);
					test.log(LogStatus.FAIL, "Store setup process is initiated again due to Application sync issue");


				}

	
	}
}
