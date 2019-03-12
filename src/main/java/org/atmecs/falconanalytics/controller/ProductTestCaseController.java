package org.atmecs.falconanalytics.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.atmecs.falconanalytics.dto.ProductTestCase;
import org.atmecs.falconanalytics.dto.TestcaseDetails;
import org.atmecs.falconanalytics.properties.TestReportProperties;
import org.atmecs.falconanalytics.repositories.ProductTestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testCase")
public class ProductTestCaseController {

	@Autowired
	ProductTestCaseRepository testcaseRepo; 
	
	@Autowired
	TestReportProperties properties;
	
	//function to get data of last runs
	@GetMapping("/details")
	public List<TestcaseDetails> history(@RequestParam("customerName") String customerName, @RequestParam("noOfRuns") int noOfRuns){
		List<ProductTestCase> testcaseModel=testcaseRepo.findByCustomernameOrderByNumberDesc(customerName);
		int countOfResults=testcaseRepo.findByCustomernameOrderByNumberDesc(customerName).size();
		countOfResults=countOfResults/properties.getNoOfTestcases();
		int skip=1;
		Iterator<ProductTestCase> reports = testcaseModel.iterator();
		ProductTestCase productTestCase;
		List<TestcaseDetails> listOfTestcase=new ArrayList<TestcaseDetails>();
		while (reports.hasNext()){
			productTestCase=reports.next();
			if(skip>countOfResults-noOfRuns) {
				TestcaseDetails testcaseDetails = new TestcaseDetails();
				testcaseDetails.setName(productTestCase.getName());
				testcaseDetails.setRunsessionid(productTestCase.getRunsessionid());
				testcaseDetails.setStatus(productTestCase.getStatus());
				testcaseDetails.setExceptionmessage(productTestCase.getExceptionmessage());
				testcaseDetails.setNumber(productTestCase.getNumber());
				listOfTestcase.add(testcaseDetails);	
			}
			skip++;
			if(skip>countOfResults)
				skip=1;
		}
		return listOfTestcase;
	}
	
	//function to get the comparison test case wise
	@GetMapping("/testcaseCompare")
	public double[] testcaseCompare(@RequestParam("customerName") String customerName, @RequestParam("noOfRuns") int noOfRuns) {
		List<ProductTestCase> testcaseModel=testcaseRepo.findByCustomernameOrderByRunsessionidDesc(customerName);
		Iterator<ProductTestCase> reports = testcaseModel.iterator();
		ProductTestCase productTestCase;
		int noOfResults=noOfRuns*properties.getNoOfTestcases();
		String allPassPercent[]=new String[noOfResults];
		double testcasePassPercent[]=new double[properties.getNoOfTestcases()];
		int position=0,loop;
		double pass;
		while (reports.hasNext() && noOfResults>0){
			productTestCase=reports.next();
			allPassPercent[position++]=productTestCase.getStatus();
			noOfResults--;
		}
		for(noOfResults=0;noOfResults<properties.getNoOfTestcases();noOfResults++)
		{
			pass=0.0;
			position=noOfResults;
			for(loop=0;loop<noOfRuns;loop++) {				
				if(allPassPercent[position].equals("PASS"))
					pass++;
				position=position+properties.getNoOfTestcases();
			}
			testcasePassPercent[noOfResults]=pass/noOfRuns*100.0;		
		}
		return testcasePassPercent;
	}
	
	
}
