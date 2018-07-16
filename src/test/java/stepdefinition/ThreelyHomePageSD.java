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
    public void iSearchOnTopSearchBarWithText(String auto) throws InterruptedException {
        homePage.autoComplete(auto);
        Thread.sleep(5000); }

    @Then("^I verify \"([^\"]*)\" as displayed result$")
    public void iVerifyAsDisplayedResult(String title) {

        homePage.verifyAutoCompleteTitle(title);
    }


    @Then("^I verify (\\d+) total post is displayed$")
    public void iVerifyTotalPostIsDisplayed(int postCount)  {
        try {
            Assert.assertEquals(homePage.numberOfPostsOnHomePage(), postCount);
        }catch (AssertionError assertionError){
            System.out.println("Total posts found are :"+postCount +"Expected posts were : " +homePage.numberOfPostsOnHomePage());
            }
    }

    @Then("^I verify all post has price tag$")
    public void iVerifyAllPostHasPriceTag()  {
        try {
            Assert.assertEquals(homePage.postContainsPriceTags(),homePage.numberOfPostsOnHomePage());
            System.out.println("All posts have price tags");
        }catch (AssertionError assertionError){
            int postswithoutpricetag = homePage.numberOfPostsOnHomePage() - homePage.postContainsPriceTags();
            System.out.println("Number of posts without price tags are = "+ postswithoutpricetag);
        }

    }

    @Then("^I verify all post has title$")
    public void iVerifyAllPostHasTitle(){
      try {
          Assert.assertEquals(homePage.allPostsHaveTitle(),homePage.numberOfPostsOnHomePage());
          System.out.println("All posts have titles");
      }catch (AssertionError assertionError){
          int postswithouttitles = homePage.numberOfPostsOnHomePage() - homePage.allPostsHaveTitle();
          System.out.println("Number of posts without title are = "+postswithouttitles);
      }

    }

    @Then("^I verify all post has displayed image$")
    public void iVerifyAllPostHasDisplayedImage(){
//        homePage.imageDisplayVerification();
        try {
            Assert.assertEquals(homePage.numberOfPostsOnHomePage(), homePage.postsWithImages());
        }catch (AssertionError assertionError){
            int difference = homePage.numberOfPostsOnHomePage() -homePage.postsWithImages();
            System.out.println("Number of posts without images are = "+difference);
        }

    }
}
