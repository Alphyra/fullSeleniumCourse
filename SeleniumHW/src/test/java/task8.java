import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class task8 {
    private WebDriver driver;

    @Test
    public void taskEight() {
        // Initiate driver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try {
            //Go to litecart admin page
            driver.get("http://localhost/litecart");
            List <WebElement> boxes = driver.findElements(By.xpath("//div[@class='middle']/div[@class='content']/div[@class='box']"));
            for (int i=0; i<boxes.size(); i++) {
                List<WebElement> ducks = boxes.get(i).findElements(By.cssSelector(".image-wrapper"));
                for (int j=0; j<ducks.size(); j++) {
                    List<WebElement> stickers = ducks.get(j).findElements(By.xpath(".//div[contains(@class,'sticker')]"));
                    Assert.assertEquals("Wrong stickers number", 1, stickers.size());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            driver.quit();
        }
    }
}
