package loginTests;

import baseTests.BaseTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogoutTests extends BaseTests {
    @Test
    public void logout(){
        loginPage.openPage();
        loginPage.login("Student", "909090");
        homePage.clickProfile();
        homePage.clickLogout();
        assertEquals("User is not on login page", "Учет запчастей", loginPage.getLoginText());
    }
}
