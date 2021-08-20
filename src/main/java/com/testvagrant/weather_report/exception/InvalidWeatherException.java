package com.testvagrant.weather_report.exception;

public class InvalidWeatherException extends Exception{

	public InvalidWeatherException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}
