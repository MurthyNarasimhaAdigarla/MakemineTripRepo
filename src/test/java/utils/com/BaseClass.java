package utils.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseClass extends MakemyTrip_Utils {


    public static WebDriver driver;

    public static void scroll() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");

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

    public static void year(String yearName) throws InterruptedException {

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


    public static void Unchecking_1_stop_and_getting_last_flight_details() throws InterruptedException {
        //Unchecking 1 stop and getting last flight details
        // driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_oneStop')]")).click();
        System.out.println("*****************Count after Unchecking 1 stop and getting last flight details***********");
        gettingListofDepartureandReturnFlights();
        driver.findElement(By.xpath("//*[@id='ow-domrt-jrny']/div/div[last()]")).click();
        Thread.sleep(5000);
        scroll();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='rt-domrt-jrny']/div/div[last()]")).click();

        verifing_Prices();

    }


    public static void gettingListofDepartureandReturnFlights() {
        //Printiing departure and return flights
        System.out.println("Printiing total count of departure and return flights");
        List<WebElement> count_of_DepartureFlights = driver.findElements(By.xpath("//*[contains(@for,'split_0')]"));
        System.out.println("Total Departure Flights are " + count_of_DepartureFlights.size());
        List<WebElement> count_of_ReturnFlights = driver.findElements(By.xpath("//*[contains(@for,'split_1')]"));
        System.out.println("Total Return Flights are " + count_of_ReturnFlights.size());
    }


}




