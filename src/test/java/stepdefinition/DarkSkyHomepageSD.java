package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.DarkSkyHomePage;
import org.testng.Assert;

public class DarkSkyHomepageSD {


    private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("^I am on Darksky home page$")
    public void i_am_on_Darksky_home_page()  {
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky - 260 Broadway, New York City, NY", "Invalid Home page");}

        @When("^I click on Time Machine$")
        public void i_click_on_Time_Machine() {
        darkSkyHomePage.clickOnTimeMachineButton(); }

    @Then("^I verify date is selected to today's date$")
    public void i_verify_date_is_selected_to_todays_date() {
        darkSkyHomePage.confirmTodayDate();
    }

    @When("^I expand todays timeline$")
    public void i_expand_todays_timeline() {
        darkSkyHomePage.expandTodayTimeLine();
        }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void i_verify_lowest_and_highest_temp_is_displayed_correctly() {
       darkSkyHomePage.minTempVerification();
       darkSkyHomePage.maxTempVerification();
       }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented(){
        darkSkyHomePage.timeLineWithTwoHoursIncrement();
    }



}

