package tests;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//This  is an executable class file.(Execution starts from here)
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCStore {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static WebDriver driver1;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());

	public static Properties prop;
	public static Properties Jprop;
	public static Properties Rprop;
	public static Properties Aprop;
	public static Properties Vprop;
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentReports Breports;
	public static ExtentReports Jreports;
	public static ExtentReports Rreports;
	public static ExtentReports Areports;
	public static ExtentTest test;
	// public static ExtentReports reports;
	// public static ExtentTest test;
	// static ExtentHtmlReporter htmlReporter;
	// static ExtentReports extent;
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;

	public static String loan_nbr;
	public static String NextDueDate;
	public static String AppURL = "http://192.168.2.203/cc/demoIndex.do";
	public static String business_date;
	public static String No_of_Installments;
	public static String transaction_date;

	public static String ESign_CheckNbr;
	public static String Password;
	public static String ESign_CollateralType;
	public static String appdate;
	public static String Date1;
	public static String Date2;
	public static String Date3;
	public static String customer_number;

	public static String Drawer_OverShort_Amount;

	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;
	public static String passwrd;
	public static String FirstName;

	public static String AdminURL;

	public static String csr_url;
	public static String csrloginpage;

	// Brahmith Transactions

	@Test(priority = 4, groups = "Brahmith1")

	public static void QC_NewLoan_Promotion_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("QC_Store_ILP_NewLoan_Promotion_Txn_scenario"),
					"Login->Borrower Registratino->New Loan with Promotion");

			FileName = prop.getProperty("QC_Store_ILP_NewLoan_Promotion_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					//BAdminStartDate.toStartdate(SSN, SSN);
					QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
					//BProc3.proc();

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {

			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_BorrowerRegistration_NewLoan_Promotion_Txn ");

		}
	}

	@Test(priority = 7, groups = "Brahmith1")

	public static void QC_NewLoan_Void_Txn() throws Exception {
		try {
			// test =
			// extent.createTest(prop.getProperty("QC_Store_NewLoan_Void_Txn_file_name"));
			test = reports.startTest((prop.getProperty("QC_Store_NewLoan_Void_Txn_Scenario")),
					"Login->Borrower Registratino->New Loan->Void");

			FileName = prop.getProperty("QC_Store_NewLoan_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {

			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_NewLoan_Void_Txn ");

		}
	}

	@Test(priority = 54, groups = "Brahmith")

	public static void QC_AgeStore_Void_Txn() throws Exception {
		try {
			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Void_Txn_file_name"));
			test = reports.startTest((prop.getProperty("QC_Store_AgeStore_Void_Txn_Scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->Void");

			FileName = prop.getProperty("QC_Store_AgeStore_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCEncryptionDetails.readEncryptionDetails(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					// QCCSRLoginLogout.adminLogin(driver, SSN, AppURL);
					QCAdminEncryption.getEncryption(driver, SSN, AppURL);
					// QCCSRLoginLogout.adminLogout(driver,SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					// QCVoid.qcVoid(SSN, AppURL);

					QCAgeStoreVoid.ageStoreVoid(SSN, AppURL);

					// QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_AgeStore_Void_Txn ");

		}
	}

	@Test(priority = 21, groups = "Brahmith")

	public static void QC_Installmentpayment_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_ILP_Installmentpayment_Txn_Scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Pay Installment Amt");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_ILP_Installmentpayment_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Installmentpayment_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_Installmentpayment_Txn ");

		}
	}

	@Test(priority = 22, groups = "Brahmith")

	public static void QC_Installmentpayment_Void_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_ILP_Installmentpayment_Void_Txn_Scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Pay Installment Amt->Void");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_ILP_Installmentpayment_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Installmentpayment_Void_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_Installmentpayment_Void_Txn ");

		}
	}

	@Test(priority = 23, groups = "Brahmith")

	public static void QC_PayAnyotherAmount_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_ILP_Payanyotheramount_Txn_Scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Payanyotheramount");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_ILP_Payanyotheramount_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Installmentpayment_Void_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_Installmentpayment_Void_Txn ");

		}
	}

	@Test(priority = 24, groups = "Brahmith")

	public static void QC_PayAnyotherAmount_Void_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_ILP_Payanyotheramount_Void_Txn_Scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Payanyotheramount-> Void");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_ILP_Payanyotheramount_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Installmentpayment_Void_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_Installmentpayment_Void_Txn ");

		}
	}

	@Test(priority = 31, groups = "Brahmith")

	public static void QC_ILP_Return_Menu_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_ILP_Return_Menu_Txn_Scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore due date->Deposit Menu-> Age Store to gracedays->Return");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_ILP_Return_Menu_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Installmentpayment_Void_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_Installmentpayment_Void_Txn ");

		}
	}

	@Test(priority = 32, groups = "Brahmith")

	public static void QC_ILP_clear_Menu_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_ILP_clear_Menu_Txn_Scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore due date->Deposit Menu-> Age Store to gracedays->->Return->clear");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_ILP_clear_Menu_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCClearMenu.clearMenu(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Installmentpayment_Void_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_Installmentpayment_Void_Txn ");

		}
	}

	@Test(priority = 35, groups = "Brahmith")

	public static void QC_ILP_Deposit_Return_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_ILP_Deposit_Return_Txn_Scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore due date->Deposit Menu-> Internal transfer->Cash Management->Return");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_ILP_Deposit_Return_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Installmentpayment_Void_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_Installmentpayment_Void_Txn ");

		}
	}

	@Test(priority = 55, groups = "Brahmith")

	public static void QC_ILP_NewLoanInstallmentDeposit_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_ILP_NewLoanInstallmentDeposit_Txn_Scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore due date to 1st installment->Deposit dropdown-> Continue till final installment");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_ILP_NewLoanInstallmentDeposit_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					int No_of_Installments_Int = Integer.parseInt(No_of_Installments);
					int j;
					for (j = 1; j <= No_of_Installments_Int; j++) {
						test.log(LogStatus.INFO, "**********************************************");
						test.log(LogStatus.INFO, "Process has started for the installment no " + j);
						System.out.println("Process has started for the installment no " + j);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);

						QCDepositDropdown.depositDropDown(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
					}
					test.log(LogStatus.INFO, "Completed installment deposits for " + (j-1) + " installments");

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Installmentpayment_Void_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_NewLoanInstallmentDeposit_Txn ");

		}
	}

	@Test(priority = 47, groups = "Brahmith")

	public static void QC_InstallPayment_Ref_Rescind_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_InstallPayment_Ref_Rescind_Txn_Scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore due date ->Partial Payment->Refinance->Rescind");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_InstallPayment_Ref_Rescind_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRefinanceprocess.Refinance(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCRescind.Rescind(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_InstallPayment_Ref_Rescind_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_InstallPayment_Ref_Rescind_Txn ");

		}
	}

	@Test(priority = 53, groups = "Brahmith")

	public static void QC_NewLoan_TLPConversion_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_NewLoan_TLPConversion_Txn_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to 15 days ->TLP Conversion");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_NewLoan_TLPConversion_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRTLPConversion.conversion(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory_Conversion.historyconversion(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_InstallPayment_Ref_Rescind_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_NewLoan_TLPConversion_Txn ");

		}
	}

	@Test(priority = 51, groups = "Brahmith")

	public static void QC_LessInterest_VoidFullPayment_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_LessInterest_VoidFullPayment_Txn_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to 12 days -> Less Than Interest Amount ->AgeStore to 12 days ->PartialPayment Pay Off the balance->Void");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_LessInterest_VoidFullPayment_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.paymentTwice(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_LessInterest_VoidFullPayment_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_LessInterest_VoidFullPayment_Txn ");

		}
	}

	@Test(priority = 16, groups = "Brahmith1")

	public static void QC_ILP_Buyback_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_ILP_Buyback_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->Pay Off the balance");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_ILP_Buyback_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Installmentpayment_Void_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_Installmentpayment_Void_Txn ");

		}
	}

	@Test(priority = 17, groups = "Brahmith")

	public static void QC_ILP_Buyback_Void_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_ILP_Buyback_Void_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->Payment Pay Off the balance-> Void");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_ILP_Buyback_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Installmentpayment_Void_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_Installmentpayment_Void_Txn ");

		}
	}

	@Test(priority = 56, groups = "Brahmith")

	public static void QC_ILP_Refinanace_Txn() throws Exception {
		try {
			test = reports.startTest((prop.getProperty("QC_ILP_Refinance_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->New MO Installment Loan on 12-Dec-2018 – $400 Payment on 10-JAN-2019 – $380 Payment on 09-FEB-2019 – $447.71 Payment on 08-APR-2019 – Refinance on 08-APR-2019");

			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = prop.getProperty("QC_ILP_Refinance_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					/*QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					
				BQCCSRNewLoan2.newLoan2(SSN, AppURL);
				QCCSRLoginLogout.logout(SSN, AppURL);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCPayment.paymentTwice(SSN, SSN);
				QCCSRLoginLogout.logout(SSN, AppURL);
				
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays3rdTime(SSN, SSN);*/
				QCCSRLoginLogout.login(SSN, AppURL);
				QCPayment.paymentThrice(SSN, SSN);
				QCCSRLoginLogout.logout(SSN, AppURL);
				
				QCCSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays4thTime(SSN, SSN);
				QCCSRLoginLogout.login(SSN, AppURL);
				QCPayment.payment4(SSN, SSN);
				QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Installmentpayment_Void_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario QC_Installmentpayment_Void_Txn ");

		}
	}

	// Janaki Transactions edited by Janaki

	@Test(priority = 0, enabled = true, groups = "Janaki")

	public static void JQC_ILP_Deposit_Menu_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_ILP_Deposit_Menu_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit Menu");

			FileName = Jprop.getProperty("QC_ILP_Deposit_Menu_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositMenu.depositMenu(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario 14 JQC_ILP_Deposit_Menu_Txn ");

		}
	}

	@Test(priority = 1, enabled = true, groups = "Janaki")

	public static void JQC_ILP_Deposit_dropdown_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_ILP_Deposit_dropdown_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit Dropdown");

			FileName = Jprop.getProperty("QC_ILP_Deposit_dropdown_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario 11 JQC_ILP_Deposit_dropdown_Txn ");

		}
	}

	@Test(priority = 2, enabled = true, groups = "Janaki")

	public static void JQC_ILP_GraceDays_Deposit_Menu_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_ILP_GraceDays_Deposit_Menu_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit Dropdown");

			FileName = Jprop.getProperty("QC_ILP_GraceDays_Deposit_Menu_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositMenu.depositMenu(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario 18 JQC_ILP_GraceDays_Deposit_Menu_Txn ");

		}
	}

	@Test(priority = 3, enabled = true, groups = "Janaki")

	public static void JQC_ILP_GraceDays_Deposit_MidDay_Txn() throws Exception {

		test = reports.startTest(Jprop.getProperty("QC_ILP_GraceDays_Deposit_MidDay_Txn"),
				"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit through MidDay");

		FileName = Jprop.getProperty("QC_ILP_GraceDays_Deposit_MidDay_Txn_file_name") + ".xls";

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				System.out.println(AppURL);

				JQCCSRLoginLogout.login(SSN, AppURL);
				JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				JCSRMidDayDeposit.middeposit(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);

			}
		}

	}

	@Test(priority = 4, enabled = true, groups = "Janaki")

	public static void JQC_ILP_Deposit_MidDay_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_ILP_Deposit_MidDay_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit through MidDay");

			FileName = Jprop.getProperty("QC_ILP_Deposit_MidDay_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JCSRMidDayDeposit.middeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario 13 JQC_ILP_Deposit_MidDay_Txn ");

		}
	}

	@Test(priority = 5, enabled = true, groups = "Janaki")

	public static void JQC_ILP_GraceDays_Deposit_dropdown_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_ILP_GraceDays_Deposit_dropdown_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit Dropdown");

			FileName = Jprop.getProperty("QC_ILP_GraceDays_Deposit_dropdown_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario 11 JQC_ILP_Deposit_dropdown_Txn ");

		}
	}
	@Test(priority = 12, enabled = true, groups = "janaki_Refinance_StUp")

	public static void JQC_ILP_Payment_Refinance_StepUp_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_ILP_Payment_Refinance_StepUp_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit Dropdown");

			FileName = Jprop.getProperty("QC_ILP_Payment_Refinance_StepUp_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario 11 JQC_ILP_Deposit_dropdown_Txn ");

		}
	}

	// Date:07/06/2018

	@Test(priority = 6, enabled = true, groups = "Janaki_EOD_set1")

	public static void JQC_ILP_Deceased_Txn() throws Exception {

		test = reports.startTest(Jprop.getProperty("QC_ILP_Deceased_Txn"),
				"Login->Borrower Registratino->New Loan ->Deceased");

		FileName = Jprop.getProperty("QC_ILP_Deceased_Txn_file_name") + ".xls";

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);

				JQCCSRLoginLogout.login(SSN, AppURL);
				JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				JQC_Deceased.Deceased(SSN, AppURL);
				JQCAdmin_Bankruptcy.Admin_Bankruptcy(SSN, AppURL);

				JQCCSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);

			}
		}

	}

	// Date:07/06/2018

	@Test(priority = 8, enabled = true, groups = "Janaki_EOD_set1")

	public static void JQC_ILP_Deposit_EOD_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_ILP_Deposit_EOD_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit EOD");

			FileName = Jprop.getProperty("QC_ILP_Deposit_EOD_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCEODDeposit.eodDeposit(SSN, AppURL);

					JQCAdminStoreSetup.storeSetup(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCSafeAssign.safeAssign(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDrawerAssign.drawerAssign(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario 12 JQC_ILP_Deposit_EOD_Txn ");

		}
	}

	// Date:01/11/2018

	@Test(priority = 9, enabled = true, groups = "Janaki_EOD_set2")

	public static void JQC_ILP_GraceDays_Deposit_EOD_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_ILP_GraceDays_Deposit_EOD_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->GraceDays->Deposit EOD");

			FileName = Jprop.getProperty("QC_ILP_GraceDays_Deposit_EOD_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCEODDeposit.eodDeposit(SSN, AppURL);

					JQCAdminStoreSetup.storeSetup(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCSafeAssign.safeAssign(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDrawerAssign.drawerAssign(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario 17 JQC_ILP_GraceDays_Deposit_EOD_Txn ");

		}
	}

	@Test(priority = 7, enabled = true, groups = "Janaki")

	public static void JQC_ILP_SignaturLoan_Default_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_ILP_SignaturLoan_Default_Txn"),
					"Login->Borrower Registratino->Signature Loan->Age Store->Default");

			FileName = Jprop.getProperty("QC_ILP_SignaturLoan_Default_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreSignatureLoan.ageStoreSignatureLoan(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCSignaturLoanDefault.signaturLoanDefault(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario 50 JQC_ILP_SignaturLoan_Default_Txn ");

		}
	}

	// RATIKANTA transactions

	 @Test(priority = 1, groups = "Ratikanta_ILP")
	public static void RQC_Bankruptcy_WORecovery_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Bankruptcy_WORecovery"),

					"Login->Borrower Registration->New Loan->Bankruptcy in Admin Portal-->AgeStore to Due date-->WriteOff Recovery");
			String FileName = "QC_Bankruptcy_WORecovery_Txn_Testdata.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRBankruptcy.bankruptcy(SSN, AppURL);
					RAdminLoginForBankruptcy.bankruptcy(driver, SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRHistory.history(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "RQC_Bankruptcy_WORecovery_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}

	 @Test(priority = 2, groups = "Ratikanta_ILP")
	public static void RQC_Bankruptcy_Discharge_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Bankruptcy_Discharge"),

					"Login->Borrower Registration->New Loan->Bankruptcy in Admin Portal-->AgeStore to Due date-->Discharge");
			String FileName = "QC_Bankruptcy_Discharge_Txn_Testdata.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRBankruptcy.bankruptcy(SSN, AppURL);
					RAdminLoginForBankruptcy.bankruptcy(driver, SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRBankruptcy.bankruptcy(SSN, AppURL);
					RAdminLoginForDischarged.discharged(driver, SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRHistory.history(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "RQC_Bankruptcy_Discharge_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}

	 @Test(priority = 3, groups = "Ratikanta_ILP")
	public static void RQC_Bankruptcy_Dismiss_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Bankruptcy_Dismiss"),

					"Login->Borrower Registration->New Loan->Bankruptcy in Admin Portal-->AgeStore to Due date-->Dismiss");
			String FileName = "QC_Bankruptcy_Dismiss_Txn_Testdata.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRBankruptcy.bankruptcy(SSN, AppURL);
					RAdminLoginForBankruptcy.bankruptcy(driver, SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRBankruptcy.bankruptcy(SSN, AppURL);
					RAdminLoginForDismiss.dismiss(driver, SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRHistory.history(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "RQC_Bankruptcy_Dismiss_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}

	 @Test(priority = 4, groups = "Ratikanta_ILP")
	public static void RQC_Default_Refinance_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Default_Refinance"),

					"Login->Borrower Registration->New Loan->Age the Store installment wise to make a loan Default->Refinance");
			String FileName = "QC_Default_Refinance_Txn_Testdata.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRDefault.sdefault(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRDefault_Refinance.refinance(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRHistory.history(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "RQC_Default_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}

	 @Test(priority = 5, groups = "Ratikanta_ILP")
	public static void RQC_DefaultPayment_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_DefaultPayment"),

					"Login->Borrower Registration->New Loan->Age the Store installment wise to make a loan Default->DefaultPayment");
			String FileName = "QC_DefaultPayment_Txn_Testdata.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRDefault.sdefault(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRHistory.history(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);

					//// RQCCSRBuyBackRebateVoid.buybackrebatevoid(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "RQC_DefaultPayment_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}

	 @Test(priority = 6, groups = "Ratikanta_ILP")
	public static void RQC_DefaultPayment_Void_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_DefaultPayment_Void"),

					"Login->Borrower Registration->New Loan->Age the Store installment wise to make a loan Default->DefaultPayment-->Void");
			String FileName = "QC_DefaultPayment_Void_Txn_Testdata.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRDefault.sdefault(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRDefaultVoid.svoid(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRHistory.history(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "RQC_DefaultPayment_Void_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}

	@Test(priority = 7, groups = "Ratikanta_ILP")
	public static void RQC_WriteOffRecovery_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_WriteOffRecovery"),

					"Login->Borrower Registration->New Loan->Age the Store Duedate-->WriteOff-->WriteOff Recovery");
			String FileName = "QC_WriteOffRecovery_Txn_Testdata.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRWORecovery.simplewriteoff_recovery(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRHistory.history(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "RQC_WriteOffRecovery_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}

	 @Test(priority = 8, groups = "Ratikanta_ILP")
	public static void RQC_WriteOffRecovery_Void_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_WriteOffRecovery_Void"),

					"Login->Borrower Registration->New Loan->Age the Store Duedate-->WriteOff-->WriteOff Recovery-->Void");
			String FileName = "QC_WriteOffRecovery_Void_Txn_Testdata.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRWORecovery.simplewriteoff_recovery(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRWOVoid.writeoffvoid(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRHistory.history(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "RQC_WriteOffRecovery_Void_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}

	 @Test(priority = 9, groups = "Ratikanta_ILP")
	public static void RQC_Default_TLPConversion_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Default_TLPConversion"),

					"Login->Borrower Registration->New Loan->Age the Store installment wise to make a loan Default->TLPConversion");
			String FileName = "QC_Default_TLPConversion_Txn_Testdata.xls";
			// String FileName=
			// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
			// Application test report");

			// String FileName= "Registration_Lend_Nation.xls";
			// Excel TestData = new
			// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
			// int lastrow=TestData.getLastRow("Start");
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					// driver.get(appUrl);
					// test.log(LogStatus.INFO, "Application is launched");
					// driver.manage().window().maximize();
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRDefault.sdefault(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRTLPConversion.conversion(SSN, AppURL);
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRHistory_Conversion.historyconversion(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "RQC_Default_TLPConversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");

		}
	}

	 @Test(priority = 10, groups = "Ratikanta_ILP")
		public static void RQC_3Payments_Refinance_StepUp_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("QC_3Payments_Refinance_StepUp"),

						"Login->Borrower Registration->New Loan->Payment-->Refinance");
				String FileName = "QC_3Payments_Refinance_StepUp_Txn_Testdata.xls";
				// String FileName=
				// Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
				// ExcelNew TestData;
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				// test=reports.startTest("Lend Nation Smoke_testing","Lend Nation
				// Application test report");

				// String FileName= "Registration_Lend_Nation.xls";
				// Excel TestData = new
				// ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
				// int lastrow=TestData.getLastRow("Start");
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				// int lastrow=TestData.getLastRow("Borrower");
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					// System.out.println(RunFlag);
					if (RunFlag.equals("Y")) {
						// driver.get(appUrl);
						// test.log(LogStatus.INFO, "Application is launched");
						// driver.manage().window().maximize();
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);

						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCPayment.payment(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan2.newLoan2(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCPayment.payment1(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays3rdTime(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCPayment.payment2(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays4thTime(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCPayment.payment3(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						QC_Edit_BorrowRegestration.editborrower_saveexit(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						/*RQCCSRLoginLogout.login(SSN, AppURL);
						RQCRefinance.StepUp(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "RQC_3Payments_Refinance_StepUp_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");

			}
		}	 
	 
	 
//============================================================================================================
	// Anoop Transactions

	@Test(priority = 14, enabled = true, groups = "Anoop")

	public void ILP_voidRefinance() throws Exception {

		FileName = "QC_Loan_Refinance_Void.xls";
		test = reports.startTest("QC_Loan_Refinance_Void",
				"Loan->Age store for 12 days->Make Payment less than interest amount->Age Store for 10 Days->Refinance->Void Refinance");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.age10days(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILPRefinanceprocess.Refinance(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				// test.log(LogStatus.INFO, "****Test Scenario for Void
				// refinance is pass******");
			}
		}
	}

	@Test(priority = 11, enabled = true, groups = "Anoop")

	public void ILP_ACHAutoClear() throws Exception {

		FileName = "ILP_ACHAutoClear.xls";
		test = reports.startTest("ILP_Scenario_NO.34",
				"Loan -->Age the store upto duedate --> perform deposit--> age the store -->ACH Auto clear");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				ILPACHProcessing.achProcess(SSN, SSN);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AutoclearCheck.autoclear(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				// test.log(LogStatus.INFO, "****Test Scenario for ACH Auto
				// clear is pass******");
			}
		}
	}

	@Test(priority = 12, enabled = true, groups = "Anoop")

	public void ILP_CheckAutoClear() throws Exception {

		FileName = "ILP_CheckAutoClear.xls";
		test = reports.startTest("QC_Loan_deposit_AutoClear",
				"Loan -->Age the store upto duedate --> perform deposit--> age the store -->Check Auto clear");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AutoclearCheck.autoclear(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				// test.log(LogStatus.INFO, "****Test Scenario for Check Auto
				// clear is pass******");
			}
		}
	}

	@Test(priority = 10, enabled = true, groups = "Anoop")

	public void ILP_ProcessClear() throws Exception {

		FileName = "ILP_ProcessClear.xls";
		test = reports.startTest("QC_Loan_deposit_ClearFromDropDown",
				"Loan -->Age the store upto duedate --> perform deposit--> age the store -->process Clear from drop Down");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILPClearFromDropDown.clearDropdown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				// test.log(LogStatus.INFO, "****Test Scenario for Process Clear
				// is pass******");
			}
		}
	}

	@Test(priority = 0, enabled = true, groups = "Anoop_StdownVoid")
	// This is date dependency make it 03/12/2018
	public void ILP_RefinanceStepDown_void() throws Exception {
		FileName = "QC_ILP_StepDown_Void.xls";
		test = reports.startTest("QC_ILP_StepDown_Void","Login-->Age the Store_payment_Age store to Duedate_Refinance Step Down Void");

		TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Refinance_StepDown.StepDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				// test.log(LogStatus.INFO, "****Test Scenario for Refinance
				// Step Down void is pass******");
			}
		}
	}

	@Test(priority = 15, enabled = true, groups = "Anoop_stDown")
	// This is date dependency make it 03/12/2018
	public void ILP_RefinanceStepDown() throws Exception {

		FileName = "QC_ILP_StepDown.xls";
		test = reports.startTest("QC_ILP_StepDown",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Down");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Refinance_StepDown.StepDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				// test.log(LogStatus.INFO, "****Test Scenario for Refinance
				// Step Down is pass******");
			}
		}
	}

	@Test(priority = 9, enabled = true, groups = "Anoop")

	public void ILP_RefinanceStepSame_Void() throws Exception {

		FileName = "QC_ILP_StepSame_Void.xls";
		test = reports.startTest("QC_Loan_Stepsame_Void",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Same Void");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Refinance_StepSame.StepSame(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				// test.log(LogStatus.INFO, "****Test Scenario for Refinance
				// Step Same Void is pass******");
			}
		}
	}

	@Test(priority = 7, enabled = true, groups = "Anoop")

	public void ILP_RefinanceStepSame() throws Exception {

		FileName = "QC_ILP_StepSame.xls";
		test = reports.startTest("QC_Loan_Stepsame",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Same");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Refinance_StepSame.StepSame(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				// test.log(LogStatus.INFO, "****Test Scenario for Refinance
				// Step Same is pass******");

			}
		}
	}

	@Test(priority = 8, enabled = true, groups = "Anoop")

	public void ILP_RefinanceStepUpVoid() throws Exception {

		FileName = "QC_ILP_StepupVoid.xls";
		test = reports.startTest("QC_Loan_StepUP_Void",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Up void");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_RefinanceStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				// test.log(LogStatus.INFO, "****Test Scenario for Refinance
				// StepUp void is pass******");
			}
		}
	}

	@Test(priority = 6, enabled = true, groups = "Anoop")

	public void ILP_RefinanceStepup() throws Exception {

		FileName = "QC_ILP_StepUp.xls";
		test = reports.startTest("QC_Loan_StepUP",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Stepup");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_RefinanceStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				// test.log(LogStatus.INFO, "****Test Scenario for Refinance
				// Stepup is pass******");
			}
		}
	}

	@Test(priority = 1, enabled = true, groups = "Anoop")

	public void ILP_Redeposit() throws Exception {

		FileName = "QC_ILP_Redeposit.xls";
		test = reports.startTest("QC_Loan_Redeposit",
				"Loan->Age store till first installment due date->Check Deposit->Age store for 2 days->Return Check->Age store for 2 days->Redeposit");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ILP_DepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				AQCAdminLoginLogout.login(SSN, AppURL);
				ILP_ReturnPosting.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Redeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				// test.log(LogStatus.INFO, "****Test Scenario for ReDeposit is
				// pass******");
			}
		}
	}

	@Test(priority = 5, enabled = true, groups = "Anoop")

	public void ILP_agerescindtest() throws Exception {
		test = reports.startTest("QC_AgeStore_Rescind Loan", "Login-->Age the loan to rescind days--->Rescind loan");
		FileName = "QC_NewLoan_AgeRescind.xls";

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.rescind(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				// test.log(LogStatus.INFO, "****Test Scenario for age to store
				// loan rescind is pass******");

			}
		}
	}

	@Test(priority = 4, enabled = true, groups = "Anoop")

	public void ILP_rescindloan() throws Exception {
		test = reports.startTest("QC_Rescind", "Loan->Rescind");
		FileName = "QC_NewLoan_Rescind.xls";

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.rescind(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				// test.log(LogStatus.INFO, "**********************Test Scenario
				// for loan rescind is pass***********************");

			}
		}
	}

	@Test(priority = 3, enabled = true, groups = "Anoop")

	public void ILP_maxloanCount() throws Exception {
		FileName = "QC_MaxLoanCount.xls";
		test = reports.startTest("QC_MaxLoanCount", "Login-->Borrower-->Max loan count");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);

				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				for (int i = 1; i <= 2; i++) {

					ACSRLoginLogout.login(SSN, AppURL);
					MaxLoanCount.maxLoan(SSN, AppURL);
					if (!(i == 2)) {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is approved successfully*****");
						break;
					} else {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is denied*****");
						break;
					}
				}
				// test.log(LogStatus.INFO, "****Test Scenario for max loan
				// amount is pass******");
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}

		}

	}

	@Test(priority = 2, enabled = true, groups = "Anoop")
	public void ILP_inactiveNewloan() throws Exception {
		FileName = "QC_NewLoan_InactiveCustomer.xls";
		test = reports.startTest("QC_NewLoan_InactiveCustomer", "Login-->Home Screen-->In active customer-->New Loan");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				CSRNewLoanInactivecust.newLoanInact(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}
	}

	@Test(priority = 13, enabled = true, groups = "Anoop")
	public void ILP_borrowregNewloan() throws Exception {
		FileName = "QC_BorrowerRegistration_NewLoan.xls";
		test = reports.startTest("QC_BorrowerRegistration_NewLoan",
				"Login-->Home Screen-->Borrower Registration-->New Loan");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}
	}
	
	@Test(priority = 1, enabled = true, groups = "Jyothi")

	public void ILP_InstallmentStepup() throws Exception {

		FileName = "QC_ILP_Payanyotheramount.xls";
		test = reports.startTest("QC_ILP_Payanyotheramount", "QC_ILP_Payanyotheramount");

		TestData = new ExcelNew(System.getProperty("user.dir") + Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow+1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				JQCCSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);

				JQCCSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				
				/*VQC_Payment.payment(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRNewLoan2.newLoan2(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				VQC_Payment.payment1(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);
				JQCCSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);*/
			/*	JQCCSRLoginLogout.login(SSN, AppURL);
				VQC_Payment.payment2(SSN, AppURL);
				JQCCSRLoginLogout.logout(SSN, AppURL);*/
				
				
			}
		}
	}


	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			BufferedReader reader;
			BufferedReader Jreader;
			BufferedReader Rreader;
			BufferedReader Areader;
			BufferedReader Vreader;

			try {
				reader = new BufferedReader(

						new FileReader("C:/QC_Batch/QC_ILP/src/test/java/tests/Objects.properties"));

				prop = new Properties();
				prop.load(reader);
				reader.close();
				AppURL = prop.getProperty("CSR_URL");
				AdminURL = prop.getProperty("ADMIN_CSR_URL");
				String Bfilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + Bfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Jreader = new BufferedReader(

						new FileReader("C:/QC_Batch/QC_ILP/src/test/java/tests/JObjects.properties"));

				Jprop = new Properties();
				Jprop.load(Jreader);
				Jreader.close();
				String Jfilename = Jprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Jprop.getProperty("QC_Store_extent_report_path") + Jfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Rreader = new BufferedReader(

						new FileReader("C:/QC_Batch/QC_ILP/src/test/java/tests/RObjects.properties"));

				Rprop = new Properties();
				Rprop.load(Rreader);
				Rreader.close();
				csr_url = Rprop.getProperty("CSR_URL");
				csrloginpage = Rprop.getProperty("Login_Page");
				AdminURL = Rprop.getProperty("ADMIN_URL");
				String Rfilename = Rprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Rprop.getProperty("QC_Store_extent_report_path") + Rfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Areader = new BufferedReader(
						new FileReader("C:/QC_Batch/QC_ILP/src/test/java/tests/AObjects.properties"));
				Aprop = new Properties();
				Aprop.load(Areader);
				Areader.close();
				String Afilename = Aprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Aprop.getProperty("QC_Store_extent_report_path") + Afilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}
			try {
				Vreader = new BufferedReader(
						new FileReader("C:/QC_Batch/QC_ILP/src/test/java/tests/VObjects.properties"));
				Vprop = new Properties();
				Vprop.load(Vreader);
				Vreader.close();
				csr_url = Vprop.getProperty("CSR_URL");
				csrloginpage = Vprop.getProperty("Login_Page");
				AdminURL = Vprop.getProperty("ADMIN_URL");
				String Vfilename = Vprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Vprop.getProperty("QC_Store_extent_report_path") + Vfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

		}

		catch (Exception e) {

			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)

	public void killProcess() throws Exception {

		try {

			//Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the process ILP scenarios");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/ILP/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod(alwaysRun = true)

	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			// test.log(LogStatus.FAIL, "Test Case Failed is
			// "+result.getThrowable());

			String screenshotPath = getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		reports.flush();
		driver.quit();

	}

	@AfterMethod(alwaysRun = true)

	public void endReport() {

		// reports.endTest(test);
		// reports.flush();

		// driver.quit();
		// extent.flush();

	}

	public static By locator(String obj) {

		String loctype = null;
		String locname = null;
		By locator = null;
		String[] locobj = obj.split("%%");
		loctype = locobj[0];
		locname = locobj[1];
		// System.out.println("startign of switch case");
		// System.out.println(obj);
		/*
		 * switch(loctype) { case "id": locator=By.id(locname); break; case
		 * "name": locator=By.name(locname); break; case "linkText":
		 * locator=By.linkText(locname); break; case "xpath":
		 * locator=By.xpath(locname); case "cssSelector":
		 * locator=By.cssSelector(locname); break; }
		 */

		if (loctype.equalsIgnoreCase("id"))
			return locator = By.id(locname);
		else if (loctype.equalsIgnoreCase("name"))
			return locator = By.name(locname);
		else if (loctype.equalsIgnoreCase("linkText"))
			return locator = By.linkText(locname);
		else if (loctype.equalsIgnoreCase("partialLinkText"))
			return locator = By.partialLinkText(locname);
		else if (loctype.equalsIgnoreCase("xpath"))
			return locator = By.xpath(locname);
		else if (loctype.equalsIgnoreCase("cssSelector"))
			return locator = By.cssSelector(locname);
		return locator;

		// System.out.println(locator);
		// return locator;

	}

}
