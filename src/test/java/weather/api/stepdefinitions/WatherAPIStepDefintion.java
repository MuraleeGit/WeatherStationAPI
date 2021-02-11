package weather.api.stepdefinitions;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import weather.api.util.Constants;
import weather.api.util.GetConfigProperties;
import weather.api.util.Utilities;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

/**
 * This class is used to glue the steps mentioned in the feature file
 * 
 * @author Muralee
 *
 */

public class WatherAPIStepDefintion {
	private static Logger log = LogManager.getLogger(WatherAPIStepDefintion.class.getName());
	private JsonPath jpWithoutAPIKey = null;
	private JsonPath jpFirstStation = null;
	private JsonPath jpSecondStation = null;
	private JsonPath jpGetFirstStation = null;
	private JsonPath jpGetSecondStation = null;
	GetConfigProperties getProps = new GetConfigProperties();
	Properties prop = new Properties();

	@Before
	public void init() {
		Utilities.expectedStationDetails();
		log.info("init");
	}

	@Given("^I have the api request$")
	public void i_have_the_api_request() {
		log.info("set the base URI");
		RestAssured.baseURI = Constants.BASE_URI;
	}

	@When("^I submit the get request without api key$")
	public void submitWithoutAPIKey() {
		log.info("Before calling the current weather API without passing api key");
		Response respWithoutAPIKey = given().when().post(Constants.WEATHER_STATIONS_RESOURCE_URI).then().extract()
				.response();
		jpWithoutAPIKey = Utilities.rawToJson(respWithoutAPIKey);
	}

	@Then("^I validate the response$")
	public void validateResponse() {
		log.info("validating for 401 response without passing the api key ");
		prop = getProps.getConfigProperty();
		Assert.assertEquals(prop.getProperty("cod"), jpWithoutAPIKey.get("cod").toString());
		Assert.assertEquals(prop.getProperty("message"), jpWithoutAPIKey.get("message"));
	}

	@When("^I submit the post request to create a station$")
	public void createWeatherStations() {
		log.info("submit a post request to create weather stations");
		prop = getProps.getConfigProperty();
		log.info("Before calling the current weather API to create weather stations");
		Response respFirstStation = given().header("Content-Type", "application/json")
				.queryParam(Constants.WEATHER_KEY, Constants.WEATHER_API_KEY_VALUE).body(Constants.FIRST_STATION_BODY)
				.when().post(Constants.WEATHER_STATIONS_RESOURCE_URI).then().extract().response();
		jpFirstStation = Utilities.rawToJson(respFirstStation);
		Response respSecondStation = given().header("Content-Type", "application/json")
				.queryParam(Constants.WEATHER_KEY, Constants.WEATHER_API_KEY_VALUE).body(Constants.SECOND_STATION_BODY)
				.when().post(Constants.WEATHER_STATIONS_RESOURCE_URI).then().extract().response();
		jpSecondStation = Utilities.rawToJson(respSecondStation);
	}

	@Then("^I validate the post request station details$")
	public void i_validate_the_post_request_station_details() {
		log.info("validation of post request station details using assertion");
		Assert.assertEquals(Utilities.expectedFirstStation.get("external_id"), jpFirstStation.get("external_id"));
		Assert.assertEquals(Utilities.expectedFirstStation.get("name"), jpFirstStation.get("name"));
		Assert.assertEquals(Utilities.expectedFirstStation.get("latitude"), jpFirstStation.get("latitude").toString());
		Assert.assertEquals(Utilities.expectedFirstStation.get("longitude"),
				jpFirstStation.get("longitude").toString());
		Assert.assertEquals(Utilities.expectedFirstStation.get("altitude"), jpFirstStation.get("altitude").toString());
		Assert.assertEquals(Utilities.expecteSecondStation.get("external_id"), jpSecondStation.get("external_id"));
		Assert.assertEquals(Utilities.expecteSecondStation.get("name"), jpSecondStation.get("name"));
		Assert.assertEquals(Utilities.expecteSecondStation.get("latitude"), jpSecondStation.get("latitude").toString());
		Assert.assertEquals(Utilities.expecteSecondStation.get("longitude"),
				jpSecondStation.get("longitude").toString());
		Assert.assertEquals(Utilities.expecteSecondStation.get("altitude"), jpSecondStation.get("altitude").toString());
	}

	@And("^I submit get request to retrieve station details$")
	public void i_submit_get_request_to_retrieve_station_details() {
		log.info("submitting get request to retrieve station details");
		Response respGetFirstStation = given().queryParam(Constants.WEATHER_KEY, Constants.WEATHER_API_KEY_VALUE).when()
				.get(Constants.WEATHER_STATIONS_RESOURCE_URI + "/" + jpFirstStation.get("ID").toString()).then()
				.extract().response();
		jpGetFirstStation = Utilities.rawToJson(respGetFirstStation);
		Response respGetSecondStation = given().queryParam(Constants.WEATHER_KEY, Constants.WEATHER_API_KEY_VALUE)
				.when().get(Constants.WEATHER_STATIONS_RESOURCE_URI + "/" + jpSecondStation.get("ID").toString()).then()
				.extract().response();
		jpGetSecondStation = Utilities.rawToJson(respGetSecondStation);
	}

	@And("^I validate the get request station details$")
	public void i_validate_the_get_request_station_details() {
		log.info("validation of get request of station using assertion");
		Assert.assertEquals(Utilities.expectedFirstStation.get("external_id"), jpGetFirstStation.get("external_id"));
		Assert.assertEquals(Utilities.expectedFirstStation.get("name"), jpGetFirstStation.get("name"));
		Assert.assertEquals(Utilities.expectedFirstStation.get("latitude"),
				jpGetFirstStation.get("latitude").toString());
		Assert.assertEquals(Utilities.expectedFirstStation.get("longitude"),
				jpGetFirstStation.get("longitude").toString());
		Assert.assertEquals(Utilities.expectedFirstStation.get("altitude"),
				jpGetFirstStation.get("altitude").toString());
		Assert.assertEquals(Utilities.expecteSecondStation.get("external_id"), jpGetSecondStation.get("external_id"));
		Assert.assertEquals(Utilities.expecteSecondStation.get("name"), jpGetSecondStation.get("name"));
		Assert.assertEquals(Utilities.expecteSecondStation.get("latitude"),
				jpGetSecondStation.get("latitude").toString());
		Assert.assertEquals(Utilities.expecteSecondStation.get("longitude"),
				jpGetSecondStation.get("longitude").toString());
		Assert.assertEquals(Utilities.expecteSecondStation.get("altitude"),
				jpGetSecondStation.get("altitude").toString());
	}
}