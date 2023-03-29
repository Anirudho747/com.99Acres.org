package testScreen;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchPage {

    @FindBy(id="keyword2")
    @CacheLookup
    protected WebElement searchBar;

    @FindBy(xpath="//*[@data-label='RENT']")
    @CacheLookup
    protected WebElement rentButton;

    @FindBy(xpath="//div[@class='title_semiBold r_srp__spacer20 undefined']")
    @CacheLookup
    protected WebElement Heading;

    @FindBy(xpath="//div[@class='title_semiBold r_srp__spacer20 undefined']")
    @CacheLookup
    protected List<WebElement> list;

    @FindBy(xpath="(//*[@class='section_header_semiBold'])[3]/following::span[2]")
    @CacheLookup
    protected WebElement singleBedroom;

    @FindBy(xpath="(//*[@class='section_header_semiBold'])[6]/following::span[2]")
    @CacheLookup
    protected WebElement family;

    @FindBy(xpath="(//*[@class='section_header_semiBold'])[8]/following::span[6]")
    @CacheLookup
    protected WebElement furnished;

    @FindBy(id="budgetLeftFilter_max_node")
    @CacheLookup
    protected WebElement maxNode;

    @FindBy(css="body.pageComponent:nth-child(2) div.side_widget__side_widget_wrapper div.side_widget__sideWidgetcont.side_widget__radiusBottom:nth-child(2) div:nth-child(1) div.sendFeedBack__sndFeedBcKCont > span.badges_regular_secondary.sendFeedBack__sideWidgetSpan")
    @CacheLookup
    protected WebElement feedback;

    @FindBy(xpath="//*[@name='Query']")
    @CacheLookup
    protected WebElement query;

    @FindBy(xpath="//*[@name='Email']")
    @CacheLookup
    protected WebElement email;

    @FindBy(xpath="//input[@value='Send']")
    @CacheLookup
    protected WebElement sendButton;

    @FindBy(xpath="(//*[@name='Email']/following::div[@id='eoiErrMsg'])[1]")
    @CacheLookup
    protected WebElement emailErrorMessage;

    @FindBy(xpath="(//*[@name='Query']/following::div[@id='eoiErrMsg'])[1]")
    @CacheLookup
    protected WebElement queryErrorMessage;

    @FindBy(xpath="//*[@class='component__charLimit']")
    @CacheLookup
    protected WebElement charLimit;
}
