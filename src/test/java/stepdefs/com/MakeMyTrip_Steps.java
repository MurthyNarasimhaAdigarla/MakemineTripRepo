package stepdefs.com;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import utils.com.MakemyTrip_Utils;
import static utils.com.BaseClass.*;

public class MakeMyTrip_Steps extends MakemyTrip_Utils {


    @Given("^I login website as a guest user$")
    public void i_login_website_as_a_guest_user() throws Throwable {
        opening_MakeMyTrip_Site();
        click_on_flights_link_and_click_on_round_trip();
    }


    @When("^I enter flight names from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iEnterFlightNamesFromTo(String fromCity, String toCity) throws Throwable {
        entering_Flights_Names(fromCity, toCity);

    }

    @When("^I select passenger details$")
    public void iSelectPassengerDetails() throws InterruptedException {
        selecting_PassengersCount();
    }

    @And("^I print Daparture and Return flight details$")
    public void iPrintDapartureAndReturnFlightDetails() {
        //Printing departure and returm flights
        System.out.println("********************Before checking non stop and 1 stop options**********************");
        gettingListofDepartureandReturnFlights();
    }


    @And("^I print Daparture and Return flight details after Selecting Non-Stop and one Stop filter options$")
    public void iPrintDapartureAndReturnFlightDetailsAfterSelectingNonStopAndOneStopFilterOptions() throws InterruptedException {
        //checking non stop and 1 stop options
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@data-filtertext,'collapsed_stop_nonStop')]")).click();
        System.out.println("********************After checking non stop and 1 stop options**********************");
        gettingListofDepartureandReturnFlights();

    }

    @And("^I print Daparture and Return flight details after unselecting non stop and one stop filter$")
    public void iPrintDapartureAndReturnFlightDetailsAfterUnselectingNonStopAndOneStopFilter() throws InterruptedException {
        Unchecking_1_stop_and_getting_last_flight_details();
    }

    @And("^I verify price info for Daparture and Return flight details$")
    public void iVerifyPriceInfoForDapartureAndReturnFlightDetails() throws InterruptedException {
        verifing_Prices();

    }

    @And("^I verify total amount of price$")
    public void iVerifyTotalAmountOfPrice() {


    }

    @And("^I book and continue$")
    public void iBookAndContinue() throws InterruptedException {
        booking();
    }
}

