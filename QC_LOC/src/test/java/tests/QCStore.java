package tests;

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
import org.testng.annotations.AfterMethod;

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
	public static Properties Sprop;
	public static Properties Vprop;
	public static String loan_number;
	public static ExtentReports reports;
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
	public static String AppURL;
	public static String AdminURL;
	public static String business_date;
	public static String No_of_Installments;
	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;
	public static String ESign_CheckNbr;

	public static String ESign_CollateralType;

	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;

	public static String Str_date;
	public static String Ctc_PrimaryPhone;
	public static String Storeid;
	public static String SSN;
	public static String PP1;
	public static String PP2;
	public static String PP3;
	public static String age_Date1;
	public static String age_Date2;
	public static String age_Date3;
	public static String Statementdate;
	public static String Duedate_confirm_text3;
	
	public static String customer_number;	
	
	public static String Drawer_OverShort_Amount;
	
	public static String Date1;
	
	public static String csr_url;
	
	public static String csrloginpage;
	
	public static String Date2;
	public static String Date3;
	
	
	
	public static String Password;
	
	public static String LOCamount;
	
	private static final String QCAdmin_Deceased = null;
	
	public static String Bank_Status;
	
	public static String App_date1;
	
	public static String logout;
	
	private static Object rescind;

	
	//Brahmith scenarios
	
	@Test(priority = 113, groups = { "1st Batch" })
	public static void LOC_Biweekly_Nextpay_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Biweekly_Nextpay_scenario"),
					"Login->Borrower Registratino->New LOC for a Customer with income to validate Min LOC Amt ");

			FileName = prop.getProperty("LOC_Biweekly_Nextpay_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 114, groups = { "1st Batch" })
	public static void LOC_NewLoan_MaxLOC_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_NewLoan_MaxLOC_Txn_scenario"),
					"Login->Borrower Registratino->New LOC for a Customer with income to validate Max LOC Amt ");

			FileName = prop.getProperty("LOC_NewLoan_MaxLOC_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					LOCMaxloanCount.newLoan(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 105, groups = { "1st Batch" })
	public static void LOC_Biweekly_NextPay_NotOn_End_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Biweekly_NextPay_NotOn_End_Txn_scenario"),
					"Login->Borrower Registratino->New LOC for a Customer with income to validate LOC Amt ");

			FileName = prop.getProperty("LOC_Biweekly_NextPay_NotOn_End_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					// QCCSRNewLoan.newLoan(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 16, groups = { "1st Batch" })
	public static void LOC_monthly_NextPay_NotOn_End_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_monthly_NextPay_NotOn_End_Txn_scenario"),
					"Login->Borrower Registratino->New LOC for a monthly Customer with income to validate LOC Amt ");

			FileName = prop.getProperty("LOC_monthly_NextPay_NotOn_End_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 107, groups = { "1st Batch" })
	public static void LOC_semimonthly_NextPay_NotOn_End_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_semimonthly_NextPay_NotOn_End_Txn_scenario"),
					"Login->Borrower Registratino->New LOC for a semimonthly Customer with income to validate LOC Amt ");

			FileName = prop.getProperty("LOC_semimonthly_NextPay_NotOn_End_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 108, groups = { "1st Batch" })
	public static void LOC_weekly_NextPay_NotOn_End_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_weekly_NextPay_NotOn_End_Txn_scenario"),
					"Login->Borrower Registratino->New LOC for a weekly Customer with income to validate LOC Amt ");

			FileName = prop.getProperty("LOC_weekly_NextPay_NotOn_End_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 134, groups = { "1st Batch" })
	public static void LOC_PayOff_after_RescindPeriod_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_PayOff_after_RescindPeriod_Txn_scenario"),
					"Login->Borrower Registratino->New LOC – Payoff after Rescind Period ");

			FileName = prop.getProperty("LOC_PayOff_after_RescindPeriod_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 135, groups = { "1st Batch" })
	public static void LOC_PayOff_On_DueDate_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_PayOff_On_DueDate_Txn_scenario"),
					"Login->Borrower Registratino->New LOC – Payoff on due date");

			FileName = prop.getProperty("LOC_PayOff_On_DueDate_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 136, groups = { "1st Batch" })
	public static void LOC_Payment_PayOff_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Payment_PayOff_Txn_scenario"),
					"Login->Borrower Registratino->New LOC – Payment -> DueDate->Payoff ");

			FileName = prop.getProperty("LOC_Payment_PayOff_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 137, groups = { "1st Batch" })
	public static void LOC_Payment_GraceDays_PayOff_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Payment_GraceDays_PayOff_Txn_scenario"),
					"Login->Borrower Registratino->New LOC – Payment ->Gracedays->PayPayoff ");

			FileName = prop.getProperty("LOC_Payment_GraceDays_PayOff_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 138, groups = { "1st Batch" })
	public static void LOC_Payment_Void_PayOff_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Payment_Void_PayOff_Txn_scenario"),
					"Login->Borrower Registratino->New LOC – Payment -> Void->PPayoff ");

			FileName = prop.getProperty("LOC_Payment_Void_PayOff_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 139, groups = { "1st Batch" })
	public static void LOC_Payment_Return_PayOff_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Payment_Return_PayOff_Txn_scenario"),
					"Login->Borrower Registratino->New LOC –Grace days->Payment check->Check Deposit->Internal transfer->Cash Managemnet->Return->Payoff ");

			FileName = prop.getProperty("LOC_Payment_Return_PayOff_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCAdminCCKReturn.cckreturn(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 140, groups = { "1st Batch" })
	public static void LOC_PayOff_RescindPeriod_void_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_PayOff_RescindPeriod_void_Txn_scenario"),
					"Login->Borrower Registratino->New LOC – Payoff after Rescind Period->Void ");

			FileName = prop.getProperty("LOC_PayOff_RescindPeriod_void_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

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

			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 141, groups = { "1st Batch" })
	public static void LOC_Payment_PayOff_Void_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Payment_PayOff_Void_Txn_scenario"),
					"Login->Borrower Registratino->New LOC – Payment -> DueDate->PayPayoff->Void ");

			FileName = prop.getProperty("LOC_Payment_PayOff_Void_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

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

			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 142, groups = { "1st Batch" })
	public static void LOC_Payment_Gracedays_PayOff_Void_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Payment_Gracedays_PayOff_Void_Txn_scenario"),
					"Login->Borrower Registratino->New LOC – Payment -> Gracedays->PayPayoff->Void ");

			FileName = prop.getProperty("LOC_Payment_Gracedays_PayOff_Void_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

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

			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 143, groups = { "1st Batch" })
	public static void LOC_Payment_Void_PayOff_Void_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Payment_Void_PayOff_Void_Txn_scenario"),
					"Login->Borrower Registratino->New LOC – Payment -> Void->Payoff-Void ");

			FileName = prop.getProperty("LOC_Payment_Void_PayOff_Void_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

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

			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 144, groups = { "1st Batch" })
	public static void LOC_PayOff_Return_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_PayOff_Return_Txn_scenario"),
					"Login->Borrower Registratino->New LOC –>Grace days->PayOff check->Check Deposit->Internal transfer->Cash Managemnet->Return");

			FileName = prop.getProperty("LOC_PayOff_Return_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminCCKReturn.cckreturn(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {

			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 145, groups = { "1st Batch" })
	public static void LOC_Payment_PayOff_Return_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Payment_PayOff_Return_Txn_scenario"),
					"Login->Borrower Registratino->New LOC –Grace days->Payment check->->Payoff->Check Deposit->Internal transfer->Cash Managemnet->Return ");

			FileName = prop.getProperty("LOC_Payment_PayOff_Return_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminCCKReturn.cckreturn(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {

			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 155, groups = { "1st Batch" })
	public static void LOC_Draw_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Draw_Txn_scenario"),
					"Login->Borrower Registratino->New LOC –>Draw ");

			FileName = prop.getProperty("LOC_Draw_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCDraw.draw(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 156, groups = { "1st Batch" })
	public static void LOC_Payment_Draw_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Payment_Draw_Txn_scenario"),
					"Login->Borrower Registratino->New LOC –>Payment->Draw ");

			FileName = prop.getProperty("LOC_Payment_Draw_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPaymentforDraw.paymentDraw(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);

					QCDraw.draw(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 157, groups = { "1st Batch" })
	public static void LOC_PayOff_Draw_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_PayOff_Draw_Txn_scenario"),
					"Login->Borrower Registratino->New LOC –>PayOff->Draw ");

			FileName = prop.getProperty("LOC_PayOff_Draw_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCDraw.draw(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 158, groups = { "1st Batch" })
	public static void LOC_Draw_Void_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Draw_Void_Txn_scenario"),
					"Login->Borrower Registratino->New LOC –>Draw ->Void");

			FileName = prop.getProperty("LOC_Draw_Void_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCDraw.draw(SSN, SSN);
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

			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 159, groups = { "1st Batch" })
	public static void LOC_Payment_Draw_Void_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Payment_Draw_Void_Txn_scenario"),
					"Login->Borrower Registratino->New LOC –>Payment->Draw -Void");

			FileName = prop.getProperty("LOC_Payment_Draw_Void_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);

					QCDraw.draw(SSN, SSN);
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

			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 160, groups = { "1st Batch" })
	public static void LOC_PayOff_Draw_Void_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_PayOff_Draw_Void_Txn_scenario"),
					"Login->Borrower Registratino->New LOC –>PayOff->Draw->Void ");

			FileName = prop.getProperty("LOC_PayOff_Draw_Void_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayOff.payoff(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDraw.draw(SSN, SSN);
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

			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 164, groups = { "1st Batch" })
	public static void LOC_Deposit_Return_PayOff_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_Deposit_Return_PayOff_Txn_scenario"),
					"Login->Borrower Registratino->New LOC=> Due Date-> ACH deposit->ACH return");
			FileName = prop.getProperty("LOC_Deposit_Return_PayOff_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCCSRReturnPosting.returnposting(SSN, SSN);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDeliquentLoan.delinquent(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 168, groups = { "EOD" })
	public static void LOC_ACHDeposit_EODs_Return_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_ACHDeposit_EODs_Return_Txn_scenario"),
					"Login->Borrower Registratino->New LOC – EOD on Payment Due Date(including collateral Deposit) – Clear – EOD on 2nd Payment Due Date(including collateral Deposit) – Clear -  EOD on 3rd Payment Due Date(including collateral Deposit) – Clear -  EOD on 4th Payment Due Date(including collateral Deposit) – Return(Loan in Delinquent) – Draw ");
			FileName = prop.getProperty("LOC_ACHDeposit_EODs_Return_Txn_file_name") + ".xls";

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

					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					 QCCSRLoginLogout.logout(SSN, AppURL); 
							 System.out.println("first EOD"); // first EOD 
							 QCCSRLoginLogout.login(SSN,AppURL); 
					 QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);
					  
					  QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);
					
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCCSRReturnPosting.returnposting(SSN, SSN);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCClearDropdown.clearDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL); // second EOD
					System.out.println("second EOD");
					QCCSRLoginLogout.login(SSN, AppURL);
					  QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					 QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					 

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCCSRReturnPosting.returnposting(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCClearDropdown.clearDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					// third EOD
					System.out.println("third EOD");
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCCSRReturnPosting.returnposting(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCClearDropdown.clearDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					// fourth EOD
					System.out.println("fourth EOD");
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);
					System.out.println("Return");
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCCSRReturnPosting.returnposting(SSN, SSN);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);

					QCDraw.draw(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	 @Test(priority = 166,groups = { "EOD" })
	public static void LOC_ACHDeposit_EODs_Return_ReDeposit_Clear_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_ACHDeposit_EODs_Return_ReDeposit_Clear_Txn_scenario"),
					"LOC – Deposit – EOD – Return – Redeposit – Clear – EOD on 2nd Payment Due Date");
			FileName = prop.getProperty("LOC_ACHDeposit_EODs_Return_ReDeposit_Clear_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					// first EOD
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCCSRReturnPosting.returnposting(SSN, SSN);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCRedeposit.redeposit(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCCSRReturnPosting.returnposting(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCClearDropdown.clearDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 167,groups = { "EOD" })
	public static void LOC_ACHDeposit_EODs_Return_ReDeposit_Return_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_ACHDeposit_EODs_Return_ReDeposit_Return_Txn_scenario"),
					"LOC – Deposit – EOD – Return – Redeposit – Return – EOD on 2nd Payment Due Date");
			FileName = prop.getProperty("LOC_ACHDeposit_EODs_Return_ReDeposit_Return_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					// first EOD
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCCSRReturnPosting.returnposting(SSN, SSN);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCRedeposit.redeposit(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCCSRReturnPosting.returnposting(SSN, SSN);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 169, groups = { "EOD2" })
	public static void LOC_ACHDeposit_EOD_Return_EOD_Default_Redeposit_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_ACHDeposit_EOD_Return_EOD_Default_Redeposit_Txn_scenario"),
					"LOC – Deposit – EOD – Return – EOD on 2nd Payment Due Date - Deafult - ReDeposit");
			FileName = prop.getProperty("LOC_ACHDeposit_EOD_Return_EOD_Default_Redeposit_Txn_file_name") + ".xls";

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

					/*QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);*/
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					// first EOD
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCCSRReturnPosting.returnposting(SSN, SSN);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCDefaultStatus.defaultStatus(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCRedeposit.redeposit(SSN, SSN);
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
			test.log(LogStatus.ERROR, e);
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	@Test(priority = 170, groups = { "EOD2" })
	public static void LOC_ACHDeposit_EOD_Return_EOD_Redeposit_Txn() throws Exception {
		try {

			test = reports.startTest(prop.getProperty("LOC_ACHDeposit_EOD_Return_EOD_Redeposit_Txn_scenario"),
					"LOC – Deposit – EOD – Return – EOD on 2nd Payment Due Date - ReDeposit");
			FileName = prop.getProperty("LOC_ACHDeposit_EOD_Return_EOD_Redeposit_Txn_file_name") + ".xls";

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

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					// first EOD
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCCSRReturnPosting.returnposting(SSN, SSN);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					QCAdminACHReturn.achreturn(SSN, SSN);


					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);

					/*QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);*/

					QCCSRLoginLogout.login(SSN, AppURL);
					QCRedeposit.redeposit(SSN, SSN);
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
			test.log(LogStatus.ERROR, "Unable to start scenario LOC_Biweekly_Nextpay_Txn ");

		}
	}

	//Ratikanta scenarios
	

	  @Test(priority=201, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_ManualDefault_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("New LOC - Manual Default"),"Login->Borrower Registration->New Loan->Age the Store Duedate->Manual Default");
			  String FileName= "QC_LOC_ManualDefault_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
		 	  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				//String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  	   RCSRLoginLogout.login(SSN, AppURL);		
				   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				   RCSRLoginLogout.logout();
				   RCSRLoginLogout.login(SSN, AppURL);
				   RQCCSRNewLoan.newLoan(SSN, AppURL);
				   RCSRLoginLogout.logout();
				   RCSRLoginLogout.login(SSN, AppURL);
				   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				   RCSRLoginLogout.login(SSN, AppURL);
			  	   RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);	
			  	   RCSRLoginLogout.login(SSN, AppURL);
			  	   RQCCSRHistory.history(SSN, AppURL);
			  	   RCSRLoginLogout.logout();
			  				
							 
				
				
				 
				 
			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  }
	  
	 	
	@Test(priority=202, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_Deposit_Return_ManualDefault_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("New LOC - Deposit - Return- Manual Default"),"Login->Borrower Registration->New Loan-->Duedate-->Deposit-->Return-->Manual Default");
			  String FileName= "QC_LOC_Deposit_Return_ManualDefault_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);			  							  				
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);	
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
							   
							   
							
				
				
				 
				 
			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 

	  
	 		  
	@Test(priority=203, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_Deposit_Return_2ndDeposit_Clear_3rdDeposit_Return_Default_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("New LOC-Deposit-Return-Deposit-Clear-Deposit-Return-Default(EOD/Auto EOD)"),"Login->Borrower Registration->New Loan-->Duedate-->Deposit-->Return-->2nd Deposit-->Clear-->3rd Deposit-->Return-->EOD");
			  String FileName= "QC_LOC_Deposit_Return_2ndDeposit_Clear_3rdDeposit_Return_Default_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
	
			  				   
			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);			  							  				
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);					  	   
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   //RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						  	   RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRACHClear.achclear(SSN, AppURL);
			  				   RCSRLoginLogout.logout();
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);					  	   
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				                   //RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays3rdTime(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSREOD_Default.eoddefault(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
			  				  
			  			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 
	  

	@Test(priority=204, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_2missedPayment_Default_EOD_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("New LOC-Deposit-Return-2nd Deposit-Clear-3rd Deposit–Return-Default(EOD/Auto EOD)"),"Login->Borrower Registration->Signature Loan-->2missed Payment-->Default_EOD/AutoEOD");
			  String FileName= "QC_LOC_2missedPayment_Default_EOD_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
	
			  				   
			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
							   RCSRLoginLogout.logout();
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);	
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSREOD_Default.eoddefault(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
		  				  
			  			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 	  
	  
	  
	  
	@Test(priority=205, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_Default_DefaultPayment_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("Default - Default Payment"),"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->Age store to 2 Gracedays-->reurn-->Age to 2nd due date-->Default-->Default Payment");
			  String FileName= "QC_LOC_Default_DefaultPayment_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
			  				
			  				//Old
				
			  				   /*RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);			  							  				
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);*/
			  				   //RCSRLoginLogout.login(SSN, AppURL);
			  				   //RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
			  				
			  				//New
			  				
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);			  							  				
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);	
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);						  	   
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);			  				   			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
							   
			  				   
			  				   
			  			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 
	  
	@Test(priority=206, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_Default_DefaultPayment_Void_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("Default - Default Payment - Void"),"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->Age store to 2 Grace days-->reurn-->Age to 2nd due date-->Default-->Default Payment-->Void");
			  String FileName= "QC_LOC_Default_DefaultPayment_Void_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);			  							  				
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);	
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);						  	   
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);			  				   			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRDefault_Void.defaultvoid(SSN, AppURL);
			  				                //RCSRLoginLogout.logout();
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
							   
			  				   
			  				   
			  			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 

	  
	@Test(priority=207, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_Default_PartialDefaultPayment_Void_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("Default - Partial Default Payment - Void"),"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->Age store to 2 Grace days-->reurn-->Age to 2nd due date-->Default-->PartialDefault Payment-->Void");
			  String FileName= "QC_LOC_Default_PartialDefaultPayment_Void_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);			  							  				
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);	
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);						  	   
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);			  				   			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);			  				  		  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRPartialDefaultPayment.partialdefaultpayment(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRDefault_Void.defaultvoid(SSN, AppURL);
			  				                                //RCSRLoginLogout.logout();
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
			  				  
							   
			  				   
			  				   
			  			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 
	
	@Test(priority=208, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_Default_DefaultPayment_Return_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("Default - Default Payment(ACH/CCK/MO) - Return"),"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->Age store to 2 Grace days-->reurn-->Age to 2nd due date-->Default-->Default Payment-->Return");
			  String FileName= "QC_LOC_Default_DefaultPayment_Return_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);			  							  				
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);	
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);						  	   
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);			  				   			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRDefaultPayment_CCK_Return.defaultpaymentreturn(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRInternalTransfer.internaltransfer(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
			  				   RCSRLoginLogout.logout();
			  				   RQCAdminCCKReturn.cckreturn(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
							   
			  				   
			  				   
			  			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  }   
	  
	@Test(priority=209, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_Default_PartialDefaultPayment_FullDefaultPayment_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("Default - Partial Default Payment - Full Default payment"),"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->reurn-->Age to 2nd due date-->Default-->PartialDefault Payment-->Full DefaultPayment");
			  String FileName= "QC_LOC_Default_PartialDefaultPayment_FullDefaultPayment_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				  
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);			  							  				
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);	
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);						  	   
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);			  				   			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);	
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRPartialDefaultPayment.partialdefaultpayment(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
			  				   
			  				  
			  				   
			  				  
							   
			  				   
			  				   
			  			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 
	
	
	  
	@Test(priority=210, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_Default_PartialDefaultPayment_FullDefaultPayment_Void_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("Default - Partial Default Payment - Full Default payment - Void"),"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->reurn-->Age to 2nd due date-->Default-->PartialDefault Payment-->Full DefaultPayment-->Void");
			  String FileName= "QC_LOC_Default_PartialDefaultPayment_FullDefaultPayment_Void_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);			  							  				
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);	
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);						  	   
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);			  				   			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);	
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRPartialDefaultPayment.partialdefaultpayment(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);		  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRDefault_Void.defaultvoid(SSN, AppURL);
			  				                //RCSRLoginLogout.logout();
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
			  			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 

	  
	  
	  @Test(priority=211, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_PayOff_Closure_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("New LOC – Payoff – LOC Closure"),"Login->Borrower Registration->New Loan-->Age Store to Gracedays-->PayOff-->Closure");
			  String FileName= "QC_LOC_PayOff_Closure_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);							   
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCPayOff.payoff(SSN, AppURL);
							                         //RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSR_LOCClosure.locclosure(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
							  
						   
							   
						  	 
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 


	  @Test(priority=212, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_Payment_PayOff_Closure_Void_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("New LOC – Payment – Payoff – LOC Closure – Void"),"Login->Borrower Registration->New Loan-->Age Store to Gracedays-->Payment-->PayOff-->Closure-->Void");
			  String FileName= "QC_LOC_Payment_PayOff_Closure_Void_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCPayment.payment(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCPayOff.payoff(SSN, AppURL);
							                           //RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSR_LOCClosure.locclosure(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSR_LOC_VoidClosure.locvoidclosure(SSN, AppURL);
							                             //RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
							  
						   
							   
						  	 
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 

	@Test(priority=213, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_PayOff_Closure_PayoffReturn_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("New LOC – Payoff – LOC Closure – Payoff return"),"Login->Borrower Registration->New Loan-->Age Store to Gracedays-->PayOff-->Closure-->PayoffReturn(Internal Transfer-->Cmg Deposit-->Return)");
			  String FileName= "QC_LOC_PayOff_Closure_PayoffReturn_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);							   
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSR_CashierCheck_Payoff.cashiercheckpayoff(SSN, AppURL);							   
							                         //RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSR_LOCClosure.locclosure(SSN, AppURL);
							   RCSRLoginLogout.logout();							   
							   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRInternalTransfer.internaltransfer(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
			  				   RCSRLoginLogout.logout();
			  				   RQCAdminCCKReturn.cckreturn(SSN, AppURL);	
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
			  				   
							   
							  
						   
							   
						  	 
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 
	  
	@Test(priority=214, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_PayOff_Agestore180days_AutoClosure_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("New LOC – Payoff – Age the store to 180 days – Auto Closure"),"Login->Borrower Registration->New Loan-->Age Store to Gracedays-->PayOff-->Age Store to 180 days-->AutoClosure");
			  String FileName= "QC_LOC_PayOff_Agestore180days_AutoClosure_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);							   							  							   							   
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCPayOff.payoff(SSN, AppURL);
							                              //RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
							   //RQCAgeStoreGraceDays.age180day(SSN, AppURL);
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRAutoClosure.autoclosure(SSN, AppURL);
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
							   
							   
							   
							  
							  
						   
							   
						  	 
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				//test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 
	  
	
	@Test(priority=215, groups="EOD")
	  public static void RQC_LOC_ManualDefault_EOD_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("New LOC - Manual Default – EOD on Payment Due Date"),"Login->Borrower Registration->New Loan-->Manual Default-->AgeStore to Duedate-->EOD");
			  String FileName= "QC_LOC_ManualDefault_EOD_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);					  							  
						  	   RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCEODDeposit.eodDeposit(SSN, AppURL);
			  				   RQCAdminStoreSetup.storeSetup(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);			  				   
			  				   RQCSafeAssign.safeAssign(SSN, AppURL);
			  				   RQCDrawerAssign.drawerAssign(SSN, AppURL);
			  				   RCSRLoginLogout.logout();
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();
							 
				
				
				 
				 
			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 
	
	
	@Test(priority=216, groups="Ratikanta_NEOD")
	  public static void RQC_LOC_Deposit_Return_2ndDeposit_Return_Default_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("New LOC - Deposit - Return- 2nd Deposit - Return - Default(EOD/Auto EOD)"),"Login->Borrower Registration->New Loan-->Duedate-->Deposit-->Return-->2nd Deposit-->Return-->EOD-->Verify Status as Default");
			  String FileName= "QC_LOC_Deposit_Return_2ndDeposit_Return_Default_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				
			  				   RCSRLoginLogout.login(SSN, AppURL);		
							   RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
							   RQCCSRNewLoan.newLoan(SSN, AppURL);
							   RCSRLoginLogout.logout();
							   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);			  							  				
						  	   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);	
						  	   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);						  	   
			  				   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);			  				   			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);						  	       			  				       	  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSR_Deposit.deposit(SSN, AppURL);
						  	   RQCCSRReturnPosting.returnposting(SSN, AppURL);
			  				   RQCAdminACHReturn.achreturn(SSN, AppURL);							  	   						  	  
			  				                  /*RCSRLoginLogout.login(SSN, AppURL);
			  				                     RQCEODDeposit.eodDeposit(SSN, AppURL);
			  				                     RQCAdminStoreSetup.storeSetup(SSN, AppURL);
			  				                     RCSRLoginLogout.login(SSN, AppURL);			  				   
			  				                     RQCSafeAssign.safeAssign(SSN, AppURL);
			  				                     RQCDrawerAssign.drawerAssign(SSN, AppURL);
			  				                    RCSRLoginLogout.logout();*/
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);			  				   
			  				   RCSRLoginLogout.login(SSN, AppURL);
			  				   RQCCSREOD_Default.eoddefault(SSN, AppURL);
			  				   RCSRLoginLogout.login(SSN, AppURL);
						  	   RQCCSRHistory.history(SSN, AppURL);
						  	   RCSRLoginLogout.logout();

							   
							   
							
				
				
				 
				 
			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  } 
