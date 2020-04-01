package pages;

import libs.ActionWithWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealsPage {
    private WebDriver webDriver;
    private ActionWithWebElements action;

    private By addButton = By.xpath("//*[@class='btn btn-info btn-sm']");
    private By dealDay = By.id("deal_dealDate_date_day");
    private By dealMonth = By.id("deal_dealDate_date_month");
    private By dealYear = By.id("deal_dealDate_date_year");
    private By dealHour = By.id("deal_dealDate_time_hour");
    private By dealMinute = By.id("deal_dealDate_time_minute");
    private By dealType = By.id("deal_dealType");
    private By dealCustomer = By.id("deal_customer");
    private By dealProvider = By.id("deal_provider");
    private By createButton = By.xpath("//*[@class='btn btn-info']");

    private By tableDateValue = By.xpath("//tbody/tr[last()]/td[1]");
    private By tableTypeValue = By.xpath("//tbody/tr[last()]/td[2]");
    private By tableBuyerValue = By.xpath("//tbody/tr[last()]/td[3]");
    private By tableSupplier = By.xpath("//tbody/tr[last()]/td[4]");

    public DealsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        action = new ActionWithWebElements(webDriver);
    }
    public void clickAddButton(){
        action.clickButton(addButton);
    }

    public void selectDealDate(String day, String month, String year, String hour, String minute){
        action.selectElementFromDropDown(dealDay, day);
        action.selectElementFromDropDown(dealMonth, month);
        action.selectElementFromDropDown(dealYear, year);
        action.selectElementFromDropDown(dealHour, hour);
        action.selectElementFromDropDown(dealMinute, minute);
    }

    public void setDealType(String type){
        action.selectElementFromDropDown(dealType, type);
    }
    public void setDealCustomer(String customer){
        action.selectElementFromDropDown(dealCustomer, customer);
    }
    public void setDealProvider(String provider){
        action.selectElementFromDropDown(dealProvider, provider);
    }
    public void clickCreateButton(){
        action.clickButton(createButton);
    }

    public void createDeal(String day, String month, String year, String hour, String minute,
                           String type, String customer, String provider){
        clickAddButton();
        selectDealDate(day,month, year, hour, minute);
        setDealType(type);
        setDealCustomer(customer);
        setDealProvider(provider);
        clickCreateButton();
    }
    public String getDealDateFromTable(){
        return action.getText(tableDateValue);
    }
    public String getDealTypeFromTable(){
        return action.getText(tableTypeValue);
    }
    public String getDealBuyerFromTable(){
        return action.getText(tableBuyerValue);
    }
    public String getDealSupplierFromTable(){
        return action.getText(tableSupplier);
    }
}
