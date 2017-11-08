import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class task7attempt2 {
    private WebDriver driver;

    @Test
    public void taskSeven() {
        // Initiate driver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try {
            //Go to litecart admin page
            driver.get("http://localhost/litecart/admin");
            //Find field for user name and provide value
            WebElement loginInput = driver.findElement(By.name("username"));
            loginInput.sendKeys("admin");
            //Find field for password and provide value
            WebElement passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("admin");
            // Find login button and click
            WebElement loginButton = driver.findElement(By.name("login"));
            loginButton.click();

            //Get number of points
            List <WebElement> points = driver.findElements(By.cssSelector("#app->a"));
            List <WebElement> subPoints;
            WebElement point;
            WebElement subPoint;
            WebElement pointText;
            WebElement subPointText;
            for (int i=1; i<=points.size(); i++) {
                point = driver.findElement(By.xpath("//li[@id='app-'][" + i + "]/a"));
                point.click();
                if (!isHeaderPresent(driver)) {
                    pointText = driver.findElement(By.xpath("//li[@id='app-'][@class='selected']/a//span[@class='name']"));
                    System.out.println("Header is absent for point '" + pointText.getText() + "'.");
                }
                subPoints = driver.findElements(By.xpath("//li[@id='app-'][@class='selected']/ul/li"));
                for (int j=1; j<=subPoints.size(); j++) {
                    subPoint = driver.findElement(By.xpath("//li[@id='app-'][@class='selected']/ul/li[" + j + "]"));
                    subPoint.click();
                    if (!isHeaderPresent(driver)) {
                        subPointText = driver.findElement(By.xpath("//li[@id='doc-template'][@class='selected']/a/span"));
                        System.out.println("Header is absent for point '" + subPointText.getText() + "'.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            driver.quit();
        }
    }

    private boolean isHeaderPresent (WebDriver driver){
        try {
            driver.findElement(By.cssSelector("h1"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
