package com.testvagrant.weather_report.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherHomePage {

	private WebDriver driver;

	public WeatherHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "search-input")
	private WebElement searchBox;

	public WebElement getSearchOptionToSelect(String cityName) {
		return driver.findElement(By.xpath("//div[contains(text(),'" + cityName + "')]"));
	}
}
