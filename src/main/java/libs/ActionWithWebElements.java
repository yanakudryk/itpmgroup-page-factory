package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ActionWithWebElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait wait;
    public ActionWithWebElements(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
        logger = Logger.getLogger(getClass());
    }

    public void inputText(By by, String text){
        try {
            webDriver.findElement(by).clear();
            webDriver.findElement(by).sendKeys(text);
            logger.info("Successful inputting.");
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during inputting.");
        }

    }
    public void clickButton(By by){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(by));
            webDriver.findElement(by).click();
            logger.info("Successful clicking. ");
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during clicking.");
        }

    }
    public boolean isDisplayedElement(By by){
        boolean result = false;
        try{
            result = webDriver.findElement(by).isDisplayed();
            logger.info("Successful displaying checking.");
            return result;
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during checking element displaying.");
            return result;
        }
    }
    public void selectElementFromDropDown(By by, String value){
        try{
            Select dropDownValue = new Select(webDriver.findElement(by));
            dropDownValue.selectByVisibleText(value);
            logger.info("Successful selecting from drop down.");
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during selecting from drop down.");
        }

    }

    public void setCheckBox(By by, Boolean state){
        try{
            if(state){
                if(!webDriver.findElement(by).isEnabled()){
                    webDriver.findElement(by).click();
                }
            }
            if(!state){
                if(webDriver.findElement(by).isEnabled()){
                    webDriver.findElement(by).click();
                }
            }
            logger.info("Successful checking check-box.");
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during checking check-box.");
        }
    }

    public String getText(By by){
        String result = null;
        try{
            result = webDriver.findElement(by).getText();
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during getting text.");
        }
        return result;
    }

    public boolean isElementEnabled(By by){
        boolean result = false;
        try{
            if (webDriver.findElement(by).isEnabled()){
                result = true;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during checking if element is enabled");
        }
        return result;
    }
    public void selectRadioButton(By by, String text){
        try {
            List<WebElement> radioButtons = webDriver.findElements(by);
            int numberOfRadioButtons = radioButtons.size();
            for (int i = 0; i < numberOfRadioButtons; i++) {
                if (radioButtons.get(i).getText() == text) {
                    if (!radioButtons.get(i).isSelected()) {
                        radioButtons.get(i).click();
                    }
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during selection Radio Button");
        }

    }
}
