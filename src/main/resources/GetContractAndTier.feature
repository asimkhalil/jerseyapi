@GetContractAndTier
Feature: Test the get contract / tier services
Scenario: Validate get and contract tier services returns the response
	Given User has sample request for get contract service
		When get contract edit service called via postman
		Then the get contract service call should be successful
		When get contract service called via postman no params
		Then the service call should be unsuccessful