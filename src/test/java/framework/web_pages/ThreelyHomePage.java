package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
    private By usernamedisplay = By.xpath("//a[@href='/profile']");

    public void clickJoinButton() {
        clickOn(joinbutton);
    } //when on home page click join button to goto signup page

    public void clickSignInButton() {
        clickOn(signinbutton);
    } //click signin button to go to signin page


    public boolean userNameIsDisplayed() {
     clickOnImageCircleButton();
     return isElementDisplayed(usernamedisplay); }


    public boolean isLogoutButtonDisplayed() { return isElementDisplayed(logoutbutton); }

    public void clickOnImageCircleButton() {
        clickOn(imagecircle);
    }

    //auto complete method
    public void autoComplete(String auto) {
        clickOn(threelysearchbartextfield);
        sendText(threelysearchbartextfield, auto); }

    public boolean autoCompleteTitleDropdown(String title){
        autoCompleteTitle(autocompletedropdown,title);
         return true; }

    //method for counting number of posts displayed on the home page
    public int postsOnHomePage() { return numberOfPosts(postsonpage); }

    //for getting if all posts have images display
    public int postsWithImages() {
        List imagelist = findElementsAsLists(imagesonposts);
        ArrayList<WebElement> images = new ArrayList(imagelist);
        int imagecount = images.size();
        for (int i = 0; i<=imagecount; i++){ }
            return imagecount; }

    //method for getting price tags from posts
    public int postContainsPriceTags() { return countNumberOfItemsOnPosts(pricetagsonposts); }


    //method for getting posts with a title
    public int postsTitle(){ return countNumberOfItemsOnPosts(titleonposts); }

}
