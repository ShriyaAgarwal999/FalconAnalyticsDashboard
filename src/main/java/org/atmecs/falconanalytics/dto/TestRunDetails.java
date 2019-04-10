package org.atmecs.falconanalytics.dto;

//import java.util.Arrays;
import java.util.List;

public class TestRunDetails {

	private List<Integer> totalcount;
	private List<Integer> passcount;
	private List<Integer> failcount;
	private List<Integer> skipcount;
	private List<Integer> passPercent;
	private int totalRuns;
	public TestRunDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestRunDetails(List<Integer> totalcount, List<Integer> passcount, List<Integer> failcount,
			List<Integer> skipcount, List<Integer> passPercent, int totalRuns) {
		super();
		this.totalcount = totalcount;
		this.passcount = passcount;
		this.failcount = failcount;
		this.skipcount = skipcount;
		this.passPercent = passPercent;
		this.totalRuns = totalRuns;
	}
	public List<Integer> getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(List<Integer> totalcount) {
		this.totalcount = totalcount;
	}
	public List<Integer> getPasscount() {
		return passcount;
	}
	public void setPasscount(List<Integer> passcount) {
		this.passcount = passcount;
	}
	public List<Integer> getFailcount() {
		return failcount;
	}
	public void setFailcount(List<Integer> failcount) {
		this.failcount = failcount;
	}
	public List<Integer> getSkipcount() {
		return skipcount;
	}
	public void setSkipcount(List<Integer> skipcount) {
		this.skipcount = skipcount;
	}
	public List<Integer> getPassPercent() {
		return passPercent;
	}
	public void setPassPercent(List<Integer> passPercent) {
		this.passPercent = passPercent;
	}
	public int getTotalRuns() {
		return totalRuns;
	}
	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}
	@Override
	public String toString() {
		return "TestRunDetails [totalcount=" + totalcount + ", passcount=" + passcount + ", failcount=" + failcount
				+ ", skipcount=" + skipcount + ", passPercent=" + passPercent + ", totalRuns=" + totalRuns + "]";
	}
}
