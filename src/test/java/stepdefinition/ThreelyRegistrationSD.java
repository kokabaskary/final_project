package stepdefinition;



import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.ThreelyHomePage;
import framework.web_pages.ThreelyRegistrationPage;
import org.testng.Assert;

public class ThreelyRegistrationSD {

    private ThreelyRegistrationPage registrationPage = new ThreelyRegistrationPage();
    private ThreelyHomePage homePage = new ThreelyHomePage();


    @When("^I am on Registration page$")
    public void iAmOnRegistrationPage() {
        homePage.clickJoinButton();
        Assert.assertEquals(registrationPage.getSignUpTitle(), "Signup", "invalid page"); }

    @When("^I enter  the name as (.+) the email as (.+) the password as (.+)$")
    public void iEnterNameAsEmailAsPasswordAs(String name, String email, String password) {
        registrationPage.enterNameAtSignUp(name);
        registrationPage.randomEmailGenarator(email);
        registrationPage.enterPasswordAtSignUp(password);
    }

    @When("^I click 'submit' button$")
    public void iClickSubmitButton()  {
        registrationPage.clickSubmitButtonToSignUp(); }

    @Then("^I am signed-in as a new user$")
    public void iAmSignedInAsANewUser() {
        homePage.userNameIsDisplayed();
       }

    @When("^I enter name as (.+) emails as (.+) password as (.+)$")
    public void iEnterDataIntoTextFields(String name, String email, String password) {
        registrationPage.enterNameAtSignUp(name);
        registrationPage.enterEmailAtSignUp(email);
        registrationPage.enterPasswordAtSignUp(password);
    }

    @Then("^I verify invalid email address$")
    public void iVerifyInvalidEmailAddress() {
        Assert.assertTrue(registrationPage.invalidLogin());
    }



}

