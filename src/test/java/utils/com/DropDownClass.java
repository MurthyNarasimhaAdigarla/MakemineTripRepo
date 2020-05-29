package utils.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.List;

public class DropDownClass extends MakemyTrip_Utils {


    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
        driver = new ChromeDriver();


        driver.get("https://www.makemytrip.com/flight/traveller/?itineraryId=a30d4bd55c00f472972c05c99073c60b31cb95ee&crId=73f04477-b5d3-4d7f-841e-324e865bfc13&cur=INR");

        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");
        driver.findElement(By.linkText("+ ADD INFANT")).click();
        Thread.sleep(2000);

        date("11");
        month("Dec");
        year("2019");

    }

    public static void date(String date) {

        driver.findElement(By.xpath("//div[@class='dropdown__placeholder css-1wa3eu0-placeholder'][contains(.,'')]")).click();
        List<WebElement> dd = driver.findElements(By.xpath("//div[@class='dropdown__menu css-26l3qy-menu']//div//div"));

        for (WebElement elements : dd
        ) {
            String names = elements.getText();
            System.out.print("names are" + names);
            if (names.equalsIgnoreCase(date)) {
                elements.click();
                break;
            }
        }

    }

    public static void month(String monthName) {

        driver.findElement(By.xpath("//*[@class=\"dropdown__placeholder css-1wa3eu0-placeholder\"][contains(.,'Month')]")).click();
        List<WebElement> dd = driver.findElements(By.xpath("//*[@class=\"dropdown__menu-list css-11unzgr\"]//div"));

        for (WebElement elements : dd
        ) {
            String names = elements.getText();
            System.out.print("names are" + names);
            if (names.equalsIgnoreCase(monthName)) {
                elements.click();
                break;
            }
        }

    }

    public static void year(String yearName) {

        driver.findElement(By.xpath("//*[@class=\"dropdown__placeholder css-1wa3eu0-placeholder\"][contains(.,'Year')]")).click();
        List<WebElement> dd = driver.findElements(By.xpath("//*[@class=\"dropdown__menu-list css-11unzgr\"]//div"));

        for (WebElement elements : dd
        ) {
            String names = elements.getText();
            System.out.print("names are" + names);
            if (names.equalsIgnoreCase(yearName)) {
                elements.click();
                break;
            }
        }


    }


}