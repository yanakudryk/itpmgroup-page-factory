package pages;

import libs.ActionWithWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartsPage {
    private WebDriver webDriver;
    private ActionWithWebElements action;

    private By addButton = By.xpath("//*[@class='btn btn-info btn-sm']");
    private By spareNameField = By.xpath("//*[@id='spares_spareName']");
    private By spareTypeField = By.xpath("//*[@id='spares_spareType']");
    private By createButton = By.xpath("//*[@class='btn btn-info']");

    private By tablePartNameValue = By.xpath("//tbody/tr[last()]/td[1]");
    private By tablePartTypeValue = By.xpath("//tbody/tr[last()]/td[2]");

    public PartsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        action = new ActionWithWebElements(webDriver);
    }
}
