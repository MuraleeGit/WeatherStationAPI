Description:

This project is a small and simple example for registering the weather stations and retrieving the weather station details using different end points
 
End points covered for Weather Station API:

1. Create weather stations
http://api.openweathermap.org/data/3.0/stations?appid=<api key>
and pass the station data in the body.
2. Retrieve station details
http://api.openweathermap.org/data/3.0/stations/<station id>?appid=<api key>



Technology stack:

REST assured using Java, Cucumber, Log 4j, Maven and JUnit 

Usage:

Run using Maven command - mvn clean install 