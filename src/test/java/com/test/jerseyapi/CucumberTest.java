package com.test.jerseyapi;

import org.junit.Ignore;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@Ignore
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources", tags = "@PostTest", plugin = "json:target/cucumber-resport.json")
public class CucumberTest {
}
