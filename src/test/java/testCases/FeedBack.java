package testCases;

import base.BaseClass;
import base.LogUtility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testSteps.SearchSteps;
import base.TestData;

public class FeedBack extends BaseClass {

    public SearchSteps sSteps;
    private LogUtility logUtility;
    public TestData td;
    public SoftAssert sa;

    public FeedBack()
    {
        super();
        driver = new FirefoxDriver();
        sSteps = new SearchSteps(driver);
        td = new TestData();
        sa = new SoftAssert();
        logUtility = new LogUtility(Selection.class);
        driver.get("https://99acres.com");
    }

    @Test(enabled=true,priority=1,groups={"odd","even"})
    @Parameters("cityName")
    public void moveToFeedBack(@Optional String cityName)
    {
        logUtility.logTestTitle("selectLocation");
        logUtility.logTestInfo("Info");
        sSteps.searchCity(td.cityName);
        sSteps.goToFeedback();

    }

    @Test(enabled=true,priority=2,dependsOnMethods = {"moveToFeedBack"},groups={"even"})
    public void validationMsgsForEmptyFields()
    {
        logUtility.logTestTitle("selectLocation");
        logUtility.logTestInfo("Info");
        sSteps.clearQuery();
        sSteps.hitSend();
          sa.assertTrue(sSteps.isMailValidationPresent());
          sa.assertTrue(sSteps.isQueryValidationPresent());
          sa.assertEquals(sSteps.returnQueryCountLeft(),td.queryCountMessages[0]);
          sa.assertAll();
    }

    @Test(enabled=true,priority=3,dependsOnMethods = {"moveToFeedBack"},groups={"odd"})
    public void validationMsgForShortQuery()
    {
        logUtility.logTestTitle("selectLocation");
        logUtility.logTestInfo("Info");
        sSteps.enterQuery(td.querySamples[0]);
        sSteps.hitSend();
        sa.assertTrue(sSteps.isMailValidationPresent());
        sa.assertTrue(sSteps.isQueryValidationPresent());
        sa.assertEquals(sSteps.returnQueryValidationMessage(),td.queryValidationMessages);
        sa.assertEquals(sSteps.returnQueryCountLeft(),td.queryCountMessages[1]);
        sa.assertAll();
    }

    @Test(enabled=true,priority=4,dependsOnMethods = {"moveToFeedBack"},groups={"even"})
    public void validationMsgForShortEmail()
    {
        logUtility.logTestTitle("selectLocation");
        logUtility.logTestInfo("Info");
        sSteps.enterMail(td.mailSamples[0]);
        sSteps.hitSend();
        sa.assertTrue(sSteps.isMailValidationPresent());
        sa.assertTrue(sSteps.isQueryValidationPresent());
        sa.assertEquals(sSteps.returnMailValidationMessage(),td.mailValidationMessages[0]);
        sa.assertEquals(sSteps.returnQueryValidationMessage(),td.queryValidationMessages);
        sa.assertEquals(sSteps.returnQueryCountLeft(),td.queryCountMessages[1]);
        sa.assertAll();
    }

    @Test(enabled=true,priority=5,dependsOnMethods = {"moveToFeedBack"},groups={"odd"})
    public void validationMsgForWrongEmail()
    {
        logUtility.logTestTitle("selectLocation");
        logUtility.logTestInfo("Info");
        sSteps.clearMail();
        sSteps.enterMail(td.mailSamples[1]);
        sSteps.hitSend();
        sa.assertTrue(sSteps.isMailValidationPresent());
        sa.assertTrue(sSteps.isQueryValidationPresent());
        sa.assertEquals(sSteps.returnMailValidationMessage(),td.mailValidationMessages[1]);
        sa.assertEquals(sSteps.returnQueryValidationMessage(),td.queryValidationMessages);
        sa.assertEquals(sSteps.returnQueryCountLeft(),td.queryCountMessages[1]);
        sa.assertAll();
    }

    @Test(enabled=false,priority=6,dependsOnMethods = {"moveToFeedBack"},groups={"even"})
    @Parameters({"Mail","Query"})
    public void noValidationMsgs(@Optional String Mail,String Query)
    {
        logUtility.logTestTitle("selectLocation");
        logUtility.logTestInfo("Info");
        sSteps.clearMail();
        sSteps.enterMail(Mail);
        sSteps.clearQuery();
        sSteps.enterQuery(Query);
        sSteps.hitSend();
        sa.assertFalse(sSteps.isMailValidationPresent());
        sa.assertFalse(sSteps.isQueryValidationPresent());
        sa.assertAll();
    }

    @Test(enabled=true,priority=7,dependsOnMethods = {"moveToFeedBack"},groups={"even","odd"})
    @Parameters({"Mail","Query"})
    public void madeToFail(@Optional String Mail,String Query)
    {
        logUtility.logTestTitle("selectLocation");
        logUtility.logTestInfo("Info");
        sSteps.clearMail();
        sSteps.enterMail(Mail);
        sSteps.clearQuery();
        sSteps.enterQuery(Query);
        sSteps.hitSend();
        sa.assertTrue(sSteps.isMailValidationPresent());
        sa.assertTrue(sSteps.isQueryValidationPresent());
        sa.assertAll();
    }


}
