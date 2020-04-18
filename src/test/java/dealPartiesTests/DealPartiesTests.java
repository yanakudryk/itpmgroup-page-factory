package dealPartiesTests;

import baseTests.BaseTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DealPartiesTests extends BaseTests {
    @Test
    public void dealPartPrivatePersonCreation(){
        loginPage.openPage();
        loginPage.login("Student", "909090");
        homePage.clickDictionary();
        homePage.clickDealParties();
        String customerName = "Name1";
        String customerAddress = "Address1";
        String customerPhone = "0945272354273";
        boolean privatePersonState = true;
        boolean isOurFirmSate = false;
        dealPartiesPage.createDealPart(customerName, customerAddress, customerPhone, privatePersonState, isOurFirmSate);
        assertEquals("Name is not equal", customerName, dealPartiesPage.getDealPartName());
        assertEquals("Address is not equal", customerAddress, dealPartiesPage.getDealPartAddress());
        assertEquals("Phone is not equal", customerPhone, dealPartiesPage.getDealPartPhone());
        assertEquals("Private peron label is not displayed", privatePersonState, dealPartiesPage.isPrivateDisplayed());
        assertEquals("Is not private person, incorrect value in label", privatePersonState, dealPartiesPage.isPrivate());
    }
    @Test
    public void dealNotPrivatePersonCreation(){
        loginPage.openPage();
        loginPage.login("Student", "909090");
        homePage.clickDictionary();
        homePage.clickDealParties();
        String customerName = "Name2";
        String customerAddress = "Address2";
        String customerPhone = "547573585345";
        boolean privatePersonState = false;
        boolean isOurFirmSate = false;
        dealPartiesPage.createDealPart(customerName, customerAddress, customerPhone, privatePersonState, isOurFirmSate);
        assertEquals("Name is not equal", customerName, dealPartiesPage.getDealPartName());
        assertEquals("Address is not equal", customerAddress, dealPartiesPage.getDealPartAddress());
        assertEquals("Phone is not equal", customerPhone, dealPartiesPage.getDealPartPhone());
        assertEquals("Private peron label is displayed", privatePersonState, dealPartiesPage.isPrivateDisplayed());
    }
}
