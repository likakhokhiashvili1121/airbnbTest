package utils.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReporterManager {

    private static ExtentReports extent;
    private static ExtentSparkReporter reporter;
    private static ExtentTest extentTest;
    private static String reportHTMLPath;


    public static void createReportHTML(){
        if (extent == null) {
            try {
                createReportName();
                reporter = new ExtentSparkReporter(getReportHTMLPath())
                        .viewConfigurer()
                        .viewOrder()
                        .as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST })
                        .apply();
                configureReporter(reporter);
                extent = new ExtentReports();
                extent.attachReporter(reporter);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void createTest(String nameTest){
        extentTest = extent.createTest(nameTest);
    }


    public static ExtentTest createLogTest(){
        return extentTest;
    }


    public static void createReportName() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath =  "target/Reports/extentReport_" + timestamp + ".html";
        setReportHTMLPath(reportPath);
    }


    private static void configureReporter(ExtentSparkReporter spark) throws IOException {
        URL configURL = ReporterManager.class.getClassLoader().getResource("spark-config.xml");
        if (configURL == null) {
            throw new RuntimeException("");
        }

        File config = new File(configURL.getPath());
        spark.loadXMLConfig(config);
    }


    public static void extentFlush(){
        extent.flush();
    }


    private static void setReportHTMLPath(String reportHTML){
        reportHTMLPath = reportHTML;
    }

    public static String getReportHTMLPath(){
        return reportHTMLPath;
    }
}