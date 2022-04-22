package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        WebElement userName1 = driver.findElement(By.xpath("//div[@class='login']//input[@name='username']"));
        userName1.sendKeys("Shalini");
        //enter password
        WebElement password1 = driver.findElement(By.xpath("//div[@class='login']//input[@name='password']"));
        password1.sendKeys("123456");
        WebElement login = driver.findElement(By.xpath("//div[@class='login']//input[@type='submit']"));
        login.click();
        //match actul massage with expected
        String expectedText = "Accounts Overview";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualText = actualTextElement.getText();
        //Validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Enter username
        WebElement userName1 = driver.findElement(By.xpath("//div[@class='login']//input[@name='username']"));
        userName1.sendKeys("Rutu");
        //enter password
        WebElement password1 = driver.findElement(By.xpath("//div[@class='login']//input[@name='password']"));
        password1.sendKeys("128566");
        //login
        WebElement login = driver.findElement(By.xpath("//div[@class='login']//input[@type='submit']"));
        login.click();
        //match actul massage with expected
        String expectedText = "The username and password could not be verified.";
        WebElement actualTextElement = driver.findElement(By.xpath("//p[@class='error']"));
        String actualText = actualTextElement.getText();
        //Validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Enter username
        WebElement userName1 = driver.findElement(By.xpath("//div[@class='login']//input[@name='username']"));
        userName1.sendKeys("Shalini");
        //enter password
        WebElement password1 = driver.findElement(By.xpath("//div[@class='login']//input[@name='password']"));
        password1.sendKeys("123456");
        WebElement login = driver.findElement(By.xpath("//div[@class='login']//input[@type='submit']"));
        login.click();
        //logout
        WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        logout.click();
        // verify  actual massage with expected
        String expectedText = "Customer Login";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualText = actualTextElement.getText();
        //Validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);


    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}