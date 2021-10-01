package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void jvmReport(String json) {
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\AdactinReport");
		
		Configuration configuration = new Configuration(file, "Adactin Hotel Page");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Author", "Shaik");
		configuration.addClassifications("Sprint", "14");
		configuration.addClassifications("Environment", "Testing");
		
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(json);
	
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();
	
	}
}
