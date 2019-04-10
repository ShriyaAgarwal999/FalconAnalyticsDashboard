package org.atmecs.falconanalytics.dto;

import java.util.Date;

public class TestcaseDetails {

	private int number;
	private String name;
	private String status;
	private int durationms;
	private Date startedat;
	private Date finishedat;
	private String exceptionmessage;
	private String exceptiontrace;
	private String modulename;
	private String customername;
	private String browser;
	private String os;
	private int runsessionid;
	
	public TestcaseDetails(int number, String name, String status, int durationms, Date startedat, Date finishedat,
			String exceptionmessage, String exceptiontrace, String modulename, String customername, String browser,
			String os, int runsessionid) {
		super();
		this.number = number;
		this.name = name;
		this.status = status;
		this.durationms = durationms;
		this.startedat = startedat;
		this.finishedat = finishedat;
		this.exceptionmessage = exceptionmessage;
		this.exceptiontrace = exceptiontrace;
		this.modulename = modulename;
		this.customername = customername;
		this.browser = browser;
		this.os = os;
		this.runsessionid = runsessionid;
	}
	public TestcaseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
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
	public int getDurationms() {
		return durationms;
	}
	public void setDurationms(int durationms) {
		this.durationms = durationms;
	}
	public Date getStartedat() {
		return startedat;
	}
	public void setStartedat(Date startedat) {
		this.startedat = startedat;
	}
	public Date getFinishedat() {
		return finishedat;
	}
	public void setFinishedat(Date finishedat) {
		this.finishedat = finishedat;
	}
	public String getExceptionmessage() {
		return exceptionmessage;
	}
	public void setExceptionmessage(String exceptionmessage) {
		this.exceptionmessage = exceptionmessage;
	}
	public String getExceptiontrace() {
		return exceptiontrace;
	}
	public void setExceptiontrace(String exceptiontrace) {
		this.exceptiontrace = exceptiontrace;
	}
	public String getModulename() {
		return modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public int getRunsessionid() {
		return runsessionid;
	}
	public void setRunsessionid(int runsessionid) {
		this.runsessionid = runsessionid;
	}
	@Override
	public String toString() {
		return "TestcaseDetails [number=" + number + ", name=" + name + ", status=" + status + ", durationms="
				+ durationms + ", startedat=" + startedat + ", finishedat=" + finishedat + ", exceptionmessage="
				+ exceptionmessage + ", exceptiontrace=" + exceptiontrace + ", modulename=" + modulename
				+ ", customername=" + customername + ", browser=" + browser + ", os=" + os + ", runsessionid="
				+ runsessionid + "]";
	}
}
