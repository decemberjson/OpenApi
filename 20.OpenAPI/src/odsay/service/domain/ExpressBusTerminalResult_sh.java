package odsay.service.domain;

import java.util.List;

public class ExpressBusTerminalResult_sh {
	
	private boolean haveDestinationTerminals;
	private double x;
	private double y;
	private String stationName;
	private int stationID;
	
	private List<String> destinationTerminals;

	/// Constructor
	public ExpressBusTerminalResult_sh() {
		
	}

	
	public boolean isHaveDestinationTerminals() {
		return haveDestinationTerminals;
	}

	public void setHaveDestinationTerminals(boolean haveDestinationTerminals) {
		this.haveDestinationTerminals = haveDestinationTerminals;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getStationID() {
		return stationID;
	}

	public void setStationID(int stationID) {
		this.stationID = stationID;
	}

	public List<String> getDestinationTerminals() {
		return destinationTerminals;
	}

	public void setDestinationTerminals(List<String> destinationTerminals) {
		this.destinationTerminals = destinationTerminals;
	}


	@Override
	public String toString() {
		return "ExpressBusTerminal_sh [haveDestinationTerminals=" + haveDestinationTerminals
				+ ", x=" + x + ", y=" + y + ", stationName=" + stationName + ", stationID=" + stationID + "]";
	}

	
	
	
}
