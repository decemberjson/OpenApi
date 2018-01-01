package odsay.domain.yuri;

public class Station {
	private String startTerminal;
	private String destTerminal;
	private String wasteTime;
	private String normalFare;
	private String specialFare;
	private String nightFare;
	private String nightSpecialFare;
	private String schedule;
	private String nightSchedule;
	
	
	public String getStartTerminal() {
		return startTerminal;
	}
	public void setStartTerminal(String startTerminal) {
		this.startTerminal = startTerminal;
	}
	public String getDestTerminal() {
		return destTerminal;
	}
	public void setDestTerminal(String destTerminal) {
		this.destTerminal = destTerminal;
	}
	public String getWasteTime() {
		return wasteTime;
	}
	public void setWasteTime(String wasteTime) {
		this.wasteTime = wasteTime;
	}
	public String getNormalFare() {
		return normalFare;
	}
	public void setNormalFare(String normalFare) {
		this.normalFare = normalFare;
	}
	public String getSpecialFare() {
		return specialFare;
	}
	public void setSpecialFare(String specialFare) {
		this.specialFare = specialFare;
	}
	public String getNightFare() {
		return nightFare;
	}
	public void setNightFare(String nightFare) {
		this.nightFare = nightFare;
	}
	public String getNightSpecialFare() {
		return nightSpecialFare;
	}
	public void setNightSpecialFare(String nightSpecialFare) {
		this.nightSpecialFare = nightSpecialFare;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getNightSchedule() {
		return nightSchedule;
	}
	public void setNightSchedule(String nightSchedule) {
		this.nightSchedule = nightSchedule;
	}
	@Override
	public String toString() {
		return "Station [startTerminal=" + startTerminal + ", destTerminal=" + destTerminal + ", wasteTime=" + wasteTime
				+ ", normalFare=" + normalFare + ", specialFare=" + specialFare + ", nightFare=" + nightFare
				+ ", nightSpecialFare=" + nightSpecialFare + ", schedule=" + schedule + ", nightSchedule="
				+ nightSchedule + "]";
	}
	
	
}
