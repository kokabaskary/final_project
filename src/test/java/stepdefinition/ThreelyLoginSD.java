package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.ThreelyHomePage;
import framework.web_pages.ThreelyLoginPage;
import org.testng.Assert;

public class ThreelyLoginSD {

    private ThreelyHomePage homePage = new ThreelyHomePage();
    private ThreelyLoginPage loginPage = new ThreelyLoginPage();

    @When("^User is on the Threely login page$")
    public void user_is_on_the_Threely_login_page() {
        homePage.clickSignInButton();

        Assert.assertEquals(loginPage.getLogInTitle(), "Login", "invalid page");
    }

    @When("^I enter  email as (.+) password as (.+)$")
    public void i_enter_email_as_password_as(String email, String password) {
        loginPage.enterEmailSignIn(email);
        loginPage.enterPasswordSignIn(password);
    }

    @When("^I click submit$")
    public void iClickSubmit() {
        loginPage.clickSubmitButtonOnSignIn();
    }

    @When("^I click on image circle button$")
    public void clickOnImageCircleButton() {
        homePage.clickOnImageCircleButton();
    }

    @Then("^I verify logout button is displayed$")
    public void i_verify_logout_button_is_displayed() {
        Assert.assertTrue(homePage.isLogoutButtonDisplayed(), "Unable to display logout button");
    }
}
