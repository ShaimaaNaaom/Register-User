import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
public class SignOut {

    WebDriver driver;
    By ContinueButton = By.cssSelector("a[data-qa='continue-button']");
    By CloseButton = By.cssSelector("#dismiss-button > div > svg");
    By LogOutButton = By.xpath ("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    public SignOut(WebDriver driver)
    {
        this.driver = driver;
    }
    private void ClickContinueButton ()
    {

        driver.findElement(ContinueButton).click();
    }
    private void ClickCloseAds ()
    {

        driver.findElement(CloseButton).click();
    }
    private void ClickLogoutButton ()
    {

        driver.findElement(LogOutButton).click();
    }
    public  void  SignOutAfterRegistration() throws InterruptedException {
        ClickContinueButton();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('closeButtonId').click();");
        ClickCloseAds ();
//        Thread.sleep(Long.parseLong("2000"));
        ClickLogoutButton ();
    }

}
