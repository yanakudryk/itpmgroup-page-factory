package dealsTests;

import baseTests.BaseTests;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealsTests extends BaseTests {

    @Test
    public void successfulDealCreation(){
        loginPage.openPage();
        loginPage.login("Student", "909090");
        homePage.clickDealsButton();
        String day = "05";
        String month = "марта";
        String monthNum = "03";
        String year = "2020";
        String hour = "06";
        String minute = "08";
        String type = "Бартер";
        String customer = "ЧП \"Ремонт автоматов\"";
        String provider = "ОАО \"МММ\"";

        dealsPage.createDeal(day, month, year, hour, minute, type, customer, provider);
        assertEquals("Deal date is not equal.", day + "." + monthNum + "." + year + " " + hour + ":" + minute, dealsPage.getDealDateFromTable());
        assertEquals("Deal type is not equal.", type, dealsPage.getDealTypeFromTable());
        assertEquals("Deal customer is not equal.", customer, dealsPage.getDealBuyerFromTable());
        assertEquals("Deal provider is not equal.", provider, dealsPage.getDealSupplierFromTable());
    }
    @Test
    public void deletingDeal(){
        String day = "05";
        String month = "марта";
        String monthNum = "03";
        String year = "2020";
        String hour = "06";
        String minute = "08";
        String randomDealType = RandomStringUtils.random(8, true, false);
        String customer = "ЧП \"Ремонт автоматов\"";
        String provider = "ОАО \"МММ\"";

        loginPage.openPage();
        loginPage.login("Student", "909090");

        homePage.clickDictionary();
        homePage.clickDealTypes();

        dealTypePage.createDealType(randomDealType);

        homePage.clickDealsButton();

        dealsPage.createDeal(day, month, year, hour, minute, randomDealType, customer, provider);
        assertTrue("Deal was not created.", dealsPage.isDealExistsByType(randomDealType));

        dealsPage.openDealByType(randomDealType);
        dealsPage.deleteDeal();
        assertFalse("Deal was not deleted.", dealsPage.isDealExistsByType(randomDealType));

    }
}
