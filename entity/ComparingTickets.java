package by.htp.belavia_test.entity;

import java.util.Comparator;


public class ComparingTickets implements Comparator<OneWayTrip>{
	
	@Override
	public int compare(OneWayTrip ticket1, OneWayTrip ticket2) {
		if (ticket1.getDate().equals(ticket2.getDate()))
			return -1;
		return ticket1.getDate().compareTo(ticket2.getDate());
	}
}
