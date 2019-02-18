package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;

public class LendNationRepaymentInformation extends LendNation{

	  @Test(priority=4)
	  public static void repaymentInformation(String SSN,String AppURL) throws Exception
	  {
		  try{
			  String FileName= prop.getProperty("file_name");
				ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 

			//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			int lastrow=TestData.getLastRow("Repayment Information");
			String sheetName="Repayment Information";
			WebDriverWait wait = new WebDriverWait(driver, 40000);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{	
			String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
			
			Thread.sleep(30000);

			  wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("repayment_method_type"))));
			  

			
			
		//	test.log(LogStatus.INFO, "Lend Nation application navigated to Repayment Information page " );
			test.log(LogStatus.INFO, "Lend Nation application navigated to Repayment Information page");
			driver.findElement(locator(prop.getProperty("repayment_method_type"))).sendKeys(RepaymentMethod);
			test.log(LogStatus.PASS, "Selected repayment type as " + RepaymentMethod);
			Thread.sleep(10000);

			driver.findElement(locator(prop.getProperty("continue_button_Information_page"))).click();
			  test.log(LogStatus.PASS, "Clicked on Continue " );
			  try{
				  driver.findElement(locator(prop.getProperty("repayment_method_type"))).sendKeys("d");
				  Thread.sleep(2000);
				  driver.findElement(locator(prop.getProperty("repayment_method_type"))).sendKeys(RepaymentMethod);
				  Thread.sleep(4000);
				  driver.findElement(locator(prop.getProperty("continue_button_Information_page"))).click();
			  }
			  catch(Exception e)
			  {
				  
			  }

			  wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("loan_amount"))));
	Thread.sleep(20000);
			  if( driver.findElement(locator(prop.getProperty("loan_amount"))).isEnabled())
			  {
					//test.log(LogStatus.PASS, "Repayment Information Entered Successfully with SSN : " +SSN);
					test.log(LogStatus.PASS, "Repayment Information Entered Successfully with SSN : " +SSN);

				 	}
					else
					{
					test.log(LogStatus.FAIL, "Repayment Information is not entered Successfully with SSN  : " +SSN);
					}
			
			
				}
			}
			
		  }
		  catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Repayment Information is not entered Successfully with SSN  " +SSN);
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "Repayment");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));

		  }
			
	  }
	  
	  

}
