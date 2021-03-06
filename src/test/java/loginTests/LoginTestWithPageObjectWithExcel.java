package loginTests;



import baseTests.BaseTests;
import libs.ConfigClass;
import libs.ExcelDriver;
import org.junit.Test;



import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginTestWithPageObjectWithExcel extends BaseTests {
    @Test
    public void validLogin() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(
                ConfigClass.getCfgValue("DATA_FILE"), "validLogOn");

        loginPage.openPage();
        loginPage.login(dataForValidLogin.get("login"), dataForValidLogin.get("pass"));
        assertTrue("User is not displayed", homePage.isUserDisplayed());
    }



}
