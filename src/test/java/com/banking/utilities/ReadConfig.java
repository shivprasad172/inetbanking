package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {

	Properties pro;
	// first create the constructor to load the entire properties file, and the create individual method to read the values
	// create one constructor
	
	public ReadConfig()   {
		File src =new File ("./Configuration/config.properties");
		
		try {
		FileInputStream fis = new FileInputStream(src);
		pro=new Properties ();
			pro.load(fis);
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
		}
		
	}
	// create individual method for each variable to read from the config.properties file
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
		
	}
	public String getUsername() {
		String uname = pro.getProperty("username");
		return uname;
}
	public String getPassword() {
		String upass = pro.getProperty("password");
		return upass;
}
}