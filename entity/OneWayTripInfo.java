package by.htp.belavia_test.entity;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.belavia_test.pages.AbstractPage;

public class OneWayTripInfo extends AbstractPage {
	private static final By INFO_TABLE = By.xpath("/html/body/div[4]/div/form/div[1]/div/div[3]/div");

	private static final By BACK_BUTTON = By.xpath("/html/body/div[4]/div/form/div[3]/div[1]/button");

	private static final By TOTAL_PRICE = By
			.xpath("/html/body/div[4]/div/form/div[2]/table/tbody/tr[1]/td[4]/div[2]/span[1]");

	private static final By DEPARTURE_TIME = By
			.xpath("/html/body/div[4]/div/form/div[1]/div/div[3]/div/div[1]/div[1]");

	private static final By TICKETS_AVALIABLE = By.xpath("//div/div/label[contains(text(),'BYN')]");

	private static final By CLASS_INFO = By.xpath("/html/body/div[4]/div/form/div[1]/div/div[3]/div/div[2]/div/a");

	public OneWayTripInfo(WebDriver driver) {
		super(driver);
	}

	public void flightInfo(Calendar date,   Set<OneWayTrip> listTicket) {
		Calendar departure = (Calendar) date.clone();
		WebElement departureTimeInfo = driver.findElement(DEPARTURE_TIME);
		String departureTime = departureTimeInfo.getText().trim().split("\n")[1];
		String[] hoursMinits = departureTime.trim().split(":");
		int departureHours = new Integer(hoursMinits[0]);
		int departureMinits = new Integer(hoursMinits[1]);
		departure.add(Calendar.HOUR, departureHours);
		departure.add(Calendar.MINUTE, departureMinits);
		// System.out.println("Departure time: " + departureTime);

		WebElement element = driver.findElement(INFO_TABLE);
		List<WebElement> ticketsAvaliable = element.findElements(TICKETS_AVALIABLE);
		List<WebElement> classInfo = driver.findElements(CLASS_INFO);
		OneWayTrip oneWayTrip;
		for (int i = 0; i < ticketsAvaliable.size(); i++) {
			oneWayTrip = new OneWayTrip();
			oneWayTrip.setDate(departure);
			try {
				ticketsAvaliable.get(i).click();
			} catch (Exception e) {
				ticketsAvaliable.get(i).click();
			}

			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.elementToBeClickable(BACK_BUTTON));

			WebElement totalPrice = driver.findElement(TOTAL_PRICE);

			String priceString = totalPrice.getText().trim();
			Double price = new Double(priceString);
			oneWayTrip.setPrice(price);
			WebElement ticketClass = classInfo.get(i);
			String tClass = ticketClass.getAttribute("data-rel");
			oneWayTrip.setTicketType(tClass);
			listTicket.add(oneWayTrip);
		}

		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(BACK_BUTTON));
		WebElement backButton = driver.findElement(BACK_BUTTON);
		backButton.click();

}}
