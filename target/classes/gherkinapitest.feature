Feature: the reset rates /edit service should be working
	Scenario: client makes call to POST /resetrates/edit
		When the client calls /resetrates/edit
		Then the user receives status code of 200
		And the response should contain:
		"""
		{
			"requestId" : "1234567abcd1234567",
			"args" : {
				"businessDate" : "2018-10-16",
				"proposedRates" : [
					{
						"commodityId" : "4229226",
						"productId" : "8229478",
						"tier" : "5",
						"proposedRate" : "194",
						"exchange" : "NFX",
						"proposedDate" : "2018-02-10",
						"editedBy" ": "null",
						"editedTimestamp" : "2019-06-20",
						"reviewedBy" : "null",
						"reviewedTimestamp" : "null",
						"key" : "8229478",
						
					}
				]
			}
			"errors" : "null"
		}
		""" 