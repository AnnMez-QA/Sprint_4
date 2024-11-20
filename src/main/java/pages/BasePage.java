import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    // скролл до элемента
    // видимость
    // циклом проверить открывается ли каждый элемент?
    protected WebDriver driver;
    public BasePage (WebDriver driver) {
        this.driver = driver;
    }


}
