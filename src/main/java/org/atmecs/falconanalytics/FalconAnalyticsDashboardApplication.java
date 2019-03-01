package org.atmecs.falconanalytics;

import org.atmecs.falconanalytics.properties.TestReportProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TestReportProperties.class)
public class FalconAnalyticsDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(FalconAnalyticsDashboardApplication.class, args);
	}

}
