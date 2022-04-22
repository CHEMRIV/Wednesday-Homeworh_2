package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //find register button and click on it
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        //verify the massage "Signing up is easy!"
        String expectedMessage = "Signing up is easy!";
        WebElement actualMassageElement = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualMassage = actualMassageElement.getText();
        //validation of actual and expected results
        Assert.assertEquals("Not match with data", actualMassage, expectedMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //find register button and click on it
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        //Enter first name
        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Shalini");
        //Enter last name
        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Shah");
        //Enter Address
        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("45, Eltorn park, near The Southern cross shop");
        //Enter city
        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("London");
        // Enter State
        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("London");
        //Enter ZipCode
        WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
        zipCode.sendKeys("WD156NW");
        //Enter Mobile number
        WebElement phoneNumber = driver.findElement(By.id("customer.phoneNumber"));
        phoneNumber.sendKeys("7778515631");
        //Enter SSN number
        WebElement ssnNumber = driver.findElement(By.id("customer.ssn"));
        ssnNumber.sendKeys("NJ526345IN");
        //Enter Username
        WebElement userName = driver.findElement(By.id("customer.username"));
        userName.sendKeys("Shalini");
        //Enter password
        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("123456");
        //Enter conformed password
        WebElement conformPassword = driver.findElement(By.id("repeatedPassword"));
        conformPassword.sendKeys("123456");
        //click on register button
        WebElement registerSuccessfully = driver.findElement(By.xpath("//table[@class='form2']//input[@type='submit']"));
        registerSuccessfully.click();
        // match actul massage with expected
        String expectedText = "Your account was created successfully. You are now logged in.";
        WebElement actualTextElement = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
        String actualText = actualTextElement.getText();
        //Validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);


    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}