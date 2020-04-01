package baseTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class BaseTests {

    private WebDriver webDriver = driverInit();
    protected LoginPage loginPage;

    @Before
    public void SetUp(){
        loginPage = new LoginPage(webDriver);
        loginPage.openPage();
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
