import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class POMTest {

    public static WebDriver driver;

    @Test
    public void webCalculator(){
        WebCalculator webCalculator = new WebCalculator();
        webCalculator.openBrowser();
        webCalculator.printNum7Dimension();
        webCalculator.num6IsDisplay();
        webCalculator.calculation();
        webCalculator.closeAll();
    }
}
