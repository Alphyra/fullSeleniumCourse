import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lesson2task1 {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() {
        //Go to litecart admin page
        driver.get("http://google.com");
    }

    @After
    public void stop() {
        driver.quit();
    }

}
