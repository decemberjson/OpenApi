package odsay.service.domain;

public class ExpressBusTerminal_sh {
	
	private int language;
	private String terminalName;
	private int departureStationID;
	private String departureStationName;
	private double departureTerminalX;
	private double departureTerminalY;
	private boolean haveDestinationTerminals;
	private int arriveStationID;
	private String arriveStationName;
	private double arriveTerminalX;
	private double arriveTerminalY;

	public ExpressBusTerminal_sh() {
		
	}
	
	
	
	
	public int getLanguage() {
		return language;
	}

	public void setLanguage(int lang) {
		this.language = lang;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public int getDepartureStationID() {
		return departureStationID;
	}

	public void setDepartureStationID(int departureStationID) {
		this.departureStationID = departureStationID;
	}

	public String getDepartureStationName() {
		return departureStationName;
	}

	public void setDepartureStationName(String departureStationName) {
		this.departureStationName = departureStationName;
	}

	public double getDepartureTerminalX() {
		return departureTerminalX;
	}

	public void setDepartureTerminalX(double departureTerminalX) {
		this.departureTerminalX = departureTerminalX;
	}

	public double getDepartureTerminalY() {
		return departureTerminalY;
	}

	public void setDepartureTerminalY(double departureTerminalY) {
		this.departureTerminalY = departureTerminalY;
	}

	public boolean isHaveDestinationTerminals() {
		return haveDestinationTerminals;
	}

	public void setHaveDestinationTerminals(boolean haveDestinationTerminals) {
		this.haveDestinationTerminals = haveDestinationTerminals;
	}

	public int getArriveStationID() {
		return arriveStationID;
	}

	public void setArriveStationID(int arriveStationID) {
		this.arriveStationID = arriveStationID;
	}

	public String getArriveStationName() {
		return arriveStationName;
	}

	public void setArriveStationName(String arriveStationName) {
		this.arriveStationName = arriveStationName;
	}

	public double getArriveTerminalX() {
		return arriveTerminalX;
	}

	public void setArriveTerminalX(double arriveTerminalX) {
		this.arriveTerminalX = arriveTerminalX;
	}

	public double getArriveTerminalY() {
		return arriveTerminalY;
	}

	public void setArriveTerminalY(double arriveTerminalY) {
		this.arriveTerminalY = arriveTerminalY;
	}




	@Override
	public String toString() {
		return "ExpressBusTerminal_sh [language=" + language + ", terminalName=" + terminalName
				+ ", departureStationID=" + departureStationID + ", departureStationName=" + departureStationName
				+ ", departureTerminalX=" + departureTerminalX + ", departureTerminalY=" + departureTerminalY
				+ ", haveDestinationTerminals=" + haveDestinationTerminals + ", arriveStationID=" + arriveStationID
				+ ", arriveStationName=" + arriveStationName + ", arriveTerminalX=" + arriveTerminalX
				+ ", arriveTerminalY=" + arriveTerminalY + ", getLanguage()=" + getLanguage() + ", getTerminalName()="
				+ getTerminalName() + ", getDepartureStationID()=" + getDepartureStationID()
				+ ", getDepartureStationName()=" + getDepartureStationName() + ", getDepartureTerminalX()="
				+ getDepartureTerminalX() + ", getDepartureTerminalY()=" + getDepartureTerminalY()
				+ ", isHaveDestinationTerminals()=" + isHaveDestinationTerminals() + ", getArriveStationID()="
				+ getArriveStationID() + ", getArriveStationName()=" + getArriveStationName()
				+ ", getArriveTerminalX()=" + getArriveTerminalX() + ", getArriveTerminalY()=" + getArriveTerminalY()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
