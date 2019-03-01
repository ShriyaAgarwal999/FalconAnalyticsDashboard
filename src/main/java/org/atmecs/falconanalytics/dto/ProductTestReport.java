package org.atmecs.falconanalytics.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="testreport")
public class ProductTestReport {

	String device;
	String testphase;
	String testenvironment;
	String testrunat;
	Date startedat;
	Date finishedat;
	String category;
	String productname;
	int runsessionid;
	Date uploadedat;
	int totalcount;
	int passcount;
	int failcount;
	int skipcount;
	int passpercentage;
	public ProductTestReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductTestReport(String device, String testphase, String testenvironment, String testrunat, Date startedat,
			Date finishedat, String category, String productname, int runsessionid, Date uploadedat, int totalcount,
			int passcount, int failcount, int skipcount, int passpercentage) {
		super();
		this.device = device;
		this.testphase = testphase;
		this.testenvironment = testenvironment;
		this.testrunat = testrunat;
		this.startedat = startedat;
		this.finishedat = finishedat;
		this.category = category;
		this.productname = productname;
		this.runsessionid = runsessionid;
		this.uploadedat = uploadedat;
		this.totalcount = totalcount;
		this.passcount = passcount;
		this.failcount = failcount;
		this.skipcount = skipcount;
		this.passpercentage = passpercentage;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getTestphase() {
		return testphase;
	}
	public void setTestphase(String testphase) {
		this.testphase = testphase;
	}
	public String getTestenvironment() {
		return testenvironment;
	}
	public void setTestenvironment(String testenvironment) {
		this.testenvironment = testenvironment;
	}
	public String getTestrunat() {
		return testrunat;
	}
	public void setTestrunat(String testrunat) {
		this.testrunat = testrunat;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getRunsessionid() {
		return runsessionid;
	}
	public void setRunsessionid(int runsessionid) {
		this.runsessionid = runsessionid;
	}
	public Date getUploadedat() {
		return uploadedat;
	}
	public void setUploadedat(Date uploadedat) {
		this.uploadedat = uploadedat;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getPasscount() {
		return passcount;
	}
	public void setPasscount(int passcount) {
		this.passcount = passcount;
	}
	public int getFailcount() {
		return failcount;
	}
	public void setFailcount(int failcount) {
		this.failcount = failcount;
	}
	public int getSkipcount() {
		return skipcount;
	}
	public void setSkipcount(int skipcount) {
		this.skipcount = skipcount;
	}
	public int getPasspercentage() {
		return passpercentage;
	}
	public void setPasspercentage(int passpercentage) {
		this.passpercentage = passpercentage;
	}
	@Override
	public String toString() {
		return "TestReportModel [device=" + device + ", testphase=" + testphase + ", testenvironment=" + testenvironment
				+ ", testrunat=" + testrunat + ", startedat=" + startedat + ", finishedat=" + finishedat + ", category="
				+ category + ", productname=" + productname + ", runsessionid=" + runsessionid + ", uploadedat="
				+ uploadedat + ", totalcount=" + totalcount + ", passcount=" + passcount + ", failcount=" + failcount
				+ ", skipcount=" + skipcount + ", passpercentage=" + passpercentage + "]";
	}

}
