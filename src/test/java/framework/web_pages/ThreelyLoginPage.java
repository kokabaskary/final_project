package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;
import stepdefinition.SharedSD;

public class ThreelyLoginPage extends BasePage {

     //locators for login


    private By emailaddressdignin = By.xpath("//input[@type='email']");
    private By passwordtextfieldsignin = By.xpath("//input[@type='password']");
    private By submitbuttonsignin = By.xpath("//button[@type='submit']");
    private By logintitle = By.xpath("//*[@class='space-top text-center']");

    public String getLogInTitle(){
        return getTextFromElement(logintitle);
    } //verify on signin page

    public  void enterEmailSignIn(String email){ sendText(emailaddressdignin, email); } //signin email

    public void enterPasswordSignIn(String password){ sendText(passwordtextfieldsignin, password); }//signin password

    public void clickSubmitButtonOnSignIn(){ clickOn(submitbuttonsignin); }//submit button for signin

}
