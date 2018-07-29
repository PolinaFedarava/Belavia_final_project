package by.htp.belavia_test.entity;

import java.util.Calendar;
import java.util.Iterator;


public class OneWayTrip implements Comparable<OneWayTrip> {
	
	public OneWayTrip() {
		super();
		
	}

	private Calendar date;
	private String ticketType;
	private Double price;
	
	public OneWayTrip(Calendar date, String ticketType, Double price) {
		super();
		this.date = date;
		this.ticketType = ticketType;
		this.price = price;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((ticketType == null) ? 0 : ticketType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OneWayTrip other = (OneWayTrip) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (ticketType == null) {
			if (other.ticketType != null)
				return false;
		} else if (!ticketType.equals(other.ticketType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OneWayTrip [date=" + date + ", ticketType=" + ticketType + ", price=" + price + "]";
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void add(OneWayTrip oneWayTrip) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(OneWayTrip t) {
		if (this.price.equals(t.price))
			return -1;
		return (int) (this.price.compareTo(t.price));
	}

	
	
	
	
	

}
