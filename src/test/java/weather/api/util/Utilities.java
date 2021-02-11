package weather.api.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * To define all the common methods
 * 
 * @author Muralee
 *
 */
public class Utilities {
	/**
	 * Convert Response object to JsonPath object
	 * 
	 * @param resp
	 * @return JsonPath object
	 */

	public static Map<String, String> expectedFirstStation = null;
	public static Map<String, String> expecteSecondStation = null;

	public static JsonPath rawToJson(Response resp) {
		String respString = resp.asString();
		JsonPath js = new JsonPath(respString);
		return js;
	}

	public static void expectedStationDetails() {
		expectedFirstStation = new HashMap<>();
		expectedFirstStation.put("external_id", "DEMO_TEST001");
		expectedFirstStation.put("name", "Team Demo Test Station 001");
		expectedFirstStation.put("latitude", "33.33");
		expectedFirstStation.put("longitude", "-122.43");
		expectedFirstStation.put("altitude", "222");

		expecteSecondStation = new HashMap<>();
		expecteSecondStation.put("external_id", "DEMO_TEST002");
		expecteSecondStation.put("name", "Team Demo Test Station 002");
		expecteSecondStation.put("latitude", "44.44");
		expecteSecondStation.put("longitude", "-122.44");
		expecteSecondStation.put("altitude", "111");
	}

}
