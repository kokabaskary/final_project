package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.mobile_pages.IonicHomePage;
import framework.mobile_pages.SplashScreen;

public class MobileIonicHomePageSD {

    SplashScreen splashScreen = new SplashScreen();
    IonicHomePage ionicHomePage = new IonicHomePage();

    @Given("^I am on home page of the app$")
    public void i_am_on_home_page_of_the_app() throws InterruptedException {
     splashScreen.tapOnContinueButton();
    Thread.sleep(1000);}

    @When("^I click on hamburger menu$")
    public void i_click_on_hamburger_menu() { ionicHomePage.tapOnMainMenuButton(); }
//
    @Then("^I verify default main menu bar fields$")
    public void i_verify_default_main_menu_bar_fields() throws InterruptedException { ionicHomePage.verifyDefaultMainMenuFields();

    Thread.sleep(1000);}

    @When("^I click on filter button$")
    public void iClickOnFilterButton() throws InterruptedException {
        ionicHomePage.tapFilterButton();
        Thread.sleep(5000); }

    @Then("^I disable (.+) option$")
    public void iDisableOption(String text){ ionicHomePage.angularDisable(text); }
//
    @Then("^I click on All Reset Filer button$")
    public void iClickOnAllResetFilerButton() throws InterruptedException { ionicHomePage.resetAllFilter();
        Thread.sleep(3000);
    }
//
    @Then("^I verify all options are enabled$")
    public void iVerifyAllOptionsAreEnabled() throws InterruptedException {
        ionicHomePage.allOptionsAreEnabled();
        Thread.sleep(5000);
    }
//
    @When("^Search for (.+)$")
    public void searchFor(String event){ ionicHomePage.searchField(event);}

    @Then("^I verify Event displayed with header, Duration, description$")
    public void iVerifyEventDisplayedWithHeaderDurationDescription() throws InterruptedException {
        Thread.sleep(1000);
      ionicHomePage.searchFieldVerification(); }

}
