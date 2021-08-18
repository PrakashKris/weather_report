package com.testvagrant.weather_report.cucumber.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WeatherStepDefinition {

	

@Given("user launches weather application to find weather for {string} city")
public void user_launches_weather_application_to_find_weather_for_city(String string) {
    System.out.println("Hello World!"); 
    
}

@And("user invokes get API of weather service to find weather for {string} city")
public void user_invokes_get_api_of_weather_service_to_find_weather_for_city(String string) {
     
    
}

@When("compare the temperature within {string} variance range")
public void compare_the_temperature_within_variance_range(String string) {
     
    
}

@Then("comparison between source is successful else unsuccessful")
public void comparison_between_source_is_successful_else_unsuccessful() {
     
    
}

}
