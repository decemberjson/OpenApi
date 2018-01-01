package odsay.domain.yuri;

import java.util.List;

public class BusSearch {
	private List<BusSearch> result;
	private int count;
	private int startStationID;
	private int endStationID;
	private List<Station> station;
	
	public List<BusSearch> getResult() {
		return result;
	}
	public void setResult(List<BusSearch> result) {
		this.result = result;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStartStationID() {
		return startStationID;
	}
	public void setStartStationID(int startStationID) {
		this.startStationID = startStationID;
	}
	public int getEndStationID() {
		return endStationID;
	}
	public void setEndStationID(int endStationID) {
		this.endStationID = endStationID;
	}
	public List<Station> getStation() {
		return station;
	}
	public void setStation(List<Station> station) {
		this.station = station;
	}
	@Override
	public String toString() {
		return "BusSearch [result=" + result + ", count=" + count + ", startStationID=" + startStationID
				+ ", endStationID=" + endStationID + ", station=" + station + "]";
	}
	
	
}
