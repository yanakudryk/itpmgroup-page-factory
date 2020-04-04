package libs;

import org.apache.log4j.Logger;
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

    public void inputText(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info("Successful inputting.");
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during inputting.");
        }

    }
    public void clickButton(WebElement element){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Successful clicking. ");
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during clicking.");
        }

    }
    public boolean isDisplayedElement(WebElement element){
        boolean result = false;
        try{
            result = element.isDisplayed();
            logger.info("Successful displaying checking.");
            return result;
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during checking element displaying.");
            return result;
        }
    }
    public void selectElementFromDropDown(WebElement element, String value){
        try{
            Select dropDownValue = new Select(element);
            dropDownValue.selectByVisibleText(value);
            logger.info("Successful selecting from drop down.");
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during selecting from drop down.");
        }

    }

    public void setCheckBox(WebElement element, Boolean state){
        try{
            if(state){
                if(!element.isEnabled()){
                    element.click();
                }
            }
            if(!state){
                if(element.isEnabled()){
                    element.click();
                }
            }
            logger.info("Successful checking check-box.");
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during checking check-box.");
        }
    }

    public String getText(WebElement element){
        String result = null;
        try{
            result = element.getText();
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during getting text.");
        }
        return result;
    }

    public boolean isElementEnabled(WebElement element){
        boolean result = false;
        try{
            if (element.isEnabled()){
                result = true;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            logger.error("Something went wrong during checking if element is enabled");
        }
        return result;
    }
    public void selectRadioButton(List<WebElement> elements, String text){
        try {
            List<WebElement> radioButtons = elements;
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
