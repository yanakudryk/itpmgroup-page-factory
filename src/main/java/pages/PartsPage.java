package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

public class PartsPage extends BasePage {

    @FindBy(xpath = "//*[@class='btn btn-info btn-sm']")
    private WebElement addButton;
    @FindBy(xpath = "//*[@id='spares_spareName']")
    private WebElement spareNameField;
    @FindBy(xpath = "//*[@id='spares_spareType']")
    private WebElement spareTypeField;
    @FindBy(xpath = "//*[@class='btn btn-info']")
    private WebElement createButton;
    @FindBy(xpath = "//tbody/tr[last()]/td[1]")
    private WebElement tablePartNameValue;
    @FindBy(xpath = "//tbody/tr[last()]/td[2]")
    private WebElement tablePartTypeValue;

    public PartsPage(WebDriver webDriver){
        super(webDriver);
    }
    public void clickAddButton(){
        action.clickButton(addButton);
    }
    public void setPartName(String name){
        action.inputText(spareNameField, name);
    }
    public void setPartType(String type){
        action.selectElementFromDropDown(spareTypeField, type);
    }
    public void clickCreateButton(){
        action.clickButton(createButton);
    }

    public void createPart(String name, String type){
        clickAddButton();
        setPartName(name);
        setPartType(type);
        clickCreateButton();
    }
    public String getPartName(){
        return action.getText(tablePartNameValue);
    }
    public String getPartType(){
        return action.getText(tablePartTypeValue);
    }
}
