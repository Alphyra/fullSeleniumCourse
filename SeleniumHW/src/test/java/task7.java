import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class task7 {
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
            Assert.assertTrue("Wrong title for 'Appearane' point.", isTitleOfTabCorrect("#app->a[href*=appearance]", "Template", driver));
            Assert.assertTrue("Wrong title for 'Template' subpoint.", isTitleOfTabCorrect("#doc-template>a", "Template", driver));
            Assert.assertTrue("Wrong title for 'Logotype' subpoint.", isTitleOfTabCorrect("#doc-logotype>a", "Logotype", driver));
            Assert.assertTrue("Wrong title for 'Catalog' point.", isTitleOfTabCorrect("#app->a[href*=catalog]", "Catalog", driver));
            Assert.assertTrue("Wrong title for 'Catalog' subpoint.", isTitleOfTabCorrect("#doc-catalog>a", "Catalog", driver));
            Assert.assertTrue("Wrong title for 'Product Group' subpoint.", isTitleOfTabCorrect("#doc-product_groups>a", "Product Groups", driver));
            Assert.assertTrue("Wrong title for 'Option Groups subpoint" , isTitleOfTabCorrect("#doc-option_groups>a", "Option Groups", driver));
            Assert.assertTrue("Wrong title for 'Manufacturers' subpoint", isTitleOfTabCorrect("#doc-manufacturers>a", "Manufacturers", driver));
            Assert.assertTrue("Wrong title for 'Suppliers' subpoint", isTitleOfTabCorrect("#doc-suppliers>a", "Suppliers", driver));
            Assert.assertTrue("Wrong title for 'Delivery Statuses' subpoint", isTitleOfTabCorrect("#doc-delivery_statuses>a", "Delivery Statuses", driver));
            Assert.assertTrue("Wrong title for 'Sold Out Statuses' subpoint", isTitleOfTabCorrect("#doc-sold_out_statuses>a", "Sold Out Statuses", driver));
            Assert.assertTrue("Wrong title for 'Quantity Units' subpoint", isTitleOfTabCorrect("#doc-quantity_units>a", "Quantity Units", driver));
            Assert.assertTrue("Wrong title for 'CSV Import/Export' subpoint", isTitleOfTabCorrect("#app-.selected #doc-csv>a", "CSV Import/Export", driver));
            Assert.assertTrue("Wrong title for 'Countries' point.", isTitleOfTabCorrect("#app->a[href*=countries]", "Countries", driver));
            Assert.assertTrue("Wrong title for 'Currencies' point.", isTitleOfTabCorrect("#app->a[href*=currencies]", "Currencies", driver));
            Assert.assertTrue("Wrong title for 'Customers' point.", isTitleOfTabCorrect("#app->a[href*=customers]", "Customers", driver));
            Assert.assertTrue("Wrong title for 'Customers' subpoint.", isTitleOfTabCorrect("#doc-customers>a", "Customers", driver));
            Assert.assertTrue("Wrong title for 'Customers' subpoint.", isTitleOfTabCorrect("#doc-customers>a", "Customers", driver));
            Assert.assertTrue("Wrong title for 'CSV Import/Export' subpoint", isTitleOfTabCorrect("#app-.selected #doc-csv>a", "CSV Import/Export", driver));
            Assert.assertTrue("Wrong title for 'Newsletter' subpoint", isTitleOfTabCorrect("#doc-newsletter>a", "Newsletter", driver));
            Assert.assertTrue("Wrong title for 'Newsletter' subpoint", isTitleOfTabCorrect("#doc-newsletter>a", "Newsletter", driver));
            Assert.assertTrue("Wrong title for 'Geo Zones' point.", isTitleOfTabCorrect("#app->a[href*=geo_zones]", "Geo Zones", driver));
            Assert.assertTrue("Wrong title for 'Languages' point.", isTitleOfTabCorrect("#app->a[href*=languages]", "Languages", driver));
            Assert.assertTrue("Wrong title for 'Languages' point.", isTitleOfTabCorrect("#app->a[href*=languages]", "Languages", driver));
            Assert.assertTrue("Wrong title for 'Languages' subpoint.", isTitleOfTabCorrect("#doc-languages>a", "Languages", driver));
            Assert.assertTrue("Wrong title for 'Storage Encoding' subpoint.", isTitleOfTabCorrect("#doc-storage_encoding>a", "Storage Encoding", driver));
            Assert.assertTrue("Wrong title for 'Modules' point.", isTitleOfTabCorrect("#app->a[href*=modules]", "Job Modules", driver));
            Assert.assertTrue("Wrong title for 'Job Modules' subpoint.", isTitleOfTabCorrect("#doc-jobs>a", "Job Modules", driver));
            Assert.assertTrue("Wrong title for 'Customer Modules' subpoint.", isTitleOfTabCorrect("#doc-customer>a", "Customer Modules", driver));
            Assert.assertTrue("Wrong title for 'Shipping Modules' subpoint.", isTitleOfTabCorrect("#doc-shipping>a", "Shipping Modules", driver));
            Assert.assertTrue("Wrong title for 'Payment Modules' subpoint.", isTitleOfTabCorrect("#doc-payment>a", "Payment Modules", driver));
            Assert.assertTrue("Wrong title for 'Order Total Modules' subpoint.", isTitleOfTabCorrect("#doc-order_total>a", "Order Total Modules", driver));
            Assert.assertTrue("Wrong title for 'Order Success Modules' subpoint.", isTitleOfTabCorrect("#doc-order_success>a", "Order Success Modules", driver));
            Assert.assertTrue("Wrong title for 'Order Action Modules' subpoint.", isTitleOfTabCorrect("#doc-order_action>a", "Order Action Modules", driver));
            Assert.assertTrue("Wrong title for 'Orders' point.", isTitleOfTabCorrect("#app->a[href*=orders]", "Orders", driver));
            Assert.assertTrue("Wrong title for 'Orders' subpoint.", isTitleOfTabCorrect("#doc-orders>a", "Orders", driver));
            Assert.assertTrue("Wrong title for 'Order Statuses' subpoint.", isTitleOfTabCorrect("#doc-order_statuses>a", "Order Statuses", driver));
            Assert.assertTrue("Wrong title for 'Pages' point.", isTitleOfTabCorrect("#app->a[href*=pages]", "Pages", driver));
            Assert.assertTrue("Wrong title for 'Reports' point.", isTitleOfTabCorrect("#app->a[href*=monthly_sales]", "Monthly Sales", driver));
            Assert.assertTrue("Wrong title for 'Monthly Sales' subpoint.", isTitleOfTabCorrect("#doc-monthly_sales>a", "Monthly Sales", driver));
            Assert.assertTrue("Wrong title for 'Most Sold Products' subpoint.", isTitleOfTabCorrect("#doc-most_sold_products>a", "Most Sold Products", driver));
            Assert.assertTrue("Wrong title for 'Most Shopping Customers' subpoint.", isTitleOfTabCorrect("#doc-most_sold_products>a", "Most Sold Products", driver));
            Assert.assertTrue("Wrong title for 'Settings' point.", isTitleOfTabCorrect("#app->a[href*=store_info]", "Settings", driver));
            Assert.assertTrue("Wrong title for 'Store Info' subpoint.", isTitleOfTabCorrect("#doc-store_info>a", "Settings", driver));
            Assert.assertTrue("Wrong title for 'General' subpoint.", isTitleOfTabCorrect("#doc-general>a", "Settings", driver));
            Assert.assertTrue("Wrong title for 'Listings' subpoint.", isTitleOfTabCorrect("#doc-listings>a", "Settings", driver));
            Assert.assertTrue("Wrong title for 'Images' subpoint.", isTitleOfTabCorrect("#doc-images>a", "Settings", driver));
            Assert.assertTrue("Wrong title for 'Checkout' subpoint.", isTitleOfTabCorrect("#doc-checkout>a", "Settings", driver));
            Assert.assertTrue("Wrong title for 'Advanced' subpoint.", isTitleOfTabCorrect("#doc-advanced>a", "Settings", driver));
            Assert.assertTrue("Wrong title for 'Security' subpoint.", isTitleOfTabCorrect("#doc-security>a", "Settings", driver));
            Assert.assertTrue("Wrong title for 'Slides' point.", isTitleOfTabCorrect("#app->a[href*=slides]", "Slides", driver));
            Assert.assertTrue("Wrong title for 'Tax' point.", isTitleOfTabCorrect("#app->a[href*=tax_classes]", "Tax Classes", driver));
            Assert.assertTrue("Wrong title for 'Tax Classes' subpoint.", isTitleOfTabCorrect("#doc-tax_classes>a", "Tax Classes", driver));
            Assert.assertTrue("Wrong title for 'Tax Rates' subpoint.", isTitleOfTabCorrect("#doc-tax_rates>a", "Tax Rates", driver));
            Assert.assertTrue("Wrong title for 'Translations' point.", isTitleOfTabCorrect("#app->a[href*=translations]", "Search Translations", driver));
            Assert.assertTrue("Wrong title for 'Search Translations' subpoint.", isTitleOfTabCorrect("#doc-search>a", "Search Translations", driver));
            Assert.assertTrue("Wrong title for 'Scan Files' subpoint.", isTitleOfTabCorrect("#doc-scan>a", "Scan Files For Translations", driver));
            Assert.assertTrue("Wrong title for 'CSV Import/Export' subpoint", isTitleOfTabCorrect("#app-.selected #doc-csv>a", "CSV Import/Export", driver));
            Assert.assertTrue("Wrong title for 'Users' point.", isTitleOfTabCorrect("#app->a[href*=users]", "Users", driver));
            Assert.assertTrue("Wrong title for 'vQmods' point.", isTitleOfTabCorrect("#app->a[href*=vqmods]", "vQmods", driver));
            Assert.assertTrue("Wrong title for 'vQmods' subpoint.", isTitleOfTabCorrect("#doc-vqmods>a", "vQmods", driver));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            driver.quit();
        }
    }

    private boolean isTitleOfTabCorrect (String locator, String expectedTitle, WebDriver driver){
        WebElement tabLink = driver.findElement(By.cssSelector(locator));
        tabLink.click();
        WebElement header = driver.findElement(By.cssSelector("h1"));
        String actualTitle = header.getText();
        return expectedTitle.equals(actualTitle);
    }
}
