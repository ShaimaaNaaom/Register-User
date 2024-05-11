import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SignUpCycle
{

    WebDriver driver;
    SignUp SingUpPage;
    RegistrationData RegistrationPage;
    SignOut LogoutPage;

    @BeforeMethod
    public void beforeTest()
    {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--disable-notifications"); // Disable notifications
        options.addArguments("--disable-popup-blocking"); // Disable popup blocking
        options.addArguments("--disable-infobars"); // Disable infobars
        options.addArguments("--disable-save-password-bubble"); // Disable save password prompt
        // Set preferences to deny automatic downloads
        options.addArguments("profile.default_content_setting_values.automatic_downloads=2");
        driver = new ChromeDriver(options);

        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        SingUpPage= new SignUp(driver);
        RegistrationPage = new RegistrationData(driver);
        LogoutPage = new SignOut(driver);

    }


    @Test
    public void CheckIfUserCanRegisterSuccessfully() {
        SingUpPage.SignUP();
        RegistrationPage.FillRegistrationData();
        LogoutPage.SignOutAfterRegistration();

        String expected = "New User Signup!";
        String actual = driver.findElement(By.cssSelector("#form > div > div > div:nth-child(3) > div > h2")).getText();

        Assert.assertEquals(actual,expected);
    }
    @AfterMethod
    public void afterTest()
    {
        driver.quit();
    }
}
