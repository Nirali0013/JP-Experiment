package io.swagger.cucumber;
/* 
 Created by Jaydip Patel
 */

import cucumber.api.CucumberOptions;
import io.swagger.testbase.TestBase;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature",
        tags = "@pet")
public class TestRunner extends TestBase {
}
