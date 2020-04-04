package pages.basePage;

import libs.ActionWithWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver webDriver;
    public ActionWithWebElements action;
    public Logger logger;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        action = new ActionWithWebElements(webDriver);
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver, this);
    }
}
