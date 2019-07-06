package com.test.jerseyapi.cucumbertests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources", 
glue = {"classpath:com.test.jerseyapi.stepdefinitions"})
public class GetContractAndTierLevelTest {
	
}
