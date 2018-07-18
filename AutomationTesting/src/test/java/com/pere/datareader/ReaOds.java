package com.pere.datareader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 this file is written to read the properties file and use package 
 com.pere.OverviewTestNG*/

public class ReaOds {
	String filepath1;
	public static Properties returnProperty(String filepath1) {
		Properties prop = new Properties();
		InputStream input = null;
		String filepath = filepath1;
		try {
			input = new FileInputStream(filepath);
			// load a properties file
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}

}
