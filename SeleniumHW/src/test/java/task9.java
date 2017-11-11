import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class task9 {
    private WebDriver driver;

    @Test
    public void taskNine () {
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

            // 1A check that countries are in alphabetical order
            // go to Countries page
            driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            // get rows of all countris and cointries with time zones
            WebElement countriesTable = driver.findElement(By.cssSelector("table.dataTable"));
            List<WebElement> countriesRows = countriesTable.findElements(By.cssSelector("tr.row"));
            ArrayList<String> allCountriesTextList = new ArrayList<>();
            ArrayList<String> rowWithZonesTextList = new ArrayList<>();
            String countryName;
            for (int i=0; i<countriesRows.size()-1; i++){
                countryName = countriesRows.get(i).findElement(By.cssSelector("td:nth-child(5)>a")).getText();
                allCountriesTextList.add(countryName);
                if (!(countriesRows.get(i).findElement(By.cssSelector("td:nth-child(6)")).getText().equals("0"))) {
                    rowWithZonesTextList.add(Integer.toString(i+1));
                }
            }

            Assert.assertTrue("Sorting for countries is not Alphabetical ASC", isSortAlphabeticalAsc(allCountriesTextList));

            //1B Check that zones are in alphabetical order
            for (String s:rowWithZonesTextList) {
                WebElement countryLink = driver.findElement(By.xpath("//table[@class='dataTable']//tr[@class='row'][" + s + "]//a"));
                countryLink.click();

                WebElement zonesTable = driver.findElement(By.cssSelector("table#table-zones"));
                ArrayList<String> allZonesTextList = new ArrayList<>();
                List<WebElement> zonesRows = zonesTable.findElements(By.cssSelector("tr:not(.header)"));
                for (int i=0; i<zonesRows.size()-1; i++) {
                    allZonesTextList.add(zonesRows.get(i).findElement(By.xpath(".//td[3]/input")).getAttribute("value"));
                }
                Assert.assertTrue(isSortAlphabeticalAsc(allZonesTextList));
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }

            //2 Check that zones are in alphabetical order

            for (int i=1; i<=rowWithZonesTextList.size(); i++) {
                driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
                WebElement countryLink = driver.findElement(By.xpath("//tr[@class='row'][" + i + "]/td[3]/a"));
                countryLink.click();
                //actions on "Edit Geo Zones" page
                WebElement zonesTable = driver.findElement(By.cssSelector("table#table-zones"));
                ArrayList<String> allZonesTextList = new ArrayList<>();
                List<WebElement> selectorsList = zonesTable.findElements(By.xpath(".//tr/td[3]/select"));
                for (WebElement selector:selectorsList) {
                    List<WebElement> options = selector.findElements(By.cssSelector("option"));
                    for (WebElement option:options){
                        if (option.isSelected()) allZonesTextList.add(option.getText());
                    }
                }
                Assert.assertTrue(isSortAlphabeticalAsc(allZonesTextList));
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            driver.quit();
        }
    }

    private boolean isSortAlphabeticalAsc (ArrayList<String> actualList) {
        ArrayList<String> sortedList = new ArrayList<>();
        for (String s:actualList) {
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        return sortedList.equals(actualList);
    }
}
