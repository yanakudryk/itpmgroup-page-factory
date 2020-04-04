package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath = ".//*[@class = 'pull-left info']")
    private WebElement user;
    @FindBy(id = "deal")
    private WebElement dealsMenu;
    @FindBy(id = "dictionary")
    private WebElement dictionary;
    @FindBy(id = "apparat")
    private WebElement devices;
    @FindBy(id = "workers")
    private WebElement employees;
    @FindBy(id = "spares")
    private WebElement parts;
    @FindBy(id = "prov_cus")
    private WebElement dealParties;

    public HomePage(WebDriver webDriver){
        super(webDriver);
    }

    public boolean isUserDisplayed(){
        return action.isDisplayedElement(user);
    }
    public DealsPage clickDealsButton(){
        action.clickButton(dealsMenu);
        return new DealsPage(webDriver);
    }
    public void clickDictionary(){
        action.clickButton(dictionary);
    }
    public void clickDevices(){
        action.clickButton(devices);
    }
    public void clickEmployees(){
        action.clickButton(employees);
    }
    public void clickParts(){
        action.clickButton(parts);
    }
    public void clickDealParties(){
        action.clickButton(dealParties);
    }
}
