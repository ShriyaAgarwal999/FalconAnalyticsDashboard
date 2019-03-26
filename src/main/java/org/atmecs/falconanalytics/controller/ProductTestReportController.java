package org.atmecs.falconanalytics.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.atmecs.falconanalytics.dto.ProductTestIdPercent;
import org.atmecs.falconanalytics.dto.ProductTestReport;
import org.atmecs.falconanalytics.dto.ProductTestResponse;
import org.atmecs.falconanalytics.properties.TestReportProperties;
import org.atmecs.falconanalytics.repositories.ProductTestReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testReport")
public class ProductTestReportController {
	
	//product collection bean
	@Autowired
	ProductTestReportRepository testReportRepository;
	
	//test report collection bean
	@Autowired
	TestReportProperties properties; 
	
	//method to show the response based on the product test phase and test pass percentage 
	@GetMapping("/get/{runSessionId}")
	public ProductTestResponse result(@PathVariable("runSessionId")int runSessionId ) {		
		ProductTestReport testReportModel= testReportRepository.findByRunsessionid(runSessionId);
		if(testReportModel.getTestphase().equals("Regression") && 
				testReportModel.getPasspercentage()>properties.getRegressionPassPercent())
			return new ProductTestResponse(properties.getGoMessage(),testReportModel.getTestphase(),
					testReportModel.getPasspercentage());
		else if(testReportModel.getTestphase().equals("Smoke") && 
				testReportModel.getPasspercentage()==properties.getSmokePassPercent())
			return new ProductTestResponse(properties.getGoMessage(),testReportModel.getTestphase(),
					testReportModel.getPasspercentage());
		return new ProductTestResponse(properties.getNoMessage(),testReportModel.getTestphase(),
				testReportModel.getPasspercentage());
	}
	
	//method to return test pass percent array and corresponding run session id array for analytics purpose
	@GetMapping("/getDetails")
	public ProductTestIdPercent analysis(@RequestParam("productName") String productName,@RequestParam("noOfRuns") int noOfRuns ) {
		List<ProductTestReport> testReportsDetails= testReportRepository.findByProductnameOrderByRunsessionidDesc(productName);
		Iterator<ProductTestReport> reports = testReportsDetails.iterator();
		int testPassPercent[]=new int[noOfRuns];
		int testRunId[]=new int[noOfRuns];
		int position=0;
		ProductTestReport productTestReport;
		while (reports.hasNext() && noOfRuns>0) {
			productTestReport=reports.next();
			testPassPercent[position]=productTestReport.getPasspercentage();
			testRunId[position]=productTestReport.getRunsessionid();
			position++;
			noOfRuns--;
		}
		return new ProductTestIdPercent(testPassPercent,testRunId);
	}
	
	@GetMapping("/getTestphaseDetails")
	public ProductTestIdPercent testPhase(@RequestParam("productName") String productName,@RequestParam("noOfRuns") int noOfRuns, @RequestParam("testphase") String testphase ) {
		List<ProductTestReport> testReportsDetails= testReportRepository.findByProductnameOrderByRunsessionidDesc(productName);
		Iterator<ProductTestReport> reports = testReportsDetails.iterator();
		int testPassPercent[]=new int[noOfRuns];
		int testRunId[]=new int[noOfRuns];
		int position=0;
		ProductTestReport productTestReport;
		while (reports.hasNext() && noOfRuns>0) {
			productTestReport=reports.next();
			if(productTestReport.getTestphase().equals(testphase) && productTestReport.getRunsessionid()>0) {
				testPassPercent[position]=productTestReport.getPasspercentage();
				testRunId[position]=productTestReport.getRunsessionid();
				position++;
				noOfRuns--;
			}
			
		}
		return new ProductTestIdPercent(testPassPercent,testRunId);
	}
	
	//API to get names of all the products
	@GetMapping("/getAllProductNames")
	public List<String> products() {
		List<ProductTestReport> testReportsDetails= testReportRepository.findAll();
		Iterator<ProductTestReport> reports = testReportsDetails.iterator();
		ProductTestReport productTestReport;
		int flag;
		List<String> productNames=new ArrayList<String>();
		while (reports.hasNext()) {
			productTestReport=reports.next();
			Iterator<String> names = productNames.iterator();
			flag=-1;
			while(names.hasNext()) {
				if(productTestReport.getProductname().equals(names.next().toString())) {
					flag=1;
					break;
				}
			}
			if(flag==-1)
				productNames.add(productTestReport.getProductname());
		}
		System.out.println(productNames.toString());
		return productNames;
	}
	
}
