Feature: Test the get contract and tier services
Scenario: Validate get and contract tier services returns the response
	Given User has sample request for get contract service
		When get contract levels service called via postman
		Then the get contract service call should be successful
	
Scenario: Validate get and contract tier services with no request id should return unsuccessful response	
	Given User has request for get contract service with no params	
		When get contract service called via postman no params
		Then the contract service call should be unsuccessful
		
Scenario: Validate new proposed scan range edit service
	Given User has sample request for proposed scan range edit service
		When scan range edit service called via postman
		Then the service call should be successful
		And update record should be written to ScanRangeUpdate.txt & activePSIData.txt files

Scenario: Validate new proposed scan range edit service with empty request body should return unsuccessful response	
	Given User has empty request for proposed scan range edit service
		When scan range edit service called via postman with empty request body
		Then the service call should be unsuccessful
		And update record should not be written to ScanRangeUpdate.txt & activePSIData.txt files
		
Scenario: Validate get reset rates at contract level service with valid date param
	Given User has sample request for get contract service with valid date params
		When get contract levels service called via postman with correct date format MM/DD/YYYY
		Then the get contract service call should return the success response
		
Scenario: Validate get reset rates at contract level service with valid request id param
	Given User has sample request for get contract service with valid request id params
		When get contract levels service called via postman with valid request id > 0
		Then the get contract service call should return the success response