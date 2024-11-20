import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutCustomerPage extends BasePage {

    public AboutCustomerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//div[@class='Header_Header__214zg']")
    private WebElement pageTitle;

    @FindBy(xpath = ".//input[@placeholder='* Имя']")
    private WebElement nameInput;

    @FindBy(xpath = ".//input[@placeholder='* Фамилия']")
    private WebElement surnameInput;

    @FindBy(xpath = ".//input[@placeholder='* Адрес: куда привезти заказ']")
    private WebElement addressInput;

    @FindBy(xpath = ".//input[@placeholder='* Станция метро']")
    private WebElement metroStationInput;

    @FindBy(xpath = ".//div[@class='select-search__select']/ul/li/button[@value='1']")
    private WebElement nameOfMetroStation;

    @FindBy(xpath = ".//input[@placeholder='* Телефон: на него позвонит курьер']")
    private WebElement phoneInput;

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement nextButton;

    public void waitForPageTitleToBeVisible() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(pageTitle));
    }

    public void fillCustomerData (String name, String surname, String address, String number) {
        nameInput.sendKeys(name);
        surnameInput.sendKeys(surname);
        addressInput.sendKeys(address);
        phoneInput.sendKeys(number);
    }

    public void fillMetroData (){
        metroStationInput.click();
        nameOfMetroStation.click();
    }

    public void clickOnNextButton() {
        nextButton.click();
    }


    }












