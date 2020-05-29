package utils.com;

import org.openqa.selenium.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MakemyTrip_Utils {

    public static WebDriver driver;

    public static void scroll() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,480)");

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
        List<WebElement> dateSelection = driver.findElements(By.xpath("//*[@class=\"dateDropdown\"]"));


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


            firstAdultNames.get(5).sendKeys("AdigarlaaInfant");
            lastAdultNames.get(5).sendKeys("MurthyyInfant");
            genderButn.get(10).click();

            driver.findElement(By.xpath("//*[contains(@class,'dropdown__value-container')]/div[contains(.,'Date')]/parent::div")).sendKeys("2");
            driver.findElement(By.xpath("//*[contains(@class,'dropdown__value-container')]/div[contains(.,'Month')]/parent::div")).sendKeys("Mar");


        }




}}