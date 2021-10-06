package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
         glue= {"com.stepdefinition"},dryRun = false,
           plugin={"pretty", "json:src\\test\\resources\\Reports\\Adactin.json"},monochrome=true)
public class TestRunner {

	@AfterClass
	public static void afterClass() {
		Reporting.jvmReport(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\Adactin.json");

		System.out.println("shaik");
		System.out.println("dawood");
	}
}
