package com.testvagrant.weather_report.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

	private static Properties property;

	private PropertyLoader() {
	}

	public static Properties getInstance() {
		if (property == null) {
			property = new Properties();
			try {
				property.load(new FileInputStream("src/test/resource/application.properties"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return property;

	}

}
