package org.atmecs.falconanalytics.dto;

import java.util.Arrays;

public class ProductTestIdPercent {
	
	private int passPercent[];
	private int runSessionId[];
	
	public ProductTestIdPercent(int[] passPercent, int[] runSessionId) {
		super();
		this.passPercent = passPercent;
		this.runSessionId = runSessionId;
	}
	public ProductTestIdPercent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int[] getPassPercent() {
		return passPercent;
	}
	public void setPassPercent(int[] passPercent) {
		this.passPercent = passPercent;
	}
	public int[] getRunSessionId() {
		return runSessionId;
	}
	public void setRunSessionId(int[] runSessionId) {
		this.runSessionId = runSessionId;
	}
	@Override
	public String toString() {
		return "IdPercentModel [passPercent=" + Arrays.toString(passPercent) + ", runSessionId="
				+ Arrays.toString(runSessionId) + "]";
	}
}
