package odsay.domain.yuri;

import java.util.List;

public class BusTerminal {
	private List<BusTerminal> result;
	private int stationID;
	private String stationName;
	private double x;
	private double y;
	private boolean haveDestinationTerminals;
	private List<BusTerminal> destinationTerminals;
	
	
	public List<BusTerminal> getResult() {
		return result;
	}
	public void setResult(List<BusTerminal> result) {
		this.result = result;
	}
	public int getStationID() {
		return stationID;
	}
	public void setStationID(int stationID) {
		this.stationID = stationID;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
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
	public boolean isHaveDestinationTerminals() {
		return haveDestinationTerminals;
	}
	public void setHaveDestinationTerminals(boolean haveDestinationTerminals) {
		this.haveDestinationTerminals = haveDestinationTerminals;
	}
	public List<BusTerminal> getDestinationTerminals() {
		return destinationTerminals;
	}
	public void setDestinationTerminals(List<BusTerminal> destinationTerminals) {
		this.destinationTerminals = destinationTerminals;
	}
	@Override
	public String toString() {
		return "BusTerminal [result=" + result + ", stationID=" + stationID + ", stationName=" + stationName + ", x="
				+ x + ", y=" + y + ", haveDestinationTerminals=" + haveDestinationTerminals + ", destinationTerminals="
				+ destinationTerminals + "]";
	}
}
