import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class lesson2task3 {
    private WebDriver driver;

    @Test
    public void task3() {
        // Initiate driver
        WebDriver driver = new ChromeDriver();
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
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            driver.quit();
        }
    }
}
