package by.htp.belavia_test.entity;

import java.util.Calendar;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.belavia_test.pages.AbstractPage;

public class OneWayTripNew extends AbstractPage {
	private static final By CALENDAR = By.xpath("/html/body/div[4]/div/div/div/div");

	private static final By CALENDAR_NEXT = By.xpath("/html/body/div[4]/div/div/div/div/div[2]/div/a/i");

	private static final By DEPARTURE_DATE = By.xpath("/html/body/div[4]/div/div/form/div[3]/div[1]");

	private static final By REQUEST_FORM = By.xpath("/html/body/div[4]/div/div/form");

	public OneWayTripNew(WebDriver driver) {
		super(driver);
	}

	public void pickDate(Calendar date) {

		String month = date.getDisplayName(2, 2, new Locale("English", "US"));
		int year = date.get(1);
		int month_number = date.get(2);
		int day = date.get(5);

		WebElement datePicker = driver.findElement(DEPARTURE_DATE);
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("arguments[0].scrollIntoView()", datePicker);
		datePicker.click();

		WebElement calendar = driver.findElement(CALENDAR);

		while (!calendar.getText().contains(month + " " + year)) {
			driver.findElement(CALENDAR_NEXT).click();
		}

		String dataXpath = "/html/body/div[4]/div/div/div/div/div/table/tbody/tr/td[@data-month='" + month_number
				+ "']/a[contains(text(),'" + day + "')]";
		WebElement data = driver.findElement(By.xpath(dataXpath));
		data.click();
	}

	public void submitRequestForm() {
		driver.findElement(REQUEST_FORM).submit();
	}
}
