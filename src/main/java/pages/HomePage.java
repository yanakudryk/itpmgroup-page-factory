package pages;

import libs.ActionWithWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver webDriver;
    private ActionWithWebElements action;
    private By user = By.xpath(".//*[@class = 'pull-left info']");

    private By dealsMenu = By.id("deal");
    private By dictionary = By.id("dictionary");
    private By devices = By.id("apparat");
    private By employees = By.id("workers");
    private By parts = By.id("spares");
    private By dealParties = By.id("prov_cus");

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        action = new ActionWithWebElements(webDriver);
    }
    public DealsPage clickDealsButton(){
        action.clickButton(dealsMenu);
        return new DealsPage(webDriver);
    }
    public boolean isUserDisplayed(){
        return action.isDisplayedElement(user);
    }
    public void clickDictionary(){
        action.clickButton(dictionary);
    }
    public DevicesPage clickDevices(){
        action.clickButton(devices);
        return new DevicesPage(webDriver);
    }
    public EmployeesPage clickEmployees(){
        action.clickButton(employees);
        return new EmployeesPage(webDriver);
    }
    public void clickParts(){
        action.clickButton(parts);
    }
    public void clickDealParties(){
        action.clickButton(dealParties);
    }
}
