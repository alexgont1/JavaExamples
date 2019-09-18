package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.Page;

//ExtentReports extent instance created here
public class ExtentManager extends Page {

  private static ExtentReports extent;

  public static ExtentReports getInstance() {
      if (extent == null) {
  		htmlReporter = new ExtentHtmlReporter(userDir + fs + "test-output" + fs + "_ExtentReport.html");
  		// Create an object of Extent Reports
  		extent = new ExtentReports();
  		extent.attachReporter(htmlReporter);
  		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
  		extent.setSystemInfo("Environment", "Production");
  		extent.setSystemInfo("User Name", "Alex");
  		htmlReporter.config().setDocumentTitle("Test report Title");
  		// Name of the report
  		htmlReporter.config().setReportName("Test report name");
  		// Dark Theme
  		htmlReporter.config().setTheme(Theme.STANDARD);
      }
      return extent;
  }
}