import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
public class SignOut {

    WebDriver driver;
      By ContinueButton = By.cssSelector("a[data-qa='continue-button']");
      By LogOutButton = By.xpath ("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    public SignOut(WebDriver driver)
    {
        this.driver = driver;
    }
    private void ClickContinueButton ()
    {

        driver.findElement(ContinueButton).click();
    }

    private void ClickLogoutButton ()
    {

        driver.findElement(LogOutButton).click();
    }
    public  void  SignOutAfterRegistration()
    {
        ClickContinueButton();
        ClickLogoutButton ();
    }

}
