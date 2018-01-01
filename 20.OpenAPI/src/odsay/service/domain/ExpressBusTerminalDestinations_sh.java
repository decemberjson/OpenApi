package odsay.service.domain;

import java.util.Arrays;
import java.util.List;

public class ExpressBusTerminalDestinations_sh {
	
	private List<String> stationName;
	private double[] x;
	private double[] y;
	private int[] stationID;
	
	
	/// Constructor
	public ExpressBusTerminalDestinations_sh() {
		
	}

	public List<String> getStationName() {
		return stationName;
	}

	public void setStationName(List<String> stationName) {
		this.stationName = stationName;
	}

	public double[] getX() {
		return x;
	}

	public void setX(double[] x) {
		this.x = x;
	}

	public double[] getY() {
		return y;
	}

	public void setY(double[] y) {
		this.y = y;
	}

	public int[] getStationID() {
		return stationID;
	}

	public void setStationID(int[] stationID) {
		this.stationID = stationID;
	}

	@Override
	public String toString() {
		return "ExpressBusTerminalDestinations_sh [stationName=" + stationName + ", x=" + Arrays.toString(x) + ", y="
				+ Arrays.toString(y) + ", stationID=" + Arrays.toString(stationID) + "]";
	}

	

	
	
}
