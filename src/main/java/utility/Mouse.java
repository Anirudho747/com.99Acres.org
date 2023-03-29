package utility;

import base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mouse {


    public  Actions action;
    public  JavascriptExecutor js;
    public WebDriver driver;

    public Mouse(WebDriver driver)
    {
        this.driver = driver;
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    public  void clickElement(WebElement element)
    {
        element.click();
    }

    public  void moveToElement(WebElement element)
    {
        action.moveToElement(element).perform();
    }

    public void doubleClick(WebElement element)
    {
        action.doubleClick(element).perform();
    }

    public void leftClick(WebElement element)
    {
        action.click(element).perform();
    }

    public void rightClick(WebElement element)
    {
        action.contextClick(element).perform();
    }

    public void doubleClick()
    {
        action.doubleClick().perform();
    }

    public void moveElement(WebElement from,WebElement to)
    {
        action.dragAndDrop(from, to).perform();
    }

    public void moveElementBy(WebElement from,int x,int y)
    {
        action.dragAndDropBy(from, x, y).perform();
    }

    public void moveByOffset(int x,int y)
    {
        action.moveByOffset(x, y).perform();
    }

    public void release()
    {
        action.release().perform();
    }

    public void release(WebElement element)
    {
        action.release(element).perform();
    }

    public void scroll(int x,int y)
    {
        System.out.println(x+" value of x "+y);
        js.executeScript("window.scrollBy(x,y)");
    }

    public void scrollTillElement(WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void scrollFullPage(WebElement element)
    {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
