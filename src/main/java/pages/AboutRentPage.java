package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRentPage extends BasePage{
    public AboutRentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = ".//div[@class='Header_Header__214zg']")
    private WebElement pageTitle;

    @FindBy(xpath = ".//input[@placeholder='* Когда привезти самокат']")
    private WebElement dateInput;

    @FindBy(xpath = ".//div[@class='react-datepicker']/div/div/div/div[@aria-label='Choose пятница, 22-е ноября 2024 г.']")
    private WebElement dateValue;

    @FindBy(xpath = ".//div[@class='Dropdown-placeholder']")
    private WebElement rentalPeriodInput;

    @FindBy(xpath = ".//div[@class='Dropdown-menu']/div[text()='сутки']")
    private WebElement rentalPeriodValue;

    @FindBy(xpath = ".//div[@class='Order_Checkboxes__3lWSI']/label/input[@id='black']")
    private WebElement colourOfScooter;

    @FindBy(xpath = ".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='Комментарий для курьера']")
    private WebElement commentInput;

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement orderButton;

    public void waitForPageTitleToBeVisible() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(pageTitle));
    }

    public void fillRentData (String comment) {
        dateInput.click();
        dateValue.click();
        rentalPeriodInput.click();
        rentalPeriodValue.click();
        colourOfScooter.click();
        commentInput.sendKeys(comment);
    }

    public void clickOnOrderButton () {
        orderButton.click();
    }

}



