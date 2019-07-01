Feature: Test the edit service response and file writing
Scenario: Validate new proposed scan range edit service
	Given User has sample request for proposed scan range edit service
		When scan range edit service called via postman
		Then the service call should be successful
		When scan range edit service called via postman with empty request body
		Then the service call should be unsuccessful 