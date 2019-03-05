package org.atmecs.falconanalytics.repositories;

import java.util.List;

import org.atmecs.falconanalytics.dto.ProductTestReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTestReportRepository extends MongoRepository<ProductTestReport, String> {

	ProductTestReport findByRunsessionid(int id);
	List<ProductTestReport> findByProductnameOrderByRunsessionidDesc(String productName);
	List<ProductTestReport> findByProductnameOrderByRunsessionidAsc(String productName);

}
