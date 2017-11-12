import Logic.PriceInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.util.concurrent.TimeUnit;

public class task10 {

    @Test
    public void taskTen () {
        String strikeoutStyle = "s";
        String boldStyle = "strong";

        // Initiate driver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try{
            driver.get("http://localhost/litecart/en/");
            WebElement good = driver.findElement(By.cssSelector("div#box-campaigns a.link"));
            // Get name of good on main page
            String goodNameTextMain = good.findElement(By.cssSelector("div.name")).getText();
            // Get Regular price on main page
            WebElement goodRegularPriceMain = good.findElement(By.cssSelector("div.price-wrapper .regular-price"));
            PriceInfo regularPriceMainInfo = getPriceInfo(goodRegularPriceMain);
            // Get Campaign price on main page
            WebElement goodCampaignPriceMain = good.findElement(By.cssSelector("div.price-wrapper .campaign-price"));
            PriceInfo campaignPriceMainInfo = getPriceInfo(goodCampaignPriceMain);
            //Go to good's page
            good.click();
            // Get name of good
            String goodNameText = driver.findElement(By.cssSelector("h1")).getText();
            // Get Regular price
            WebElement goodRegularPrice = driver.findElement(By.cssSelector("div.price-wrapper .regular-price"));
            PriceInfo regularPriceInfo = getPriceInfo(goodRegularPrice);
            // Get Campaign price
            WebElement goodCampaignPrice = driver.findElement(By.cssSelector("div.price-wrapper .campaign-price"));
            PriceInfo campaignPriceInfo = getPriceInfo(goodCampaignPrice);

            //Verifications
            // a
            Assert.assertEquals("Good's name must be equal on main and good's page.", goodNameTextMain, goodNameText);
            // b
            Assert.assertEquals("Regular Price must be equal on main and good's page.", regularPriceMainInfo.text, regularPriceInfo.text);
            Assert.assertEquals("Campaign Price must be equal on main and good's page.", campaignPriceMainInfo.text, campaignPriceInfo.text);
            // c
            Assert.assertEquals("Regular Price must be strikeout on main page.", strikeoutStyle, regularPriceMainInfo.style);
            Assert.assertTrue("Regulat Price must be grey on main page.", isGreyColor(regularPriceMainInfo.color));
            Assert.assertEquals("Regular Price must be strikeout on good's page.", strikeoutStyle, regularPriceInfo.style);
            Assert.assertTrue("Regulat Price must be grey on good's page.", isGreyColor(regularPriceInfo.color));
            // d
            Assert.assertEquals("Campaign Price must be bold on main page.", boldStyle, campaignPriceMainInfo.style);
            Assert.assertTrue("Campaign Price must be red on main page.", isRedColor(campaignPriceMainInfo.color));
            Assert.assertEquals("Campaign Price must be bold on good's page.", boldStyle, campaignPriceInfo.style);
            Assert.assertTrue("Campaign Price must be red on good's page.", isRedColor(campaignPriceInfo.color));
            // e
            Assert.assertTrue("Campaign Price must be bigger than Regular on main page.", campaignPriceMainInfo.height > regularPriceMainInfo.height);
            Assert.assertTrue("Campaign Price must be bigger than Regular on good's page.", campaignPriceInfo.height > regularPriceInfo.height);
        }catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            driver.quit();
        }
    }

    private boolean isGreyColor (String color){
        int red = Color.fromString(color).getColor().getRed();
        int green = Color.fromString(color).getColor().getGreen();
        int blue = Color.fromString(color).getColor().getBlue();
        if (red == green && green == blue) return true;
        return false;
    }

    private boolean isRedColor (String color) {
        int red = Color.fromString(color).getColor().getRed();
        int green = Color.fromString(color).getColor().getGreen();
        int blue = Color.fromString(color).getColor().getBlue();
        if (green == 0 && blue == 0) return true;
        return false;
    }

    private PriceInfo getPriceInfo (WebElement we){
        PriceInfo pi = new PriceInfo();

        pi.text = we.getText();
        pi.style = we.getTagName();
        pi.color = we.getCssValue("color");
        pi.height = we.getSize().height;

        return pi;
    }

}
