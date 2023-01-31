import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

import java.util.ArrayList;

public class WebCalculator {
    private WebDriver driver;
    private final int calculation = 13;
    public WebCalculator(){
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void openBrowser(){
        driver.get("https://dgotlieb.github.io/WebCalculator/");
    }

    public void printNum7Dimension(){
        System.out.println("Num 7 X is: "+driver.findElement(Constants.num7).getRect().x);
        System.out.println("Num 7 Y is: "+driver.findElement(Constants.num7).getRect().y);
        System.out.println("Num 7 height is: "+driver.findElement(Constants.num7).getRect().height);
        System.out.println("Num 7 width is: "+driver.findElement(Constants.num7).getRect().width);
    }

    public void num6IsDisplay(){
        System.out.println("Num 6 is display: "+driver.findElement(Constants.num6).isDisplayed());
    }

    public void calculation(){
        driver.findElement(Constants.num7).click();
        driver.findElement(By.id("add")).click();
        driver.findElement(Constants.num6).click();
        driver.findElement(By.id("equal")).click();
        int screenResult = Integer.parseInt(driver.findElement(By.id("screen")).getText());
        Assert.assertEquals(screenResult,calculation);

    }

    public void openMultipleBrowsers(){
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com/");
        driver.switchTo().newWindow(WindowType.TAB).get("https://translate.google.com/");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().window(tabs.get(1));
    }

    public void closeAll(){
        driver.quit();
    }
}
