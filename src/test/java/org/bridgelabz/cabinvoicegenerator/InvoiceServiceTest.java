package org.bridgelabz.cabinvoicegenerator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class InvoiceServiceTest {
	Ride[] rides = null;
	InvoiceService invoiceService=null;
	InvoiceSummary expectedInvoiceSummary = null;
	private RideRepository rideRepository = null;
	
	@Before
	public void setUp() throws Exception{
		invoiceService = new InvoiceService();
		rideRepository = new RideRepository();
		invoiceService.setRideRepository(rideRepository);
		rides = new Ride[] {
				new Ride(2.0, 5,CabRide.NORMAL),
				new Ride(0.1, 1,CabRide.PREMIUM)
		};

		expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance,time);
		Assert.assertEquals(25.0, fare,0.0);		
	}
	
	@Test
	public void givenLessDistanceOrTime_SHouldReturnMinFare() {
		double distance = 0.1;
		int time =1;
		double fare = invoiceService.calculateFare(distance,time);
		Assert.assertEquals(5,fare,0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5, CabRide.NORMAL), new Ride(0.1, 1, CabRide.NORMAL) };
	    InvoiceSummary summary = invoiceService.calculateFare(rides);
	   InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
	    Assert.assertEquals(expectedInvoiceSummary,summary);
	}
	@Test
	public void givenUsedIdAndRides_ShouldReturnInvoiceSummary() {

		String userId = "Sandeep45";
		Ride[] rides = { new Ride(2.0, 5, CabRide.NORMAL), new Ride(0.1, 1, CabRide.NORMAL) };
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	@Test
	public void givenUserIdAndRidesForBothCategoriesRides_ShouldReturnInvoiceSummary() {
		String userId = "Sandeep45";
		Ride[] rides = { new Ride(2.0, 5, CabRide.NORMAL), new Ride(0.1, 1, CabRide.PREMIUM) };
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
}
