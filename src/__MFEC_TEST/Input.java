package __MFEC_TEST;

public class Input {
	private String strName = null, startDT = null, endDT = null, startDate = null, endDate = null, startTime = null,
			endTime = null;

	public Input(String strName, String startDate, String startTime, String endDate, String endTime) {
		this.strName = strName;
		this.startDT = startDate + " " + startTime;
		this.endDT = endDate + " " + endTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getName() {
		return strName;
	}

	public String getStartDT() {
		return startDT;
	}

	public String getEndDT() {
		return endDT;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}
}
