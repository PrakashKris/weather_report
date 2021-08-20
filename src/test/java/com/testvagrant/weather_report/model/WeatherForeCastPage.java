package com.testvagrant.weather_report.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class WeatherForeCastPage {

	public WeatherForeCastPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='cur-con-weather-card__panel'] div[class='temp']")
	private WebElement currentTemp;

}
