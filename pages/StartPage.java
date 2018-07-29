package by.htp.belavia_test.pages;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends AbstractPage {
	
	private static final String URL = "https://en.belavia.by/";

	private static final By FROM = By.xpath("//*[@id=\"OriginLocation_Combobox\"]");
	private static final By FROM_ELEMENT = By.xpath("/html/body/ul[1]/li[1]");

	private static final By TO = By.xpath("//*[@id=\"DestinationLocation_Combobox\"]");
	private static final By TO_ELEMENT = By.xpath("/html/body/ul[2]/li[1]");

	private static final By CALENDAR = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/div");
	private static final By DEPARTURE_DATE = By
			.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form/div[2]/div[2]/div[1]/div/a/i");

	private static final By CALENDAR_NEXT = By
			.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/div/div[2]/div/a/i");

	private static final By RADIO_BUTTON = By
			.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form/div[2]/div[1]/div/label");

	private static final By REQUEST_FORM = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form");
	
	public StartPage(WebDriver driver) {
		super(driver);
	}
	
	public void goToPage() {
		driver.get(URL);
	}


	public void fillFrom() {
		WebElement elem = driver.findElement(FROM);
		elem.sendKeys("Minsk");
		try {
			driver.findElement(FROM_ELEMENT).click();
		} catch (Exception e) {
			driver.findElement(FROM_ELEMENT).click();
		}

	}

	public void fillTo() {
		WebElement elem = driver.findElement(TO);
		elem.sendKeys("Riga");
		try {
			driver.findElement(TO_ELEMENT).click();
		} catch (Exception e) {
			driver.findElement(TO_ELEMENT).click();
		}

	}

	public void pickOneWayTrip() {
		List<WebElement> radioButtoList = driver.findElements(RADIO_BUTTON);
		radioButtoList.get(0).click();
	}

	public void pickDate(Calendar date) {
		String month = date.getDisplayName(2, 2, new Locale("English", "US"));
		int year = date.get(1);
		int month_number = date.get(2);
		int day = date.get(5);
		WebElement datePicker = driver.findElement(DEPARTURE_DATE);
		datePicker.click();
		WebElement calendar = driver.findElement(CALENDAR);

		while (!calendar.getText().contains(month + " " + year)) {
			driver.findElement(CALENDAR_NEXT).click();
		}
		String dataXpath = "/html/body/div[4]/div[1]/div/div/div[2]/div/div/div/table/tbody/tr/td[@data-month='"
				+ month_number + "']/a[contains(text(),'" + day + "')]";
		WebElement data = driver.findElement(By.xpath(dataXpath));
		data.click();
	}

	public void submitRequestForm() {
		driver.findElement(REQUEST_FORM).submit();
	}
}
