package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        // Find and click on the sale menu
        driver.findElement(By.id("ui-id-8")).click();
        // Find and click on jackets link
        driver.findElement(By.xpath("(//a[normalize-space()='Jackets'])[3]")).click();
        //Verify Jacket text
        String expectedJacketText = "Jackets";
        String actualJacketText = driver.findElement(By.id("page-title-heading")).getText();
        Assert.assertEquals(expectedJacketText, actualJacketText);
        //count the items
        // Count the total items displayed on the page and print
//        List<WebElement> links = driver.findElements(By.tagName("column main"));
//        System.out.println("The number of links is " + links.size());
//        for(int i = 0; i< links.size(); i++) {
//            //obtain text
//            String s = links.get(i).getText();
//            System.out.println("Text is: " + s);


        //Find number of items per page element and print total number
        List<WebElement> numberOfDisplayedItems = driver.findElements(By.xpath("//li[@class='item product product-item']"));
        System.out.println("Total: " + numberOfDisplayedItems.size());
        //Find each items displayed element and print each item
        List<WebElement> linkeditems = driver.findElements(By.tagName("ol"));
        System.out.println("total number of items:" + linkeditems.size());
        for (WebElement link : linkeditems) {
            System.out.println("linked text: " + link.getText());


            //verify
            int productCount = driver.findElements(By.className("product-image-photo")).size();
            Assert.assertEquals(productCount, 12);
            closeBrowser();
        }
    }
}






