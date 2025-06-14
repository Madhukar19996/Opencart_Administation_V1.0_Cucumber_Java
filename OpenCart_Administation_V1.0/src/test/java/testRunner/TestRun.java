package testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		//features= {".//Features/LoginFeature.feature"}, 
	    features= {".//Features/Customers.feature"},
        glue="stepDefinations",
        dryRun=false,
        monochrome=true,
        plugin= {"pretty", "html:reports/myreport.html"})
        
       // plugin= {"pretty","json:reports/cucumber-reports/myreport_json.json"})


public class TestRun {
// this is empty function  it will never implement 
	
}
