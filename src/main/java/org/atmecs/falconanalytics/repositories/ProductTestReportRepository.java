package org.atmecs.falconanalytics.repositories;

import java.util.List;

import org.atmecs.falconanalytics.dto.ProductTestReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTestReportRepository extends MongoRepository<ProductTestReport, String> {

	ProductTestReport findByRunsessionid(int id);
	List<ProductTestReport> findAllByProductname(String productName);
	List<ProductTestReport> findAllByProductnameOrderByRunsessionid(String productName);
	List<ProductTestReport> findAllByProductnameOrderByRunsessionidDesc(String productName);
	List<ProductTestReport> findTop5ByProductnameOrderByRunsessionidDesc(String productName);
	int[] findPasspercentageTop5ByProductnameOrderByRunsessionidDesc(String productName);
	int[] findPasspercentageByProductnameOrderByRunsessionidDesc(String productName);
	List<ProductTestReport> findByProductnameOrderByRunsessionidDesc(String productName);

}
