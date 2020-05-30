package utils.com;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static utils.com.BaseClass.*;


public class Test  {



    @BeforeTest
    public void opening_MakeMyTrip_Site() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
        driver = new ChromeDriver();

       /* System.setProperty("webdriver.gecko.driver",
                "src/test/java/geckodriver.exe");
        driver = new FirefoxDriver();*/

        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='SW']/div[2]/div[2]/div/div/nav/ul/li[1]/a/span[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(" //*[@id='root']/div/div[2]/div/div/div[1]/ul/li[2]/span")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }


    public void enterin_Flights_Names() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.findElement(By.id("fromCity")).click();
        WebElement f = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));

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


        //Printong departure and returm flights
        System.out.println("********************Before checking non stop and 1 stop options**********************");
        gettingListofDepartureandReturnFlights();

        //checking non stop and 1 stop options
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_nonStop')]")).click();
        Thread.sleep(3000);


       /* if (driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_oneStop')]")).isDisplayed()) {
            driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_oneStop')]")).click();

        }*/

        System.out.println("********************After checking non stop and 1 stop options**********************");
        gettingListofDepartureandReturnFlights();


        Unchecking_1_stop_and_getting_last_flight_details();


    }


    public static void verifing_Prices() throws InterruptedException {

        WebElement chargesof1stDPFlight = driver.findElement(By.xpath("//*[@id=\"ow-domrt-jrny\"]/div/div/label/div[2]/div[3]"));
        String s1 = chargesof1stDPFlight.getText();
        s1 = s1.replaceAll("[^a-zA-Z0-9]", "");

        int i1 = Integer.parseInt(s1);
        System.out.println(i1);

        WebElement chargesof1stRPFlight = driver.findElement(By.xpath("//*[@id=\"rt-domrt-jrny\"]/div/div[4]/label/div[2]/div[3]/div/p/span"));
        String s2 = chargesof1stRPFlight.getText();

        s2 = s2.replaceAll("[^a-zA-Z0-9]", "");

        int i2 = Integer.parseInt(s2);
        System.out.println(i2);

        int i3 = i1 + i2;
        //Total charge is
        System.out.println("Total charge is " + i3);

        //Down Prices

        WebElement chargesofdownDPFlight = driver.findElement(By.xpath("//*[@id='left-side--wrapper']/div/div/div[4]/div/div[1]/div/div[1]/div/div[2]/div[4]/p"));
        String ss1 = chargesofdownDPFlight.getText();
        ss1 = ss1.replaceAll("[^a-zA-Z0-9]", "");

        int ii1 = Integer.parseInt(ss1);
        System.out.println(i2);


        //Total charge is
        System.out.println("Total charge is " + i3);
        WebElement chargesofdownRPFlight = driver.findElement(By.xpath("//*[@id=\"left-side--wrapper\"]/div/div/div[4]/div/div[1]/div/div[2]/div/div[2]/div[4]/p"));
        String ss2 = chargesofdownRPFlight.getText();
        ss2 = ss2.replaceAll("[^a-zA-Z0-9]", "");

        int ii2 = Integer.parseInt(ss2);
        System.out.println(ii2);

        int ii3 = ii1 + ii2;
        //Total charge is
        System.out.println("Total charge is " + ii3);


        Assert.assertEquals(i1, ii1, "Both flights charges are not equal");
        Assert.assertEquals(i2, ii2, "Both flights charges are not equal");

        Assert.assertEquals(i3, ii3, "Both flights charges are not equal");

        booking();
    }


    public static void booking() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='fli_primary_btn text-uppercase ']")).click();
        Thread.sleep(5000);

        //Check box
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
//iterate through your windows
        while (it.hasNext()) {
            String parent = it.next();
            String newwin = it.next();
            driver.switchTo().window(newwin);
//perform actions on new window


        }
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,950)");

       /* WebElement oldInsuranceBtn = driver.findElement(By.xpath("(//input[@value='no'])[2]"));


        if (oldInsuranceBtn.isDisplayed())
            oldInsuranceBtn.click();
        else {
            WebElement newInsuranceBtn = driver.findElement(By.xpath("//*[@id='insurance-section']/div/div[3]/label[1]/input"));
            newInsuranceBtn.click();

        }*/
        WebElement newInsuranceBtn = driver.findElement(By.xpath("//*[@id='insurance-section']/div/div[3]/label[1]/input"));
        newInsuranceBtn.click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='review-continue']")).click();
        Thread.sleep(3000);


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
}