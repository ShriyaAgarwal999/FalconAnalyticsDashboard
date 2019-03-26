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
}
