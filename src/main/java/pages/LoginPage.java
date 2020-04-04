package pages;

import libs.ConfigClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basePage.BasePage;

public class LoginPage extends BasePage {

    @FindBy(name = "_username")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@class = 'login-logo']/a")
    private WebElement loginText;

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public void openPage(){
        try{
            webDriver.get(ConfigClass.getCfgValue("base_url") + "/login");
            logger.info("Page login was opened.");
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Can not open URL.");
        }
    }
    public void setEmail(String email){
        action.inputText(emailField, email);
    }

    public void setPassword(String password){
        action.inputText(passwordField, password);
    }

    public void login(String username, String password){
        setEmail(username);
        setPassword(password);
        action.clickButton(enterButton);
    }
    public String getLoginText(){
        return action.getText(loginText);
    }
}
