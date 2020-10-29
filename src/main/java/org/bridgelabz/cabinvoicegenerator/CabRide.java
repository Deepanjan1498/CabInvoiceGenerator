package org.bridgelabz.cabinvoicegenerator;

public enum CabRide {
	NORMAL(10.0, 1.0, 5.0), PREMIUM(15.0, 2.0, 20.0);

	private final double ratePerKm;
	private final double ratePerMin;
	private final double minimumFarePerRide;

	CabRide(double ratePerKm, double ratePerMin, double minimumFarePerRide) {
		this.ratePerKm = ratePerKm;
		this.ratePerMin = ratePerMin;
		this.minimumFarePerRide = minimumFarePerRide;
	}

	public double calculateCostOfCabRide(Ride ride) {
		double rideCost = ride.distance * ratePerKm + ride.time * ratePerMin;
		return Math.max(rideCost, minimumFarePerRide);
	}

}
