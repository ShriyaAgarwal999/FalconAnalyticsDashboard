package org.atmecs.falconanalytics.controller;

import java.util.ArrayList;
import java.util.List;

import org.atmecs.falconanalytics.dto.ProductTestCase;
import org.atmecs.falconanalytics.repositories.ProductTestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testCase")
public class ProductTestCaseController {

	@Autowired
	ProductTestCaseRepository testcaseRepo; 
	
	@GetMapping("/details")
	public ProductTestCase history(@PathVariable("customerName") String customerName)
	{
		List<ProductTestCase> testcaseModel=new ArrayList<>();
		
		return null;
	}
	
	
}
