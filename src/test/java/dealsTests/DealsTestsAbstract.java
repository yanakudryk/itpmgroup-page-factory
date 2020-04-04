package dealsTests;

import baseTests.AbstractBaseTests;
import org.junit.Test;
import pages.DealsPage;
import pages.HomePage;

import static org.junit.Assert.assertEquals;

public class DealsTestsAbstract extends AbstractBaseTests {

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
}
