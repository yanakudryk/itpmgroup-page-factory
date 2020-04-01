package pages;

import libs.ActionWithWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DevicesPage {

    private WebDriver webDriver;
    private ActionWithWebElements action;

    private By addButton = By.xpath("//*[@class='btn btn-info btn-sm']");
    private By apparatNumberField = By.id("apparat_apparatNumber");
    private By apparatCommentField = By.id("apparat_apparatComment");
    private By createButton = By.xpath("//*[@class='btn btn-info']");

    private By tableNumberValue = By.xpath("//tbody/tr[last()]/td[1]");
    private By tableCommentValue = By.xpath("//tbody/tr[last()]/td[2]");

    public DevicesPage(WebDriver webDriver){
        this.webDriver = webDriver;
        action = new ActionWithWebElements(webDriver);
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
