package testCases;

import base.BaseClass;
import base.ConfigReader;
import base.LogUtility;
import base.TestData;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import testSteps.SearchSteps;

public class Selection2 extends BaseClass {

    public SearchSteps sSteps;
    private LogUtility logUtility;
    public TestData td;
    public ConfigReader cr;

    public Selection2()
    {
        super();
        driver = getBrowser();
        cr = new ConfigReader();
        sSteps = new SearchSteps(driver);
        logUtility = new LogUtility(Selection2.class);
        td = new TestData();
        driver.get(cr.getURL());
    }

    @Test(enabled=true,priority=1,groups = {"odd","even"})
    public void selectLocation()
    {
        logUtility.logTestTitle("selectLocation");
        logUtility.logTestInfo("Info");
        sSteps.searchCity(td.cityName);
        sSteps.getHeading(25,td.Headings[0]);
    }

    @Test(enabled=true,priority=2,dependsOnMethods = {"selectLocation"},groups={"even"})
    public void selectBedrooms()  {
        logUtility.logTestTitle("selectBedroom");
        logUtility.logTestInfo("Info");
        sSteps.selectRooms();
        sSteps.getHeading(25,td.Headings[1]);

    }

    @Test(enabled=true,priority=3,dependsOnMethods = {"selectLocation"},groups={"odd"})
    public void selectRoomAvailableFor()
    {
        logUtility.logTestTitle("selectRoomAvailableFor");
        logUtility.logTestInfo("Info");
        sSteps.selectAvailableFor();
        sSteps.getHeading(25,td.Headings[2]);
    }

    @Test(enabled=true,priority=4,dependsOnMethods = {"selectLocation"},groups={"even"})
    public void selectFurnishedStatus()
    {
        logUtility.logTestTitle("selectFurnishedStatus");
        logUtility.logTestInfo("Info");
        sSteps.selectFurnishedStatus();
        sSteps.getHeading(25,td.Headings[3]);
    }

    @Test(enabled=true,priority=5,dependsOnMethods = {"selectLocation"},groups={"odd"})
    public void selectPricing()
    {
        logUtility.logTestTitle("selectPricing");
        logUtility.logTestInfo("Info");
        sSteps.selectUpperRange();
        sSteps.getHeading(25,td.Headings[4]);
    }
}
