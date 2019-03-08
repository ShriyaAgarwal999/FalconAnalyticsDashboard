package org.atmecs.falconanalytics.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("test")
public class TestReportProperties {
	
	private String goMessage="Ready to deploy";
	private String noMessage="Not Ready for deployment";
	private int smokePassPercent=95;
	private int regressionPassPercent=95;
	private int noOfTestcases=5;
	
	public String getGoMessage() {
		return goMessage;
	}

	public void setGoMessage(String message) {
		this.goMessage = message;
	}

	public String getNoMessage() {
		return noMessage;
	}

	public void setNoMessage(String noMessage) {
		this.noMessage = noMessage;
	}

	public int getSmokePassPercent() {
		return smokePassPercent;
	}

	public void setSmokePassPercent(int smokePassPercent) {
		this.smokePassPercent = smokePassPercent;
	}

	public int getRegressionPassPercent() {
		return regressionPassPercent;
	}

	public void setRegressionPassPercent(int regressionPassPercent) {
		this.regressionPassPercent = regressionPassPercent;
	}

	public int getNoOfTestcases() {
		return noOfTestcases;
	}

	public void setNoOfTestcases(int noOfTestcases) {
		this.noOfTestcases = noOfTestcases;
	}
	

}
