package com.assignment.opus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class util {

	public Properties prop = null;
	FileInputStream fis = null;

	public util() {

		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
				try {
					prop.load(fis);
				} catch (IOException e) {
					System.out.println(e.fillInStackTrace());
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.fillInStackTrace());
			}
		}
	}
}
