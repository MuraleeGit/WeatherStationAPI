Feature: Weather API scenarios 

Scenario: Weather API post request without API key 
    Given I have the api request
	When I submit the get request without api key 
	Then I validate the response 
	
Scenario: Weather API post request to create new stations 
	
	Given I have the api request
	When I submit the post request to create a station
    Then I validate the post request station details
	
	
Scenario: Weather API get request to verify the station details
	Given I have the api request
	When I submit the post request to create a station
	And I submit get request to retrieve station details
    Then I validate the get request station details