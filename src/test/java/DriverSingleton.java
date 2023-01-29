import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

    private static WebDriver driver;
    public static WebDriver getDriverInstance(){
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Automation Course\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

}
