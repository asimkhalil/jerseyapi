Feature: the user service should be working
	Scenario: client makes call to POST /createuser
		When the client calls /createuser
		Then the user receives status code of 200
		And the response should contain:
		"""
		{"first_name":"asim"}
		""" 