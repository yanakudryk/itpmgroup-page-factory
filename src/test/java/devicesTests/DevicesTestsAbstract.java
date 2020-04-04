package devicesTests;

import baseTests.AbstractBaseTests;
import org.junit.Test;
import pages.DevicesPage;
import pages.HomePage;

import static org.junit.Assert.assertEquals;

public class DevicesTestsAbstract extends AbstractBaseTests {

    @Test
    public void successDeviceCreation(){
        loginPage.openPage();
        loginPage.login("Student", "909090");
        homePage.clickDictionary();
        homePage.clickDevices();
        String number = "12345";
        String comment = "Some comment";
        devicesPage.createDevice(number, comment);
        assertEquals("Number is not equal.", number, devicesPage.getDeviceNumberFromTable());
        assertEquals("Comment is not equal.", comment, devicesPage.getDeviceCommentFromTable());
    }
}
