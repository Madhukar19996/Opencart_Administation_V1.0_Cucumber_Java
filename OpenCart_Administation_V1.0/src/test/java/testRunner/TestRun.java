package testRunner;



import io.cucumber.testng.CucumberOptions;
//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Features/LoginFeature.feature",".//Features/Customers.feature"}, 
	    // features= {".//Features/LoginFeature.feature"},
	   // features= ".//Features/",
	   //tags="@regression or @sanity", //scenario under regression or sanity tag will be executed 
	   // tags="@regression and @sanity", //will run scenario which is tagged with sanity as well regression
		tags="@regression or @sanity", //will run scenario which is tagged with regression but not sanity
        glue="stepDefinations",
        dryRun=false,
        monochrome=true,
         //features= {"@target/rerun.txt"},
        //plugin= {"pretty", "html:reports/myreport.html"})
        plugin= {"pretty", "html:reports/myreport.html", 
		  "rerun:target/rerun.txt",
		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		
		)
        
       // plugin= {"pretty","json:reports/cucumber-reports/myreport_json.json"})


public class TestRun extends AbstractTestNGCucumberTests{
// this is empty function  it will never implement 
	
}
