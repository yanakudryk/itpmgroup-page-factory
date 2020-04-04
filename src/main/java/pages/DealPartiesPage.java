package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

public class DealPartiesPage extends BasePage {
    @FindBy (xpath = "//*[@class='btn btn-info btn-sm']")
    private WebElement addButton;

    @FindBy(id = "prov_cus_proCustName")
    private WebElement custNameField;

    @FindBy(id ="prov_cus_proCustAddress")
    private WebElement custAddressField;

    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement custPhoneField;

    @FindBy(id ="prov_cus_proCustIsFl")
    private WebElement privatePersonCheckBox;

    @FindBy(id ="prov_cus_isOurFirm")
    private WebElement isOurFirmCheckBox;

    @FindBy (xpath = "//*[@class='btn btn-info']")
    private WebElement createButton;

    @FindBy (xpath = "//tbody/tr[last()]/td[1]")
    private WebElement tableNameValue;

    @FindBy (xpath = "//tbody/tr[last()]/td[2]")
    private WebElement tableAddressValue;

    @FindBy (xpath = "//tbody/tr[last()]/td[3]")
    private WebElement tablePhoneValue;

    @FindBy (xpath = "//tbody/tr[last()]/td[4]/span")
    private WebElement tablePrivatePersonValue;

    public DealPartiesPage(WebDriver webDriver){
        super(webDriver);
    }
}
