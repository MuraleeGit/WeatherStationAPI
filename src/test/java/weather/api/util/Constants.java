package weather.api.util;

/**
 * To define Weather api constants
 * 
 * @author Muralee
 *
 */

public class Constants {
	public static final String BASE_URI = "http://api.openweathermap.org";
	public static final String WEATHER_STATIONS_RESOURCE_URI = "/data/3.0/stations";
	public static final String WEATHER_KEY = "appid";
	public static final String WEATHER_API_KEY_VALUE = "9da0212f4044f4b95d827fb0af1f4147";
	public static final String FIRST_STATION_BODY = "{\n" + " \"external_id\": \"DEMO_TEST001\",\n"
			+ " \"name\": \"Team Demo Test Station 001\",\n" + " \"latitude\": 33.33,\n" + " \"longitude\": -122.43,\n"
			+ " \"altitude\": 222\n" + "}";
	public static final String SECOND_STATION_BODY = "{\n" + " \"external_id\": \"DEMO_TEST002\",\n"
			+ " \"name\": \"Team Demo Test Station 002\",\n" + " \"latitude\": 44.44,\n" + " \"longitude\": -122.44,\n"
			+ " \"altitude\": 111\n" + "}\n" + "";
}