//============================================================================================================	  
	 @Test(priority=202)
	  public static void RQC_DefaultPayment_Void_Txn_Testdata() throws Exception {
		  try
		  {
			  test=reports.startTest(("ILP_Scenario_No.37"),"Login->Borrower Registration->New Loan->Age the Store installment wise to make a loan Default->DefaultPayment-->Void");
			  String FileName= "QC_DefaultPayment_Void_Txn_Testdata.xls";
			  //String FileName= Rprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
			  			//ExcelNew TestData;
			  			TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
			  		  
			  	//test=reports.startTest("Lend Nation Smoke_testing","Lend Nation Application test report");


			  	//String FileName= "Registration_Lend_Nation.xls";
			  		//Excel TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			  		//int lastrow=TestData.getLastRow("Start");
			  			int lastrow=TestData.getLastRow("Start");
			  		String sheetName="Start";
			  		//int lastrow=TestData.getLastRow("Borrower");
			  		System.out.println(lastrow);
			  		for(int row=2;row<=lastrow;row++)
			  		{
			  			
			  			
			  			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			  			//System.out.println(RunFlag);
			  		if(RunFlag.equals("Y"))
			  		{	
			  			//driver.get(appUrl);
			  			//test.log(LogStatus.INFO, "Application is launched");
			  			//driver.manage().window().maximize();
			  				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
			  				String SSN = TestData.getCellData(sheetName,"SSN",row); 
			  				
			  				System.out.println(AppURL);
				 //RQCRCSRLoginLogout.login(SSN, AppURL);
				 RCSRLoginLogout.login(SSN, AppURL);
				 RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				 //RQCRCSRLoginLogout.logout(SSN, AppURL);
				 RCSRLoginLogout.logout();
				 RCSRLoginLogout.login(SSN, AppURL);
				 RQCCSRNewLoan.newLoan(SSN, AppURL);
				 RCSRLoginLogout.login(SSN, AppURL);
				 RQCCSRDefault.sdefault(SSN, AppURL);
				 RCSRLoginLogout.login(SSN, AppURL);
				 RQCAgeStoreGraceDays.ageStoreGraceDays(SSN,AppURL);	
				 RCSRLoginLogout.login(SSN, AppURL);
				
				
				 
							 
				 
			
		}
		}
		  }
		  
		  
		  
		  
		  catch(Exception e)
		  {
			  System.out.println("under catch of Test" +e);
				test.log(LogStatus.ERROR, "Unable to start scenarios " );

		  }
	  }  
	  
	
	  
