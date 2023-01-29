import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main {
    WebDriver driver;
    WebDriverWait wait;
    NgWebDriver ngWebDriver;

    String firstName = "Adar";

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Automation Course\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
    }
    @Test
    public void Test01_Question1_ImplicitlyWait(){
        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
        driver.findElement(By.id("btn")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/form/div[1]/input")).click();
    }

    @Test
    public void Test02_Question1_ThreadSleep() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.findElement(By.id("hidden")).click();
        Thread.sleep(5000);
        System.out.println("The Element is: " + driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/h4")).getText());
    }

    @Test
    public void Test03_Question1_ExplicitWait(){
        driver.findElement(By.id("rendered")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[4]/h4"))).getText();
        System.out.println("The Element is: " + driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[4]/h4")).getText());
    }

    @Test
    public void Test04_Question2_OpenBrowser(){
        driver.get("https://dgotlieb.github.io/AngularJS/main.html");
        ngWebDriver.waitForAngularRequestsToFinish();
    }

    @Test
    public void Test05_Question2_SetFirstName(){
        WebElement firstNameElement= driver.findElement(ByAngular.model("firstName"));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    @Test
    public void Test06_Question2_AssertFirstName(){
        Assert.assertEquals(driver.findElement(ByAngular.binding("firstName")).getText(),firstName);
    }

    // Question3 PageLoadTimeOut is to change the default settings for waiting for Website to fully open.
    // the default waiting is 30 seconds
}
