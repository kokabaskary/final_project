package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class DarkSkyHomePage extends BasePage {


    private By timemachine = By.xpath(" //a[@class='button']");
    private By calendar = By.xpath("//*[@id=\"timeMachine\"]/div[3]//tbody//descendant::*");
    private By todaytimeline = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]");
    private By expandtimeline = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]/span[3]");
    private By mintemp = By.xpath("//*[@id=\"week\"]/a[1]/span[2]/span[1]");
    private By mintempontodaytimeline = By.xpath("//*[@id=\"week\"]/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]");
    private By maxtemp = By.xpath("//*[@id=\"week\"]/a[1]/span[2]/span[3]");
    private By maxtempontodaytimeline = By.xpath("//*[@id=\"week\"]/div[2]/div[1]/div[2]/div[1]/span[3]/span[1]");
    private By timeline  = By.xpath("//div[@class='hours']//following-sibling::*//span[2]");

        //click on time machine button
    public void clickOnTimeMachineButton(){
        clickOn(timemachine);}

    //confirming that today's date is displayed in the calendar
    public void confirmTodayDate() {
        String todaydate = todayDateFromCalendar();//calling today's date from base page

        List<WebElement> tdate = findElementsAsLists(calendar);
        try {
            for (WebElement date1 : tdate) {
                String expectedDate = date1.getText();
                if (expectedDate.equals(todaydate)) {
                    date1.isSelected();

                    System.out.println(todaydate);
                    System.out.println(expectedDate);
                    break; }
            }}catch (AssertionError error){
            Assert.fail("Today's Date is not been Displayed");
        }}

        //finding today timeline and clicking/expanding on the + image to expand
    public void expandTodayTimeLine() {
        findElement(todaytimeline);
        findElement(expandtimeline).click(); }


        //method for verifying both min temps displayed are same
    public void minTempVerification(){
        String mintempexpanded = findElement(mintemp).getText();
        String mintempontimeline = findElement(mintempontodaytimeline).getText();
        try {
//            if (mintempontimeline.equals(mintempexpanded)){
                Assert.assertEquals(mintempontimeline,mintempexpanded);
                System.out.println("min temp  on expanded :" + mintempexpanded  +" min temp on time line : " + mintempontimeline);
            } catch (AssertionError e){
            e.printStackTrace(); } }

    //method for verifying both max temps displayed are same
    public void maxTempVerification(){
        String maxtempexpanded = findElement(maxtemp).getText();
        String maxtempontimeline = findElement(maxtempontodaytimeline).getText();
        try {
//            if (maxtempontimeline.equals(maxtempexpanded)){
                Assert.assertEquals(maxtempontimeline, maxtempexpanded);
                System.out.println("max temp  on expanded :" + maxtempexpanded  + " min temp on time line : " + maxtempontimeline);
            } catch (AssertionError e){
            e.printStackTrace(); } }

    public void timeLineWithTwoHoursIncrement() {

        List<WebElement> elements = findElementsAsLists(timeline);
        ArrayList<String> elementsinarraylist = new ArrayList<>();
        String loop = null;
        int size = elements.size();
        for (int i = 0; i <size-1; i++){
            loop = elements.get(i).getText();
            elementsinarraylist.add(loop);}
        System.out.println(elementsinarraylist);

            String looptime = null;
            ArrayList<String> newTimeList = new ArrayList();
            Calendar cal = Calendar.getInstance();
            for (int j = 0; j < 11; j++) {
                cal.add(Calendar.HOUR, 2);
                DateFormat dateFormat = new SimpleDateFormat("ha");
                looptime=dateFormat.format(cal.getTime()).toLowerCase();
                newTimeList.add(looptime);}
        System.out.println(newTimeList);


            try {
//
                Assert.assertEquals(elementsinarraylist, newTimeList);
                System.out.println("Time on the timeline is being incremented by 2 hours");
            }catch (AssertionError error) {
                Assert.fail("Time on the timeline is NOT being incremented by 2 hours");
            }}}





