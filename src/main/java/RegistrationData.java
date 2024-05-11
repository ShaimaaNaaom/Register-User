import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class RegistrationData
{
    Faker faker = new Faker();
    WebDriver driver;
    By Title = By.cssSelector("#id_gender2");
    By Password = By.cssSelector("#password");
    By FirstName= By.cssSelector("#first_name");
    By LastName= By.cssSelector("#last_name");
    By Address1 = By.cssSelector("#address1");
    By State = By.cssSelector("#state");
    By City = By.cssSelector("#city");
    By Zipcode = By.cssSelector("#zipcode");
    By Mobile = By.cssSelector("#mobile_number");
    By CreateAccountButton = By.cssSelector("button[data-qa=\"create-account\"]");

    public RegistrationData(WebDriver driver)
    {
        this.driver= driver;
    }

    private void SelectTitle ()
    {
        driver.findElement(Title).click();
    }
    private void EnterPassword ()
    {
        driver.findElement(Password).sendKeys(faker.internet().password());
    }

    private void EnterFirstname()
    {
        driver.findElement(FirstName).sendKeys(faker.name().firstName());
    }

    private void EnterLastname()
    {
        driver.findElement(LastName).sendKeys(faker.name().lastName());
    }

    private void EnterAddress()
    {
        driver.findElement(Address1).sendKeys(faker.address().fullAddress());
    }

    private void EnterState()
    {
        driver.findElement(State).sendKeys(faker.address().state());
    }

    private void EnterCity()
    {
        driver.findElement(City).sendKeys(faker.address().city());
    }

    private void EnterZipcode()
    {
        driver.findElement(Zipcode).sendKeys(faker.address().zipCode());
    }

    private void EnterMobileNumber()
    {
        driver.findElement(Mobile).sendKeys(faker.phoneNumber().cellPhone());
    }
    private void PressCreateAccountButton()
    {
        driver.findElement(CreateAccountButton).click();
    }

    public void FillRegistrationData ()
    {

       SelectTitle();
       EnterPassword();
       EnterFirstname();
       EnterLastname();
       EnterAddress();
       EnterState ();
       EnterCity();
       EnterZipcode();
       EnterMobileNumber();
       PressCreateAccountButton();

    }
}
