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
       // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        SingUpPage= new SignUp(driver);
        RegistrationPage = new RegistrationData(driver);
        LogoutPage = new SignOut(driver);
        options.addArguments("start-maximized");
        options.addArguments("test-type");
        options.addArguments("disable-notifications");
    }


    @Test
    public void CheckIfUserCanRegisterSuccessfully() throws InterruptedException {
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
