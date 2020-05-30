package utils.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static utils.com.BaseClass.*;


public class MakemyTrip_Utils {


    @BeforeTest
    public void opening_MakeMyTrip_Site() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/browser_drivers/chromedriver.exe");
        driver = new ChromeDriver();

       /* System.setProperty("webdriver.gecko.driver",
                "src/test/java/geckodriver.exe");
        driver = new FirefoxDriver();*/


        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test(priority = 1)
    public void click_on_flights_link_and_click_on_round_trip() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='SW']/div[2]/div[2]/div/div/nav/ul/li[1]/a/span[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(" //*[@id='root']/div/div[2]/div/div/div[1]/ul/li[2]/span")).click();


    }

    @Test(priority = 2)
    public void entering_Flights_Names(String fromCity, String toCity) throws InterruptedException {
        driver.findElement(By.id("fromCity")).click();
        WebElement from_City = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));

        from_City.sendKeys(fromCity);
        Thread.sleep(3000);
        from_City.sendKeys(Keys.ARROW_DOWN);
        from_City.sendKeys(Keys.ENTER);


        WebElement to_City = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input"));
        to_City.sendKeys(toCity);
        to_City.sendKeys(Keys.ARROW_DOWN);
        to_City.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[5]/div[7]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[7]/div")).click();
    }

    @Test(priority = 3)
    public static void selecting_PassengersCount() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div/ul[1]/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div/div/div[1]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div/div/div[2]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a")).click();
    }

    @Test(dependsOnMethods = "selecting_PassengersCount")
    public static void verifing_Prices() throws InterruptedException {
        WebElement charges_of_DepFlight_That_is_displayed = driver.findElement(By.xpath("//*[@id=\"ow-domrt-jrny\"]/div/div/label/div[2]/div[3]"));
        String charges_of_DepFlight_That_is_displayed_InString = charges_of_DepFlight_That_is_displayed.getText().replaceAll("[^a-zA-Z0-9]", "");
        // s1 = s1.replaceAll("[^a-zA-Z0-9]", "");
        int charges_of_DepFlight_That_is_displayed_InInteger = Integer.parseInt(charges_of_DepFlight_That_is_displayed_InString);
        System.out.println("Price of Dep flight  " + charges_of_DepFlight_That_is_displayed_InInteger);

        WebElement charges_of_ReturnFlight_That_is_displayed = driver.findElement(By.xpath("//*[@id=\"rt-domrt-jrny\"]/div/div[4]/label/div[2]/div[3]/div/p/span"));
        String charges_of_ReturnFlight_That_is_displayed_inString = charges_of_ReturnFlight_That_is_displayed.getText().replaceAll("[^a-zA-Z0-9]", "");
        //s2 = s2.replaceAll("[^a-zA-Z0-9]", "");
        int charges_of_ReturnFlight_That_is_displayed_inInteger = Integer.parseInt(charges_of_ReturnFlight_That_is_displayed_inString);
        System.out.println("Price of return flight " + charges_of_ReturnFlight_That_is_displayed_inInteger);

        int totalchargesofDepFlighst_ReturnFlights = charges_of_DepFlight_That_is_displayed_InInteger + charges_of_ReturnFlight_That_is_displayed_inInteger;
        //Total charge is
        System.out.println("Total amount of dep and Return flghts displayed in site are " + totalchargesofDepFlighst_ReturnFlights);


        //Selected Flight details

        WebElement charges_of_DepFlight_That_is_Selected = driver.findElement(By.xpath("//*[@id='left-side--wrapper']/div/div/div[4]/div/div[1]/div/div[1]/div/div[2]/div[4]/p"));
        String charges_of_DepFlight_That_is_Selected_InString = charges_of_DepFlight_That_is_Selected.getText().replaceAll("[^a-zA-Z0-9]", "");
        //ss1 = ss1.replaceAll("[^a-zA-Z0-9]", "");

        int charges_of_DepFlight_That_is_Selected_InInteger = Integer.parseInt(charges_of_DepFlight_That_is_Selected_InString);
        System.out.println("Price of Selected Dep flight " + charges_of_DepFlight_That_is_Selected_InInteger);


        //Total charge is
        System.out.println("Total charge is " + totalchargesofDepFlighst_ReturnFlights);
        WebElement charges_of_ReturnFlight_That_is_Selected = driver.findElement(By.xpath("//*[@id=\"left-side--wrapper\"]/div/div/div[4]/div/div[1]/div/div[2]/div/div[2]/div[4]/p"));
        String charges_of_ReturnFlight_That_is_Selected_InString = charges_of_ReturnFlight_That_is_Selected.getText().replaceAll("[^a-zA-Z0-9]", "");
        // ss2 = ss2.replaceAll("[^a-zA-Z0-9]", "");

        int charges_of_ReturnFlight_That_is_Selected_InInteger = Integer.parseInt(charges_of_ReturnFlight_That_is_Selected_InString);
        System.out.println("Price of Selected Retrun flight " + charges_of_ReturnFlight_That_is_Selected_InInteger);

        int totalchargesofSelectedDepFlighst_ReturnFlights = charges_of_DepFlight_That_is_Selected_InInteger + charges_of_ReturnFlight_That_is_Selected_InInteger;
        //Total charge is
        System.out.println("Total amount for selected fights is " + totalchargesofSelectedDepFlighst_ReturnFlights);


        Assert.assertEquals(charges_of_DepFlight_That_is_displayed_InInteger, charges_of_DepFlight_That_is_Selected, "Displayed Departure and Return flights charges are not equal");
        Assert.assertEquals(charges_of_ReturnFlight_That_is_Selected_InInteger, charges_of_ReturnFlight_That_is_Selected_InInteger, "Selected  Departure and Return flights charges are not equal");

        Assert.assertEquals(totalchargesofDepFlighst_ReturnFlights, totalchargesofSelectedDepFlighst_ReturnFlights, "Both flights charges are not equal");

    }

    @Test(dependsOnMethods = "verifing_Prices")
    public static void booking() throws InterruptedException {

//Clicking "Book Now" Button
        driver.findElement(By.xpath("//*[@class='fli_primary_btn text-uppercase ']")).click();


        //Navigated to Second window
        Set<String> No_of_Windows = driver.getWindowHandles();
        Iterator<String> iterator = No_of_Windows.iterator();
        //iterate through your windows
        while (iterator.hasNext()) {
            String parent_window = iterator.next();
            String new_window = iterator.next();
            driver.switchTo().window(new_window);
            //perform actions on new window
        }

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,950)");
        //Clicking Insurance Button
        WebElement newInsuranceBtn = driver.findElement(By.xpath("//*[@id='insurance-section']/div/div[3]/label[1]/input"));
        newInsuranceBtn.click();
        driver.findElement(By.xpath("//*[@id='review-continue']")).click();


        //adding adults
        driver.findElement(By.linkText("+ ADD ADULT")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("+ ADD ADULT")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("+ ADD CHILD")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("+ ADD CHILD")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("+ ADD INFANT")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("+ ADD INFANT")).click();


        List<WebElement> firstAdultNames = driver.findElements(By.xpath("//*[@placeholder='First & Middle Name']"));
        List<WebElement> lastAdultNames = driver.findElements(By.xpath("//*[@placeholder='Last Name']"));
        List<WebElement> genderButn = driver.findElements(By.xpath("//div/label"));


        for (int i = 0; i < 1; i++) {

            firstAdultNames.get(0).sendKeys("Adigarla");
            lastAdultNames.get(0).sendKeys("Murthy");
            genderButn.get(0).click();


            firstAdultNames.get(1).sendKeys("Adigarlaa");
            lastAdultNames.get(1).sendKeys("Murthyy");
            genderButn.get(2).click();

            firstAdultNames.get(2).sendKeys("AdigarlaChild");
            lastAdultNames.get(2).sendKeys("MurthyChild");
            genderButn.get(4).click();

            firstAdultNames.get(3).sendKeys("AdigarlaaChild");
            lastAdultNames.get(3).sendKeys("MurthyyChild");
            genderButn.get(6).click();

            firstAdultNames.get(4).sendKeys("AdigarlaaInfant");
            lastAdultNames.get(4).sendKeys("MurthyyInfant");
            genderButn.get(8).click();
            //Selection dropdowns
            date("11");
            month("Dec");
            year("2019");


            Thread.sleep(3000);

            firstAdultNames.get(5).sendKeys("AdigarlaaInfant");
            lastAdultNames.get(5).sendKeys("MurthyyInfant");
            genderButn.get(12).click();
            date("11");
            month("Dec");
            year("2019");

            Thread.sleep(3000);
            //entering mobile num and Email
            driver.findElement(By.xpath("//input[contains(@placeholder,'Mobile No')]")).sendKeys("9966236635");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[contains(@placeholder,'Email')]")).sendKeys("murthy.adigarlaa@gmail.com");
            Thread.sleep(3000);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[contains(@class,'ack-cta btn fli_primary_btn text-uppercase')]")).click();
            // JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,300)");

        }


    }

    @AfterTest
    public void closeBrowser() {
        driver.close();

    }
}