//Janaki's (Ratikanta) scenarios
	  
	  @Test(priority=301,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_New_Loan_Void_Txn() throws Exception {
			try
			{			
				
				test=reports.startTest(Jprop.getProperty("QC_LOC_New_Loan_Void_Txn"),"Login->Borrower Registratino->New Loan ->Void");
				//test=reports.startTest(("QC_LOC_New_Loan_Void_Txn"),"Login->Borrower Registratino->New Loan ->Void");
				
				FileName= Jprop.getProperty("QC_LOC_New_Loan_Void_Txn_file_name")+".xls";
				//FileName= "QC_LOC_ManualDefault_Txn_Testdata.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);
				

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_LOC_New_Loan_Void_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				test.log(LogStatus.ERROR,"Unable to start scenario 17 JQC_LOC_New_Loan_Void_Txn ");


			}
		}
		@Test(priority=302,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_New_Loan_Rescind_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_New_Loan_Rescind_Txn"),"Login->Borrower Registratino->New Loan ->Rescind");

				FileName= Jprop.getProperty("QC_LOC_New_Loan_Rescind_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRescind.Rescind(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_New_Loan_Rescind_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start scenario 19 JQC_LOC_New_Loan_Rescind_Txn ");


			}
		}
		@Test(priority=303,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_New_Loan_Void_GraceDay_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_New_Loan_Void_GraceDay_Txn"),"Login->Borrower Registratino->New Loan ->GraceDays_Void");

				FileName= Jprop.getProperty("QC_LOC_New_Loan_Void_GraceDay_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCEncryptionDetails.readEncryptionDetails(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCAdminEncryption.getEncryption(driver, SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreVoid.ageStoreVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_New_Loan_Void_GraceDay_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start scenario 18 JQC_LOC_New_Loan_Void_GraceDay_Txn ");


			}
		}
		@Test(priority=304,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_New_Loan_GraceDay_Rescind_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_New_Loan_GraceDay_Rescind_Txn"),"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName= Jprop.getProperty("QC_LOC_New_Loan_GraceDay_Rescind_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRescind.Rescind(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_New_Loan_GraceDay_Rescind_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start scenario 20 JQC_LOC_New_Loan_GraceDay_Rescind_Txn ");


			}
		}
		@Test(priority=305,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_New_Loan_After_RescindDays_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_New_Loan_After_RescindDays_Txn"),"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName= Jprop.getProperty("QC_LOC_New_Loan_After_RescindDays_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRescind.Rescind(SSN, AppURL);
											
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_New_Loan_After_RescindDays_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start scenario 21 JQC_LOC_New_Loan_After_RescindDays_Txn ");


			}
		}
		@Test(priority=306,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_Payment_After_Rescind_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_Payment_After_Rescind_Txn"),"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName= Jprop.getProperty("QC_LOC_Payment_After_Rescind_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCPayment.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_Payment_After_Rescind_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start scenario 22 JQC_LOC_Payment_After_Rescind_Txn ");


			}
		}
		@Test(priority=307,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_Payment_OnDueDate_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_Payment_OnDueDate_Txn"),"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName= Jprop.getProperty("QC_LOC_Payment_OnDueDate_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
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
						JQCPayment.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_Payment_OnDueDate_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start scenario 23 JQC_LOC_Payment_OnDueDate_Txn ");


			}
		}
			
		@Test(priority=308,enabled = true, groups="Janaki_NEOD")
		
		public static void JQC_LOC_LessThan_MinPayment_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_LessThan_MinPayment_Txn"),"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName= Jprop.getProperty("QC_LOC_LessThan_MinPayment_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_LessThan_MinPayment_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start scenario 24 JQC_LOC_LessThan_MinPayment_Txn ");


			}
		}

		@Test(priority=309,enabled = true, groups="Janaki_NEOD")
		

		public static void JQC_LOC_GreaterThan_MinPayment_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_GreaterThan_MinPayment_Txn"),"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName= Jprop.getProperty("QC_LOC_GreaterThan_MinPayment_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_GreaterThan_MinPayment_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start scenario 25 JQC_LOC_GreaterThan_MinPayment_Txn ");


			}
		}

		@Test(priority=310,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_DueDate_GreaterThan_MinPayment_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_DueDate_GreaterThan_MinPayment_Txn"),"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName= Jprop.getProperty("QC_LOC_DueDate_GreaterThan_MinPayment_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
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
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_DueDate_GreaterThan_MinPayment_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start scenario 26 JQC_LOC_DueDate_GreaterThan_MinPayment_Txn ");


			}
		}

		@Test(priority=311,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_DueDate_LessThan_MinPayment_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_DueDate_LessThan_MinPayment_Txn"),"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName= Jprop.getProperty("QC_LOC_DueDate_LessThan_MinPayment_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
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
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_DueDate_LessThan_MinPayment_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start scenario 27 JQC_LOC_DueDate_LessThan_MinPayment_Txn ");


			}
		}
		@Test(priority=312,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_Payment_void_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_Payment_void_Txn"),"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName= Jprop.getProperty("QC_LOC_Payment_void_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCPayment.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_Payment_void_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start scenario 28 JQC_LOC_Payment_void_Txn ");


			}
		}
		
		@Test(priority=313,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_Payment_void_NextBusinessDay_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_Payment_void_NextBusinessDay_Txn"),"Login->Borrower Registratino->New Loan ->Payment -> void on NextBusinessDay");

				FileName= Jprop.getProperty("QC_LOC_Payment_void_NextBusinessDay_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCPayment.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCEncryptionDetails.readEncryptionDetails(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						    //JQCAdminLoginLogout.login(SSN, AppURL);
						JQCAdminEncryption.getEncryption(driver, SSN, AppURL);
						   //JQCAdminLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreVoid.ageStoreVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_Payment_void_NextBusinessDay_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start LOC_Scenario No.29 JQC_LOC_Payment_void_NextBusinessDay_Txn ");


			}
		}

		@Test(priority=314,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_LessThan_MinPayment_Viod_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_LessThan_MinPayment_Void_Txn"),"Login->Borrower Registratino->New Loan ->MinPayment --> Void");

				FileName= Jprop.getProperty("QC_LOC_LessThan_MinPayment_Void_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_LessThan_MinPayment_Viod_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start  LOC_Scenario No.30 JQC_LOC_LessThan_MinPayment_Viod_Txn ");


			}
		}
		@Test(priority=315,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_GreaterThan_MinPayment_Void_Txn() throws Exception {
			
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_GreaterThan_MinPayment_Void_Txn"),"Login->Borrower Registratino->New Loan ->GreaterThanMinPayment --> Void");

				FileName= Jprop.getProperty("QC_LOC_GreaterThan_MinPayment_Void_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_GreaterThan_MinPayment_Void_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start  LOC_Scenario No.31 JQC_LOC_GreaterThan_MinPayment_Void_Txn ");


			}
		}
		
		@Test(priority=316,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_LessThan_MinPayment_Return_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_LessThan_MinPayment_Return_Txn"),"Login->Borrower Registratino->New Loan ->MinPayment --> return");

				FileName= Jprop.getProperty("QC_LOC_LessThan_MinPayment_Return_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL); 
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);				
						JQCInternalTransfer.internalTransfer(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminLoginLogout.login(SSN, AppURL);		
						JQCAdminCCKReturn.cckreturn(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_LessThan_MinPayment_Return_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start  LOC_Scenario No.32 JQC_LOC_LessThan_MinPayment_Return_Txn ");


			}
		}
		@Test(priority=317,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_GreaterThan_MinPayment_Return_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_GreaterThan_MinPayment_Return_Txn"),"Login->Borrower Registratino->New Loan ->GreaterThan-> MinPayment-> Return");

				FileName= Jprop.getProperty("QC_LOC_GreaterThan_MinPayment_Return_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);				
						JQCInternalTransfer.internalTransfer(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminLoginLogout.login(SSN, AppURL);		
						JQCAdminCCKReturn.cckreturn(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						

					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_GreaterThan_MinPayment_Return_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start  LOC_Scenario No.33 JQC_LOC_GreaterThan_MinPayment_Return_Txn ");


			}
		}

		@Test(priority=318,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_Refinance_StepSame_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_Refinance_StepSame_Txn"),"Login->Borrower Registratino->New Loan ->Refinance_StepSame");

				FileName= Jprop.getProperty("QC_LOC_Refinance_StepSame_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
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
						JQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL); 
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinance_StepSame.StepSame(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
				
					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_Refinance_StepSame_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start  LOC_Scenario No.94 JQC_LOC_Refinance_StepSame_Txn ");


			}
		}
		
		@Test(priority=319,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_Refinance_StepUp_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_Refinance_StepUp_Txn"),"Login->Borrower Registratino->New Loan ->Refinance_StepUp");

				FileName= Jprop.getProperty("QC_LOC_Refinance_StepUp_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JDrawNewLoanMinamount.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
		  				   
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinance_StepUp.Stepup(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_Refinance_StepUp_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start  LOC_Scenario No.95 JQC_LOC_Refinance_StepUp_Txn ");


			}
		}
		
		@Test(priority=320,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_Refinance_CABPayment_Return_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_Refinance_CABPayment_Return_Txn"),"Login->Borrower Registratino->New Loan ->Refinance_CABPayment_Return");

				FileName= Jprop.getProperty("QC_LOC_Refinance_CABPayment_Return_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
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
						JQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
		  				   
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinance_CABPayment.CABPayment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);				
						JQCInternalTransfer.internalTransfer(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminLoginLogout.login(SSN, AppURL);		
						JQCAdminCCKReturn.cckreturn(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_Refinance_CABPayment_Return_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start  LOC_Scenario No.98 JQC_LOC_Refinance_CABPayment_Return_Txn ");


			}
		}
		@Test(priority=321,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_Refinance_Stepdown_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_Refinance_Stepdown_Txn"),"Login->Borrower Registratino->New Loan ->Refinance_Stepdown");

				FileName= Jprop.getProperty("QC_LOC_Refinance_Stepdown_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
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
						JQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
		  				   
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinance_Stepdown.Stepdown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_Refinance_Stepdown_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start  LOC_Scenario No.95 JQC_LOC_Refinance_Stepdown_Txn ");


			}
		}
		
	 @Test(priority=322,enabled = true, groups="Janaki_NEOD")
		public static void JQC_LOC_Refinance_Latefee_Payment_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_Refinance_Latefee_Payment_Txn"),"Login->Borrower Registratino->New Loan ->Refinance_Latefee_Payment");

				FileName= Jprop.getProperty("QC_LOC_Refinance_Latefee_Payment_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						System.out.println(AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewloanSignature.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
					  	JQCCSRLoginLogout.login(SSN, AppURL);
		  				JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
		  				  
		  				JQCCSRLoginLogout.login(SSN, AppURL);
					  	JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					  	   
					    JQCCSRLoginLogout.login(SSN, AppURL);
		  			    JQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);

		  				JQCCSRLoginLogout.login(SSN, AppURL);
		  				JRefinance_waive.waive(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
			}

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_Refinance_Latefee_Payment_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start  LOC_Scenario No.97 JQC_LOC_Refinance_Latefee_Payment_Txn ");


			}
		}
		@Test(priority=323,enabled = true, groups="Janaki_EOD")
		public static void JQC_LOC_Refinance_EOD_Payment_Txn() throws Exception {
			try
			{			
				test=reports.startTest(Jprop.getProperty("QC_LOC_Refinance_EOD_Payment_Txn"),"Login->Borrower Registratino->New Loan ->Refinance_EOD_Payment");

				FileName= Jprop.getProperty("QC_LOC_Refinance_EOD_Payment_Txn_file_name")+".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName);

				int lastrow=TestData.getLastRow("Start");
				String sheetName="Start";
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);
					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
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
						JQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
		  				   
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinance_StepSame.StepSame(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCEODDeposit.eodDeposit(SSN, AppURL);
						
						JQCAdminStoreSetup.storeSetup(SSN, AppURL);
						           //JQCAdminLoginLogout.logout(SSN, AppURL);
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

			catch(Exception e)
			{
				System.out.println("under catch of Test" + e);
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_LOC_Refinance_EOD_Payment_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				
				test.log(LogStatus.ERROR,"Unable to start  LOC_Scenario No.99 JQC_LOC_Refinance_EOD_Payment_Txn ");


			}
		}

	//Anoop scenarios
		

		@Test(priority=427,enabled=true,groups={"EOD3"})
		public void PaymentDepositEODReDeposit() throws Exception{
			FileName="QC_PaymentDepositEODReDeposit.xls";
			test=reports.startTest("QC_PaymentDepositEODReDeposit","LOC-->Payment less than Min Payment Amt -->Deposit -->EOD-->Return-->Redeposit");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					ALOCPayments.payment(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();


					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					AQCAdminLoginLogout.login(SSN, AppURL);
					AQCCSRReturnPosting.returnposting(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);

					AQCAdminLoginLogout.login(SSN, AppURL);
					AQCAdminACHReturn.achreturn(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCRedeposit.redeposit(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

				}}
		}



		@Test(priority=426,enabled=false,groups={"EOD3"})
		public void DepositEODReDeposit() throws Exception{
			FileName="QC_DepositEODReDeposit.xls";
			test=reports.startTest("QC_DepositEODReDeposit","LOC – Deposit-->EOD-->Return-->Redeposit");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();


					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();


					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					AQCAdminLoginLogout.login(SSN, AppURL);
					AQCCSRReturnPosting.returnposting(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);

					AQCAdminLoginLogout.login(SSN, AppURL);
					AQCAdminACHReturn.achreturn(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCRedeposit.redeposit(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

				}}
		}



	
		@Test(priority=423,enabled=false,groups={"EOD3"})
		public void SignatureNewLoan_EODTwice() throws Exception{
			FileName="QC_LOC_SignatureLoan_EOD.xls";
			test=reports.startTest("QC_LOC_SignatureLoan_EOD","New LOC for signature collateral –-> EOD on Payment Due Date- Age the store to 10 days-->EOD on 2nd Payment Due Date) ");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewloanSignature.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);			
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					ALatefeegenerationCheck.transactioncheck(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);			
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					//test.log(LogStatus.INFO, "****Test Scenario for paymentDraw and EOD  is pass******");
				}}}



		@Test(priority=422,enabled=false,groups={"EOD3"})
		public void Clear_Return_EODTwice() throws Exception{
			FileName="QC_LOC_clearReturnEODTwice.xls";
			test=reports.startTest("QC_LOC_clearReturnEODTwice","New LOC – EOD on Payment Due Date(including collateral Deposit) - Age the store - clear -EOD on 2nd Payment Due Date(including collateral Deposit) - Age the store - Return - EOD on 3nd Payment Due Date(including collateral Deposit) ");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();


					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);			
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					AQCAdminLoginLogout.login(SSN, AppURL);
					AQCCSRReturnPosting.returnposting(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCClearDropdown.clearDropDown(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);			
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					AQCAdminLoginLogout.login(SSN, AppURL);
					AQCCSRReturnPosting.returnposting(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);

					AQCAdminLoginLogout.login(SSN, AppURL);
					AQCAdminACHReturn.achreturn(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					//test.log(LogStatus.INFO, "****Test Scenario for paymentDraw and EOD  is pass******");
				}}}




		@Test(priority=421,enabled=false,groups={"EOD2"})
		public void Deposit_DrawEODTwice() throws Exception{
			FileName="QC_LOC_Draw_EODTwice.xls";
			test=reports.startTest("QC_LOC_Draw_EODTwice","New LOC-->EOD on Payment Due Date(including collateral Deposit)-->Age the store-->Draw -EOD on 2nd Payment Due Date(including collate ral Deposit)");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					ADrawNewLoanMinamount.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();


					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					AQCAdminLoginLogout.login(SSN, AppURL);
					AQCCSRReturnPosting.returnposting(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCClearDropdown.clearDropDown(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCDraw.draw(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					//test.log(LogStatus.INFO, "****Test Scenario for paymentDraw and EOD  is pass******");
				}}}


		@Test(priority=420,enabled=false,groups={"EOD2"})
		public void DepositEODTwice() throws Exception{
			FileName="QC_LOC_DepositEODTwice.xls";
			test=reports.startTest("QC_LOC_DepositEODTwice","New LOC-->EOD on Payment Due Date(including collateral Deposit)-->EOD on 2nd Payment Due Date(including collateral Deposit)");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();


					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();


					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					//test.log(LogStatus.INFO, "****Test Scenario for paymentDraw and EOD  is pass******");
				}}}



		@Test(priority=419,enabled=false,groups={"EOD2"})
		public void PaymentdrawVoidEOD() throws Exception{
			FileName="QC_LOC_paymentDraw_Void_EOD.xls";
			test=reports.startTest("QC_LOC_paymentDraw_Void_EOD","New LOC--> Payment-->Draw(LOC Increment amt)--->Void-->EOD on Payment Due Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					//This is normal payment
					AQCPayment.payment(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCDraw.draw(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCDrawVoid.qcVoid(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

					//test.log(LogStatus.INFO, "****Test Scenario for paymentDraw and EOD  is pass******");
				}}}



		@Test(priority=418,enabled=false,groups={"EOD2"})
		public void PaymentAndDraw() throws Exception{
			FileName="QC_LOC_payment_Draw.xls";
			test=reports.startTest("QC_LOC_payment_Draw","New LOC--> Payment-->Draw(LOC Increment amt)-->EOD on Payment Due Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					//This is normal payment
					AQCPayment.payment(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCDraw.draw(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					//test.log(LogStatus.INFO, "****Test Scenario for paymentDraw and EOD  is pass******");
				}}}





		@Test(priority=417,enabled=false,groups={"EOD1"})
		public void DrawAndEOD() throws Exception{
			FileName="QC_LOC_Draw_EOD.xls";
			test=reports.startTest("QC_LOC_Draw_EOD","New LOC-->Draw(LOC Increment amt)-->EOD on Payment Due Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();


					ACSRLoginLogout.login(SSN,AppURL);
					ADrawNewLoanMinamount.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCDraw.draw(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

					test.log(LogStatus.INFO, "****Test Scenario for Draw and EOD  is pass******");
				}}}





		@Test(priority=416,enabled=false,groups={"EOD1"})
		public void DepositAndEOD() throws Exception{
			FileName="QC_LOC_Deposit_EOD.xls";
			test=reports.startTest("QC_LOC_Deposit_EOD","New LOC -->Deposit--> EOD on Payment Due Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();


					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

					test.log(LogStatus.INFO, "****Test Scenario for Deposit and EOD  is pass******");
				}}}



		@Test(priority=415,enabled=false,groups={"EOD1"})
		public void PayOFFandEod() throws Exception{
			FileName="QC_LOC_PayOff_EOD.xls";
			test=reports.startTest("QC_LOC_PayOff_EOD","New LOC -->Payoff--> EOD on Payment Due Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCPayOff.payoff(SSN, AppURL);
					ACSRLoginLogout.logout();


					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

					test.log(LogStatus.INFO, "****Test Scenario for PayOff and EOD  is pass******");
				}}}



		@Test(priority=414,enabled=false,groups={"EOD1"})
		public void VoidandEod() throws Exception{
			FileName="QC_LOC_Void_EOD.xls";
			test=reports.startTest("QC_LOC_Void_EOD","New LOC-->Payment --> Void --> EOD on payment Due Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					//This is normal payment
					AQCPayment.payment(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCVoid.qcVoid(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Payment void and EOD is pass******");
				}}}


		@Test(priority=414,enabled=false,groups={"EOD1"})
		public void HigherPaymentAndEod() throws Exception{
			FileName="QC_LOC_MorePayment_EOD.xls";
			test=reports.startTest("QC_LOC_MorePayment_EOD","New LOC-->Payment More than Min Payment Amt after Rescind Period -->EOD on Payment Due Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					//This is conditional payment
					ALOCPayments.payment(SSN, AppURL);
					ACSRLoginLogout.logout();


					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

					test.log(LogStatus.INFO, "****Test Scenario for Higher Payment and EOD  is pass******");
				}}}



		@Test(priority=413,enabled=false,groups={"EOD1"})
		public void PaymentAndEod() throws Exception{
			FileName="QC_LOC_Payment_EOD.xls";
			test=reports.startTest("QC_LOC_Payment_EOD","New LOC-->Payment less than Min Payment Amt after Rescind Period -->EOD on Payment Due Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					ALOCPayments.payment(SSN, AppURL);
					ACSRLoginLogout.logout();


					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

					test.log(LogStatus.INFO, "****Test Scenario for Payment and EOD  is pass******");
				}}}



		@Test(priority=412,enabled=false,groups={"EOD1"})
		public void EODOnDueDate() throws Exception{
			FileName="QC_LOC_EODDuedate.xls";
			test=reports.startTest("QC_LOC_EODDuedate","New LOC – EOD on Payment Due Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					AadminOpen.storeSetup(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					//EOD Process 
					ACSRLoginLogout.login(SSN, AppURL);
					AQCEODDeposit.eodDeposit(SSN, AppURL);
					AQCAdminStoreSetup.storeSetup(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);			  				   
					AQCSafeAssign.safeAssign(SSN, AppURL);
					AQCDrawerAssign.drawerAssign(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for EOD on Due date is pass******");
				}}}



		//------SET 1 of SHASHI------------------------------------------------------------------------------------------------------------------------------------------------------
		@Test(priority=487,enabled=true,groups={"NonEOD"})
		public void MinLocAmounts() throws Exception{
			FileName="QC_LOC_NewLoan_monthly_MinAmount.xls";
			test=reports.startTest("QC_LOC_MinAmount_Counts","New LOC for  Minimum amount LOC amts to validate Minimum Payment Amt");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					ALoanDecisionPage.newLoan(SSN, AppURL);

					test.log(LogStatus.INFO, "****Test Scenario for Monthly pay frequence to validate Minimum payment amount  is pass******");
				}}}



		@Test(priority=488,enabled=true,groups={"NonEOD"})
		public void MaxLocAmounts() throws Exception{
			FileName="QC_LOC_NewLoan_monthly_Maxamount.xls";
			test=reports.startTest("QC_LOC_Maxamount_Counts","New LOC for  Max amount LOC amts to validate Minimum Payment Amt");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					ALoanDecisionPage.newLoan(SSN, AppURL);

					test.log(LogStatus.INFO, "****Test Scenario for Monthly pay frequence to validate Minimum payment amount  is pass******");
				}}}



		@Test(priority=489,enabled=true,groups={"NonEOD"})

		public void ILP_maxloanCount() throws Exception{
			FileName=  "QC_LOC_MaxLoan.xls";
			test=reports.startTest("QC_LOC_MaxLoan_Count ","Login-->Borrower-->Max loan count");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");

			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					for(int i=1;i<=3;i++){

						ACSRLoginLogout.login(SSN,AppURL);
						LOCMaxloanCount.newLoan(SSN, AppURL);
						if(!(i==3))
						{
							test.log(LogStatus.INFO, "******Customer loan Number "+i+"is approved successfully*****");
						}
						else{
							test.log(LogStatus.INFO, "******Customer loan Number "+i+"is denied*****");
						}
					}
					test.log(LogStatus.INFO, "****Test Scenario for max loan amount is pass******");

				}}}

		@Test(priority=490,enabled=true,groups={"NonEOD"})
		public void NewLoanWeekly_Duedatevalidation() throws Exception{
			FileName="QC_LOC_EndDate_Weekly_Duedate.xls";
			test=reports.startTest("QC_LOC_EndDate_Weekly","New LOC for a customer with pay frequency Weekly and next pay date on End of the month  to validate Payment Due Date and Statement Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					LOCMaxloanCount.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Weekly pay frequence new loan and Due date validation is pass******");
				}}}

		@Test(priority=491,enabled=true,groups={"NonEOD"})
		public void NewLoanSemiMonthly_Duedatevalidation() throws Exception{
			FileName="QC_LOC_EndDate_Semimonthly_Duedate.xls";
			test=reports.startTest("QC_LOC_EndDate_Semimonthly","New LOC for a customer with pay frequency Semi – monthly and next pay date on End of the month  to validate Payment Due Date and Statement Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					LOCMaxloanCount.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Semi Monthly pay frequence new loan and Due date validation is pass******");
				}}}


		@Test(priority=492,enabled=true,groups={"NonEOD"})
		public void NewLoanMonthly_Duedatevalidation() throws Exception{
			FileName="QC_LOC_EndDate_monthly_Duedate.xls";
			test=reports.startTest("QC_LOC_EndDate_monthly","New LOC for a customer with pay frequency monthly and next pay date on End of the month  to validate Payment Due Date and Statement Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					LOCMaxloanCount.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Monthly pay frequence new loan and Due date validation is pass******");
				}}}


		@Test(priority=493,enabled=true,groups={"NonEOD"})
		public void NewLoanBiweeklyPaymentDuedate() throws Exception{
			FileName="QC_LOC_EndDate_Biweekly_Duedate.xls";
			test=reports.startTest("QC_LOC_EndDate_Biweekly","New LOC for a customer with pay frequency Biweekly and next pay date on End of the month  to validate Payment Due Date and Statement Date");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					LOCMaxloanCount.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for BiWeekly pay frequence new loan and Due date validation is pass******");
				}}}



		@Test(priority=494,enabled=true,groups={"NonEOD"})
		public void NewLoanWeekly() throws Exception{
			FileName="QC_LOC_NewLoan_Weekly.xls";
			test=reports.startTest("QC_LOC_NewLoan_Weekly","New LOC for a customer with pay frequency Weekly to validate LOC Eligible Amt");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Weekley pay frequence new loan is pass******");
				}}}


		@Test(priority=495,enabled=true,groups={"NonEOD"})
		public void NewLoanSemiMonthly() throws Exception{
			FileName="QC_LOC_NewLoan_Semimonthly.xls";
			test=reports.startTest("QC_LOC_NewLoan_Semimonthly","New LOC for a customer with pay frequency Semi monthly to validate LOC Eligible Amt");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Semi Monthly pay frequence new loan is pass******");
				}}}




		@Test(priority=496,enabled=true,groups={"NonEOD"})
		public void NewLoanMonthly() throws Exception{
			FileName="QC_LOC_NewLoan_monthly.xls";
			test=reports.startTest("QC_LOC_NewLoan_monthly","New LOC for a customer with pay frequency monthly to validate LOC Eligible Amt");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Monthly pay frequence new loan is pass******");
				}}}

		@Test(priority=497,enabled=true,groups={"NonEOD"})
		public void NewLoanBiweekly() throws Exception{
			FileName="QC_LOC_NewLoan_Biweekly.xls";
			test=reports.startTest("QC_LOC_NewLoan_Biweekly","New LOC for a customer with pay frequency Biweekly to validate LOC Eligible Amt");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for BiWeekly pay frequence new loan is pass******");
				}}}

		
		@Test(priority=498,enabled=true,groups={"NonEOD"})
		public void AReviseCredit_IncreaseIncome() throws Exception{

			FileName="QC_ AReviseCredit_IncreaseIncome.xls";
			test=reports.startTest("QC_ AReviseCredit_IncreaseIncome"," New LOC-->Increase Income-Revise credit ");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AReviseCredit.revisecredit(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					ABorrowerEdit.borrowerIncreaseNet(SSN, AppURL);
					ACSRLoginLogout.logout();	

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					//This is normal payment
					AQCPayment.payment(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					//This is normal payment
					AQCPayment.payment(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AReviseCredit.revisecreditafterIncrease(SSN, AppURL);
					ACSRLoginLogout.logout();	
					
					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

				}}
		}

		
		@Test(priority=499,enabled=true,groups={"NonEOD"})
		public void AReviseCredit_PayofffIncreaseIncome() throws Exception{
			FileName="QC_Payoff_AReviseCreditincreaseincome.xls";
			test=reports.startTest("QC_Payoff_AReviseCreditincreaseincome"," New LOC-->Payoff-->Auto closure-->Increase Income-->LOC-->Revise credit ");

			TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/ALOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 

					ACSRLoginLogout.login(SSN,AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.ageGracedays(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCPayOff.payoff(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.age180day(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AAutoclosure.autoclose(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AReviseCredit.revisecredit(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					ABorrowerEdit.borrowerIncreaseNet(SSN, AppURL);
					ACSRLoginLogout.logout();	

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					//This is normal payment
					AQCPayment.payment(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AAgetheStore.age1day(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					ACSRLoginLogout.login(SSN,AppURL);
					//This is normal payment
					AQCPayment.payment(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN,AppURL);
					AReviseCredit.revisecreditafterIncrease(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					ACSRLoginLogout.login(SSN,AppURL);
					AQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
				}}
		}


		
//Shashi scenarios

		

		@Test(priority=500,enabled=true,groups="Shashi")

		public void Deposit_Dropdown() throws Exception{
			FileName="QC_LOC_Deposit_Dropdown.xls";
			test=reports.startTest("QC_LOC_Deposit_DropDown");

			 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/SLOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					
					SCSRLoginLogout.login(SSN,AppURL);
					SCSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					SCSRLoginLogout.logout();
					SCSRLoginLogout.login(SSN,AppURL);
					SQCCSRNewLoan.newLoan(SSN, AppURL);
				    SCSRLoginLogout.logout();
					SCSRLoginLogout.login(SSN,AppURL);
					SQCAgeStoreDueDate.ageStoreDueDate(SSN,AppURL);
					SCSRLoginLogout.login(SSN,AppURL);
					SQCDepositDropdown.depositDropDown(SSN,AppURL);
					SCSRLoginLogout.logout();
					SCSRLoginLogout.login(SSN,AppURL);
					SQC_LOC_History.history(SSN,AppURL);
					SCSRLoginLogout.logout();
					
					test.log(LogStatus.INFO, "****Test Scenario for Deposit_DropDown_Sucsessfully******");
				}}}
		

		   @Test(priority=501,enabled=true,groups="Shashi")

	    public void Deposit_Dropdown_Void() throws Exception{
				FileName="QC_LOC_Deposit_DropDown_Void.xls";
				test=reports.startTest("QC_LOC_Deposit_DropDown_Void");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/SLOC/"+FileName);
				String sheetName="Start";
				int lastrow=TestData.getLastRow("Start");
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);

					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						
						SCSRLoginLogout.login(SSN,AppURL);
						SCSRBorrowerRegistration.borrowerReg(SSN,AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCCSRNewLoan.newLoan(SSN, AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCAgeStoreDueDate.ageStoreDueDate(SSN,AppURL);
						SCSRLoginLogout.login(SSN,AppURL);
						SQCDepositDropdown.depositDropDown(SSN,AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCVoid.qcVoid(SSN,AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQC_LOC_History.history(SSN,AppURL);
						SCSRLoginLogout.logout();
						test.log(LogStatus.INFO, "****Test Scenario for Deposit_DropDown_Void_Sucsessfully******");
					}}}
			

		   @Test(priority=502,enabled=true,groups="Shashi")

		public void SQC_LOC_Deposit_Bulk() throws Exception{
				FileName="QC_LOC_Deposit_Bulk.xls";
				test=reports.startTest("QC_LOC_Deposit_Bulk");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/SLOC/"+FileName);
				String sheetName="Start";
				int lastrow=TestData.getLastRow("Start");
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);

					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						
						SCSRLoginLogout.login(SSN,AppURL);
						SCSRBorrowerRegistration.borrowerReg(SSN,AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCCSRNewLoan.newLoan(SSN, AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCAgeStoreDueDate.ageStoreDueDate(SSN,AppURL);
						SCSRLoginLogout.login(SSN,AppURL);
						SQCDepositMenu.depositMenu(SSN,AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQC_LOC_History.history(SSN,AppURL);
						SCSRLoginLogout.logout();
						test.log(LogStatus.INFO, "****Test Scenario for Deposit_Bulk (Menu)_Sucsessfully******");
					}}}
			

		@Test(priority=503,enabled=true,groups="Shashi")

		public void SQC_LOC_Deposit_Bulk_Void() throws Exception{
			FileName="QC_LOC_Deposit_Bulk_Void.xls";
			test=reports.startTest("QC_LOC_Deposit_Bulk_Void");

			 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/SLOC/"+FileName);
			String sheetName="Start";
			int lastrow=TestData.getLastRow("Start");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);

				if(RunFlag.equals("Y"))
				{	
					String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					
					SCSRLoginLogout.login(SSN,AppURL);
					SCSRBorrowerRegistration.borrowerReg(SSN,AppURL);
					SCSRLoginLogout.logout();
					SCSRLoginLogout.login(SSN,AppURL);
					SQCCSRNewLoan.newLoan(SSN, AppURL);
					SCSRLoginLogout.logout();
					SCSRLoginLogout.login(SSN,AppURL);
					SQCAgeStoreDueDate.ageStoreDueDate(SSN,AppURL);
					SCSRLoginLogout.login(SSN,AppURL);
					SQCDepositMenu.depositMenu(SSN,AppURL);
					SCSRLoginLogout.logout();
					SCSRLoginLogout.login(SSN,AppURL);
					SQCVoid.qcVoid(SSN,AppURL);
					SCSRLoginLogout.logout();
					SCSRLoginLogout.login(SSN,AppURL);
					SQC_LOC_History.history(SSN,AppURL);
					SCSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Deposit_Bulk (Menu)_Void_Sucsessfully******");
				}}}
		

		  @Test(priority=504,enabled=true,groups="Shashi")

		public void MidDay_Deposit() throws Exception{
				FileName="QC_LOC_MidDay_Deposit.xls";
				test=reports.startTest("QC_LOC_MidDay_Deposit");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/SLOC/"+FileName);
				String sheetName="Start";
				int lastrow=TestData.getLastRow("Start");
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);

					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						
						SCSRLoginLogout.login(SSN,AppURL);
						SCSRBorrowerRegistration.borrowerReg(SSN,AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCCSRNewLoan.newLoan(SSN, AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCAgeStoreDueDate.ageStoreDueDate(SSN,AppURL);
						SCSRLoginLogout.login(SSN,AppURL);
					    SCSRMidDayDeposit.middeposit(SSN,AppURL);
					    SCSRLoginLogout.logout();
					    SCSRLoginLogout.login(SSN,AppURL);
						SQC_LOC_History.history(SSN,AppURL);
						SCSRLoginLogout.logout();
					   
					    
						test.log(LogStatus.INFO, "****Test Scenario for MidDay_Deposit_Sucsessfully******");
					}}}
			

			
		

			@Test(priority=505,enabled=true,groups="Shashi")

		public void MidDay_Void_Deposit() throws Exception{
				FileName="QC_LOC_MidDay_Void_Deposit.xls";
				test=reports.startTest("QC_LOC_MidDay_Void_Deposit");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/SLOC/"+FileName);
				String sheetName="Start";
				int lastrow=TestData.getLastRow("Start");
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);

					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						
						SCSRLoginLogout.login(SSN,AppURL);
						SCSRBorrowerRegistration.borrowerReg(SSN,AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCCSRNewLoan.newLoan(SSN, AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCAgeStoreDueDate.ageStoreDueDate(SSN,AppURL);
						SCSRLoginLogout.login(SSN,AppURL);
					    SCSRMidDayDeposit.middeposit(SSN,AppURL);
					    SCSRLoginLogout.logout();
					    SCSRLoginLogout.login(SSN,AppURL);
					    SQCVoid.qcVoid(SSN,AppURL);
					    SCSRLoginLogout.logout();
					    SCSRLoginLogout.login(SSN,AppURL);
						SQC_LOC_History.history(SSN,AppURL);
						SCSRLoginLogout.logout();
					    
						test.log(LogStatus.INFO, "****<FONT color=green style=Arial>Test Scenario for MidDay_Void_Deposit_Sucsessfully******");
					}}}
			


			@Test(priority=506,enabled=true,groups="Shashi")

		public void SQC_LOC_LessMinPayment_Deposit() throws Exception{
				FileName="QC_LOC_LessMinPayment_Deposit.xls";
				test=reports.startTest("QC_LOC_LessMinPayment_Deposit");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/SLOC/"+FileName);
				String sheetName="Start";
				int lastrow=TestData.getLastRow("Start");
				System.out.println(lastrow);
				for(int row=2;row<=lastrow;row++)
				{
					String RunFlag = TestData.getCellData(sheetName,"Run",row);

					if(RunFlag.equals("Y"))
					{	
						String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
						String SSN = TestData.getCellData(sheetName,"SSN",row); 
						
						SCSRLoginLogout.login(SSN,AppURL);
						SCSRBorrowerRegistration.borrowerReg(SSN,AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCCSRNewLoan.newLoan(SSN, AppURL);
					    SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCAgeStoreDueDate.ageStoreDueDate(SSN,AppURL);
						SCSRLoginLogout.login(SSN,AppURL);
						SLOCPayments.payment(SSN,AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQCDepositDropdown.depositDropDown(SSN,AppURL);
						SCSRLoginLogout.logout();
						SCSRLoginLogout.login(SSN,AppURL);
						SQC_LOC_History.history(SSN,AppURL);
						SCSRLoginLogout.logout();
						test.log(LogStatus.INFO, "****Test Scenario for LessMinPaymentAmt_Deposit Sucsessfully******");
					}}}
			
					
		
//V Jyothi scenarios

		@Test(priority=0,enabled=true)

		public static void LOC_Writeoff() throws Exception {
			
				  
				  FileName="LOC_Writeoff.xls";
					test=reports.startTest("VQC_Writeoff","Login-->New LOC - Write off");

					 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/VLOC/"+FileName);

			int lastrow=TestData.getLastRow("Start");
			String sheetName="Start";
			//int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				
				
				
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				//System.out.println(RunFlag);
			if(RunFlag.equals("Y"))
			{	
				
					//String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
					String SSN = TestData.getCellData(sheetName,"SSN",row); 
					
					System.out.println(AppURL);
			 
					VQCCSRLoginLogout.login(SSN, AppURL);
					VQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					VQCCSRLoginLogout.login(SSN, AppURL);
					VQCCSRNewLoan.newLoan(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					VQCCSRLoginLogout.login(SSN, AppURL);
					VQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					VQCCSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOff.writeoff(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					VQCCSRLoginLogout.login(SSN, AppURL);
					//VQC_LOC_History.history(SSN, AppURL);
					VCSRLoginLogout.logout(SSN, AppURL);
					
					
			}
			}
			  
		  }

	@Test(priority=601,enabled=true)
	public static void LOC_WriteoffRecovery() throws Exception {
		
			  
			  FileName="LOC_WriteoffRecovery.xls";
				test=reports.startTest("VQC_WriteoffRecovery","Login-->New LOC - Write off - Write off recovery--Void");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/VLOC/"+FileName);

		int lastrow=TestData.getLastRow("Start");
		String sheetName="Start";
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			
			
			
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				System.out.println(AppURL);
		
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRNewLoan.newLoan(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOff.writeoff(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOffRecovery_Partial.writeoffrecovery(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
			
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCVoid.qcVoid(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				//VQC_LOC_History.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
		}
		}
		  
	  }

	
	
	@Test(priority=602,enabled=true)
	public static void LOC_PartialWriteoffRecovery() throws Exception {
		
			  
			  FileName="LOC_PartialWriteoffRecovery.xls";
				test=reports.startTest("VQC_PartialWriteoffRecovery","Login-->New LOC - Write off -  Partial Write off recovery");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/VLOC/"+FileName);

		int lastrow=TestData.getLastRow("Start");
		String sheetName="Start";
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			
			
			
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				System.out.println(AppURL);
		 
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRNewLoan.newLoan(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOff.writeoff(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOffRecovery_Partial.writeoffrecovery(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				//VQC_LOC_History.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
		}
		}
		  
	  }

	@Test(priority=603,enabled=true)
	public static void LOC_PartialWriteoffRecoveryVoid() throws Exception {
		
			  
			  FileName="LOC_PartialWriteoffRecoveryVoid.xls";
				test=reports.startTest("VQC_PartialWriteoffRecoveryVoid","Login-->New LOC - Write off -  Partial Write off recovery—Void");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/VLOC/"+FileName);

		int lastrow=TestData.getLastRow("Start");
		String sheetName="Start";
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			
			
			
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				System.out.println(AppURL);
		 
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRNewLoan.newLoan(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOff.writeoff(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOffRecovery_Partial.writeoffrecovery(SSN, AppURL);
				//VQCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCVoid.qcVoid(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				//VQC_LOC_History.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
			
		}
		}
		  
	  }

	@Test(priority=604,enabled=true)
	public static void LOC_Bankrupt_Writeoff() throws Exception {
		
			  
			  FileName="LOC _Bankrupt_Write off.xls";
				test=reports.startTest("VQC_Bankrupt_Writeoff","Login-->New LOC - Bankrupt Write off");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/VLOC/"+FileName);

		int lastrow=TestData.getLastRow("Start");
		String sheetName="Start";
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			
			
			
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				System.out.println(AppURL);
		 
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRNewLoan.newLoan(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
			
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRBankruptcy.bankruptcy(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				//VQCCSRLoginLogout.login(SSN, AppURL);
				VAdminLoginForBankruptcy.bankruptcy(driver, SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRHistory.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				//VQC_LOC_History.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				//VQC_LOC_History.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
			
		}
		}
		  
	  }

	@Test(priority=605,enabled=true)
	public static void LOC_Bankrupt_Writeoff_Dismissed() throws Exception {
		
			  
			  FileName="LOC_Bankrupt_Writeoff_Dismissed.xls";
				test=reports.startTest("VQC_Bankrupt_Writeoff_Dismissed","Login-->New LOC - Bankrupt Write off - Dismissed/Discharged");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/VLOC/"+FileName);

		int lastrow=TestData.getLastRow("Start");
		String sheetName="Start";
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			
			
			
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				System.out.println(AppURL);
		 
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRNewLoan.newLoan(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
			
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRBankruptcy.bankruptcy(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				//VQCCSRLoginLogout.login(SSN, AppURL);
				VAdminLoginForBankruptcy.bankruptcy(driver, SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRHistory.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VDismissed_Admin.Dismissed(driver, SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				//VQC_LOC_History.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
			
		}
		}
		  
	  }

	 @Test(priority=606,enabled=true)
	public static void  LOC_Deposit_Return_Writeoff() throws Exception {
		
			  
			  FileName="LOC_Deposit_Return_Writeoff.xls";
				test=reports.startTest(" VQC_Deposit-Return-Writeoff","Login-->New LOC - Deposit - Return- Write off");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/VLOC/"+FileName);

		int lastrow=TestData.getLastRow("Start");
		String sheetName="Start";
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			
			
			
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				System.out.println(AppURL);
		 
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRNewLoan.newLoan(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSR_Deposit.deposit(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRReturnPosting.returnposting(SSN, AppURL);
				VQCAdminACHReturn.achreturn(SSN, AppURL);			
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOff.writeoff(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				//VQC_LOC_History.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
					
			
		}
		}
		  
	  }


	@Test(priority=607,enabled=true)
	public static void  LOC_Deposit2_Return_Writeoff() throws Exception {
		
			  
			  FileName="LOC_Deposit2_Return_Writeoff.xls";
				test=reports.startTest(" VQC_Deposit2_Return_Writeoff","Login-->New LOC - Deposit - Return- 2nd Deposit - Return - Write off");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/VLOC/"+FileName);

		int lastrow=TestData.getLastRow("Start");
		String sheetName="Start";
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++) 
		{
			
			
			
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			
				String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				System.out.println(AppURL);
		 

				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRNewLoan.newLoan(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSR_Deposit.deposit(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRReturnPosting.returnposting(SSN, AppURL);
				VQCAdminACHReturn.achreturn(SSN, AppURL);
				
		        VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				
				
				VQCCSR_Deposit.deposit(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRReturnPosting.returnposting(SSN, AppURL);
				VQCAdminACHReturn.achreturn(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOff.writeoff(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
				VQCCSRLoginLogout.login(SSN, AppURL);
				//VQC_LOC_History.history(SSN, AppURL);
				VQCCSRHistory.history(SSN, SSN);				
				VCSRLoginLogout.logout(SSN, AppURL);
		}
	}
	}
	@Test(priority=608,enabled=true)
	public static void LOC_WriteoffRecoveryReturn() throws Exception {
		
			  
			  FileName="LOC_WriteoffRecoveryReturn.xls";
				test=reports.startTest("VQC_WriteoffRecoveryReturn","Login-->New LOC - Write off - Write off recovery--Return");

				 TestData = new ExcelNew(System.getProperty("user.dir")+"/TestData/QCStore/VLOC/"+FileName);

		int lastrow=TestData.getLastRow("Start");
		String sheetName="Start";
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			
			
			
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
		if(RunFlag.equals("Y"))
		{	
			
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row); 
				String SSN = TestData.getCellData(sheetName,"SSN",row); 
				
				System.out.println(AppURL);
		 
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRNewLoan.newLoan(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				         
				VQCCSRLoginLogout.login(SSN, AppURL);
	      		VQCCSRWriteOff.writeoff(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
			    VQCCSRLoginLogout.login(SSN, AppURL);
				VQCInternalTransfer.internalTransfer(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCCSRLoginLogout.login(SSN, AppURL);
				VQCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				VQCAdminCCKReturn.cckreturn(SSN, AppURL);
				
				VQCCSRLoginLogout.login(SSN, AppURL);
				//VQC_LOC_History.history(SSN, AppURL);
				VCSRLoginLogout.logout(SSN, AppURL);
				
		}
		}
		  
	  }

	
	
	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			// prop=prop.getProperty("user.dir")+"/Tests/Objects.properties";
			BufferedReader reader;
			BufferedReader Jreader;
			BufferedReader Rreader;
			BufferedReader Areader;
			BufferedReader Sreader;
			BufferedReader Vreader;
			

			try{ 
				reader = new BufferedReader(
						new FileReader("D:/QC_Batch/QC_LOC/src/test/java/tests/Objects.properties"));
				prop = new Properties();
				prop.load(reader);
				reader.close();
				AppURL = prop.getProperty("CSR_URL");
				AdminURL = prop.getProperty("ADMIN_CSR_URL"); 
				String Bfilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + Bfilename, true);

				
				
			
			}
			
			catch(Exception e)
			{
				
				System.out.println("Object proprties file not found");
			}
			

			try{ 
				Jreader = new BufferedReader(
						new FileReader("E:/QC_Batch/QC_LOC/src/test/java/tests/JObjects.properties"));
				Jprop = new Properties();
				Jprop.load(Jreader);
				Jreader.close();

				String Jfilename = Jprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				csr_url=prop.getProperty("CSR_URL");
				csrloginpage=prop.getProperty("Login_Page");
				AdminURL=prop.getProperty("ADMIN_URL");
				


				reports = new ExtentReports(
						System.getProperty("user.dir") + Jprop.getProperty("QC_Store_extent_report_path") + Jfilename, true);

			}
			
			catch(Exception e)
			{
				
				System.out.println("Object proprties file not found");
			}
			

			try{ 
				Rreader = new BufferedReader(
						new FileReader("E:/QC_Batch/QC_LOC/src/test/java/tests/RObjects.properties"));
				Rprop = new Properties();
				Rprop.load(Rreader);
				Rreader.close();
				csr_url=Rprop.getProperty("CSR_URL");
				csrloginpage=Rprop.getProperty("Login_Page");
				AdminURL=Rprop.getProperty("ADMIN_URL");
				String Rfilename = Rprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Rprop.getProperty("QC_Store_extent_report_path") + Rfilename, true);

			}
			
			catch(Exception e)
			{
				
				System.out.println("Object proprties file not found");
			}
			

			try{ 
				Areader = new BufferedReader(

						new FileReader("D:/QC_Batch/QC_LOC/src/test/java/tests/AObjects.properties"));

						


				Aprop = new Properties();
				Aprop.load(Areader);
				Areader.close();
				String Afilename = Aprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Aprop.getProperty("QC_Store_extent_report_path") + Afilename, true);

			}
			
			catch(Exception e)
			{
				
				System.out.println("Object proprties file not found");
			}
			


			try{ 
				Sreader = new BufferedReader(
						new FileReader("D:/QC_Batch/QC_LOC/src/test/java/tests/SObjects.properties"));
				Sprop = new Properties();
				Sprop.load(Sreader);
				Sreader.close();
				String Sfilename = Sprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Sprop.getProperty("QC_Store_extent_report_path") + Sfilename, true);

			}

			catch(Exception e)
			{
				
				System.out.println("Object proprties file not found");
			}
			
			
			
			try{ 
				Vreader = new BufferedReader(
						new FileReader("E:/QC_Batch/QC_LOC/src/test/java/tests/VObjects.properties"));
				Vprop = new Properties();
				Vprop.load(Vreader);
				Vreader.close();
				String Vfilename = Vprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Vprop.getProperty("QC_Store_extent_report_path") + Vfilename, true);

			}
			
			catch(Exception e)
			{
				
				System.out.println("Object proprties file not found");
			}
			
	
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

					}

		catch (Exception e) {
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// setup for the QC Store " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)
	public void killProcess() throws Exception {

		try {

			Runtime.getRuntime().exec("taskkill /IM iexplore.exe /F");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the IE process LOC process");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/LOC/FailedTestsScreenshots/"
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

	//@AfterMethod(alwaysRun = true)

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
