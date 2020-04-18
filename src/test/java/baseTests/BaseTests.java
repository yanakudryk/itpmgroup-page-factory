package baseTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.Utils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {

    private WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected DevicesPage devicesPage;
    protected DealsPage dealsPage;
    protected DealPartiesPage dealPartiesPage;
    protected EmployeesPage employeesPage;
    protected PartsPage partsPage;
    protected DealTypePage dealTypePage;

    protected Utils utils;
    private String pathToScreenshot;

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            utils.screenShot(pathToScreenshot, webDriver);
        }
        @Override
        protected void finished(Description description) {
            webDriver.close();
        }
    };

    @Before
    public void SetUp(){
        webDriver = driverInit();
/*
        try {
            webDriver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

 */

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        devicesPage = new DevicesPage(webDriver);
        dealsPage = new DealsPage(webDriver);
        dealPartiesPage = new DealPartiesPage(webDriver);
        employeesPage = new EmployeesPage(webDriver);
        partsPage = new PartsPage(webDriver);
        dealTypePage = new DealTypePage(webDriver);

        pathToScreenshot = "C:\\Users\\akade\\IdeaProjects\\kudryk\\target\\screenshot\\" +
                this.getClass().getPackage().getName() + "\\" +
                this.getClass().getSimpleName() + this.testName.getMethodName() + ".jpg";

        utils = new Utils();
    }

    private WebDriver driverInit() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        return options;
    }
/*
    @After
    public void tearDown(){
        webDriver.quit();
    }
 */
}
