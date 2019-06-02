package com.lcl.service;


import com.lcl.bo.Citys;
import com.lcl.pojo.Flight;
import com.lcl.util.CitysUtil;
import com.lcl.util.FlightUtil;

public class FlightCreate {
	/**
	 * 创建一个航班对象
	 * @return
	 */
	public static Flight CreateFlight() {
		Flight flight = new Flight();
		flight.setFlightID(FlightUtil.getflightId());
		Citys c = CitysUtil.getCitysRandom();
		flight.setFromcity(c.getFromCity());
		flight.setArrivecity(c.getArriveCity());
		return flight;
	}
}
