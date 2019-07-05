Feature: Test the get contract and tier services
Scenario: Validate get and contract tier services returns the response
	Given User has sample request for get contract service
		When get contract levels service called via postman
		Then the get contract service call should be successful
	Given User has request for get contract service with no params	
		When get contract service called via postman no params
		Then the contract service call should be unsuccessful
		
Scenario: Validate new proposed scan range edit service
	Given User has sample request for proposed scan range edit service
		When scan range edit service called via postman
		Then the service call should be successful
		And update record should be written to ScanRangeUpdate.txt & activePSIData.txt files
	Given User has empty request for proposed scan range edit service
		When scan range edit service called via postman with empty request body
		Then the service call should be unsuccessful
		And update record should not be written to ScanRangeUpdate.txt & activePSIData.txt files