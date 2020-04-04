package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

public class DealTypePage extends BasePage {
    @FindBy(xpath = "//*[@class='btn btn-info btn-sm']")
    private WebElement addButton;
    @FindBy(xpath = "//*[@id='deal_type_dealTypeName']")
    private WebElement dealTypeName;
    @FindBy(xpath = "//*[@class='btn btn-info']")
    private WebElement createButton;

    public DealTypePage(WebDriver webdriver){
        super(webdriver);
    }
    public void clickAddButton(){
        action.clickButton(addButton);
    }
    public void setDealTypeName(String type){
        action.inputText(dealTypeName, type);
    }
    public void clickCreateButton(){
        action.clickButton(createButton);
    }
    public void createDealType(String type){
        clickAddButton();
        setDealTypeName(type);
        clickCreateButton();
    }

}
