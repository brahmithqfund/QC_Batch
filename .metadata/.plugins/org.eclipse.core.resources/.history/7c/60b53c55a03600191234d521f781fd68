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
import org.openqa.selenium.ie.InternetExplorerDriver;
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
	public static String business_date;
	public static String NextDueDate;
	public static String AppURL;
	public static String AdminURL;
	public static String transaction_date;

	public static String ESign_CheckNbr;
	public static String Password;
	public static String ESign_CollateralType;
	public static String Date1;
	public static String Date2;
	public static String Date3;
	public static String customer_number;

	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;

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
	public static String appdate;
	public static String day;
