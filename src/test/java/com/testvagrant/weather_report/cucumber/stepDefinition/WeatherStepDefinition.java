package com.testvagrant.weather_report.cucumber.stepDefinition;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.testvagrant.weather_report.exception.InvalidWeatherException;
import com.testvagrant.weather_report.model.WeatherForeCastPage;
import com.testvagrant.weather_report.model.WeatherHomePage;
import com.testvagrant.weather_report.utils.Driver;
import com.testvagrant.weather_report.utils.PropertyLoader;
import com.testvagrant.weather_report.utils.weatherLocation.GetWeatherLocation;
import com.testvagrant.weather_report.weatherLocation.Celsius;
import com.testvagrant.weather_report.weatherLocation.WeatherLocation;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WeatherStepDefinition {
	private WebDriver driver;
	private Properties property;
	private WeatherHomePage homePage;
	private WeatherForeCastPage foreCastPage;
	private WeatherLocation uiWeather;
	private WeatherLocation apiWeather;
	private int variance;
	private int range;	
	private Celsius celsius;
	
	@Before
	public void before() {
		driver = Driver.getChromerDriver("chrome");
		property = PropertyLoader.getInstance();
	}

	@Given("user launches weather application to find weather for {string} city")
	public void user_launches_weather_application_to_find_weather_for_city(String cityName) {
		driver.get(property.getProperty("testvagrant.weather.ui.url"));
		homePage = new WeatherHomePage(driver);
		homePage.getSearchBox().sendKeys(cityName);
		homePage.getSearchOptionToSelect(cityName).click();
		foreCastPage=new WeatherForeCastPage(driver);
		int celsius=Integer.parseInt(foreCastPage.getCurrentTemp().getText().split("°C")[0].toString());		
		uiWeather=new WeatherLocation();
		uiWeather.setCelsius(celsius);		
		uiWeather.setCityName(cityName);
	}

	@And("user invokes get API of weather service to find weather for {string} city")
	public void user_invokes_get_api_of_weather_service_to_find_weather_for_city(String cityName) {
		Float apiTemp=new GetWeatherLocation().getWeatherLocationForCity(cityName).getBody().jsonPath().get("main.temp");
		apiWeather=new WeatherLocation();
		apiWeather.setCelsius((int) (apiTemp-273.15));		
		apiWeather.setCityName(cityName);
	}

	@When("compare the temperature within {string} variance range")
	public void compare_the_temperature_within_variance_range(String range) {
		this.range=Integer.parseInt(range.split("°C")[0]);
		celsius=new Celsius();
		celsius.setRange(this.range);
		variance=celsius.compare(uiWeather, apiWeather);	
	}

	@Then("comparison between source is successful else unsuccessful")
	public void comparison_between_source_is_successful_else_unsuccessful() throws InvalidWeatherException {
		if(variance<0)
			throw new InvalidWeatherException("Weather between source is beyond the range(~"+range+")");
	}
	
	@After
	public void after(){
		driver.quit();
	}

}
