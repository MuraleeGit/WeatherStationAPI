$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/weather/api/features/weather.feature");
formatter.feature({
  "line": 1,
  "name": "Weather API scenarios",
  "description": "",
  "id": "weather-api-scenarios",
  "keyword": "Feature"
});
formatter.before({
  "duration": 212925000,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Weather API post request without API key",
  "description": "",
  "id": "weather-api-scenarios;weather-api-post-request-without-api-key",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I have the api request",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I submit the get request without api key",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I validate the response",
  "keyword": "Then "
});
formatter.match({
  "location": "WatherAPIStepDefintion.i_have_the_api_request()"
});
formatter.result({
  "duration": 1108127100,
  "status": "passed"
});
formatter.match({
  "location": "WatherAPIStepDefintion.submitWithoutAPIKey()"
});
formatter.result({
  "duration": 3118034400,
  "status": "passed"
});
formatter.match({
  "location": "WatherAPIStepDefintion.validateResponse()"
});
formatter.result({
  "duration": 596491700,
  "status": "passed"
});
formatter.before({
  "duration": 748200,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Weather API post request to create new stations",
  "description": "",
  "id": "weather-api-scenarios;weather-api-post-request-to-create-new-stations",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I have the api request",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I submit the post request to create a station",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I validate the post request station details",
  "keyword": "Then "
});
formatter.match({
  "location": "WatherAPIStepDefintion.i_have_the_api_request()"
});
formatter.result({
  "duration": 621200,
  "status": "passed"
});
formatter.match({
  "location": "WatherAPIStepDefintion.createWeatherStations()"
});
formatter.result({
  "duration": 1261982300,
  "status": "passed"
});
formatter.match({
  "location": "WatherAPIStepDefintion.i_validate_the_post_request_station_details()"
});
formatter.result({
  "duration": 125677000,
  "status": "passed"
});
formatter.before({
  "duration": 879500,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Weather API get request to verify the station details",
  "description": "",
  "id": "weather-api-scenarios;weather-api-get-request-to-verify-the-station-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "I have the api request",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I submit the post request to create a station",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I submit get request to retrieve station details",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I validate the get request station details",
  "keyword": "Then "
});
formatter.match({
  "location": "WatherAPIStepDefintion.i_have_the_api_request()"
});
formatter.result({
  "duration": 1228200,
  "status": "passed"
});
formatter.match({
  "location": "WatherAPIStepDefintion.createWeatherStations()"
});
formatter.result({
  "duration": 1288843700,
  "status": "passed"
});
formatter.match({
  "location": "WatherAPIStepDefintion.i_submit_get_request_to_retrieve_station_details()"
});
formatter.result({
  "duration": 1235387500,
  "status": "passed"
});
formatter.match({
  "location": "WatherAPIStepDefintion.i_validate_the_get_request_station_details()"
});
formatter.result({
  "duration": 107723300,
  "status": "passed"
});
});