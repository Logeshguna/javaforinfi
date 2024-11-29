package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class Opengoogle_Definitions {
    WebDriver driver;

    @Given("^open browser$")
    public void open_browser() throws Throwable {
        // Set ChromeDriver property and initialize ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\logesh.g\\AppData\\Local\\Programs\\Python\\Python311\\Scripts\\chromedriver.exe"); // Replace with actual path
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");
        driver = new ChromeDriver(opt);
        
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @When("^click on the register$")
    public void click_on_the_register() throws Throwable {
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    	// Click "My Account"
    	WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
    	js.executeScript("arguments[0].click();", myAccount);

    	// Wait for "Register" and click
    	WebElement registerLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Register']")));
    	js.executeScript("arguments[0].click();", registerLink);
        // Wait for the "Register" link to be clickable and then click it
        
    }

    @Then("^verify user moved to register page$")
    public void verify_user_moved_to_register_page() throws Throwable {
        // Wait for the heading of the registration page to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        WebElement registerLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Register']")));
//        registerLink.click();
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1")));
        String actualHeading = heading.getText();
        System.out.print(actualHeading);

        // Verify the page title matches "Register Account"
        Assert.assertEquals("Register Account", actualHeading);

        // Close the browser after verification
        driver.quit();
    }
}
