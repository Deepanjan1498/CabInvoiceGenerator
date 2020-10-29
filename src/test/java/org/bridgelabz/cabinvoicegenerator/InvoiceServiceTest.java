package org.bridgelabz.cabinvoicegenerator;


import org.junit.Assert;
import org.junit.Test;
public class InvoiceServiceTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(25.0, fare,0.0);		
	}
	
	@Test
	public void givenLessDistanceOrTime_SHouldReturnMinFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time =1;
		double fare = invoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(5,fare,0.0);
	}
}
