package org.atmecs.falconanalytics.repositories;

import java.util.List;

import org.atmecs.falconanalytics.dto.ProductTestCase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTestCaseRepository extends MongoRepository<ProductTestCase, String>{
	List<ProductTestCase> findByCustomername(String customerName);
	List<ProductTestCase> findByCustomernameOrderByRunsessionidDesc(String customerName);
	List<ProductTestCase> findByCustomernameOrderByNumberDesc(String customerName);
	List<ProductTestCase> findByCustomernameOrderByNumberAsc(String customerName);
	List<ProductTestCase> findByRunsessionidOrderByRunsessionidDesc(int sessionId);
	List<ProductTestCase> findByRunsessionid(int sessionId);
	List<ProductTestCase> findByRunsessionidAndBrowserAndOsOrderByNumberAsc(int sessionId, String browser, String os);
	List<ProductTestCase> findByRunsessionidOrderByNumberAsc(int sessionId);
	List<ProductTestCase> findByRunsessionidAndBrowserOrderByNumberAsc(int sessionId, String browser);
	List<ProductTestCase> findByRunsessionidAndOsOrderByNumberAsc(int sessionId, String os);
	List<ProductTestCase> findByRunsessionidAndStatusOrderByNumberAsc(int sessionId, String status);
	List<ProductTestCase> findByRunsessionidAndStatusAndOsOrderByNumberAsc(int sessionId, String status, String os);
	List<ProductTestCase> findByRunsessionidAndStatusAndBrowserOrderByNumberAsc(int sessionId, String status,
			String browser);
	
}
