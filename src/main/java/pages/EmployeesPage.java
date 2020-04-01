package pages;

import libs.ActionWithWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeesPage {
    private WebDriver webDriver;
    private ActionWithWebElements action;

    private By addButton = By.xpath("//*[@class='btn btn-info btn-sm']");
    private By workerSurnameField = By.xpath("//*[@id='workers_workerSurname']");
    private By workerNameField = By.xpath("//*[@id='workers_workerName']");
    private By workerMiddleNameField = By.xpath("//*[@id='workers_workerMiddleName']");
    private By workerPhoneField = By.xpath("//*[@id='workers_workerPhone']");
    private By createButton = By.xpath("//*[@class='btn btn-info']");

    private By tableEmployeeValue = By.xpath("//tbody/tr[last()]/td[1]");
    private By tablePhoneValue = By.xpath("//tbody/tr[last()]/td[2]");

    public EmployeesPage(WebDriver webDriver){
        this.webDriver = webDriver;
        action = new ActionWithWebElements(webDriver);
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
