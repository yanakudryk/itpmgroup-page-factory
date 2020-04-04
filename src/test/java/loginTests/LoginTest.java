package loginTests;

import baseTests.AbstractBaseTests;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest extends AbstractBaseTests {
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.login("Student", "909090");
        assertTrue("User is not displayed", homePage.isUserDisplayed());
    }

    @Test
    public void invalidLogin(){
        loginPage.openPage();
        loginPage.login("Student", "123456");
        assertEquals("User is not on login page", "Учет запчастей", loginPage.getLoginText());
    }

}
