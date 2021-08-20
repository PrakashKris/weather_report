package com.testvagrant.weather_report.utils.weatherLocation;

import static io.restassured.RestAssured.given;

import java.util.Properties;

import org.junit.Assert;

import com.testvagrant.weather_report.utils.PropertyLoader;

import io.restassured.response.Response;

public class GetWeatherLocation {

	public Response getWeatherLocationForCity(String cityName) {
		Properties property = PropertyLoader.getInstance();
		Response response = null;
		try {
			response = given().queryParam("q", cityName)
					.queryParam("appid", property.getProperty("testvagrant.weather.api.key")).when()
					.get(property.getProperty("testvagrant.weather.api.url")).then().extract().response();
		} catch (Exception e) {
			Assert.fail("Exception in GetWeatherLocation method:" + e);
		}
		return response;
	}

}
