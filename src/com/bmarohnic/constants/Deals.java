package com.bmarohnic.constants;

public enum Deals {
	Fridays("TGI Fridays", "Buy One Get One", "24th Street", "2013-09-01"),
	Tuesdays("Ruby Tuesdays", "Fifty Percent Off", "25th Street", "2013-09-02"),
	LongHorn("Long Horn Steakhouse", "Twenty-five Percent Off", "26th Street", "2013-09-03");
	
	private final String dealLocation;
	private final String dealDescription;
	private final String dealAddress;
	private final String dealDate;
	
	private Deals(String dealLocation, String dealDescription, String dealAddress, String dealDate){
		this.dealLocation = dealLocation;
		this.dealDescription = dealDescription;
		this.dealAddress = dealAddress;
		this.dealDate = dealDate;
		
	}

	public String setDealDescription() {
		return dealDescription;
	}

	public String setDealAddress() {
		return dealAddress;
	}

	public String setDealDate() {
		return dealDate;
	}

	public String setDealLocation() {
		return dealLocation;
	}
}
