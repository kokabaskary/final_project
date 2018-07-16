package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;
import stepdefinition.SharedSD;

import java.util.Random;

public class ThreelyRegistrationPage extends BasePage {


    //locators  required for registration/signing up
    private By signupnametextfield = By.xpath("//input[@type='text']");
    private By signupemailtextfield =  By.xpath("//input[@type='email']");
    private By signuppasswordtextfield = By.xpath("//input[@type='password']");
    private By signupsubmitbutton = By.xpath("//*[@type='submit']");
    private By signuppagetitle = By.xpath("//*[@class='space-top text-center']");
//


    public String getSignUpTitle(){ return getTextFromElement(signuppagetitle); }//to verify I am on registration/signup page
    public void enterNameAtSignUp(String name){sendText(signupnametextfield,name);} //for entering name in name text field
    public void enterEmailAtSignUp(String email){sendText(signupemailtextfield, email);} //for entering email in email text field
    public void enterPasswordAtSignUp(String password){sendText(signuppasswordtextfield, password);}//for entering valid password at signup
    public void clickSubmitButtonToSignUp(){clickOn(signupsubmitbutton);} //@signup page click submit button to register as new user

//    to generate random email for a valid registration
    public void emailGenerator(String email){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        sendText(signupemailtextfield,"username"+ randomInt +"@gmail.com");
    }

     //to verify if signed up as new user click image on homepage to verify your name is displayed
    public boolean invalidLogin(){ return SharedSD.getDriver().findElement(signuppagetitle).isDisplayed();
    }

}
