package com.testvagrant.weather_report.cucumber.runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:Feature"
		,glue={"com/testvagrant/weather_report/cucumber/stepDefinition"				
		},plugin={"pretty","summary", "html:target/cucumber"}//
		,monochrome=true
		)
public class CucumberRunnerTest {

}
