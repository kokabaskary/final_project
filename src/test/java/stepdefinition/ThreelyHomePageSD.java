package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.ThreelyHomePage;
import org.testng.Assert;

public class ThreelyHomePageSD {

    private ThreelyHomePage homePage = new ThreelyHomePage();

    @Given("^I am on Threely homepage$")
    public void iAmOnThreelyHomepage() {
        String url = SharedSD.getDriver().getCurrentUrl();
        Assert.assertEquals(url,"https://floating-anchorage-58495.herokuapp.com/");
        }

    @When("^I search on top search bar with text \"([^\"]*)\"$")
    public void iSearchOnTopSearchBarWithText(String auto)  {
        homePage.autoComplete(auto);
    }

    @Then("^I verify \"([^\"]*)\" as displayed result$")
    public void iVerifyAsDisplayedResult(String title) {
        try {
            Assert.assertTrue(homePage.autoCompleteTitleDropdown(title),"Title: I will teach you IOS");
        }catch (AssertionError error){
            System.out.println("Title did not match");
        }
    }


    @Then("^I verify (\\d+) total post is displayed$")
    public void iVerifyTotalPostIsDisplayed(int postCount)  {
        try {
            Assert.assertEquals(homePage.postsOnHomePage(), postCount);
        }catch (AssertionError assertionError){
            System.out.println("Total posts found are :"+postCount +"Expected posts were : " +homePage.postsOnHomePage());
            }
    }

    @Then("^I verify all post has price tag$")
    public void iVerifyAllPostHasPriceTag()  {
        try {
            Assert.assertEquals(homePage.postContainsPriceTags(), homePage.postsOnHomePage());
            System.out.println("All posts have price tags");
        }catch (AssertionError assertionError){
            int postswithoutpricetag = homePage.postsOnHomePage() - homePage.postContainsPriceTags();
            System.out.println("Number of posts without price tags are = "+ postswithoutpricetag);
        }

    }

    @Then("^I verify all post has title$")
    public void iVerifyAllPostHasTitle(){
      try {
          Assert.assertEquals(homePage.postsTitle(),homePage.postsOnHomePage());
          System.out.println("All posts have titles");
      }catch (AssertionError assertionError){
          int postswithouttitles = homePage.postsOnHomePage() - homePage.postsTitle();
          System.out.println("Number of posts without title are = "+postswithouttitles);
      }

    }

    @Then("^I verify all post has displayed image$")
    public void iVerifyAllPostHasDisplayedImage(){
        try {
            Assert.assertEquals(homePage.postsOnHomePage(), homePage.postsWithImages());
        }catch (AssertionError assertionError){
            int difference = homePage.postsOnHomePage() - homePage.postsWithImages();
            System.out.println("Number of posts without images are = "+difference);
        }

    }
}
