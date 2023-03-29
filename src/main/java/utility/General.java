package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class General {

    public WebDriver driver;
    public String clickpath;
    public WebDriverWait wait;

    public General(WebDriver driver)
    {
        this.driver = driver;
    }

    public void refreshScreen()
    {
        driver.getCurrentUrl();
    }

    public void implicitWait(int sec)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    public void explicitWaitForTitle(int sec,String str)
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.titleContains(str));
    }

    public void explicitWaitForURL(int sec,String str)
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.urlContains(str));
    }

    public void explicitWaitForElement(int sec,WebElement element)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void explicitRefresh(int sec,WebElement element)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));;
    }

    public void explicitWaitForTextChange(int sec, String str, WebElement element)
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.textToBePresentInElement(element,str));
    }

    public void explicitWaitForStaleness(int sec, WebElement element)
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.stalenessOf(element));
    }

    public String returnTitle()
    {
        return (driver.getTitle());
    }

    public String returnURL()
    {
        return (driver.getCurrentUrl());
    }

    public String Snpshot() {

        try {
            clickpath = "./src/test/resources/Clicks/ClickedAt"+getTime()+".png";
            TakesScreenshot tss = ((TakesScreenshot)driver);
            File src = tss.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(clickpath));

        } catch (IOException e) {
            e.getCause();
            e.getMessage();
            System.out.println("Snpsht Class");
        }
        return clickpath;
    }

    public String getTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date curr = new Date();
        return(sdf.format(curr));
    }

    public boolean isElementPresent(WebElement element,int timeout)
    {
        boolean found = false;
        try
        {
		explicitWaitForElement(timeout,element);
		found=true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return found;
    }

}
