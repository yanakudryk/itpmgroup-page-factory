package loginTests;

import baseTests.BaseTests;
import org.junit.Test;
import pages.HomePage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTests {

    @Test
    public void validLogin(){
        HomePage homePage = loginPage.login("Student", "909090");
        assertTrue("User is not displayed", homePage.isUserDisplayed());
    }

    @Test
    public void invalidLogin(){
        HomePage homePage = loginPage.login("Student", "123456");
        assertFalse("User is not displayed", homePage.isUserDisplayed());
    }

}
