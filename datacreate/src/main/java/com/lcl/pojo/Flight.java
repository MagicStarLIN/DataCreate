package com.lcl.pojo;


/**
 * 实体类航班
 * @author liuchanglin
 *
 */
public class Flight {
	private String flightID;//航班号
//	private String startDate;//出发日期
//	private String arriveDate;//到达日期
//	private Passenger passenger;//乘客
	private String fromcity;
	private String arrivecity;
	
	
	
	public Flight() {
	}
	
	public String getFlightID() {
		return flightID;
	}
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
//	public String getStartDate() {
//		return startDate;
//	}
//	public void setStartDate(String startDate) {
//		this.startDate = startDate;
//	}
//	public String getArriveDate() {
//		return arriveDate;
//	}
//	public void setArriveDate(String arriveDate) {
//		this.arriveDate = arriveDate;
//	}
//	public Passenger getPassenger() {
//		return passenger;
//	}
//	public void setPassenger(Passenger passenger) {
//		this.passenger = passenger;
//	}


	public String getFromcity() {
		return fromcity;
	}

	public void setFromcity(String fromcity) {
		this.fromcity = fromcity;
	}

	public String getArrivecity() {
		return arrivecity;
	}

	public void setArrivecity(String arrivecity) {
		this.arrivecity = arrivecity;
	}

	@Override
	public String toString() {
		return "Flight [flightID=" + flightID 
				+ ", fromcity=" + fromcity + ", arrivecity=" + arrivecity + "]";
	}
	
	
	
}
