import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUp
{
    Faker faker = new Faker();
    WebDriver driver;
    By SignUpLoginButton = By.cssSelector("a[href='/login']");
    By Name = By.cssSelector("input[data-qa=\"signup-name\"]");
    By Email = By.cssSelector("input[data-qa=\"signup-email\"]");

    By SignupButton= By.cssSelector("button[data-qa=\"signup-button\"]");
    public SignUp(WebDriver driver)
    {
        this.driver= driver;

    }
    private void ClickSignUpLogin ()
    {

        driver.findElement(SignUpLoginButton).click();
    }
    private void InsertUserName()
    {

        driver.findElement(Name).sendKeys(faker.name().username());
    }

    private void InsertEmail()
    {
        driver.findElement(Email).sendKeys(faker.internet().emailAddress());
    }

    private void ClickSignupButton()
    {
        driver.findElement(SignupButton).click();
    }

    public void SignUP () {

        ClickSignUpLogin();

        InsertUserName();

        InsertEmail();

        ClickSignupButton();
    }
}
