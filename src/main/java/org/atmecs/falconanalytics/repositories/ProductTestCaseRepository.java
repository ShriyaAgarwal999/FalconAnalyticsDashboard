package org.atmecs.falconanalytics.repositories;

import org.atmecs.falconanalytics.dto.ProductTestCase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTestCaseRepository extends MongoRepository<ProductTestCase, String>{

}
