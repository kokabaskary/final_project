package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import stepdefinition.SharedSD;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class BasePage {

	public void clickOn(By locator) {
		try {
			SharedSD.getDriver().findElement(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void sendText(By locator, String text) {
		try {
			SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public String getTextFromElement(By locator) {
		String text = null;
		try {
			text = SharedSD.getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}

	public boolean isElementDisplayed(By locator) {
		return SharedSD.getDriver().findElement(locator).isDisplayed();
	}


	public WebElement findElement(By locator){
		WebElement element = SharedSD.getDriver().findElement(locator);
		return element; }


	public List<WebElement> findElementsAsLists(By locator){
		List<WebElement>  webElements = SharedSD.getDriver().findElements(locator);
		return webElements; }


	public void autoCompleteTitle(By locator,String title) {
		List<WebElement> dropdown = findElementsAsLists(locator);
		for (WebElement ele :dropdown ) {
			if (ele.getText().equalsIgnoreCase(title)) ;
			ele.isDisplayed(); }
	}

	public void emailGenerator(By locator, String email){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		sendText(locator,"username"+ randomInt +"@gmail.com"); }


	public void findelement(By locator){
		SharedSD.getDriver().findElement(locator);
	}

	//getting today's date from calendar
	public String todayDateFromCalendar(){
		Date currentDate = new Date();
        Format sdf = new SimpleDateFormat("d");
		String sdfDate = sdf.format(currentDate);
		return sdfDate;
		}

	public String selectTomorrowDateFromCalendar(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Date newDate = cal.getTime();
		DateFormat format = new SimpleDateFormat("d");
		String tomorrowDate = format.format(newDate);
//		System.out.println(tomorrowDate);
	return tomorrowDate;}

		//getting current time
    public String currentTime(){
		Calendar rightNow = Calendar.getInstance();
		rightNow.get(Calendar.HOUR);
		SimpleDateFormat dateFormat = new SimpleDateFormat("ha");
		String formattedDate = dateFormat.format(rightNow.getTime()).toLowerCase();
		return formattedDate;}


	//getting the actual number of posts that are displayed on the page
	public int numberOfPosts(By locator){
		List<WebElement> posts = findElementsAsLists(locator);
		int postcount = posts.size();
		return postcount;
		}

	//counting if the posts have titles or images with it
	public int countNumberOfItemsOnPosts(By locator){
	List<WebElement> count = findElementsAsLists(locator);
	ArrayList<String> postCount = new ArrayList<>();
	String s = null;
	int  number = count.size();
	for ( int i = 0; i< number; i++){
		s = count.get(i).getText();
		if (s.length()>= 2){
			postCount.add(s); }
	}
	return  postCount.size();
}

    public void clickOnBrowserBackArrow() { SharedSD.getDriver().navigate().back(); }

	public void clickOnBrowserForwardArrow() {
		SharedSD.getDriver().navigate().forward();
	}

	public void refreshBrowser() {
		SharedSD.getDriver().navigate().refresh();
	}
}
