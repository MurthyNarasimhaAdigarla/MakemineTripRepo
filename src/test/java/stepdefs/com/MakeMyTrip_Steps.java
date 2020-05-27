package stepdefs.com;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.com.MakemyTrip_Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MakeMyTrip_Steps extends MakemyTrip_Utils {


    @Given("^I login website as a guest user$")
    public void i_login_website_as_a_guest_user() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='SW']/div[2]/div[2]/div/div/nav/ul/li[1]/a/span[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(" //*[@id='root']/div/div[2]/div/div/div[1]/ul/li[2]/span")).click();

        dropurl();


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
        driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_nonStop')]")).click();
        driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_oneStop')]")).click();
        System.out.println("********************After checking non stop and 1 stop options**********************");
        gettingListofDepartureandReturnFlights();


        Unchecking_1_stop_and_getting_last_flight_details();


    }

    public static void Unchecking_1_stop_and_getting_last_flight_details() throws InterruptedException {
        //Unchecking 1 stop and getting last flight details
        driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_oneStop')]")).click();
        System.out.println("*****************Count after Unchecking 1 stop and getting last flight details***********");
        gettingListofDepartureandReturnFlights();
        driver.findElement(By.xpath("//*[@id=\"ow-domrt-jrny\"]/div/div[last()]")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        driver.findElement(By.xpath("//*[@id='rt-domrt-jrny']/div/div[last()]")).click();

        gettingPrices();

    }


    public static void gettingListofDepartureandReturnFlights() {
        //Printiong departure and returm f;oghts
        List<WebElement> df = driver.findElements(By.xpath("//*[contains(@for,'split_0')]"));
        System.out.println("Departure Flights are " + df.size());
        List<WebElement> rf = driver.findElements(By.xpath("//*[contains(@for,'split_1')]"));
        System.out.println("Return Flights are " + rf.size());
    }

    public static void gettingPrices() throws InterruptedException {

        WebElement chargesof1stDPFlight = driver.findElement(By.xpath("//*[@id=\"ow-domrt-jrny\"]/div/div/label/div[2]/div[3]"));
        String s1 = chargesof1stDPFlight.getText();
        s1 = s1.replaceAll("[^a-zA-Z0-9]", "");

        int i1 = Integer.parseInt(s1);
        System.out.println(i1);

        WebElement chargesof1stRPFlight = driver.findElement(By.xpath("//*[@id=\"rt-domrt-jrny\"]/div/div[5]/label/div[2]/div[3]"));
        String s2 = chargesof1stRPFlight.getText();

        s2 = s2.replaceAll("[^a-zA-Z0-9]", "");

        int i2 = Integer.parseInt(s2);
        System.out.println(i2);

        int i3 = i1 + i2;
        //Total charge is
        System.out.println("Total charge is " + i3);

        //Down Prices

        WebElement chargesofdownDPFlight = driver.findElement(By.xpath("//*[@id=\"left-side--wrapper\"]/div/div/div[4]/div/div[1]/div/div[1]/div/div[2]/div[4]/p"));
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
        driver.findElement(By.xpath("//*[@class=\"fli_primary_btn text-uppercase \"]")).click();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[2]/span")).click();
        driver.findElement(By.id("review-continue")).click();

        //adding adults
        driver.findElement(By.xpath("//*[@id=\"wrapper_ADULT\"]/a")).click();
        driver.findElement(By.xpath("//*[@placeholder=\"First & Middle Name\"]")).sendKeys("Adigarla Narasimha");
        driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Murthy");
        driver.findElement(By.xpath("//*[@id=\"MANUAL_bc601132-9148-485d-bba2-b5c5e6ae20de\"]/div[2]/div/div/div[3]/div/div/label[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"wrapper_ADULT\"]/a")).click();
        driver.findElement(By.xpath("//*[@placeholder=\"First & Middle Name\"]")).sendKeys("Adigarla Narasimha");
        driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Murthy");
        driver.findElement(By.xpath("//*[@id=\"MANUAL_bc601132-9148-485d-bba2-b5c5e6ae20de\"]/div[2]/div/div/div[3]/div/div/label[1]")).click();


        //adding child
        driver.findElement(By.xpath("//*[@id=\"wrapper_CHILD\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"MANUAL_2b339011-eb4f-4e0a-8b82-bb56077313d4\"]/div[2]/div/div/div[1]/div/input")).sendKeys("Adigarla Narasimha");
        driver.findElement(By.xpath("//*[@id=\"MANUAL_2b339011-eb4f-4e0a-8b82-bb56077313d4\"]/div[2]/div/div/div[2]/div/input")).sendKeys("Murthy");
        driver.findElement(By.xpath("//*[@id=\"MANUAL_2b339011-eb4f-4e0a-8b82-bb56077313d4\"]/div[2]/div/div/div[3]/div/div/label[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"wrapper_CHILD\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"MANUAL_2b339011-eb4f-4e0a-8b82-bb56077313d4\"]/div[2]/div/div/div[1]/div/input")).sendKeys("Adigarla Narasimha");
        driver.findElement(By.xpath("//*[@id=\"MANUAL_2b339011-eb4f-4e0a-8b82-bb56077313d4\"]/div[2]/div/div/div[2]/div/input")).sendKeys("Murthy");
        driver.findElement(By.xpath("//*[@id=\"MANUAL_2b339011-eb4f-4e0a-8b82-bb56077313d4\"]/div[2]/div/div/div[3]/div/div/label[1]")).click();


        //adding infant
        driver.findElement(By.xpath("//*[@id=\"wrapper_INFANT\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"MANUAL_5e44b2f1-1969-44d2-afca-eb26b9850444\"]/div[2]/div/div[1]/div[1]/div/input")).sendKeys("Adigarla Narasimha");
        driver.findElement(By.xpath("//*[@id=\"MANUAL_5e44b2f1-1969-44d2-afca-eb26b9850444\"]/div[2]/div/div[1]/div[2]/div/input")).sendKeys("Murthy");
        driver.findElement(By.xpath("//*[@id=\"MANUAL_5e44b2f1-1969-44d2-afca-eb26b9850444\"]/div[2]/div/div[1]/div[3]/div/div/label[1]")).click();
        WebElement dd1 = driver.findElement(By.xpath("//*[@class=\"dateDropdown\"]"));

        Select s = new Select(dd1);
        s.selectByVisibleText("11");
        s.selectByVisibleText("Dec");
        s.selectByVisibleText("2019");

        driver.findElement(By.xpath("//*[@id=\"wrapper_INFANT\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"MANUAL_5e44b2f1-1969-44d2-afca-eb26b9850444\"]/div[2]/div/div[1]/div[1]/div/input")).sendKeys("Adigarla Narasimha");
        driver.findElement(By.xpath("//*[@id=\"MANUAL_5e44b2f1-1969-44d2-afca-eb26b9850444\"]/div[2]/div/div[1]/div[2]/div/input")).sendKeys("Murthy");
        driver.findElement(By.xpath("//*[@id=\"MANUAL_5e44b2f1-1969-44d2-afca-eb26b9850444\"]/div[2]/div/div[1]/div[3]/div/div/label[1]")).click();
        WebElement dd2 = driver.findElement(By.xpath("//*[@class=\"dateDropdown\"]"));

        Select s2 = new Select(dd2);
        s2.selectByVisibleText("11");
        s2.selectByVisibleText("Dec");
        s2.selectByVisibleText("2019");


    }

}