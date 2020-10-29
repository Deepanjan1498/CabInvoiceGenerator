package org.bridgelabz.cabinvoicegenerator;

public class InvoiceGenerator {

	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KILOMETER = 10;

	public double calculateFare(double distance, int time) {
		// TODO Auto-generated method stub
		return distance * MINIMUM_COST_PER_KILOMETER+ time * COST_PER_TIME;
				
	}

}
