package by.htp.belavia_test.steps;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import by.htp.belavia_test.entity.OneWayTrip;
import by.htp.belavia_test.entity.OneWayTripInfo;
import by.htp.belavia_test.entity.OneWayTripNew;
import by.htp.belavia_test.pages.StartPage;



public class Steps {
	private WebDriver driver;

	public Steps(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void oneWayRequest(Calendar departureData, Set<OneWayTrip> listTicket) {
		StartPage startPage = new StartPage(driver);
		startPage.goToPage();
		startPage.fillFrom();
		startPage.fillTo();
		startPage.pickOneWayTrip();
		startPage.pickDate(departureData);
		startPage.submitRequestForm();
		startPage.captchaInput();
		OneWayTripInfo infoPage = new OneWayTripInfo(driver);
		infoPage.flightInfo(departureData, listTicket);
	}
	
	public void oneWayRequestNewDate(Calendar departureData, Calendar departureDataFinish,  Set<OneWayTrip> listTicket) {
		Calendar departureDataNext = (Calendar) departureData.clone();
		Calendar departureDataFinishNext = (Calendar) departureDataFinish.clone();
		departureDataNext.add(Calendar.DAY_OF_MONTH, 1);
		departureDataFinishNext.add(Calendar.DAY_OF_MONTH, 1);
		while (!departureDataNext.equals(departureDataFinishNext)) {
			OneWayTripNew startPageNew = new OneWayTripNew(driver);
			startPageNew.pickDate(departureDataNext);
			startPageNew.submitRequestForm();
			startPageNew.captchaInput();
			OneWayTripInfo infoPage = new OneWayTripInfo(driver);
			infoPage.flightInfo(departureDataNext, listTicket);
			infoPage.captchaInput();
			departureDataNext.add(Calendar.DAY_OF_MONTH, 1);
		}
	}

	public void printListOfFlights(Set<OneWayTrip> listTicket) {
		int count = 1;
		for (Iterator<OneWayTrip> iterator = listTicket.iterator(); iterator.hasNext();) {
			OneWayTrip flight = (OneWayTrip) iterator.next();
			System.out.println(count+"  "+flight.toString());
			count++;
		}
	}
}
