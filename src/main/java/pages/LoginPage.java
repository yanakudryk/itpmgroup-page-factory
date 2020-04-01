package pages;

import libs.ActionWithWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver webDriver;
    private ActionWithWebElements action;
    private By emailField = By.name("_username");
    private By passwordField = By.id("password");
    private By enterButton =  By.xpath("//*[@type='submit']");
    private String url = "http://v3.test.itpmgroup.com/";
    private Logger logger;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        action = new ActionWithWebElements(webDriver);
        logger = Logger.getLogger(getClass());
    }

    public void openPage(){
        try{
            webDriver.get(url);
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong.");
        }
    }
    public void setEmail(String email){
        action.inputText(emailField, email);
    }

    public void setPassword(String password){
        action.inputText(passwordField, password);
    }

    public HomePage login(String username, String password){
        setEmail(username);
        setPassword(password);
        action.clickButton(enterButton);
        return new HomePage(webDriver);
    }
}
