package org.bridgelabz.cabinvoicegenerator;

public class InvoiceSummary {
	private int noOfRides;
	private double totalFare;
	private double averageFare;

	public InvoiceSummary(int numOfRides, double totalFare) {
		
	}

	public InvoiceSummary(int noOfRides, double totalFare, double averageFare) {
		super();
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.averageFare = averageFare;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (noOfRides != other.noOfRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}

}
