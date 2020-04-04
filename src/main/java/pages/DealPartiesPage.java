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
    public void clickAddButton(){
        action.clickButton(addButton);
    }
    public void setCustomerName(String name){
        action.inputText(custNameField, name);
    }
    public void setCustomerAddress(String address){
        action.inputText(custAddressField, address);
    }
    public void setCustomerPhone(String phone) {
        action.inputText(custPhoneField, phone);
    }
    public void setPrivatePersonCheckBox(boolean state){
        action.setCheckBox(privatePersonCheckBox, state);
    }
    public void setIsOurFirmCheckBox(boolean state){
        action.setCheckBox(isOurFirmCheckBox, state);
    }
    public void clickCreateButton(){
        action.clickButton(createButton);
    }
    public void createDealPart(String name, String address, String phone, boolean stateOfIsPrivate, boolean stateOfIsOurFirm){
        clickAddButton();
        setCustomerName(name);
        setCustomerAddress(address);
        setCustomerPhone(phone);
        setPrivatePersonCheckBox(stateOfIsPrivate);
        setIsOurFirmCheckBox(stateOfIsOurFirm);
        clickCreateButton();
    }
    public String getDealPartName(){
        return action.getText(tableNameValue);
    }
    public String getDealPartAddress(){
        return action.getText(tableAddressValue);
    }
    public String getDealPartPhone(){
        return action.getText(tablePhoneValue);
    }
    public boolean isPrivate(){
        if (action.getText(tablePrivatePersonValue).equals("1")) {
            return true;
        }
        else return false;
    }
    public boolean isPrivateDisplayed(){
        if(action.isDisplayedElement(tablePrivatePersonValue)){
            return true;
        }
        else return false;
    }
}
