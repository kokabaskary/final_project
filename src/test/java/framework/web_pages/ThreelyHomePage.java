package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ThreelyHomePage extends BasePage {

    private By threelysearchbartextfield = By.xpath("//input[@type='search']");//top search bar locator
    private By autocompletedropdown = By.xpath("//span[@id='algolia-autocompletedropdown-listbox-0']");//top search dropdown
    private By postsonpage = By.xpath("//div[@class='gig-card']");//number of posts on page
    private By imagesonposts = By.tagName("img");//images on posts
    private By pricetagsonposts = By.xpath("//*[contains(text(),'$')]");//price tags on posts
    private By titleonposts = By.xpath("//div[@class='row']//div[1]//h4[1]"); //titles on posts
    private By joinbutton = By.xpath("//a[@class='btn btn-success']");
    private By signinbutton = By.xpath("//a[@href='/login']");
    private By imagecircle = By.xpath("//img[@class='img-circle']");
    private By logoutbutton = By.xpath("//a[@href='/logout']");

    public void clickJoinButton() {
        clickOn(joinbutton);
    } //when on home page click join button to goto signup page

    public void clickSignInButton() {
        clickOn(signinbutton);
    } //click signin button to go to signin page


    public void userNameIsDisplayed() {
        SharedSD.getDriver().findElement(imagecircle).isDisplayed();
    }

    public boolean isLogoutButtonDisplayed() {

        return isElementDisplayed(logoutbutton);
    }

    public void clickOnImageCircleButton() {
        clickOn(imagecircle);
    }

    //auto complete method
    public void autoComplete(String auto) {
        clickOn(threelysearchbartextfield);
        sendText(threelysearchbartextfield, auto);
    }

    //verifying expected title is displayed
    public void verifyAutoCompleteTitle(String title) {

        List<WebElement> dropdown = SharedSD.getDriver().findElements(autocompletedropdown);
        try {
            for (WebElement ele : dropdown) {
                if (ele.getText().equalsIgnoreCase("Title: I will teach you IOS")) {
                    ele.isDisplayed();
                }
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found :");
            e.printStackTrace();
        }
    }

    //method for counting number of posts displayed on the home page
    public int numberOfPostsOnHomePage() {
        List<WebElement> posts = SharedSD.getDriver().findElements(postsonpage);
        int postcount = posts.size();

        return postcount;
    }

    //for getting if all posts have images display
    public int postsWithImages() {
        List<WebElement> images = SharedSD.getDriver().findElements(imagesonposts);
        int imagecount = images.size();

        for (WebElement img : images) {
            img.isDisplayed();
        }
        return imagecount;
    }

    //method for getting price tags from posts
    public int postContainsPriceTags() {
        List<WebElement> pricetag = SharedSD.getDriver().findElements(pricetagsonposts);
        ArrayList<String> withpricetag = new ArrayList<>();
        String price = null;

        int tags = pricetag.size();

        for (int i = 0; i < tags; i++) {
            price = pricetag.get(i).getText();
            if (price.length() >= 2) {
                withpricetag.add(price);
            }
        }
        return withpricetag.size();
    }

    //method for verifying if all posts have titles
    public int allPostsHaveTitle() {
        List<WebElement> title = SharedSD.getDriver().findElements(titleonposts);
        ArrayList<String> postsWithTitle = new ArrayList<>();
        int titlecount = title.size();
        for (WebElement titles : title) {
            String ti = titles.getText();
            if (ti.length() >= 1) {
                postsWithTitle.add(ti);
            }
        }
        return postsWithTitle.size();
    }
}
