package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

public class DealsPage extends BasePage {


    @FindBy(xpath = "//*[@class='btn btn-info btn-sm']")
    private WebElement addButton;
    @FindBy(id = "deal_dealDate_date_day")
     private WebElement dealDay;
    @FindBy(id = "deal_dealDate_date_month")
    private WebElement dealMonth;
    @FindBy(id = "deal_dealDate_date_year")
    private WebElement dealYear;
    @FindBy(id = "deal_dealDate_time_hour")
    private WebElement dealHour;
    @FindBy(id = "deal_dealDate_time_minute")
    private WebElement dealMinute;
    @FindBy(id = "deal_dealType")
    private WebElement dealType;
    @FindBy(id = "deal_customer")
    private WebElement dealCustomer;
    @FindBy(id = "deal_provider")
    private WebElement dealProvider;
    @FindBy(xpath = "//*[@class='btn btn-info']")
    private WebElement createButton;
    @FindBy(xpath = "//tbody/tr[last()]/td[1]")
    private WebElement tableDateValue;
    @FindBy(xpath = "//tbody/tr[last()]/td[2]")
    private WebElement tableTypeValue;
    @FindBy(xpath = "//tbody/tr[last()]/td[3]")
    private WebElement tableBuyerValue;
    @FindBy(xpath = "//tbody/tr[last()]/td[4]")
    private WebElement tableSupplier;

    public DealsPage(WebDriver webDriver){
        super(webDriver);
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
