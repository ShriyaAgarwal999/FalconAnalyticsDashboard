package org.atmecs.falconanalytics.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import org.atmecs.falconanalytics.dto.ProductTestIdPercent;
import org.atmecs.falconanalytics.dto.ProductTestReport;
import org.atmecs.falconanalytics.dto.TestRunDetails;
import org.atmecs.falconanalytics.properties.TestReportProperties;
import org.atmecs.falconanalytics.repositories.ProductTestReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
//	//method to return test pass percent array and corresponding run session id array for analytics purpose
//	@GetMapping("/getDetails")
//	public ProductTestIdPercent analysis(@RequestParam("productName") String productName,@RequestParam("noOfRuns") int noOfRuns ) {
//		List<ProductTestReport> testReportsDetails= testReportRepository.findByProductnameOrderByRunsessionidDesc(productName);
//		Iterator<ProductTestReport> reports = testReportsDetails.iterator();
//		int testPassPercent[]=new int[noOfRuns];
//		int testRunId[]=new int[noOfRuns];
//		int position=0;
//		ProductTestReport productTestReport;
//		while (reports.hasNext() && noOfRuns>0) {
//			productTestReport=reports.next();
//			testPassPercent[position]=productTestReport.getPasspercentage();
//			testRunId[position]=productTestReport.getRunsessionid();
//			position++;
//			noOfRuns--;
//		}
//		return new ProductTestIdPercent(testPassPercent,testRunId);
//	}
	
	//get pass percentage based on testphase
//	@GetMapping("/getTestphaseDetails")
//	public ProductTestIdPercent testPhase(@RequestParam("productName") String productName,@RequestParam("noOfRuns") int noOfRuns, @RequestParam("testphase") String testphase ) {
//		List<ProductTestReport> testReportsDetails= testReportRepository.findByProductnameOrderByRunsessionidDesc(productName);
//		Iterator<ProductTestReport> reports = testReportsDetails.iterator();
//		int testPassPercent[]=new int[noOfRuns];
//		int testRunId[]=new int[noOfRuns];
//		int position=0;
//		ProductTestReport productTestReport;
//		while (reports.hasNext() && noOfRuns>0) {
//			productTestReport=reports.next();
//			System.out.println(productTestReport.getRunsessionid()+" "+productTestReport.getTestphase());
//			if(productTestReport.getTestphase().equals(testphase) && productTestReport.getRunsessionid()>0) {
//				testPassPercent[position]=productTestReport.getPasspercentage();
//				testRunId[position]=productTestReport.getRunsessionid();
////				System.out.println(testPassPercent[position]);
////				System.out.println(noOfRuns);
//				position++;
//				noOfRuns--;
//			}
//			
//		}
//		return new ProductTestIdPercent(testPassPercent,testRunId);
//	}
	
//	//Api to get no of testcases and its details from each testrun
//	@GetMapping("/getTestRunDetails")
//	public TestRunDetails testRunDetails(@RequestParam("productName") String productName,@RequestParam("noOfRuns") int noOfRuns, @RequestParam("testphase") String testphase) {
//		List<ProductTestReport> testReportsDetails= testReportRepository.findByProductnameOrderByRunsessionidDesc(productName);
//		Iterator<ProductTestReport> reports = testReportsDetails.iterator();
//		List<Integer> totalcount=new ArrayList<Integer>();
//		List<Integer> passcount=new ArrayList<Integer>();
//		List<Integer> failcount=new ArrayList<Integer>();
//		List<Integer> skipcount=new ArrayList<Integer>();
//		List<Integer> passPercent=new ArrayList<Integer>();
//		ProductTestReport productTestReport;
//		TestRunDetails testrun=new TestRunDetails();
//		while (reports.hasNext() && noOfRuns>0) {
//			productTestReport=reports.next();if(productTestReport.getTestphase().equals(testphase)) {
//				totalcount.add(productTestReport.getTotalcount());
//				passcount.add(productTestReport.getPasscount());
//				failcount.add(productTestReport.getFailcount());
//				skipcount.add(productTestReport.getSkipcount());
//				passPercent.add(productTestReport.getPasspercentage());
//				noOfRuns--;
//			}
//		}
//		testrun.setTotalcount(totalcount);
//		testrun.setPasscount(passcount);
//		testrun.setFailcount(failcount);
//		testrun.setSkipcount(skipcount);
//		testrun.setPassPercent(passPercent);
//		return testrun;
//	}
	
	//Api to get no of testcases and its details from each testrun
		@GetMapping("/getTestRunDetails")
		public TestRunDetails testRunDetails(@RequestParam("productName") String productName,@RequestParam("noOfRuns") int noOfRuns,
				@RequestParam("testphase") String testphase) {
			List<ProductTestReport> testReportsDetails= testReportRepository.findByProductnameAndTestphaseOrderByRunsessionidDesc
					(productName,testphase);
			Iterator<ProductTestReport> reports = testReportsDetails.iterator();
			List<Integer> totalcount=new ArrayList<Integer>();
			List<Integer> passcount=new ArrayList<Integer>();
			List<Integer> failcount=new ArrayList<Integer>();
			List<Integer> skipcount=new ArrayList<Integer>();
			List<Integer> passPercent=new ArrayList<Integer>();
			ProductTestReport productTestReport;
			TestRunDetails testrun=new TestRunDetails();
			testrun.setTotalRuns(testReportsDetails.size());
			while (reports.hasNext() && noOfRuns>0) {
				productTestReport=reports.next();
				totalcount.add(productTestReport.getTotalcount());
				passcount.add(productTestReport.getPasscount());
				failcount.add(productTestReport.getFailcount());
				skipcount.add(productTestReport.getSkipcount());
				passPercent.add(productTestReport.getPasspercentage());
				noOfRuns--;
			}
			testrun.setTotalcount(totalcount);
			testrun.setPasscount(passcount);
			testrun.setFailcount(failcount);
			testrun.setSkipcount(skipcount);
			testrun.setPassPercent(passPercent);
			return testrun;
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
		return productNames;
	}
	
	
	
	
}
