package by.htp.belavia_test.tests;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import by.htp.belavia_test.driver.DriverSingleton;
import by.htp.belavia_test.entity.ComparingTickets;
import by.htp.belavia_test.entity.OneWayTrip;
import by.htp.belavia_test.steps.Steps;


public class TestOneWay {
	
	protected static WebDriver driver;
	protected Steps steps;

	private static final Calendar DATE = new GregorianCalendar(2018, 7, 1, 0, 0, 0);
	private static final Calendar FINISH_DATE = new GregorianCalendar(2018, 7, 5, 0, 0, 0);
	
	@BeforeTest
	public void initDriver() {
		driver = DriverSingleton.getDriver();
		steps = new Steps(driver);
		System.out.println("initDriver");
	}
	
	@Parameters({ "SortResults" })
	@Test
	public void OneWayInfoTest(@Optional("1") int SortResults) {
		System.out.println("Period " + DATE.getTime() + " - " + FINISH_DATE.getTime());
		
		Set<OneWayTrip> listTicket = new TreeSet<>();
		if (SortResults == 1) {
			listTicket = new TreeSet<>(); 
		}
		if (SortResults == 2) {
			listTicket = new TreeSet<> (new ComparingTickets ());

		}

		steps.oneWayRequest(DATE, listTicket);
		steps.oneWayRequestNewDate(DATE, FINISH_DATE, listTicket);
		steps.printListOfFlights(listTicket);
	}

	@AfterTest
	public void closeDriver() {
		System.out.println("Driver close!");
		driver.quit();
		driver = null;
	}
}
