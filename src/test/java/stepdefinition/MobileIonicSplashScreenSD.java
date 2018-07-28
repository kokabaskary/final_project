package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.mobile_pages.SplashScreen;

public class MobileIonicSplashScreenSD {
    SplashScreen splashScreen = new SplashScreen();


    @Given("^I am on Splash screen of the ionic conference app$")
    public void i_am_on_Splash_screen_of_the_ionic_conference_app(){
        splashScreen.verifyOnSplashScreen(); }

    @When("^I swipe right (.+) times on tutorials slides$")
    public void i_swipe_right_times_on_tutorials_slides(int swipe) {
        splashScreen.swipeAction(swipe); }

    @Then("^I verify Continue button is displayed$")
    public void i_verify_Continue_button_is_displayed(){
        splashScreen.continueButtonIsDisplayed();
    }

}
