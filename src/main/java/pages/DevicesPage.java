package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

public class DevicesPage extends BasePage {
    @FindBy(xpath = "//*[@class='btn btn-info btn-sm']")
    private WebElement addButton;
    @FindBy(id = "apparat_apparatNumber")
    private WebElement apparatNumberField;
    @FindBy(id = "apparat_apparatComment")
    private WebElement apparatCommentField;
    @FindBy(xpath = "//*[@class='btn btn-info']")
    private WebElement createButton;
    @FindBy(xpath = "//tbody/tr[last()]/td[1]")
    private WebElement tableNumberValue;
    @FindBy(xpath = "//tbody/tr[last()]/td[2]")
    private WebElement tableCommentValue;

    public DevicesPage(WebDriver webDriver){
        super(webDriver);
    }
    public void clickAddButton(){
        action.clickButton(addButton);
    }

    public void setDeviceNumber(String number){
        action.inputText(apparatNumberField, number);
    }
    public void setDeviceComment(String comment){
        action.inputText(apparatCommentField, comment);
    }
    public void clickCreateButton(){
        action.clickButton(createButton);
    }
    public void createDevice(String number, String comment){
        clickAddButton();
        setDeviceNumber(number);
        setDeviceComment(comment);
        clickCreateButton();
    }

    public String getDeviceNumberFromTable(){
        return action.getText(tableNumberValue);
    }
    public String getDeviceCommentFromTable(){
        return action.getText(tableCommentValue);
    }
}
