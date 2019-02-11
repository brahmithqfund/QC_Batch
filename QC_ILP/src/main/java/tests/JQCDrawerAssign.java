package tests;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCDrawerAssign extends QCStore{
	public static void drawerAssign(String SSN,String AppURL)
	{
		
		try{
				int lastrow=TestData.getLastRow("Drawer_Assign");
				String sheetName="Drawer_Assign";


				for(int row=2;row<=lastrow;row++)
				{		
					
				
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);	
						
						if(SSN.equals(RegSSN))
						{
						
						String PIN = TestData.getCellData(sheetName,"PIN",row);						
						String CountofDollarCoins = TestData.getCellData(sheetName,"CountofDollarCoins",row);
						

						
						test.log(LogStatus.INFO, "Drawer assign process initiated" );
						 Thread.sleep(4000);
						 driver.switchTo().defaultContent();
		                    driver.switchTo().frame("topFrame");
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Cash Management')]")));

		                    driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();
		                    test.log(LogStatus.PASS, "Clicked on Cash Management");
		                    Thread.sleep(3000);
		                 
		                    driver.switchTo().defaultContent();
		                    driver.switchTo().frame("mainFrame");
		                 
		                    driver.findElement(By.linkText("Drawer")).click();
		                    test.log(LogStatus.PASS, "Clicked on Drawer");

		                    driver.switchTo().defaultContent();
		                    driver.switchTo().frame("mainFrame");
		                    driver.findElement(By.linkText("Assign")).click();
		                    test.log(LogStatus.PASS, "Clicked on Assign");
		                    Thread.sleep(5000);
		                    driver.switchTo().defaultContent();
		                    driver.switchTo().frame("mainFrame");
		                    driver.switchTo().frame("main");

		                    driver.findElement(By.name("drawerAssignRequestBean.noOf100Dollars")).sendKeys(CountofDollarCoins);
		                    test.log(LogStatus.PASS,"Count of Dollar Coins is entered as 500");
		                    Thread.sleep(4000);
		                    driver.findElement(By.name("drawerAssignRequestBean.password")).sendKeys(PIN);
		                    test.log(LogStatus.PASS,"Entered the Password as: "+PIN);
		                    driver.findElement(By.name("drawerassign")).click();
		                    test.log(LogStatus.PASS,"Clicked on Drawer assign ");
		                    try {
		                            Alert alert = driver.switchTo().alert();
		                            alert.accept();
		                            test.log(LogStatus.PASS," Alert accepted ");

		                    }
		                    catch (NoAlertPresentException e) {
		                        

		                    }

						    		Thread.sleep(4000);
						    	 test.log(LogStatus.PASS,"Drawer assigned successfully");
						    	 test.log(LogStatus.PASS, "***********************************************");
						    	 driver.findElement(By.name("done")).click();
						    	 test.log(LogStatus.PASS,"Click on ok button");
						  
		                  break; 
						}
				}
		
				  // break for FOR loop	
		}
		
		catch (Exception e) {
			test.log(LogStatus.INFO,""+e);
			test.log(LogStatus.FAIL, "Drawer assign process is initiated again due to Application sync issue");

			e.printStackTrace();
			
			
		}
		
		
	
}
}
		