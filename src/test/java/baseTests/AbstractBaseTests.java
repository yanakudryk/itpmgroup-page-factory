package baseTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class AbstractBaseTests {

    private WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected DevicesPage devicesPage;
    protected DealsPage dealsPage;
    protected DealPartiesPage dealPartiesPage;
    protected EmployeesPage employeesPage;
    protected PartsPage partsPage;
    protected DealTypePage dealTypePage;

    @Before
    public void SetUp(){
        webDriver = driverInit();
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        devicesPage = new DevicesPage(webDriver);
        dealsPage = new DealsPage(webDriver);
        dealPartiesPage = new DealPartiesPage(webDriver);
        employeesPage = new EmployeesPage(webDriver);
        partsPage = new PartsPage(webDriver);
        dealTypePage = new DealTypePage(webDriver);
    }

    private WebDriver driverInit() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
