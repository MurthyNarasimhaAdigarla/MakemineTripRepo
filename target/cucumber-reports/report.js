$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/Features/MakeMyTrip.feature");
formatter.feature({
  "line": 1,
  "name": "To test MakeMytrip",
  "description": "",
  "id": "to-test-makemytrip",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "To test features of makemytrip",
  "description": "",
  "id": "to-test-makemytrip;to-test-features-of-makemytrip",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I login website as a guest user",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter flight names from \"Chennai\" to \"Hyderabad\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I select passenger details",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I print Daparture and Return flight details",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I print Daparture and Return flight details after Selecting Non-Stop and one Stop filter options",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I print Daparture and Return flight details after unselecting non stop and one stop filter",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I verify price info for Daparture and Return flight details",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I verify total amount of price",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I book and continue",
  "keyword": "And "
});
formatter.match({
  "location": "MakeMyTrip_Steps.i_login_website_as_a_guest_user()"
});
formatter.result({
  "duration": 12306357500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Chennai",
      "offset": 27
    },
    {
      "val": "Hyderabad",
      "offset": 40
    }
  ],
  "location": "MakeMyTrip_Steps.iEnterFlightNamesFromTo(String,String)"
});
formatter.result({
  "duration": 1450323000,
  "status": "passed"
});
formatter.match({
  "location": "MakeMyTrip_Steps.iSelectPassengerDetails()"
});
formatter.result({
  "duration": 1846374900,
  "status": "passed"
});
formatter.match({
  "location": "MakeMyTrip_Steps.iPrintDapartureAndReturnFlightDetails()"
});
formatter.result({
  "duration": 5517594800,
  "error_message": "java.lang.NullPointerException\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:450)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementsByXPath(RemoteWebDriver.java:517)\r\n\tat org.openqa.selenium.By$ByXPath.findElements(By.java:356)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:402)\r\n\tat utils.com.BaseClass.gettingListofDepartureandReturnFlights(BaseClass.java:91)\r\n\tat stepdefs.com.MakeMyTrip_Steps.iPrintDapartureAndReturnFlightDetails(MakeMyTrip_Steps.java:35)\r\n\tat ✽.And I print Daparture and Return flight details(src/main/resources/Features/MakeMyTrip.feature:8)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "MakeMyTrip_Steps.iPrintDapartureAndReturnFlightDetailsAfterSelectingNonStopAndOneStopFilterOptions()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MakeMyTrip_Steps.iPrintDapartureAndReturnFlightDetailsAfterUnselectingNonStopAndOneStopFilter()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MakeMyTrip_Steps.iVerifyPriceInfoForDapartureAndReturnFlightDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MakeMyTrip_Steps.iVerifyTotalAmountOfPrice()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MakeMyTrip_Steps.iBookAndContinue()"
});
formatter.result({
  "status": "skipped"
});
});