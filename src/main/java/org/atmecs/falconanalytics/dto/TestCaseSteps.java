package org.atmecs.falconanalytics.dto;

public class TestCaseSteps {
	
	private String description;
	private String type;
	public TestCaseSteps() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestCaseSteps(String description, String type) {
		super();
		this.description = description;
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
