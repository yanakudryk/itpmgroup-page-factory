package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

public class EmployeesPage extends BasePage {
    @FindBy(xpath = "//*[@class='btn btn-info btn-sm']")
    private WebElement addButton;

    @FindBy(xpath = "//*[@id='workers_workerSurname']")
    private WebElement workerSurnameField;

    @FindBy(xpath = "//*[@id='workers_workerName']")
    private WebElement workerNameField;

    @FindBy(xpath = "//*[@id='workers_workerMiddleName']")
    private WebElement workerMiddleNameField;

    @FindBy(xpath = "//*[@id='workers_workerPhone']")
    private WebElement workerPhoneField;

    @FindBy(xpath = "//*[@class='btn btn-info']")
    private WebElement createButton;

    @FindBy(xpath = "//tbody/tr[last()]/td[1]")
    private WebElement tableEmployeeValue;

    @FindBy(xpath = "//tbody/tr[last()]/td[2]")
    private WebElement tablePhoneValue;

    public EmployeesPage(WebDriver webDriver){
        super(webDriver);

    }
    public void clickAddButton(){
        action.clickButton(addButton);
    }
    public void setSurname(String surname){
        action.inputText(workerSurnameField, surname);
    }
    public void setName(String name){
        action.inputText(workerNameField, name);
    }
    public void setMiddleName(String middleName){
        action.inputText(workerMiddleNameField, middleName);
    }
    public void setPhoneNumber(String phone){
        action.inputText(workerPhoneField, phone);
    }
    public void clickCreateButton(){
        action.clickButton(createButton);
    }
    public void createEmployee(String surname, String name, String middleName, String phone){
        clickAddButton();
        setSurname(surname);
        setName(name);
        setMiddleName(middleName);
        setPhoneNumber(phone);
        clickCreateButton();
    }

    public String getFullNameEmployeeFromTable(){
        return action.getText(tableEmployeeValue);
    }
    public String getPhoneEmployeeFromTable(){
        return action.getText(tablePhoneValue);
    }
}
