package com.shopping.test.web.acceptancetests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
 
@RunWith(Cucumber.class)
		@CucumberOptions(
				features = "src/test/resources/features", 
				glue = {"com.shopping.test.web.stepdefs"}, 
				plugin = {"pretty","html:target/site/htmlReport","json:target/reports/cucumber-ShoppingTestWebFeature-report.json"},
				monochrome = true ,
                tags = {"@regression"})


 

public class testRunner_WebFramework {

}
