package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationWindow extends BasePage{
    public ConfirmationWindow(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//div[@class='Order_Modal__YZ-d3']")
    private WebElement confirmationWindow;

    @FindBy(xpath = ".//div[@class='Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']")
    private WebElement successConfirmationText;

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']")
    private WebElement yesButton;

    public void waitForWindowToBeVisible() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(confirmationWindow));
    }

    public void waitForTextOfSuccessToBeVisible() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(successConfirmationText));
    }

    public void verifyOrderSuccess() {
        // Проверяем, что элемент доступен и видим
        Assert.assertTrue("Сообщение о завершении заказа не отображается!",
                successConfirmationText.isDisplayed());
    }

    public void clickOnYesButton(){
        yesButton.click();
    }

}
