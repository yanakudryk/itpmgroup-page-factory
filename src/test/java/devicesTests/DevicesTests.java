package devicesTests;

import baseTests.BaseTests;
import org.junit.Test;
import pages.DevicesPage;
import pages.HomePage;

import static org.junit.Assert.assertEquals;

public class DevicesTests extends BaseTests {

    @Test
    public void successDeviceCreation(){
        HomePage homePage = loginPage.login("Student", "909090");
        homePage.clickDictionary();
        DevicesPage devicesPage = homePage.clickDevices();
        String number = "12345";
        String comment = "Some comment";
        devicesPage.createDevice(number, comment);
        assertEquals("Number is not equal.", number, devicesPage.getDeviceNumberFromTable());
        assertEquals("Comment is not equal.", comment, devicesPage.getDeviceCommentFromTable());
    }
}
