package testSteps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import testScreen.SearchPage;
import org.openqa.selenium.WebDriver;
import utility.Mouse;
import utility.General;

public class SearchSteps extends SearchPage{

    WebDriver driver;
    Mouse m;
    JavascriptExecutor js;
    String heading;
    int rooms;
    General g;

    public SearchSteps(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        m = new Mouse(driver);
        g = new General(driver);
        js = (JavascriptExecutor) driver;
    }

    public void searchCity(String city)
    {
        rentButton.click();
        searchBar.click();
        searchBar.sendKeys(city);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void getHeading(int sec,String txt)
    {

        g.Snpshot();
        g.explicitWaitForTextChange(sec,txt,Heading);
        heading = Heading.getText();
        System.out.println(heading);
        System.out.println(extractNumber());
    }

    public void selectRooms()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("window.scrollBy(0,100)");
        singleBedroom.click();
    }

    public void selectAvailableFor()
    {
        js.executeScript("window.scrollBy(0,100)");
        family.click();
    }

    public void selectFurnishedStatus()
    {
        js.executeScript("window.scrollBy(0,100)");
        furnished.click();
    }

    public void selectUpperRange()
    {
       m.moveElementBy(maxNode,-205,0);
    }

    public int extractNumber()
    {
        rooms = Integer.parseInt(heading.substring(0,heading.indexOf(" ")));
        return rooms;
    }

    public void goToFeedback()
    {
        try {
            Thread.sleep(16000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g.refreshScreen();
        g.explicitRefresh(70,feedback);
        feedback.click();

    }

    public void hitSend()
    {
        g.explicitWaitForElement(25,sendButton);
        sendButton.click();
    }

    public void clearMail()
    {
        email.clear();
    }

    public void clearQuery()
    {
        query.clear();
    }

    public void enterMail(String s)
    {
        email.sendKeys(s);
    }

    public void enterQuery(String s)
    {
        query.sendKeys(s);
    }

    public boolean isMailValidationPresent()
    {
        return (g.isElementPresent(emailErrorMessage,25));
    }

    public boolean isQueryValidationPresent()
    {
        return (g.isElementPresent(queryErrorMessage,25));
    }

    public String returnMailValidationMessage()
    {
        return (emailErrorMessage.getText());
    }

    public String returnQueryValidationMessage()
    {
        return (queryErrorMessage.getText());
    }

    public String returnQueryCountLeft()
    {
        return (charLimit.getText());
    }
}
