package framework.mobile_pages;

import framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;


public class SplashScreen extends MobileBasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Welcome to ICA']")
    private MobileElement welcomeText;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SKIP ']")
    private MobileElement skip;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='CONTINUE arrow forward ']")
    private MobileElement continueButton;



    public void verifyOnSplashScreen(){

        try {
            Assert.assertTrue(welcomeText.isDisplayed());
        }catch (AssertionError e){
            Assert.fail("Continue Button is not displayed");
        } }

        //method for calling swipe from mobile base page and do swipe 3 times
    public void swipeAction(int numberofswipes){
        for (int i=0;i<=numberofswipes;i++){
            swipe(DIRECTION.RIGHT, 2000); }

    }

    public void tapOnContinueButton(){ tapOn(continueButton); }


    public void continueButtonIsDisplayed(){
        try {
            Assert.assertTrue(continueButton.isDisplayed());
        }catch (AssertionError e){
            Assert.fail("Continue Button is not displayed");
        }}


///    public void iamOnHomePage(){
//        for (int j = 0; j<=3;j++){
//            swipe(DIRECTION.RIGHT, 2000);
//        }
//        tapOn(continueButton);
//    }
//


}




































