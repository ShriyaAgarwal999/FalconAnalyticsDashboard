package org.atmecs.falconanalytics.dto;

public class TestcaseDetails {

	private String name;
	private String status;
	private String exceptionmessage;
	private int runsessionid;
	private int number;
	
	public TestcaseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestcaseDetails(String name, String status, String exceptionmessage, int runsessionid, int number) {
		super();
		this.name = name;
		this.status = status;
		this.exceptionmessage = exceptionmessage;
		this.runsessionid = runsessionid;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExceptionmessage() {
		return exceptionmessage;
	}
	public void setExceptionmessage(String exceptionmessage) {
		this.exceptionmessage = exceptionmessage;
	}
	public int getRunsessionid() {
		return runsessionid;
	}
	public void setRunsessionid(int runsessionid) {
		this.runsessionid = runsessionid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "TestcaseDetails [name=" + name + ", status=" + status + ", exceptionmessage=" + exceptionmessage
				+ ", runsessionid=" + runsessionid + ", number=" + number + "]";
	}	
}
