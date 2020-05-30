/*
package utils.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static stepdefs.com.MakeMyTrip_Steps.Unchecking_1_stop_and_getting_last_flight_details;
import static stepdefs.com.MakeMyTrip_Steps.gettingListofDepartureandReturnFlights;

public class MakemyTrip_Utils  {





    public void login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
        driver = new ChromeDriver();

       */
/* System.setProperty("webdriver.gecko.driver",
                "src/test/java/geckodriver.exe");
        driver = new FirefoxDriver();*//*


        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='SW']/div[2]/div[2]/div/div/nav/ul/li[1]/a/span[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(" //*[@id='root']/div/div[2]/div/div/div[1]/ul/li[2]/span")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public void dropurl() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.findElement(By.id("fromCity")).click();
        WebElement f = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));
        //f.click();
        //*[@id="root"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input
        f.sendKeys("Chennai");
        Thread.sleep(2000);
        f.sendKeys(Keys.ARROW_DOWN);
        f.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        //f.sendKeys(Keys.TAB);

        //driver.findElement(By.id("toCity")).click();
        WebElement t = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input"));
        Thread.sleep(2000);
        t.sendKeys("Hyderabad");
        Thread.sleep(2000);
        t.sendKeys(Keys.ARROW_DOWN);
        t.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[5]/div[7]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[7]/div")).click();

        //Selecting people

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/label/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div/ul[1]/li[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div/div/div[1]/ul/li[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div/div/div[2]/ul/li[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a")).click();


        //Printiong departure and returm f;oghts
        System.out.println("********************Before checking non stop and 1 stop options**********************");
        gettingListofDepartureandReturnFlights();

        //checking non stop and 1 stop options
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_nonStop')]")).click();
        Thread.sleep(3000);


       */
/* if (driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_oneStop')]")).isDisplayed()) {
            driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_oneStop')]")).click();

        }*//*


        System.out.println("********************After checking non stop and 1 stop options**********************");
        gettingListofDepartureandReturnFlights();


        Unchecking_1_stop_and_getting_last_flight_details();


    }

    public void enteringFlights() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.findElement(By.id("fromCity")).click();
        WebElement f = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));
        //f.click();
        //*[@id="root"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input
        f.sendKeys("Chennai");
        Thread.sleep(2000);
        f.sendKeys(Keys.ARROW_DOWN);
        f.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        //f.sendKeys(Keys.TAB);

        //driver.findElement(By.id("toCity")).click();
        WebElement t = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input"));
        Thread.sleep(2000);
        t.sendKeys("Hyderabad");
        Thread.sleep(2000);
        t.sendKeys(Keys.ARROW_DOWN);
        t.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[5]/div[7]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[7]/div")).click();

        //Selecting people

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/label/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div/ul[1]/li[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div/div/div[1]/ul/li[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div/div/div[2]/ul/li[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a")).click();


        //Printiong departure and returm f;oghts
        System.out.println("********************Before checking non stop and 1 stop options**********************");
        gettingListofDepartureandReturnFlights();

        //checking non stop and 1 stop options
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_nonStop')]")).click();
        Thread.sleep(3000);


       */
/* if (driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_oneStop')]")).isDisplayed()) {
            driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_oneStop')]")).click();

        }*//*


        System.out.println("********************After checking non stop and 1 stop options**********************");
        gettingListofDepartureandReturnFlights();


        Unchecking_1_stop_and_getting_last_flight_details();


    }




    }
}*/
