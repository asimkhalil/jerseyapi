package com.test.jerseyapi;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources", tags = "@GetContractAndTier", plugin = "json:target/cucumber-resport.json")
public class GetContractAndTierLevelTest {
}