package framework;

import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import stepdefinition.SharedSD;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MobileBasePage {

    /**
     * This is a constructor which initializes initPageElements()
     */
    public MobileBasePage() {
        initPageElements();
    }

    /**
     * This method handles wait functionality for mobile actions, which means if the element is not found
     * during test then the app will re-try and wait up to 15 seconds before failing the test step
     */
    protected void initPageElements() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumWrapper.getAppiumDriver(), 15, TimeUnit.SECONDS), this);
    }

    /**
     * This method is used to tap on element
     *
     * @param mobileElement element to tap on
     */
    protected void tapOn(MobileElement mobileElement) {
        try {
            mobileElement.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }

    /**
     * This method is used to set value in text field
     *
     * @param mobileElement
     * @param setValue
     */
    protected void setValue(MobileElement mobileElement, String setValue) {

        try {
            mobileElement.sendKeys(setValue);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }

    public  void findMobileElement(MobileBy locator){
        AppiumWrapper.getAppiumDriver().findElement(locator); }


//    public void findMobileElements(MobileBy locator){
//        AppiumWrapper.getAppiumDriver().findElements(MobileBy.xpath("//UIAWindow[1]/*"
////        AppiumWrapper.getAppiumDriver().findElements(locator);
//    }


    public enum DIRECTION {
        DOWN, UP, LEFT, RIGHT
    }

    public static void swipe(DIRECTION direction, long duration) {

       AppiumDriver driver1 = AppiumWrapper.getAppiumDriver();
        Dimension size = driver1.manage().window().getSize();
//
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;
//
        switch (direction) {
            case RIGHT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.90);
                endX = (int) (size.width * 0.05);
                new TouchAction(driver1)
                        .press(startX, startY)
                        .waitAction(Duration.ofMillis(duration))
                        .moveTo(endX, startY)
                        .release()
                        .perform();
                break;

            case LEFT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.05);
                endX = (int) (size.width * 0.90);
                new TouchAction(driver1)
                        .press(startX, startY)
                        .waitAction(Duration.ofMillis(duration))
                        .moveTo(endX, startY)
                        .release()
                        .perform();
                break;

            case UP:
                endY = (int) (size.height * 0.70);
                startY = (int) (size.height * 0.30);
                startX = (size.width / 2);
                new TouchAction(driver1)
                        .press(startX, startY)
                        .waitAction(Duration.ofMillis(duration))
                        .moveTo(endX, startY)
                        .release()
                        .perform();
                break;

            case DOWN:
                startY = (int) (size.height * 0.70);
                endY = (int) (size.height * 0.30);
                startX = (size.width / 2);
                new TouchAction(driver1)
                        .press(startX, startY)
                        .waitAction(Duration.ofMillis(duration))
                        .moveTo(startX, endY)
                        .release()
                        .perform();
                break;

        }
    }



}
