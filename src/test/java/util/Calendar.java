//package util;
//
//import framework.BasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import stepdefinition.SharedSD;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//public class Calendar  {
//
//









//    public void selectSixDaysFromTomorrow() throws InterruptedException {
//    Calendar calendar = Calendar.getInstance();
//    calendar.add(Calendar.DATE, 4);
//
//    Date date = calendar.getTime();
//    DateFormat dateFormat = new SimpleDateFormat("d");
//    String seventhDateFromTomorrow = dateFormat.format(date);
//
//    SharedSD.getDriver().findElement(By.xpath(".//*[@id='qf-0q-localised-check-out']")).click();
//    List<WebElement> days = SharedSD.getDriver().findElements(By.xpath(".//*[@class='widget-datepicker-bd']/descendant::a"));
//    for (WebElement day :days) {
//        String expectedDate = day.getText();
//        if (expectedDate.equals(seventhDateFromTomorrow)) {
//            day.click();
//            Thread.sleep(9000);
//            break;
//        } }
//}
//    public void selectTomorrowDateFromCalendar() throws InterruptedException {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, 1);
//
//        Date date = calendar.getTime();
//        DateFormat dateFormat = new SimpleDateFormat("d");
//        String tomorrowDate = dateFormat.format(date);
//
//        SharedSD.getDriver().findElement(By.xpath(".//*[@id='qf-0q-localised-check-in']")).click();
//        List<WebElement> days = SharedSD.getDriver().findElements(By.xpath(".//*[@class='widget-datepicker-bd']/descendant::a"));
//        for (WebElement day :days) {
//            String expectedDate = day.getText();
//            if (expectedDate.equals(tomorrowDate)){
//                day.click();
//                Thread.sleep(6000);
//                break;
//            } }
//    }

//    }
