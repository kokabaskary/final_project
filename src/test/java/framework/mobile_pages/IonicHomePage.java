package framework.mobile_pages;

import framework.AppiumWrapper;
import framework.MobileBasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class IonicHomePage extends MobileBasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='menu ']")
    private MobileElement mainMenuButton;

    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    private MobileElement mainMenuFields;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='options ']")
    private MobileElement filterButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Angular']")
    private MobileElement angular;

//    @AndroidFindBy(xpath = "//android.view.View//android.widget.Button[@content-desc='Reset All Filters ']")
//    @AndroidFindBy(accessibility = "Reset All Filters ")
//    @AndroidFindBy(xpath = "//android.view.View[@index='5']/android.widget.Button[@index='31']")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Reset All Filters ']")
    private MobileElement resetfilter;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search']")
    private MobileElement searchBar;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Breakfast 8:00 am — 9:00 am: Main hallway ']")
    private MobileElement breakfastDropDown;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Breakfast']")
    private MobileElement header;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='8:00 am - 9:00 am']")
    private MobileElement duration;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Main hallway']")
    private MobileElement description;




    public void tapOnMainMenuButton(){ tapOn(mainMenuButton); }

    public void verifyDefaultMainMenuFields(){
        List<MobileElement> menubarfields = AppiumWrapper.getAppiumDriver().findElements(MobileBy.xpath("//android.widget.FrameLayout//android.view.View"));
        ArrayList<String> menu = new ArrayList<>();
        String menubar = null;
        System.out.println(menubarfields);
        int list = menubarfields.size();
        for (int j= 0; j<list; j++){
            menubar = menubarfields.get(j).getText();
            menu.add(menubar);
            }
        System.out.println(menu);
//       try {
//           for (MobileElement ele: menubarfields) {
//               Assert.assertTrue(ele.isDisplayed());
////               System.out.println(ele);
//               break;
//           } }catch (AssertionError error){
//                   Assert.fail("All main menu bar fields are not displayed"); }
    }

    public void iamonhomepage(){
        for(int i=0; i<3;i++){
        swipe(DIRECTION.RIGHT,2000);
    }}

    public void tapFilterButton(){ tapOn(filterButton); }

    public void angularDisable(String value){

        if (angular.isEnabled()){
            tapOn(angular);
            System.out.println("Angular button is now disabled");
        }else {
            System.out.println("Angular button is disabled");
        } }


    public void resetAllFilter(){

        swipe(DIRECTION.DOWN,1000);
        tapOn(resetfilter); }

    public void  allOptionsAreEnabled(){
//        List<MobileElement> alloptions =  (MobileElement)AppiumWrapper.getAppiumDriver().findElementsByXPath("//*[@class='android.view.View' AND @index='5']");
        List<MobileElement> elements = AppiumWrapper.getAppiumDriver().findElements(MobileBy.xpath("//android.widget.CheckBox"));
        System.out.println(elements);
        for (MobileElement mobile:elements) {
            if (!mobile.isEnabled()){
                tapOn(mobile);
            }
            else { System.out.println("All Mobile elements are enabled");

            } }
 }

        public void searchField(){
        tapOn(searchBar);}

        public void searchField(String text){
            tapOn(searchBar);
            setValue(searchBar,text);}
//            searchBar.setValue(text); }

        public void searchFieldVerification() {
            tapOn(breakfastDropDown);
            try {
                Assert.assertTrue(header.isDisplayed());
                Assert.assertTrue(duration.isDisplayed());
                Assert.assertTrue(description.isDisplayed());
            } catch (AssertionError error) {
                Assert.fail("Event is not displayed properly"); }
        }

    }









