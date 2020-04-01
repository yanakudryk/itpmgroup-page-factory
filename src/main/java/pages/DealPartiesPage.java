package pages;

import libs.ActionWithWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealPartiesPage {
    private WebDriver webDriver;
    private ActionWithWebElements action;

    private By addButton = By.xpath("//*[@class='btn btn-info btn-sm']");
    private By custNameField = By.id("prov_cus_proCustName");
    private By custAddressField = By.id("prov_cus_proCustAddress");
    private By custPhoneField = By.id("prov_cus_proCustPhone");
    private By privatePersonCheckBox = By.id("prov_cus_proCustIsFl");
    private By isOurFirmCheckBox = By.id("prov_cus_isOurFirm");
    private By createButton = By.xpath("//*[@class='btn btn-info']");

    private By tableNameValue = By.xpath("//tbody/tr[last()]/td[1]");
    private By tableAddressValue = By.xpath("//tbody/tr[last()]/td[2]");
    private By tablePhoneValue = By.xpath("//tbody/tr[last()]/td[3]");
    private By tablePrivatePersonValue = By.xpath("//tbody/tr[last()]/td[4]/span");

    public DealPartiesPage(WebDriver webDriver){
        this.webDriver = webDriver;
        action = new ActionWithWebElements(webDriver);
    }
}
